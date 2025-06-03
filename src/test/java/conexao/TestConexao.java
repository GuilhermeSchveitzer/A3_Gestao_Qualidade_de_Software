package conexao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestConexao {

    private static Connection conexao;

    @BeforeAll
    public static void setup() {
        conexao = Conexao.getConexao();
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
        }
    }

    @Test
    public void testGetConexaoNotNull() {
        assertNotNull(conexao, "A conexão não deve ser nula");
        try {
            assertFalse(conexao.isClosed(), "A conexão não deve estar fechada");
        } catch (SQLException e) {
            fail("Erro ao verificar conexão aberta: " + e.getMessage());
        }
    }

    @Test
    public void testTabelasCriadas() {
        // Testa se as tabelas foram criadas/existem no banco
        try (Statement stmt = conexao.createStatement()) {
            // Testar se tabela tb_amigos existe
            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tb_amigos';");
            assertTrue(rs.next(), "Tabela tb_amigos deve existir");
            rs.close();

            // Testar se tabela tb_ferramentas existe
            rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tb_ferramentas';");
            assertTrue(rs.next(), "Tabela tb_ferramentas deve existir");
            rs.close();

            // Testar se tabela tb_emprestimos existe
            rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='tb_emprestimos';");
            assertTrue(rs.next(), "Tabela tb_emprestimos deve existir");
            rs.close();
        } catch (SQLException e) {
            fail("Erro ao verificar existência das tabelas: " + e.getMessage());
        }
    }
}
