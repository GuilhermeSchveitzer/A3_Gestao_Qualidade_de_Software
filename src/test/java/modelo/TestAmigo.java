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
    public void testConstrutorComParametrosLimites() {
        Amigo amigo = new Amigo(-1, "", null);
        assertEquals(-1, amigo.getIdAmigo());
        assertEquals("", amigo.getNomeAmigo());
        assertNull(amigo.getTelefone());
    }

    @Test
    public void testConstrutorComStringsMuitoLongas() {
        String nomeLongo = "a".repeat(1000);
        String telefoneLongo = "9".repeat(20);
        Amigo amigo = new Amigo(9999, nomeLongo, telefoneLongo);
        assertEquals(9999, amigo.getIdAmigo());
        assertEquals(nomeLongo, amigo.getNomeAmigo());
        assertEquals(telefoneLongo, amigo.getTelefone());
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
    public void testSettersAlteramValores() {
        Amigo amigo = new Amigo(1, "Antigo", "11111");
        amigo.setNomeAmigo("Novo");
        amigo.setTelefone("22222");
        amigo.setIdAmigo(2);

        assertEquals(2, amigo.getIdAmigo());
        assertEquals("Novo", amigo.getNomeAmigo());
        assertEquals("22222", amigo.getTelefone());
    }

    @Test
    public void testSettersComValoresNulos() {
        Amigo amigo = new Amigo();
        amigo.setNomeAmigo(null);
        amigo.setTelefone(null);
        assertNull(amigo.getNomeAmigo());
        assertNull(amigo.getTelefone());
    }

    @Test
    public void testToString() {
        Amigo amigo = new Amigo(2, "Carlos", "88888-8888");
        String esperado = "idAmigo=2, nomeAmigo=Carlos, telefone=88888-8888";
        assertEquals(esperado, amigo.toString());
    }

    @Test
    public void testLimparTelefoneComEspacosEmBranco() {
        Amigo amigo = new Amigo();
        String telefone = "  11 91234 5678  ";
        String esperado = "11912345678";
        assertEquals(esperado, amigo.limparTelefone(telefone));
    }

    // Testa chamada repetida do método limparTelefone para garantir idempotência
    @Test
    public void testLimparTelefoneIdempotente() {
        Amigo amigo = new Amigo();
        String telefoneOriginal = "(11) 91234-5678";
        String primeiraLimpeza = amigo.limparTelefone(telefoneOriginal);
        String segundaLimpeza = amigo.limparTelefone(primeiraLimpeza);
        assertEquals(primeiraLimpeza, segundaLimpeza);
    }
}
