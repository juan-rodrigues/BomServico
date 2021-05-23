
package dal;

import util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Categoria;


public class DalCategoria {
    public boolean salvar (Categoria cat)
    {
        String sql="insert into categoria (descricao) values ('$2')";
        sql=sql.replace("$2",cat.getDescricao());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
    public boolean alterar (Categoria cat)
    {
        String sql="update categoria set descricao='$1' where idcategoria="+cat.getId();
        sql=sql.replace("$1",cat.getDescricao());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from categoria where idcategoria="+id);
        con.fecharConexao();
        return flag;                      
    }
    public Categoria getCategoriaNome(String nome)
    {   Categoria cat=null;
        String sql="select * from categoria where descricao='"+nome+"'";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            cat=new Categoria(rs.getInt("idcategoria"),rs.getString("descricao"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return cat;
    }
    public Categoria getCategoria(int cod)
    {   Categoria cat=null;
        String sql="select * from categoria where idcategoria="+cod;
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            cat=new Categoria(rs.getInt("idcategoria"),rs.getString("descricao"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return cat;
    }
    public ArrayList <Categoria> getCategoriaList(String filtro)
    {   ArrayList <Categoria> lista=new ArrayList();
        String sql="select * from categoria";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by idcategoria";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(new Categoria(rs.getInt("idcategoria"),rs.getString("descricao")) );
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
}
