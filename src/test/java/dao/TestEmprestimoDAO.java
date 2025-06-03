package dao;

import modelo.Emprestimo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmprestimoDAO {

    private static EmprestimoDAO dao;

    @BeforeAll
    public static void setup() {
        dao = new EmprestimoDAO();
    }

    @Test
    @Order(1)
    public void testInserirEmprestimoBD() {
        Emprestimo e = new Emprestimo(9999, 1, 1, "2025-06-03", "2025-06-10", true);
        boolean resultado = dao.inserirEmprestimoBD(e);
        assertTrue(resultado, "Inserção deve retornar true");
    }

    @Test
    @Order(2)
    public void testGetMinhaLista() {
        ArrayList<Emprestimo> lista = dao.getMinhaLista();
        assertNotNull(lista, "Lista não deve ser nula");
        assertFalse(lista.isEmpty(), "Lista não deve estar vazia");
    }

    @Test
    @Order(3)
    public void testCarregaEmprestimoPorIdExistente() {
        Emprestimo e = dao.carregaEmprestimoPorId(9999);
        assertNotNull(e, "Emprestimo não deve ser nulo");
        assertEquals(9999, e.getIdEmprestimo(), "ID do empréstimo deve ser 9999");
        assertEquals(1, e.getIdAmigo(), "IdAmigo deve ser 1");
        assertEquals(1, e.getIdFerramenta(), "IdFerramenta deve ser 1");
        assertEquals("2025-06-03", e.getDataEmprestimo(), "DataEmprestimo deve ser '2025-06-03'");
        assertEquals("2025-06-10", e.getDataDevolucao(), "DataDevolucao deve ser '2025-06-10'");
        assertTrue(e.getPendente(), "Pendente deve ser true");
    }

    @Test
    @Order(4)
    public void testAtualizarEmprestimoBD() {
        Emprestimo e = new Emprestimo(9999, 2, 2, "2025-06-05", "2025-06-12", false);
        boolean atualizado = dao.atualizarEmprestimoBD(e);
        assertTrue(atualizado, "Atualização deve retornar true");

        Emprestimo atualizadoEmprestimo = dao.carregaEmprestimoPorId(9999);
        assertNotNull(atualizadoEmprestimo, "Emprestimo atualizado não deve ser nulo");
        assertEquals(2, atualizadoEmprestimo.getIdAmigo());
        assertEquals(2, atualizadoEmprestimo.getIdFerramenta());
        assertEquals("2025-06-05", atualizadoEmprestimo.getDataEmprestimo());
        assertEquals("2025-06-12", atualizadoEmprestimo.getDataDevolucao());
        assertFalse(atualizadoEmprestimo.getPendente());
    }

    @Test
    @Order(5)
    public void testMaiorID() {
        int maior = dao.maiorID();
        assertTrue(maior >= 9999, "Maior ID deve ser pelo menos 9999");
    }

    @Test
    @Order(6)
    public void testDeletarEmprestimoBD() {
        boolean deletado = dao.deletarEmprestimoBD(9999);
        assertTrue(deletado, "Deleção deve retornar true");

        Emprestimo e = dao.carregaEmprestimoPorId(9999);
        assertNotNull(e, "Objeto retornado não deve ser nulo após deleção");
        assertEquals(9999, e.getIdEmprestimo(), "ID deve continuar 9999");
    }
}