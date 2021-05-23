
package models;


public class Anuncio {
    private int id;
    private String titulo,descricao,estado,cidade,dia,horario,preco,imagen1,imagen2,imagen3,
            breveDescri;
    private Usuario usu;
    private Categoria cat;

    public Anuncio() {
    }

    public Anuncio(int id, Usuario usu, Categoria cat, String titulo, String descricao, String breveDescri,
            String estado, String cidade, String dia, String horario, String preco, String imagen1,
            String imagen2, String imagen3) {
        this.id = id;
        this.usu = usu;
        this.cat = cat;
        this.titulo = titulo;
        this.descricao = descricao;
        this.breveDescri = breveDescri;
        this.estado = estado;
        this.cidade = cidade;
        this.dia = dia;
        this.horario = horario;
        this.preco = preco;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;  
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public String getBreveDescri() {
        return breveDescri;
    }

    public void setBreveDescri(String breveDescri) {
        this.breveDescri = breveDescri;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

   

   
    
    
    
    
}
