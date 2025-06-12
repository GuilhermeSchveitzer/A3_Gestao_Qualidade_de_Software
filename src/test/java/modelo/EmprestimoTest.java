import modelo.Emprestimo;
import modelo.Amigo;
import modelo.Ferramenta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {

    @Test
    void testGettersAndSetters() {
        Emprestimo e = new Emprestimo();

        e.setIdEmprestimo(1);
        e.setIdAmigo(2);
        e.setIdFerramenta(3);
        e.setDataEmprestimo("2025-06-01");
        e.setDataDevolucao("2025-06-10");
        e.setPendente(false);

        assertEquals(1, e.getIdEmprestimo());
        assertEquals(2, e.getIdAmigo());
        assertEquals(3, e.getIdFerramenta());
        assertEquals("2025-06-01", e.getDataEmprestimo());
        assertEquals("2025-06-10", e.getDataDevolucao());
        assertFalse(e.getPendente());
    }

    @Test
    void testToString() {
        Emprestimo e = new Emprestimo(1, 2, 3, "2025-06-01", "2025-06-10", true);
        String result = e.toString();
        assertTrue(result.contains("idEmprestimo=1"));
        assertTrue(result.contains("idAmigo= 2"));
        assertTrue(result.contains("idFerramenta= 3"));
        assertTrue(result.contains("dataEmprestimo=2025-06-01"));
        assertTrue(result.contains("dataDevolucao=2025-06-10"));
        assertTrue(result.contains("pendente=true"));
    }

    @Test
    void testSetAndGetAmigo() {
        Emprestimo e = new Emprestimo();
        Amigo a = new Amigo();
        e.setAmigo(a);
        assertEquals(a, e.getAmigo());
    }

    @Test
    void testSetAndGetFerramenta() {
        Emprestimo e = new Emprestimo();
        Ferramenta f = new Ferramenta();
        e.setFerramenta(f);
        assertEquals(f, e.getFerramenta());
    }

    @Test
    void testMaiorId() {
        Emprestimo e = new Emprestimo();
        int maior = e.maiorID();
        assertTrue(maior >= 0);
    }

    @Test
    void testInsertUpdateDeleteEmprestimoBD() {
        Emprestimo e = new Emprestimo();
        int novoId = e.maiorID() + 1;

        boolean inserido = e.inserirEmprestimoBD(novoId, 1, 1, "2025-06-04", true, new Ferramenta(), new Amigo());
        assertTrue(inserido, "Falha ao inserir");

        Emprestimo buscado = e.carregaEmprestimoPorId(novoId);
        assertEquals(novoId, buscado.getIdEmprestimo());

        boolean atualizado = e.atualizarEmprestimoBD(novoId, 1, 1, "2025-06-04", "2025-06-10", false);
        assertTrue(atualizado, "Falha ao atualizar");

        Emprestimo atualizadoObj = e.carregaEmprestimoPorId(novoId);
        assertEquals("2025-06-10", atualizadoObj.getDataDevolucao());
        assertFalse(atualizadoObj.getPendente());

        boolean deletado = e.deletarEmprestimoBD(novoId);
        assertTrue(deletado, "Falha ao deletar");
    }

    @Test
    void testGetMinhaLista() {
        Emprestimo e = new Emprestimo();
        ArrayList<Emprestimo> lista = e.getMinhaLista();
        assertNotNull(lista);
    }

    @Test
    void testCarregaEmprestimoPorIdComDadoExistente() {
        Emprestimo e = new Emprestimo();
        int idExistente = e.maiorID(); // usando último ID existente
        Emprestimo buscado = e.carregaEmprestimoPorId(idExistente);
        assertEquals(idExistente, buscado.getIdEmprestimo());
    }
}