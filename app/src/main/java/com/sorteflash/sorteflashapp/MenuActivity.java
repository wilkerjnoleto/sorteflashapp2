package com.sorteflash.sorteflashapp;

import android.app.Activity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private Button gerenciarClientes,sairApp,pedidosApp,relatorioApp;
    private TextView nomeUserLogado;
    private UsuarioLogar usuarioLogar = new UsuarioLogar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Intent interacao = getIntent();
        Bundle receber = interacao.getExtras();

        usuarioLogar.setNome(receber.getString("nomeusuario"));
        usuarioLogar.setTutorId(receber.getString("tutorId"));

        nomeUserLogado = (TextView) findViewById(R.id.textView2);
        nomeUserLogado.setText("Usuário: " + usuarioLogar.getNome());

        final Activity activity = this;
        gerenciarClientes = (Button) findViewById(R.id.imageButton1);
        gerenciarClientes.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view){
                    Intent abriEditarEvento = new Intent(MenuActivity.this, ListActivity.class);
                    Bundle enviar = new Bundle();
                    enviar.putString("nomeusuario",usuarioLogar.getNome());
                    enviar.putString("tutorId",usuarioLogar.getTutorId());
                    abriEditarEvento.putExtras(enviar);
                    startActivity(abriEditarEvento);
                }

        });

        sairApp = (Button) findViewById(R.id.imageButton);
        sairApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                finish();
            }
        });

        pedidosApp = (Button) findViewById(R.id.imageButton2);
        pedidosApp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent abriEditarEvento = new Intent(MenuActivity.this, ListPedidoActivity.class);
                Bundle enviar = new Bundle();
                enviar.putString("nomeusuario",usuarioLogar.getNome());
                enviar.putString("tutorId",usuarioLogar.getTutorId());
                abriEditarEvento.putExtras(enviar);
                startActivity(abriEditarEvento);
            }

        });

        relatorioApp = (Button) findViewById(R.id.imageButton3);
        relatorioApp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent abriEditarEvento = new Intent(MenuActivity.this, RelatorioActivity.class);
                Bundle enviar = new Bundle();
                enviar.putString("nomeusuario",usuarioLogar.getNome());
                enviar.putString("tutorId",usuarioLogar.getTutorId());
                abriEditarEvento.putExtras(enviar);
                startActivity(abriEditarEvento);
            }

        });

    }
}
