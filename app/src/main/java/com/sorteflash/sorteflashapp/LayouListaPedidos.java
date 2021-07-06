package com.sorteflash.sorteflashapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

public class LayouListaPedidos extends BaseAdapter {

    private final List<Pedido> listaPedido;
    private final Activity act;

    public LayouListaPedidos(List<Pedido> listaPedido, Activity act) {
        this.listaPedido = listaPedido;
        this.act = act;
    }

    @Override public int getCount(){return listaPedido.size();}

    @Override public Object getItem(int position){return listaPedido.get(position);}

    @Override public long getItemId(int position){return 0;}

    @Override public View getView(int position, View convertView, ViewGroup parent){
        View view = act.getLayoutInflater().inflate(R.layout.lista_pedidos_personalizada,parent,false);
        Pedido pedido = listaPedido.get(position);

        TextView nome = (TextView) view.findViewById(R.id.lista_nome);
        TextView descricao = (TextView) view.findViewById(R.id.lista_descricao);

        nome.setText("Cliente: " + pedido.getCliente());


            descricao.setText("Código.:"+pedido.getCodigo() + " - Data:" + pedido.getData());


        return view;
    }

}
