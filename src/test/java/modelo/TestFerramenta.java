import modelo.Ferramenta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFerramenta {

    @Test
    public void testGetSetIdFerramenta() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setIdFerramenta(10);
        assertEquals(10, ferramenta.getIdFerramenta());
    }

    @Test
    public void testGetSetNomeFerramenta() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setNomeFerramenta("Martelo");
        assertEquals("Martelo", ferramenta.getNomeFerramenta());
    }

    @Test
    public void testGetSetMarca() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setMarca("Tramontina");
        assertEquals("Tramontina", ferramenta.getMarca());
    }

    @Test
    public void testGetSetCusto() {
        Ferramenta ferramenta = new Ferramenta();
        ferramenta.setCusto(99.99);
        assertEquals(99.99, ferramenta.getCusto(), 0.01);
    }

    @Test
    public void testCorrigirVirgula() {
        Ferramenta ferramenta = new Ferramenta();
        String resultado = ferramenta.corrigirVirgula("10,50");
        assertEquals("10.50", resultado);
    }

    @Test
    public void testToString() {
        Ferramenta ferramenta = new Ferramenta(1, "Chave Inglesa", "Stanley", 150.0);
        String resultado = ferramenta.toString();
        assertTrue(resultado.contains("idFerramenta=1"));
        assertTrue(resultado.contains("nomeFerramenta= Chave Inglesa"));
    }
}
