package dados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {

    public void inserir(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal (nome, cor, idade, largura, comprimento, altura) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getCor());
            stmt.setInt(3, animal.getIdade());
            stmt.setInt(4, animal.getLargura());
            stmt.setInt(5, animal.getComprimento());
            stmt.setInt(6, animal.getAltura());

            stmt.executeUpdate();
        }
    }

    public List<Animal> listarTodos() throws SQLException {
        List<Animal> animais = new ArrayList<>();
        String sql = "SELECT * FROM animal";
        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setNome(rs.getString("nome"));
                animal.setCor(rs.getString("cor"));
                animal.setIdade(rs.getInt("idade"));
                animal.setLargura(rs.getInt("largura"));
                animal.setComprimento(rs.getInt("comprimento"));
                animal.setAltura(rs.getInt("altura"));
                animais.add(animal);
            }
        }
        return animais;
    }
}
