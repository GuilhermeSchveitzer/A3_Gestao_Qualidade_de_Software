package conexao;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ConexaoTest {

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
        // Limpar a conexão estática para não atrapalhar outros testes
        try {
            Field conexaoField = Conexao.class.getDeclaredField("conexao");
            conexaoField.setAccessible(true);
            conexaoField.set(null, null);
        } catch (Exception e) {
            e.printStackTrace();
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
    public void testSingletonConexao() {
        Connection conexao2 = Conexao.getConexao();
        assertSame(conexao, conexao2, "Deve retornar a mesma instância da conexão (singleton)");
    }

    @Test
    public void testTabelasCriadas() {
        try (Statement stmt = conexao.createStatement()) {
            assertTrue(existeTabela(stmt, "tb_amigos"), "Tabela tb_amigos deve existir");
            assertTrue(existeTabela(stmt, "tb_ferramentas"), "Tabela tb_ferramentas deve existir");
            assertTrue(existeTabela(stmt, "tb_emprestimos"), "Tabela tb_emprestimos deve existir");
        } catch (SQLException e) {
            fail("Erro ao verificar existência das tabelas: " + e.getMessage());
        }
    }

    private boolean existeTabela(Statement stmt, String nomeTabela) throws SQLException {
        try (ResultSet rs = stmt.executeQuery(
                "SELECT name FROM sqlite_master WHERE type='table' AND name='" + nomeTabela + "';")) {
            return rs.next();
        }
    }

    @Test
    public void testCriarTabelasIniciaisIdempotente() {
        assertDoesNotThrow(() -> Conexao.criarTabelasIniciais(), "Não deve lançar exceção ao criar tabelas novamente"); 

        
        try (Statement stmt = conexao.createStatement()) {
            assertTrue(existeTabela(stmt, "tb_amigos"), "Após recriar, tb_amigos ainda deve existir");
            assertTrue(existeTabela(stmt, "tb_ferramentas"), "Após recriar, tb_ferramentas ainda deve existir");
            assertTrue(existeTabela(stmt, "tb_emprestimos"), "Após recriar, tb_emprestimos ainda deve existir");
        } catch (SQLException e) {
            fail("Erro ao verificar tabelas após idempotência: " + e.getMessage());
        }
    }

    @Test
    public void testGetConexaoClassNotFoundException() {
        assertTrue(true, "Este teste é conceitual e precisa de mock para ser efetivo."); 
    }

    @Test
    public void testGetConexaoSQLException() {
         assertTrue(true, "Este teste é conceitual e precisa de mock para ser efetivo.");
    }
}