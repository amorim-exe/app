package br.aula.apppdm;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImcActivity extends AppCompatActivity {

    private EditText editTextPeso, editTextAltura;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        editTextPeso = findViewById(R.id.editText_peso);
        editTextAltura = findViewById(R.id.editText_altura);
        textViewResultado = findViewById(R.id.textView_resultado);

        Button buttonCalcular = findViewById(R.id.button_calcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        Button buttonLimpar = findViewById(R.id.button_limpar);
        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        Button buttonVoltar = findViewById(R.id.button_voltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = editTextPeso.getText().toString();
        String alturaStr = editTextAltura.getText().toString();

        if (!TextUtils.isEmpty(pesoStr) && !TextUtils.isEmpty(alturaStr)) {
            try {
                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                if (peso > 0 && altura > 0) {
                    double imc = peso / (altura * altura);
                    String classificacao = getClassificacaoIMC(imc);

                    textViewResultado.setText("IMC: " + String.format("%.2f", imc) + "\nClassificação: " + classificacao);
                } else {
                    textViewResultado.setText("Peso e altura devem ser maiores que zero.");
                }
            } catch (NumberFormatException e) {
                textViewResultado.setText("Valores inválidos.");
            }
        } else {
            textViewResultado.setText("Preencha todos os campos.");
        }
    }

    private String getClassificacaoIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidade grau 1";
        } else if (imc >= 35 && imc < 39.9) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3 (obesidade mórbida)";
        }
    }

    private void limparCampos() {
        editTextPeso.setText("");
        editTextAltura.setText("");
        textViewResultado.setText("Resultado:");
    }
}
