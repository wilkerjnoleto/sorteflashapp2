package com.sorteflash.sorteflashapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private TextView nomeUserLogado;
    private UsuarioLogar usuarioLogar = new UsuarioLogar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list);

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
        List<Clientes> listaDeClientes = new RotaClientes().listaClientesPorCambista(usuarioLogar.getTutorId());
        //ArrayAdapter<Clientes> adapter = new ArrayAdapter<Clientes>(this,android.R.layout.simple_list_item_1,listaDeClientes);
        LayouListaClientes adapter = new LayouListaClientes(listaDeClientes,this);
        listView.setAdapter(adapter);
    }
}
