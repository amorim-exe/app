package br.aula.apppdm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ApresentacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);

        TextView textViewNome = findViewById(R.id.textView_nome);
        TextView textViewCurso = findViewById(R.id.textView_curso);
        TextView textViewMatricula = findViewById(R.id.textView_matricula);
        TextView textViewSemestre = findViewById(R.id.textView_semestre);
        TextView textViewDisciplina = findViewById(R.id.textView_disciplina);
        TextView buttonClose = findViewById(R.id.button_close); // O "X"

        String nomeAluno = "João Victor";
        String curso = "Ciência da Computação";
        String matricula = "2023123456";
        String semestre = "5º Semestre";
        String disciplina = "Desenvolvimento Mobile";

        textViewNome.setText("Nome do Aluno: " + nomeAluno);
        textViewCurso.setText("Curso: " + curso);
        textViewMatricula.setText("Número de Matrícula: " + matricula);
        textViewSemestre.setText("Semestre: " + semestre);
        textViewDisciplina.setText("Disciplina: " + disciplina);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApresentacaoActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
