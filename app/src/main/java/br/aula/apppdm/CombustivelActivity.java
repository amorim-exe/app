package br.aula.apppdm;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CombustivelActivity extends AppCompatActivity {

    private EditText editTextGasolina, editTextAlcool;
    private TextView textViewResultado;
    private RadioGroup radioGroupCombustivel;
    private RadioButton radioButtonGasolina, radioButtonAlcool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);

        editTextGasolina = findViewById(R.id.editText_gasolina);
        editTextAlcool = findViewById(R.id.editText_alcool);
        textViewResultado = findViewById(R.id.textView_resultado_combustivel);
        radioGroupCombustivel = findViewById(R.id.radioGroup_combustivel);
        radioButtonGasolina = findViewById(R.id.radioButton_gasolina);
        radioButtonAlcool = findViewById(R.id.radioButton_alcool);

        radioGroupCombustivel.setOnCheckedChangeListener((group, checkedId) -> calcularMelhorCombustivel());

        Button buttonLimpar = findViewById(R.id.button_limpar_combustivel);
        buttonLimpar.setOnClickListener(v -> limparCampos());

        TextView buttonClose = findViewById(R.id.button_close);
        buttonClose.setOnClickListener(v -> {
            Intent intent = new Intent(CombustivelActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }

    private void calcularMelhorCombustivel() {
        String gasolinaStr = editTextGasolina.getText().toString();
        String alcoolStr = editTextAlcool.getText().toString();

        if (!TextUtils.isEmpty(gasolinaStr) && !TextUtils.isEmpty(alcoolStr)) {
            try {
                double gasolina = Double.parseDouble(gasolinaStr);
                double alcool = Double.parseDouble(alcoolStr);

                if (gasolina > 0 && alcool > 0) {
                    double relacao = alcool / gasolina;
                    String resultado;

                    // Verifica qual opção o usuário selecionou
                    if (radioButtonGasolina.isChecked()) {
                        resultado = calcularDiferenca(relacao, "Gasolina");
                    } else if (radioButtonAlcool.isChecked()) {
                        resultado = calcularDiferenca(relacao, "Álcool");
                    } else {
                        resultado = "Selecione um combustível.";
                    }

                    // Mostra o resultado
                    textViewResultado.setText(resultado);
                } else {
                    textViewResultado.setText("Os valores devem ser maiores que zero.");
                }
            } catch (NumberFormatException e) {
                textViewResultado.setText("Valores inválidos.");
            }
        } else {
            textViewResultado.setText("Preencha todos os campos.");
        }
    }

    private String calcularDiferenca(double relacao, String tipoCombustivel) {
        double percentual = relacao * 100;
        double diferenca = percentual - 70;
        String resultado;

        if (percentual <= 70) {
            resultado = tipoCombustivel + " vale mais a pena.\n" +
                    "Relação: " + String.format("%.2f", percentual) + "%";
        } else {
            resultado = tipoCombustivel + " não vale a pena.\n" +
                    "Está " + String.format("%.2f", diferenca) + "% acima do parâmetro.";
        }
        return resultado;
    }

    private void limparCampos() {
        editTextGasolina.setText("");
        editTextAlcool.setText("");
        textViewResultado.setText("Resultado:");
        radioGroupCombustivel.clearCheck();
    }
}
