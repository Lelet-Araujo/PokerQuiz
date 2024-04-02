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

public class QuizGeografia extends AppCompatActivity {

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
                    Intent intent = new Intent(QuizGeografia.this, UltimaPag.class);
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
                    Toast.makeText(QuizGeografia.this, "Você está na primeira questão", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verificarResposta(ImageButton respostaSelecionada) {
        if (quiz.get(posicao).getResposta().trim().toLowerCase().equals(respostaSelecionada.getTag().toString().trim().toLowerCase())) {
            pontos++;
            Toast.makeText(QuizGeografia.this, "Parabéns! Você acertou!\nA resposta correta é " + quiz.get(posicao).getResposta(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(QuizGeografia.this, "Resposta Errada", Toast.LENGTH_LONG).show();
        }

        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
    }

    private void iniciarPerguntas() {
        quiz = new ArrayList<>();
        quiz.add(new Perguntas("1- Qual é o ponto mais alto do mundo? \nA) Monte Kilimanjaro \nB) Monte Everest \nC) Monte Fuji  \nD) Montanha K2 " , "A","B","C","D", "B"));

        quiz.add(new Perguntas("2- Qual é o maior rio do mundo em volume de água? \nA) Rio Amazonas \nB) Rio Nilo \nC) Rio Yangtzé \nD)Rio Mississipi", "A","B","C","D", "A"));

        quiz.add(new Perguntas("3- Qual é o menor continente do mundo? \nA) Ásia \nB) Europa \nC) Oceania \nD) Antártica", "A","B","C","D", "C"));

        quiz.add(new Perguntas("4- Qual é o país com a maior área territorial do mundo? \nA) Estados Unidos \nB) Canadá \nC) China \nD) Rússia", "A","B","C","D","D"));

        quiz.add(new Perguntas("5- Qual é o oceano mais profundo do mundo? \nA) Oceano Atlântico \nB) Oceano Pacífico \nC) Oceano Índico \nD) Oceano Ártico", "A","B","C","D", "B"));
    }

    private void setarQuestao(int i) {
        pergunta.setText(quiz.get(i).getQuestao());
        A.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);
    }
}
