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

public class RotaPedidos {

    public List<Pedido> listaPedidoPorCambista(String tutorId) {
        List<Pedido> resultado = new ArrayList<>();
        try {
//rota de teste - http://162.214.107.96:5000/api
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"tutorId\" : \""+tutorId+"\"}");
            Request request = new Request.Builder()
                    .url("http://162.214.107.96:5000/api/pedidos/listar-pedidos")
                    .post(body)
                    .addHeader("content-type", "application/json")
                    .addHeader("Cookie", "session=eyJmbGFzaCI6e319; session.sig=MwT6aSgX1rSKg7mAgoHLtyJoI2k")
                    .build();
            Response response = client.newCall(request).execute();

            String jsonData = response.body().string();
            JSONArray objetoJSON = (JSONArray) JSONValue.parseWithException(jsonData.toString());
            if (objetoJSON != null) {
                for (Iterator it = objetoJSON.iterator(); it.hasNext();) {
                    JSONObject obj = (JSONObject) it.next();
                    Pedido pedido = new Pedido();
                    pedido.setCodigo(obj.get("codigo").toString());
                    pedido.setData(obj.get("data").toString());

                    JSONObject contatos = (JSONObject) obj.get("clienteId");
                    pedido.setCliente(contatos.get("nome").toString());
                    resultado.add(pedido);
                }
            }


        }catch(Exception e){
            e.printStackTrace();

        }

        return resultado;
    }

/*
    public static void main(String args[]) {
        RotaPedidos rotaClientes = new RotaPedidos();

        System.out.println(rotaClientes.listaPedidoPorCambista("5f7f1d1869483d43b788df30"));


    }
*/
}
