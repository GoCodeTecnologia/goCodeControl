package gocodecontrol.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/coopgreen?useTimezone=true&serverTimezone=UTC";
    private final String USER = "root";
    private final String PASS = "arlabs2022";
    private Connection conn;

    public Conexao() throws ClassNotFoundException, SQLException {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("O Driver não foi localizado e adicionado. Talvez a biblioteca JDBC não foi adicionada ao projeto.\n" + e.getMessage());
        } catch (SQLException e) {
            throw new SQLException("Deu erro na conexão com a fonte de dados.\n" + e.getMessage());
        }
    }

    public Connection getConexao() {
        return conn;
    }

    public void confirmar() throws SQLException {
        try {
            conn.commit();
        } catch (SQLException e) {

            throw new SQLException("Não foi possível executar o comando SQL.\n" + e.getMessage());
        } finally {
            conn.close();
        }
    }
}