import modelo.Amigo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AmigoTest {

    @Test
    public void testConstrutorPadrao() {
        Amigo amigo = new Amigo();
        assertEquals(0, amigo.getIdAmigo());
        assertEquals("", amigo.getNomeAmigo());
        assertEquals("", amigo.getTelefone());
    }

    @Test
    public void testConstrutorComParametros() {
        Amigo amigo = new Amigo(1, "João", "(11) 91234-5678");
        assertEquals(1, amigo.getIdAmigo());
        assertEquals("João", amigo.getNomeAmigo());
        assertEquals("(11) 91234-5678", amigo.getTelefone());
    }

    @Test
    public void testGetSetIdAmigo() {
        Amigo amigo = new Amigo();
        amigo.setIdAmigo(5);
        assertEquals(5, amigo.getIdAmigo());
    }

    @Test
    public void testGetSetNomeAmigo() {
        Amigo amigo = new Amigo();
        amigo.setNomeAmigo("Maria");
        assertEquals("Maria", amigo.getNomeAmigo());
    }

    @Test
    public void testGetSetTelefone() {
        Amigo amigo = new Amigo();
        amigo.setTelefone("12345");
        assertEquals("12345", amigo.getTelefone());
    }

    @Test
    public void testToString() {
        Amigo amigo = new Amigo(10, "Carlos", "99999-8888");
        String esperado = "idAmigo=10, nomeAmigo=Carlos, telefone=99999-8888";
        assertEquals(esperado, amigo.toString());
    }

    @Test
    public void testLimparTelefone() {
        Amigo amigo = new Amigo();
        String telefoneSujo = "(11) 91234-5678";
        String esperado = "11912345678";
        String resultado = amigo.limparTelefone(telefoneSujo);
        assertEquals(esperado, resultado);
    }
}
