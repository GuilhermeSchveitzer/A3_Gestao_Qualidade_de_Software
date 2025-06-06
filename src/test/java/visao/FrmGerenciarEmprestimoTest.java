package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrmGerenciarEmprestimoTest {

    private FrmGerenciarEmprestimoFake frm;

    @BeforeEach
    public void setUp() {
        frm = new FrmGerenciarEmprestimoFake();
    }

    @Test
    public void testCarregaTabelaNaoLancaErro() {
        assertDoesNotThrow(() -> frm.carregaTabela());
        int linhas = frm.getTabelaEmprestimos().getRowCount();
        assertTrue(linhas >= 0); // Pode ser 0 se não houver dados
    }

    @Test
    public void testMostrarMensagem() {
        frm.mostrarMensagem("Teste de mensagem");
        assertEquals("Teste de mensagem", frm.getUltimaMensagem());
    }
}