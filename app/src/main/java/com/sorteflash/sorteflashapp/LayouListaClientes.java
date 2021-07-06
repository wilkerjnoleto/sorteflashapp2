package com.sorteflash.sorteflashapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class LayouListaClientes extends BaseAdapter {

    private final List<Clientes> listaClientes;
    private final Activity act;

    public LayouListaClientes(List<Clientes> listaClientes, Activity act) {
        this.listaClientes = listaClientes;
        this.act = act;
    }

    @Override public int getCount(){return listaClientes.size();}

    @Override public Object getItem(int position){return listaClientes.get(position);}

    @Override public long getItemId(int position){return 0;}

    @Override public View getView(int position, View convertView, ViewGroup parent){
        View view = act.getLayoutInflater().inflate(R.layout.lista_clientes_personalizada,parent,false);
        Clientes clientes = listaClientes.get(position);

        TextView nome = (TextView) view.findViewById(R.id.lista_nome);
        TextView descricao = (TextView) view.findViewById(R.id.lista_descricao);

        nome.setText("Nome: " + clientes.getNome());
        descricao.setText("Cid.:"+clientes.getCidade() + " - Tel." + clientes.getTelefone());

        return view;
    }

}
