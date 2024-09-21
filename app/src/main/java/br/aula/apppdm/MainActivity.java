package br.aula.apppdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIMC = findViewById(R.id.button_imc);
        buttonIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImcActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button_combustivel);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CombustivelActivity.class);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button_apresentacao);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ApresentacaoActivity.class);
                startActivity(intent);
            }
        });

        Button button4 = findViewById(R.id.button_fechaapp);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecharApp();
            }
        });
    }

    public void fecharApp() {
        finishAffinity();
        System.exit(0);
    }
}
