package com.example.pokerquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PagInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pag_inicial);


        ImageButton btnGeografia = findViewById(R.id.Geografia);
        btnGeografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PagInicial.this, QuizGeografia.class));
            }
        });

        ImageButton btnMatematica = findViewById(R.id.Matematica);
        btnMatematica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PagInicial.this, QuizMatematica.class));
            }
        });

        ImageButton btnHistoria = findViewById(R.id.Historia);
        btnHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PagInicial.this, QuizHistoria.class));
            }
        });

        ImageButton btnDiversos = findViewById(R.id.Diversos);
        btnDiversos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PagInicial.this, QuizEntretenimento.class));
            }
        });
    }
}