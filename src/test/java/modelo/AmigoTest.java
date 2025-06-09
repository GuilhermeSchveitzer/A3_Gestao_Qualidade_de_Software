import modelo.Amigo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AmigoTest {

    private static Amigo amigo;
    private static int idInserido;

    @BeforeAll
    public static void setup() {
        amigo = new Amigo();
    }

    @Test
    @Order(1)
    public void testConstrutorPadrao() {
        Amigo a = new Amigo();
        assertEquals(0, a.getIdAmigo());
        assertEquals("", a.getNomeAmigo());
        assertEquals("", a.getTelefone());
    }

    @Test
    @Order(2)
    public void testConstrutorComParametros() {
        Amigo a = new Amigo(1, "João", "123456789");
        assertEquals(1, a.getIdAmigo());
        assertEquals("João", a.getNomeAmigo());
        assertEquals("123456789", a.getTelefone());
    }

    @Test
    @Order(3)
    public void testGettersAndSetters() {
        Amigo a = new Amigo();
        a.setIdAmigo(10);
        a.setNomeAmigo("Maria");
        a.setTelefone("99999-9999");
        assertEquals(10, a.getIdAmigo());
        assertEquals("Maria", a.getNomeAmigo());
        assertEquals("99999-9999", a.getTelefone());
    }

    @Test
    @Order(4)
    public void testToString() {
        Amigo a = new Amigo(2, "Carlos", "88888-8888");
        String esperado = "idAmigo=2, nomeAmigo=Carlos, telefone=88888-8888";
        assertEquals(esperado, a.toString());
    }

    @Test
    @Order(5)
    public void testLimparTelefone() {
        String original = "(48) 91234-5678";
        String esperado = "48912345678";
        assertEquals(esperado, amigo.limparTelefone(original));
    }

    @Test
    @Order(6)
    public void testLimparTelefoneIdempotente() {
        String original = "(11) 91234-5678";
        String primeira = amigo.limparTelefone(original);
        String segunda = amigo.limparTelefone(primeira);
        assertEquals(primeira, segunda);
    }

    @Test
    @Order(7)
    public void testMaiorID() {
        int id = amigo.maiorID();
        assertTrue(id >= 0);
    }

    @Test
    @Order(8)
    public void testInserirAmigoBD() {
        boolean sucesso = amigo.inserirAmigoBD(0, "TesteInsercao", "123456");
        assertTrue(sucesso);
        idInserido = amigo.maiorID(); // salva para próximos testes
    }

    @Test
    @Order(9)
    public void testGetListaAmigo() {
        ArrayList<Amigo> lista = amigo.getListaAmigo();
        assertNotNull(lista);
        assertTrue(lista.size() > 0);
    }

    @Test
    @Order(10)
    public void testCarregaAmigoPorId() {
        Amigo recuperado = amigo.carregaAmigoPorId(idInserido);
        assertNotNull(recuperado);
        assertEquals("TesteInsercao", recuperado.getNomeAmigo());
    }

    @Test
    @Order(11)
    public void testAtualizarAmigoBD() {
        boolean sucesso = amigo.atualizarAmigoBD(idInserido, "NovoNome", "000000");
        assertTrue(sucesso);
        Amigo atualizado = amigo.carregaAmigoPorId(idInserido);
        assertEquals("NovoNome", atualizado.getNomeAmigo());
    }

}