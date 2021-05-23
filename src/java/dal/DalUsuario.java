
package dal;

import models.Usuario;
import util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DalUsuario {
    public boolean salvar (Usuario usu)
    {
        String sql="insert into usuario (nome,email,telefone,CEP,estado,"
                + "cidade,endereco,numero,complemento,CPF,senha,nivel) "
                + "values ('$1','$2','$3','$4','$5','$6','$7','$8','$9','$X0','$X1','$X2')";
        sql=sql.replace("$1",usu.getNome());
        sql=sql.replace("$2",usu.getEmail());
        sql=sql.replace("$3",usu.getTelefone());
        sql=sql.replace("$4",usu.getCEP());
        sql=sql.replace("$5",usu.getEstado());
        sql=sql.replace("$6",usu.getCidade());
        sql=sql.replace("$7",usu.getEndereco());
        sql=sql.replace("$8",usu.getNumero());
        sql=sql.replace("$9",usu.getComplemento());
        sql=sql.replace("$X0",usu.getCPF());
        sql=sql.replace("$X1",usu.getSenha());
        sql=sql.replace("$X2",Integer.toString(usu.getNivel()) );
        System.out.println(sql);
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
    public boolean alterar (Usuario usu)
    {
        String sql="update usuario set nome='$1', email='$2', telefone='$3', CEP='$4', estado='$5', cidade='$6'"
                + ", endereco='$7', numero='$8', complemento='$9', CPF='$X0', senha='$X1', nivel='$X2' "
                + " where idusuario="+usu.getId();
        sql=sql.replace("$1",usu.getNome());
        sql=sql.replace("$2",usu.getEmail());
        sql=sql.replace("$3",usu.getTelefone());
        sql=sql.replace("$4",usu.getCEP());
        sql=sql.replace("$5",usu.getEstado());
        sql=sql.replace("$6",usu.getCidade());
        sql=sql.replace("$7",usu.getEndereco());
        sql=sql.replace("$8",usu.getNumero());
        sql=sql.replace("$9",usu.getComplemento());
        sql=sql.replace("$X0",usu.getCPF());
        sql=sql.replace("$X1",usu.getSenha());
        sql=sql.replace("$X2",Integer.toString(usu.getNivel()));
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from usuario where idusuario="+id);
        con.fecharConexao();
        return flag;                      
    }
    public Usuario getUsuario(int cod)
    {   Usuario usu=null;
        String sql="select * from usuario where idusuario="+cod;
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            usu=new Usuario(rs.getInt("idusuario"),rs.getString("nome"),rs.getString("email")
                    ,rs.getString("telefone"),rs.getString("CEP"),rs.getString("estado")
                    ,rs.getString("cidade"),rs.getString("endereco"),rs.getString("numero")
                    ,rs.getString("complemento"),rs.getString("CPF"),rs.getString("senha"),rs.getInt("nivel"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return usu;
    }
    public Usuario getLogin(String email,String senha)
    {   Usuario usu=null;
        String sql="select * from usuario where email='"+email+"' and senha='"+senha+"'";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            usu=new Usuario(rs.getInt("idusuario"),rs.getString("nome"),rs.getString("email")
                    ,rs.getString("telefone"),rs.getString("CEP"),rs.getString("estado")
                    ,rs.getString("cidade"),rs.getString("endereco"),rs.getString("numero")
                    ,rs.getString("complemento"),rs.getString("CPF"),rs.getString("senha"),rs.getInt("nivel"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return usu;
    }
    public ArrayList <Usuario> getUsuarioList(String filtro)
    {   ArrayList <Usuario> lista=new ArrayList();
        String sql="select * from usuario";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by idusuario";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(
          new Usuario(rs.getInt("idusuario"),rs.getString("nome"),rs.getString("email")
                    ,rs.getString("telefone"),rs.getString("CEP"),rs.getString("estado")
                    ,rs.getString("cidade"),rs.getString("endereco"),rs.getString("numero")
                    ,rs.getString("complemento"),rs.getString("CPF"),rs.getString("senha"),rs.getInt("nivel"))
             );
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
}
