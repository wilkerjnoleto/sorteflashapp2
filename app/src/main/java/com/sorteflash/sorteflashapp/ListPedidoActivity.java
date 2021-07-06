package com.sorteflash.sorteflashapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListPedidoActivity extends AppCompatActivity {

    private ListView listView;
    private TextView nomeUserLogado;
    private UsuarioLogar usuarioLogar = new UsuarioLogar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_listpedidos);

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

        listView = findViewById(R.id.list);
        List<Pedido> listaDePedidos = new RotaPedidos().listaPedidoPorCambista(usuarioLogar.getTutorId());

        LayouListaPedidos adapter = new LayouListaPedidos(listaDePedidos,this);
        listView.setAdapter(adapter);
    }
}
