package repositorio;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CriarBanco {
    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS pedido (" +
                "codigo TEXT PRIMARY KEY," +
                "descricao TEXT NOT NULL," +
                "valor REAL NOT NULL" +
                ");";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Banco e tabela criados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar banco ou tabela: " + e.getMessage());
        }
    }
}
