package dao;

import modelo.Ferramenta;
import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFerramentaDAO {

    FerramentaDAO dao = new FerramentaDAO();
    static int idTeste = 999;

    @Test
    @Order(1)
    public void testInserirFerramentaBD() {
        Ferramenta nova = new Ferramenta(idTeste, "Martelo", "Tramontina", 35.50);
        assertTrue(dao.inserirFerramentaBD(nova));
    }

    @Test
    @Order(2)
    public void testGetListaFerramenta() {
        ArrayList<Ferramenta> lista = dao.getListaFerramenta();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test
    @Order(3)
    public void testCarregaFerramentaPorIdValido() {
        Ferramenta f = dao.carregaFerramentaPorId(idTeste);
        assertEquals("Martelo", f.getNomeFerramenta());
    }

    @Test
    @Order(4)
    public void testAtualizarFerramentaBD() {
        Ferramenta atualizada = new Ferramenta(idTeste, "Martelo de Borracha", "Vonder", 45.00);
        assertTrue(dao.atualizarFerramentaBD(atualizada));

        Ferramenta f = dao.carregaFerramentaPorId(idTeste);
        assertEquals("Martelo de Borracha", f.getNomeFerramenta());
    }

    @Test
    @Order(5)
    public void testMaiorID() {
        int maiorID = dao.maiorID();
        assertTrue(maiorID >= idTeste);
    }

    @Test
    @Order(6)
    public void testVerificaDisponibilidadeComFerramentaDisponivel() {
        boolean disponivel = FerramentaDAO.verificaDisponibilidade(idTeste);
        assertTrue(disponivel); // deve estar disponível
    }

    @Test
    @Order(7)
    public void testVerificaDisponibilidadeComIdInvalido() {
        boolean disponivel = FerramentaDAO.verificaDisponibilidade(-1); // não existe
        assertTrue(disponivel); // ainda será tratado como disponível
    }

    @Test
    @Order(8)
    public void testDeletarFerramentaBDComIdValido() {
        assertTrue(dao.deletarFerramentaBD(idTeste));
    }

    @Test
    @Order(9)
    public void testDeletarFerramentaBDComIdInexistente() {
        assertTrue(dao.deletarFerramentaBD(-1)); // não lança exceção, apenas não deleta nada
    }

    @Test
    @Order(10)
    public void testGetListaFerramentaSemFerramentas() {
        ArrayList<Ferramenta> lista = dao.getListaFerramenta();
        assertNotNull(lista); // retorna lista vazia se não há registros
    }
}
