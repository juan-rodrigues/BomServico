package models;

public class Usuario {

    private int id,nivel;
    private String nome, email, telefone, CEP, estado, cidade, endereco, numero,complemento, CPF, senha;

    public Usuario() {
    }

    public Usuario(int id, String nome, String email, String telefone, String CEP, String estado, String cidade, String endereco, String numero, String complemento, String CPF, String senha, int nivel) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.CEP = CEP;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.CPF = CPF;
        this.senha = senha;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

   

}
