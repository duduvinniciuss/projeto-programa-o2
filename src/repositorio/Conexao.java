package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:sqlite:banco.db";

    public static Connection conectar() {
        try {
            // Carrega o driver SQLite explicitamente
            Class.forName("org.sqlite.JDBC");
            // Tenta abrir a conexão com o banco
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver SQLite não encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco: " + e.getMessage());
            return null;
        }
    }
}
