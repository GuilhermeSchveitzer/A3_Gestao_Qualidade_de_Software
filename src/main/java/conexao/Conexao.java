package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:sqlite:C:/Users/igor/Documents/BancoDados/banco de dados.db"; // <- precisa do prefixo jdbc:sqlite:
    private static Connection conexao;

    // Método que retorna a conexão (como no código original)
    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                // Carrega o driver (não obrigatório em versões mais recentes, mas bom por compatibilidade)
                Class.forName("org.sqlite.JDBC");

                conexao = DriverManager.getConnection(URL);
                System.out.println("Conexão com banco de dados SQLite estabelecida.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC SQLite não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        return conexao;
    }
}

   