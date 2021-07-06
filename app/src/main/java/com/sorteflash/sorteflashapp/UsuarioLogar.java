package com.sorteflash.sorteflashapp;

public class UsuarioLogar {

    private boolean status;
    private String _id;
    private String nome;
    private String email;
    private String telefone;
    private String comissao;
    private String cpf;
    private String endereco;
    private String cidade;
    private String estado;
    private String tutorId;
    private String perfil;


    public UsuarioLogar() {

    }

    public UsuarioLogar(boolean status, String _id, String nome, String email, String telefone, String comissao, String cpf, String endereco, String cidade, String estado, String tutorId, String perfil) {
        this.status = status;
        this._id = _id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.comissao = comissao;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.tutorId = tutorId;
        this.perfil = perfil;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getComissao() {
        return comissao;
    }

    public void setComissao(String comissao) {
        this.comissao = comissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "UsuarioLogar{" +
                "status=" + status +
                ", _id='" + _id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", comissao='" + comissao + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", tutorId='" + tutorId + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
