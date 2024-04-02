package com.example.pokerquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizEntretenimento extends AppCompatActivity {

    ImageButton A, B, C, D;
    Button voltar, proximo;
    TextView pergunta;
    ArrayList<Perguntas> quiz;
    int pontos = 0;
    int posicao = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);
        voltar = findViewById(R.id.voltar);
        proximo = findViewById(R.id.Proximo);
        pergunta = findViewById(R.id.textView2);

        iniciarPerguntas();
        setarQuestao(0);

        A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarResposta(A);
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarResposta(B);
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarResposta(C);
            }
        });

        D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarResposta(D);
            }
        });

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posicao++;
                if (posicao < quiz.size()) {
                    setarQuestao(posicao);
                }
                if (posicao == quiz.size()) {
                    Intent intent = new Intent(QuizEntretenimento.this, UltimaPag.class);
                    intent.putExtra("quantidadeQuestoesAcertadas", pontos);
                    startActivity(intent);
                }
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posicao > 0) {
                    posicao--;
                    setarQuestao(posicao);
                } else {
                    Toast.makeText(QuizEntretenimento.this, "Você está na primeira questão", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verificarResposta(ImageButton respostaSelecionada) {
        if (quiz.get(posicao).getResposta().trim().toLowerCase().equals(respostaSelecionada.getTag().toString().trim().toLowerCase())) {
            pontos++;
            Toast.makeText(QuizEntretenimento.this, "Parabéns! Você acertou!\nA resposta correta é " + quiz.get(posicao).getResposta(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(QuizEntretenimento.this, "Resposta Errada", Toast.LENGTH_LONG).show();
        }

        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
    }

    private void iniciarPerguntas() {
        quiz = new ArrayList<>();
        quiz.add(new Perguntas("1-Qual é o nome do protagonista da série 'Breaking Bad'? \nA)Walter White \nB) Jesse Pinkman \nC) 1Saul Goodman \nD) Hank Schrader " ,
                "A",
                "B",
                "C",
                "D",
                "A"));

        quiz.add(new Perguntas("2-Qual é o nome do ator que interpreta o Homem de Ferro nos filmes da Marvel? \nA)Chris Hemsworth \nB)Chris Evans \nC)Robert Downey Jr. \nD)Mark Ruffalo",
                "A",
                "B",
                "C",
                "D",
                "C"));

        quiz.add(new Perguntas("3-Qual é o título do filme vencedor do Oscar de Melhor Filme em 2020? \nA) 1917 \nB) Parasita \nC) Jojo Rabbit \nD) O Irlandês",
                "A",
                "B",
                "C",
                "D",
                "B"));

        quiz.add(new Perguntas("4-Qual é o nome da banda de rock famosa por hits como 'Stairway to Heaven' e 'Whole Lotta Love'? \nA)The Rolling Stones \nB)Pink Floyd \nC)Led Zeppelin \nD)Queen ",
                "A",
                "B",
                "C",
                "D",
                "C"));

        quiz.add(new Perguntas("5-Quem é o criador da série de televisão 'Game of Thrones'? \nA)J.K. Rowling \nB)George R. R. Martin \nC)Stephen King \nD)J.R.R. Tolkien ",
                "A",
                "B",
                "C",
                "D",
                "B"));
    }

    private void setarQuestao(int i) {
        pergunta.setText(quiz.get(i).getQuestao());
        A.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);
    }
}
