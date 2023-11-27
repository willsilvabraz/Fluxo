package com.example.alpha2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_tl_cadastrar, bt_estoque;

    private  Programa programa = new Programa();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle dados = getIntent().getExtras();
        if (dados != null) {
            programa = (Programa) dados.getSerializable("Programa");
        }
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();


        bt_tl_cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormCadastrarProduto.class);
                intent.putExtra("Programa", programa);
                startActivity(intent);

            }
        });

        bt_estoque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormEstoque.class);
                intent.putExtra("Programa", programa);
                startActivity(intent);
            }
        });
    }

    public void inicializarComponentes(){
        bt_tl_cadastrar = findViewById(R.id.bt_tl_cadastrar);
        bt_estoque = findViewById(R.id.bt_estoque);
    }
}