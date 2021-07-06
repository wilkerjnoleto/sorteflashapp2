package com.sorteflash.sorteflashapp;

public class Pedido {
    private String codigo;
    private String Data;
    private String cliente;
    private String status;
    private String recebido;
    private String validado;

    public Pedido() {
    }

    public Pedido(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecebido() {
        return recebido;
    }

    public void setRecebido(String recebido) {
        this.recebido = recebido;
    }

    public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }

    @Override
    public String toString() {
        return  getData() + "  -  " + getCodigo() + "  -  " + getCliente();
    }

}
