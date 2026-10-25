package unifaj.com.planosaude.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    private static final String URL      = "jdbc:h2:file:./data/planosaude;AUTO_SERVER=TRUE";
    private static final String USER     = "sa";
    private static final String PASSWORD = "";

    static {
        criarTabelas();
    }

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void criarTabelas() {
        String sqlPaciente =
                "CREATE TABLE IF NOT EXISTS paciente (" +
                        " id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        " nome VARCHAR(150) NOT NULL," +
                        " cpf VARCHAR(14) NOT NULL," +
                        " data_nascimento DATE," +
                        " telefone VARCHAR(20)," +
                        " numero_carteirinha VARCHAR(30))";
        String sqlMedico =
                "CREATE TABLE IF NOT EXISTS medico (" +
                        " id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        " nome VARCHAR(150) NOT NULL," +
                        " crm VARCHAR(20) NOT NULL," +
                        " especialidade VARCHAR(80)," +
                        " telefone VARCHAR(20))";
        try (Connection c = getConnection(); Statement st = c.createStatement()) {
            st.execute(sqlPaciente);
            st.execute(sqlMedico);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabelas", e);
        }
    }
}