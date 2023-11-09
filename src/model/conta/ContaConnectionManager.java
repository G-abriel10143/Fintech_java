package model.conta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContaConnectionManager {
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521/seubanco"; // Substitua pelo URL do seu banco de dados Oracle
    private static final String DATABASE_USER = "seuusuario"; // Substitua pelo nome de usuário do banco de dados
    private static final String DATABASE_PASSWORD = "suasenha"; // Substitua pela senha do banco de dados

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Carrega o driver JDBC para o Oracle
            Class.forName("oracle.jdbc.OracleDriver");

            // Estabelece a conexão com o banco de dados Oracle
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao estabelecer a conexão com o banco de dados Oracle.");
        }
        return connection;
    }
}
