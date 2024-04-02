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

public class QuizHistoria extends AppCompatActivity {

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
                    Intent intent = new Intent(QuizHistoria.this, UltimaPag.class);
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
                    Toast.makeText(QuizHistoria.this, "Você está na primeira questão", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void verificarResposta(ImageButton respostaSelecionada) {
        if (quiz.get(posicao).getResposta().trim().toLowerCase().equals(respostaSelecionada.getTag().toString().trim().toLowerCase())) {
            pontos++;
            Toast.makeText(QuizHistoria.this, "Parabéns! Você acertou!\nA resposta correta é " + quiz.get(posicao).getResposta(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(QuizHistoria.this, "Resposta Errada", Toast.LENGTH_LONG).show();
        }

        A.setEnabled(false);
        B.setEnabled(false);
        C.setEnabled(false);
        D.setEnabled(false);
    }

    private void iniciarPerguntas() {
        quiz = new ArrayList<>();
        quiz.add(new Perguntas("1-Quem foi o primeiro presidente dos Estados Unidos da América? \nA)Thomas Jefferson \nB) George Washington \nC) Abraham Lincoln \nD) John F. Kennedy " , "A","B","C","D", "B"));

        quiz.add(new Perguntas("2-Qual evento histórico marcou o fim da Segunda Guerra Mundial na Europa? \nA)Batalha de Stalingrado \nB)Bombardeio de Pearl Harbor \nC)Queda do Muro de Berlim \nD)Rendição da Alemanha Nazista ", "A","B","C","D", "D"));

        quiz.add(new Perguntas("3-Qual civilização antiga construiu as pirâmides de Gizé? \nA) Gregos \nB) Romanos \nC) Egípcios \nD) Mesopotâmicos", "A","B","C","D", "C"));

        quiz.add(new Perguntas("4-Quem foi o líder da Revolução Cubana de 1959? \nA)Fidel Castro \nB) Che Guevara \nC) Fulgencio Batista \nD)Raul Castro ", "A","B","C","D","A"));

        quiz.add(new Perguntas("5-Qual foi o período conhecido como Idade das Trevas na Europa Ocidental? \nA) Idade Média \nB) Renascimento \nC) Idade Antiga \nD) Idade Moderna", "A","B","C","D", "A"));
    }

    private void setarQuestao(int i) {
        pergunta.setText(quiz.get(i).getQuestao());
        A.setEnabled(true);
        B.setEnabled(true);
        C.setEnabled(true);
        D.setEnabled(true);
    }
}
