package com.sorteflash.sorteflashapp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RotaUsuario {

    public UsuarioLogar logarApp(String email,String senha) {
        UsuarioLogar usuarioLogar = new UsuarioLogar();
        try {

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"email\" : \""+email+"\",\"senha\" : \""+senha+"\"}");
            Request request = new Request.Builder()
                    .url("http://162.214.107.96:5000/api/auth/login?email="+email+"&senha="+senha)
                    .post(body)
                    .addHeader("content-type", "text/plain")
                    .addHeader("Cookie", "session=eyJwYXNzcG9ydCI6eyJ1c2VyIjoiNWZjYTcyZDU4NTc2YzI0ZDFmOGNiYjgxIn19; session.sig=UF3Sr6Z2A2OU3rEzyKGzLYwA7v0")
                    .build();
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            String jsonData = response.body().string();
            JSONObject objetoJSON = (JSONObject) JSONValue.parseWithException(jsonData.toString());
            if (objetoJSON != null) {


                    usuarioLogar.set_id(objetoJSON.get("_id").toString());
                   try{ usuarioLogar.setCidade(objetoJSON.get("cidade").toString());}catch(Exception e){}
                   try{usuarioLogar.setEstado(objetoJSON.get("estado").toString());}catch(Exception e){}
                    usuarioLogar.setComissao(objetoJSON.get("comissao").toString());
                    usuarioLogar.setCpf(objetoJSON.get("cpf").toString());
                    usuarioLogar.setEmail(objetoJSON.get("email").toString());
                    try{usuarioLogar.setEndereco(objetoJSON.get("endereco").toString());}catch(Exception e){}
                    usuarioLogar.setNome(objetoJSON.get("nome").toString());
                    usuarioLogar.setPerfil(objetoJSON.get("perfil").toString());
                    try{usuarioLogar.setStatus((boolean)objetoJSON.get("status"));}catch(Exception e){}
                    usuarioLogar.setTelefone(objetoJSON.get("telefone").toString());
                    if(objetoJSON.get("tutorId") != null) {
                        usuarioLogar.setTutorId(objetoJSON.get("tutorId").toString());
                    } else {
                        usuarioLogar.setTutorId(objetoJSON.get("_id").toString());
                    }


            }


        }catch(Exception e){
            e.printStackTrace();

        }

        return usuarioLogar;
    }


    /*public static void main(String args[]) {
        RotaUsuario rotaClientes = new RotaUsuario();

        System.out.println(rotaClientes.logarApp("teste8@sorteflash.com","sortemaster"));


    }*/

}
