import modelo.Amigo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAmigo {

    @Test
    public void testConstrutorPadrao() {
        Amigo amigo = new Amigo();
        assertEquals(0, amigo.getIdAmigo());
        assertEquals("", amigo.getNomeAmigo());
        assertEquals("", amigo.getTelefone());
    }

    @Test
    public void testConstrutorComParametros() {
        Amigo amigo = new Amigo(1, "João", "12345678910");
        assertEquals(1, amigo.getIdAmigo());
        assertEquals("João", amigo.getNomeAmigo());
        assertEquals("12345678910", amigo.getTelefone());
    }

    @Test
    public void testGettersAndSetters() {
        Amigo amigo = new Amigo();
        amigo.setIdAmigo(10);
        amigo.setNomeAmigo("Maria");
        amigo.setTelefone("99999-9999");

        assertEquals(10, amigo.getIdAmigo());
        assertEquals("Maria", amigo.getNomeAmigo());
        assertEquals("99999-9999", amigo.getTelefone());
    }

    @Test
    public void testToString() {
        Amigo amigo = new Amigo(2, "Carlos", "88888-8888");
        String esperado = "idAmigo=2, nomeAmigo=Carlos, telefone=88888-8888";
        assertEquals(esperado, amigo.toString());
    }

    @Test
    public void testLimparTelefone() {
        Amigo amigo = new Amigo();
        String original = "(11) 91234-5678";
        String esperado = "11912345678";
        String resultado = amigo.limparTelefone(original);
        assertEquals(esperado, resultado);
    }
}
