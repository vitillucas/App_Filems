package com.example.myfirstapp;


import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button buttonLimpar;
    private Button buttonPesquisar;
    private EditText editText;

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarando os botoes e a barra de pesquisar
        buttonPesquisar = (Button) findViewById(R.id.buttonPesquisar);
        buttonVoltar = (Button) findViewById(R.id.buttonVoltar);

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
        })
// iniciando o json
new JsonTask().execute("http://www.omdbapi.com/?i=tt3896198&apikey=a45a2a24");
}

//lendo o json
class JsonTask extends AsyncTask<String, String, String> {


            protected void onPreExecute() {
                super.onPreExecute();
            }

            protected String doInBackground(String... params) {

               HttpURLConnection connection = null;
                BufferedReader reader = null;

                try {
                    URL url = new URL(params[0]);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();


                    InputStream stream = connection.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();
                    String line = "";

                    while ((line = reader.readLine()) != null) {
                        buffer.append(line+"\n");
                        Log.d("Response: ", "> " + line);
                    }

                    return buffer.toString();


                } catch (java.net.MalformedURLException e) {
                    e.printStackTrace();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }



            }





