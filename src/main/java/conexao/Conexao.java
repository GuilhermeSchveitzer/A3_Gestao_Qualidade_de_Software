package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    private static final String URL = "jdbc:sqlite:bancodedados.db"; 
    private static Connection conexao;

    // Método que retorna a conexão
    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName("org.sqlite.JDBC");

                conexao = DriverManager.getConnection(URL);
                System.out.println("Conexão com banco de dados SQLite estabelecida.");

                // <<< MÍNIMA ALTERAÇÃO: chama criação das tabelas assim que conecta
                criarTabelasIniciais();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC SQLite não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }

        return conexao;
    }

    public static void criarTabelasIniciais() {
        String sqlAmigos = "CREATE TABLE IF NOT EXISTS tb_amigos (" +
                "idAmigo INTEGER NOT NULL PRIMARY KEY," +
                "nomeAmigo TEXT NOT NULL," +
                "telefone TEXT NOT NULL);";

        String sqlFerramentas = "CREATE TABLE IF NOT EXISTS tb_ferramentas (" +
                "idFerramenta INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nomeFerramenta TEXT NOT NULL," +
                "marca TEXT NOT NULL," +
                "custo REAL NOT NULL);";

        String sqlEmprestimos = "CREATE TABLE IF NOT EXISTS tb_emprestimos (" +
                "idEmprestimo INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "idAmigo INTEGER NOT NULL," +
                "idFerramenta INTEGER NOT NULL," +
                "dataDevolucao TEXT," +
                "dataEmprestimo TEXT," +
                "pendente INTEGER NOT NULL," +
                "FOREIGN KEY(idAmigo) REFERENCES tb_amigos(idAmigo)," +
                "FOREIGN KEY(idFerramenta) REFERENCES tb_ferramentas(idFerramenta));";

        try (Statement stmt = conexao.createStatement()) {
            stmt.execute(sqlAmigos);
            stmt.execute(sqlFerramentas);
            stmt.execute(sqlEmprestimos);
            System.out.println("Tabelas verificadas/criadas com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}
