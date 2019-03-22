package com.example.myfirstapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button buttonLimpar;
    private Button buttonPesquisar;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarando os botoes e a barra de pesquisar
        buttonLimpar = (Button) findViewById(R.id.buttonLimpar);
        buttonPesquisar = (Button) findViewById(R.id.buttonPesquisar);
        editText = (EditText) findViewById(R.id.editText);

        // Colocando ação no botão limpar
        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText ("");
            }



        });

        // colocando ação no botão pesquisar
        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.telainfo);
            }
        });

    }


        }



