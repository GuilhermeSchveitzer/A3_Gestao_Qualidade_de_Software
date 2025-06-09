import modelo.Ferramenta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class FerramentaTest {

    @Test
    public void testGetSetIdFerramenta() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setIdFerramenta(10);
        assertEquals(10, ferramenta.getIdFerramenta());

        ferramenta.setIdFerramenta(-1);
        assertEquals(-1, ferramenta.getIdFerramenta());
    }

    @Test
    public void testCorrigirVirgula() {
        Ferramenta ferramenta = new Ferramenta();
        String resultado = ferramenta.corrigirVirgula("10,50");
        assertEquals("10.50", resultado);
    }

    @Test
    public void testGetSetNomeFerramenta() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setNomeFerramenta("Martelo");
        assertEquals("Martelo", ferramenta.getNomeFerramenta());

        ferramenta.setNomeFerramenta(null);
        assertNull(ferramenta.getNomeFerramenta());

        ferramenta.setNomeFerramenta("");
        assertEquals("", ferramenta.getNomeFerramenta());
    }

    @Test
    public void testGetSetMarca() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setMarca("Tramontina");
        assertEquals("Tramontina", ferramenta.getMarca());

        ferramenta.setMarca(null);
        assertNull(ferramenta.getMarca());

        ferramenta.setMarca("");
        assertEquals("", ferramenta.getMarca());
    }

    @Test
    public void testGetSetCusto() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setCusto(99.99);
        assertEquals(99.99, ferramenta.getCusto(), 0.001);

        ferramenta.setCusto(0);
        assertEquals(0, ferramenta.getCusto(), 0.001);

        ferramenta.setCusto(-10.5);
        assertEquals(-10.5, ferramenta.getCusto(), 0.001);
    }

    @Test
    public void testConstrutorPadrao() {
        Ferramenta ferramenta = new Ferramenta();
        assertEquals(0, ferramenta.getIdFerramenta());
        assertEquals("", ferramenta.getNomeFerramenta());
        assertEquals("", ferramenta.getMarca());
        assertEquals(0.0, ferramenta.getCusto(), 0.001);
    }

    @Test
    public void testConstrutorCompleto() {
        Ferramenta ferramenta = new Ferramenta(5, "Serra", "Bosch", 200.5);
        assertEquals(5, ferramenta.getIdFerramenta());
        assertEquals("Serra", ferramenta.getNomeFerramenta());
        assertEquals("Bosch", ferramenta.getMarca());
        assertEquals(200.5, ferramenta.getCusto(), 0.001);
    }

    @Test
    public void testToString() {
        Ferramenta f = new Ferramenta(1, "Furadeira", "Makita", 120.0);
        String resultado = f.toString();
        assertTrue(resultado.contains("Furadeira"));
        assertTrue(resultado.contains("Makita"));
        assertTrue(resultado.contains("120.0"));
    }

    @Test
    public void testGetListaFerramentaDelegado() {
        Ferramenta f = new Ferramenta();
        ArrayList<Ferramenta> lista = f.getListaFerramenta();
        assertNotNull(lista);
    }

    @Test
    public void testCarregaFerramentaPorIdDelegado() {
        Ferramenta f = new Ferramenta();
        Ferramenta resultado = f.carregaFerramentaPorId(-1);
        assertNotNull(resultado);
    }

    @Test
    public void testInserirFerramentaBDDelegado() {
        Ferramenta f = new Ferramenta();
        boolean inserido = f.inserirFerramentaBD(0, "Test", "MarcaTest", 10.0);
        assertTrue(inserido);
    }

    @Test
    public void testDeletarFerramentaBDDelegado() {
        Ferramenta f = new Ferramenta();
        boolean deletado = f.deletarFerramentaBD(-1);
        assertTrue(deletado);
    }

    @Test
    public void testAtualizarFerramentaBDDelegado() {
        Ferramenta f = new Ferramenta();
        boolean atualizado = f.atualizarFerramentaBD(0, "NovoNome", "NovaMarca", 99.9);
        assertTrue(atualizado);
    }

    @Test
    public void testMaiorIdDelegado() {
        Ferramenta f = new Ferramenta();
        int id = f.maiorID();
        assertTrue(id >= 0);
    }
}
