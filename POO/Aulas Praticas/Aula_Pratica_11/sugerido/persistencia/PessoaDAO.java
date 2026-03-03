import java.util.concurrent.ConcurrentHashMap;
import java.sql.Connection;
import java.sql.*;
import dados.Pessoa;

public class PessoaDAO{

    private static PessoaDAO pessoaDAO = null;
    private PreparedStatement selectPessoa;

    private PessoaDAO{
        Connection con = Conexao.getConexao();

        selectPessoa = new con.prepareStatment("Select * from pessoa where ");

    }

    public static PessoaDAO getInstance() throws ClassNotFoundException, SQLException{
        if(PessoaDAO == null){
            pessoaDAO = new PessoaDAO();

        }

        return pessoaDAO;

    }

    public Pessoa select (int id_pessoa){
        Pessoa p = null;

        selectPessoa.setInt(1, id_pessoa);
        Resultset rs  = selectPessoa.executeQuery();

        if(rs.next()){
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cps"));
        }

        return p;

    }

}