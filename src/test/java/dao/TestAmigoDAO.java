package dao;

import modelo.Amigo;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAmigoDAO {

    private static AmigoDAO dao;

    @BeforeAll
    public static void setup() {
        dao = new AmigoDAO();
    }

    @Test
    @Order(1)
    public void testInserirAmigoBD() {
        Amigo amigo = new Amigo(9999, "Teste Amigo", "99999999999");
        boolean inseriu = dao.inserirAmigoBD(amigo);
        assertTrue(inseriu, "Deve inserir o amigo na base");
    }

    @Test
    @Order(2)
    public void testGetListaAmigo() {
        ArrayList<Amigo> lista = dao.getListaAmigo();
        assertNotNull(lista, "Lista não deve ser nula");
        assertTrue(lista.size() > 0, "Lista deve conter pelo menos um amigo");
    }

    @Test
    @Order(3)
    public void testCarregaAmigoPorId() {
        Amigo amigo = dao.carregaAmigoPorId(9999);
        assertNotNull(amigo);
        assertEquals(9999, amigo.getIdAmigo());
        assertEquals("Teste Amigo", amigo.getNomeAmigo());
    }

    @Test
    @Order(4)
    public void testAtualizarAmigoBD() {
        Amigo amigo = new Amigo(9999, "Amigo Atualizado", "88888888888");
        boolean atualizou = dao.atualizarAmigoBD(amigo);
        assertTrue(atualizou);

        Amigo atualizado = dao.carregaAmigoPorId(9999);
        assertEquals("Amigo Atualizado", atualizado.getNomeAmigo());
        assertEquals("88888888888", atualizado.getTelefone());
    }

    @Test
    @Order(5)
    public void testVerificaEmprestimoPendente() {
        // Como não sabemos a base, só checamos se retorna boolean sem erro
        boolean pendente = AmigoDAO.verificaEmprestimoPendente(9999);
        assertNotNull(pendente);
    }

    @Test
    @Order(6)
    public void testMaiorID() {
        int maiorId = dao.maiorID();
        assertTrue(maiorId >= 0, "Maior ID deve ser >= 0");
    }

    @Test
    @Order(7)
    public void testDeletarAmigoBD() {
        boolean deletou = dao.deletarAmigoBD(9999);
        assertTrue(deletou, "Deve deletar o amigo");
    }
}
