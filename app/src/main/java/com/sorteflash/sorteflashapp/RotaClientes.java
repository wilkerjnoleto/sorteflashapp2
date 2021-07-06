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
import okhttp3.ResponseBody;

public class RotaClientes {

    public List<Clientes> listaClientesPorCambista(String tutorId) {
        List<Clientes> resultado = new ArrayList<>();
        try {
//rota de teste - http://162.214.107.96:5000/api
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"tutorId\" : \""+tutorId+"\"}");
            Request request = new Request.Builder()
                    .url("http://162.214.107.96:5000/api/usuarios/listar-por-tutor")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("Cookie", "session=eyJmbGFzaCI6e319; session.sig=MwT6aSgX1rSKg7mAgoHLtyJoI2k")
                    .build();
            Response response = client.newCall(request).execute();
            //System.out.println(response.body().string());
            String jsonData = response.body().string();
            JSONArray objetoJSON = (JSONArray) JSONValue.parseWithException(jsonData.toString());
            if (objetoJSON != null) {
                for (Iterator it = objetoJSON.iterator(); it.hasNext();) {
                    JSONObject obj = (JSONObject) it.next();
                    Clientes clientes = new Clientes();
                    clientes.set_id(obj.get("_id").toString());
                    clientes.setBairro(obj.get("bairro").toString());
                    clientes.setCidade(obj.get("cidade").toString());
                    try{clientes.setCpf(obj.get("cpf").toString());}catch(Exception e){}
                    clientes.setEndereco(obj.get("endereco").toString());
                    clientes.setEstado(obj.get("estado").toString());
                    clientes.setNome(obj.get("nome").toString());
                    clientes.setPerfil(obj.get("perfil").toString());
                    clientes.setTelefone(obj.get("telefone").toString());
                    clientes.setTutorId(obj.get("tutorId").toString());
                    resultado.add(clientes);
                }
            }


        }catch(Exception e){
            e.printStackTrace();

        }

        return resultado;
    }


   /* public static void main(String args[]) {
        RotaClientes rotaClientes = new RotaClientes();

        System.out.println(rotaClientes.listaClientesPorCambista(""));


    }*/

}
