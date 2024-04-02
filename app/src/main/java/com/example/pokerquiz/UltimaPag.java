package com.example.pokerquiz;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class UltimaPag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultima_pag);


        Intent intent = getIntent();
        int quantidadeQuestoesAcertadas = intent.getIntExtra("quantidadeQuestoesAcertadas", 0);


        TextView textView = findViewById(R.id.QuestõesQuantidade);
        textView.setText( quantidadeQuestoesAcertadas + "/5");



        ImageButton btnHome = findViewById(R.id.Home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UltimaPag.this, PagInicial.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
