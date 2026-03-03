package persistencia;

import dados.Gastos;
import dados.TipoGasto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastosDAO {

    public void inserir(int usuarioId, Gastos g) {
        String sql = "INSERT INTO gasto (usuario_id, nome, data, descricao, valor, tipo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, usuarioId);
            stmt.setString(2, g.getNome());
            stmt.setString(3, g.getData());
            stmt.setString(4, g.getDesc());
            stmt.setDouble(5, g.getValor());
            stmt.setString(6, g.getTipo().name()); //tava dando problema
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) g.setId(rs.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gastos> buscarPorUsuario(int usuarioId) {

        //verificando tambem se o metodo esta sendo chamado 
       // System.out.println("Buscando gastos do usuário ID: " + usuarioId);

        List<Gastos> lista = new ArrayList<>();
        String sql = "SELECT * FROM gasto WHERE usuario_id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Gastos g = new Gastos();
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setData(rs.getString("data"));
                g.setDesc(rs.getString("descricao"));
                g.setValor(rs.getDouble("valor"));
                g.setTipo(TipoGasto.valueOf(rs.getString("tipo")));
                lista.add(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Gastos g) {
        String sql = "UPDATE gasto SET nome=?, data=?, descricao=?, valor=?, tipo=? WHERE id=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, g.getNome());
            stmt.setString(2, g.getData());
            stmt.setString(3, g.getDesc());
            stmt.setDouble(4, g.getValor());
            stmt.setObject(5, g.getTipo().name(), Types.OTHER);
            stmt.setInt(6, g.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean remover(int gastoId) {
        String sql = "DELETE FROM gasto WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, gastoId);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Gastos> buscarPorNome(int usuarioId, String nome) {
        List<Gastos> lista = new ArrayList<>();
        String sql = "SELECT * FROM gasto WHERE usuario_id = ? AND LOWER(nome) = LOWER(?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.setString(2, nome.trim());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Gastos g = new Gastos();
                g.setId(rs.getInt("id"));
                g.setNome(rs.getString("nome"));
                g.setData(rs.getString("data"));
                g.setDesc(rs.getString("descricao"));
                g.setValor(rs.getDouble("valor"));
                g.setTipo(TipoGasto.valueOf(rs.getString("tipo")));
                lista.add(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
