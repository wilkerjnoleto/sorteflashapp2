package com.sorteflash.sorteflashapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btLogin;
    private EditText editText01,editText02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        editText01 = (EditText) findViewById(R.id.editText);
        editText02 = (EditText) findViewById(R.id.editText2);

        final Activity activity = this;
        btLogin = (Button) findViewById(R.id.button);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                UsuarioLogar usuarioLogar = new RotaUsuario().logarApp(editText01.getText().toString(),editText02.getText().toString());
                //System.out.println(usuarioLogar.getNome());
                if(usuarioLogar.getTutorId() != null && usuarioLogar.getTutorId().isEmpty() == false) {
                    Intent abriEditarEvento = new Intent(LoginActivity.this, MenuActivity.class);
                    Bundle enviar = new Bundle();
                    enviar.putString("nomeusuario",usuarioLogar.getNome());
                    enviar.putString("tutorId",usuarioLogar.getTutorId());
                    abriEditarEvento.putExtras(enviar);
                    startActivity(abriEditarEvento);
                } else {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Aviso!!!")
                            .setMessage("Você ainda não está cadastrado")
                            .show();
                }
            }
        });

    }
}
