package visao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMensagem {

    @Test
    void testInstanciaMensagem() {
        Mensagem e = new Mensagem("Erro de conexão");
        assertNotNull(e);
    }

    @Test
    void testMensagemConteudo() {
        Mensagem e = new Mensagem("Falha na operação");
        assertEquals("Falha na operação", e.getMessage());
    }

    @Test
    void testLancarECapturarExcecao() {
        Exception exception = assertThrows(Mensagem.class, () -> {
            throw new Mensagem("Exceção esperada");
        });
        assertEquals("Exceção esperada", exception.getMessage());
    }
}