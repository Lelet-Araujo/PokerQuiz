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

public class QuizMatematica extends AppCompatActivity {

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
                    Intent intent = new Intent(QuizMatematica.this, UltimaPag.class);
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
                    Toast.makeText(QuizMatematica.this, "Você está na primeira questão", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verificarResposta(ImageButton respostaSelecionada) {
        if (quiz.get(posicao).getResposta().trim().toLowerCase().equals(respostaSelecionada.getTag().toString().trim().toLowerCase())) {
            pontos++;
            Toast.makeText(QuizMatematica.this, "Parabéns! Você acertou!\nA resposta correta é " + quiz.get(posicao).getResposta(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(QuizMatematica.this, "Resposta Errada", Toast.LENGTH_LONG).show();
        }

        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
    }

    private void iniciarPerguntas() {
        quiz = new ArrayList<>();
        quiz.add(new Perguntas("Qual e o resultado da seguinte expressão:3x(4+2)-8 ? \n\nA)10 \nB) 12\nC) 14\nD) 16 " , "A","B","C","D", "A"));

        quiz.add(new Perguntas("Qual a raiz quadrada de 64? \n\nA)6 \nB)7 \nC)8 \nD)9 ", "A","B","C","D", "C"));

        quiz.add(new Perguntas("Qual é o resultado da expressão  (5×3)+(4×2)−6? \n\nA) 10 \nB) 12 \nC) 14 \nD) 16", "A","B","C","D", "A"));

        quiz.add(new Perguntas("Qual é o produto de 7 e 9? \n\nA)56 \nB)63 \nC)70 \nD)72 ", "A","B","C","D","B"));

        quiz.add(new Perguntas("Qual é o resultado da divisão de 45 por 5? \n\nA)7 \nB)8 \nC)9 \nD)10 ", "A","B","C","D", "C"));
    }

    private void setarQuestao(int i) {
        pergunta.setText(quiz.get(i).getQuestao());
        A.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);
    }
}
