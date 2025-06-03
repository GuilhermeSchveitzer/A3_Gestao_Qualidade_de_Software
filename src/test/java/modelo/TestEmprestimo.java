import modelo.Emprestimo;
import modelo.Amigo;
import modelo.Ferramenta;

import org.junit.jupiter.api.Test;

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
}
