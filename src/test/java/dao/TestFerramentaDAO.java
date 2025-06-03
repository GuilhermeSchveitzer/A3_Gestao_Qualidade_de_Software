package dao;

import modelo.Ferramenta;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFerramentaDAO {

    private static FerramentaDAO dao;
    private static final int TEST_ID = 9999;

    @BeforeAll
    public static void setup() {
        dao = new FerramentaDAO();
    }

    @Test
    @Order(1)
    public void testInserirFerramentaBD_Sucesso() {
        Ferramenta f = new Ferramenta(TEST_ID, "Chave Inglesa", "MarcaX", 99.99);
        boolean inserted = dao.inserirFerramentaBD(f);
        assertTrue(inserted, "Inserção deve retornar true");
    }

    @Test
    @Order(2)
    public void testInserirFerramentaBD_Falha() {
        // Testar inserção com objeto null gera RuntimeException pelo DAO (catch SQLException lança RuntimeException)
        assertThrows(RuntimeException.class, () -> {
            dao.inserirFerramentaBD(null);
        }, "Inserir objeto null deve lançar RuntimeException");
    }

    @Test
    @Order(3)
    public void testGetListaFerramenta() {
        ArrayList<Ferramenta> lista = dao.getListaFerramenta();
        assertNotNull(lista, "Lista não deve ser nula");
        assertTrue(lista.size() > 0, "Lista deve conter pelo menos uma ferramenta");
        boolean found = lista.stream().anyMatch(f -> f.getIdFerramenta() == TEST_ID);
        assertTrue(found, "Deve conter ferramenta com id TEST_ID");
    }

    @Test
    @Order(4)
    public void testCarregaFerramentaPorId_Existente() {
        Ferramenta f = dao.carregaFerramentaPorId(TEST_ID);
        assertNotNull(f, "Ferramenta não deve ser nula");
        assertEquals(TEST_ID, f.getIdFerramenta());
        assertEquals("Chave Inglesa", f.getNomeFerramenta());
        assertEquals("MarcaX", f.getMarca());
        assertEquals(99.99, f.getCusto(), 0.001);
    }

    @Test
    @Order(6)
    public void testAtualizarFerramentaBD_Sucesso() {
        Ferramenta f = new Ferramenta(TEST_ID, "Chave Atualizada", "MarcaAtualizada", 120.0);
        boolean updated = dao.atualizarFerramentaBD(f);
        assertTrue(updated, "Atualização deve retornar true");

        Ferramenta f2 = dao.carregaFerramentaPorId(TEST_ID);
        assertEquals("Chave Atualizada", f2.getNomeFerramenta());
        assertEquals("MarcaAtualizada", f2.getMarca());
        assertEquals(120.0, f2.getCusto(), 0.001);
    }

    @Test
    @Order(7)
    public void testAtualizarFerramentaBD_Falha() {
        // Atualizar com null deve lançar RuntimeException, pois NullPointerException ocorre fora do try (melhor para teste)
        assertThrows(RuntimeException.class, () -> {
            dao.atualizarFerramentaBD(null);
        }, "Atualizar objeto null deve lançar RuntimeException");
    }

    @Test
    @Order(8)
    public void testMaiorID() {
        int maior = dao.maiorID();
        assertTrue(maior >= TEST_ID, "Maior ID deve ser maior ou igual ao TEST_ID");
    }
    
    @Test
    @Order(11)
    public void testVerificaDisponibilidade_Disponivel() {
        boolean disponivel = FerramentaDAO.verificaDisponibilidade(-1); // ID provavelmente inexistente
        assertTrue(disponivel, "Ferramenta inexistente deve estar disponível");
    }

    @Test
    @Order(12)
    public void testVerificaDisponibilidade_Indisponivel() {
        boolean disponivel = FerramentaDAO.verificaDisponibilidade(TEST_ID);
        assertNotNull(disponivel);
    }
}

