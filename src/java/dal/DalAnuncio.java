package dal;

import util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Anuncio;

public class DalAnuncio {

    public boolean salvar(Anuncio anun) {
        String sql = "insert into anuncio (idusuario ,idcategoria ,titulo ,descricao ,brevedesc ,"
                + "estado ,cidade ,dia ,horario ,preco ,imagem1 ,imagem2,imagem3  ) "
                + "values ('$1','$2','$3','$4','$5','$6','$7','$8','$9','$X0','$X1','$X2','$X3')";
        sql = sql.replace("$1", Integer.toString(anun.getUsu().getId()));
        sql = sql.replace("$2", Integer.toString(anun.getCat().getId()));
        sql = sql.replace("$3", anun.getTitulo());
        sql = sql.replace("$4", anun.getDescricao());
        sql = sql.replace("$5", anun.getBreveDescri());
        sql = sql.replace("$6", anun.getEstado());
        sql = sql.replace("$7", anun.getCidade());
        sql = sql.replace("$8", anun.getDia());
        sql = sql.replace("$9", anun.getHorario());
        sql = sql.replace("$X0", anun.getPreco());
        sql = sql.replace("$X1", anun.getImagen1());
        sql = sql.replace("$X2", anun.getImagen2());
        sql = sql.replace("$X3", anun.getImagen3());
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean alterar(Anuncio anun) {
        String sql = "update anuncio set idusuario='$1', idcategoria='$2', titulo='$3', descricao='$4', brevedesc='$5', estado='$6'"
                + ", cidade='$7', dia='$8', horario='$9', preco='$X0', imagem1='$X1', imagem2='$X2', imagem3='$X3' "
                + " where idanuncio=" + anun.getId();
        sql = sql.replace("$1", Integer.toString(anun.getUsu().getId()));
        sql = sql.replace("$2", Integer.toString(anun.getCat().getId()));
        sql = sql.replace("$3", anun.getTitulo());
        sql = sql.replace("$4", anun.getDescricao());
        sql = sql.replace("$5", anun.getBreveDescri());
        sql = sql.replace("$6", anun.getEstado());
        sql = sql.replace("$7", anun.getCidade());
        sql = sql.replace("$8", anun.getDia());
        sql = sql.replace("$9", anun.getHorario());
        sql = sql.replace("$X0", anun.getPreco());
        sql = sql.replace("$X1", anun.getImagen1());
        sql = sql.replace("$X2", anun.getImagen2());
        sql = sql.replace("$X3", anun.getImagen3());
        Conexao con = new Conexao();
        boolean flag = con.manipular(sql);
        con.fecharConexao();
        return flag;
    }

    public boolean apagar(int id) {
        Conexao con = new Conexao();
        boolean flag = con.manipular("delete from anuncio where idanuncio=" + id);
        con.fecharConexao();
        return flag;
    }

    public Anuncio getAnuncio(int cod) {
        Anuncio anun = null;
        String sql = "select * from anuncio where idanuncio=" + cod;
        Conexao con = new Conexao();
        ResultSet rs = con.consultar(sql);
        try {
            if (rs.next()) {
                anun = new Anuncio(
                        rs.getInt("idanuncio"),
                        new DalUsuario().getUsuario(rs.getInt("idusuario")),
                        new DalCategoria().getCategoria(rs.getInt("idcategoria")),
                        rs.getString("titulo"), rs.getString("descricao"),
                        rs.getString("brevedesc"), rs.getString("estado"), rs.getString("cidade"),
                        rs.getString("dia"), rs.getString("horario"), rs.getString("preco"),
                        rs.getString("imagem1"), rs.getString("imagem2"), rs.getString("imagem3")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return anun;
    }

    public ArrayList<Anuncio> getAnuncioList(String filtro) {
        ArrayList<Anuncio> lista = new ArrayList();
        String sql = "select * from anuncio";
        if (!filtro.isEmpty()) {
            sql += " where " + filtro;
        }
        sql += " order by idanuncio";
        Conexao con = new Conexao();
        ResultSet rs = con.consultar(sql);
        try {
            while (rs.next()) {
                lista.add(
                        new Anuncio(
                                rs.getInt("idanuncio"),
                                new DalUsuario().getUsuario(rs.getInt("idusuario")),
                                new DalCategoria().getCategoria(rs.getInt("idcategoria")),
                                rs.getString("titulo"), rs.getString("descricao"),
                                rs.getString("brevedesc"), rs.getString("estado"), rs.getString("cidade"),
                                rs.getString("dia"), rs.getString("horario"), rs.getString("preco"),
                                rs.getString("imagem1"), rs.getString("imagem2"), rs.getString("imagem3")
                        )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        con.fecharConexao();
        return lista;
    }
}
