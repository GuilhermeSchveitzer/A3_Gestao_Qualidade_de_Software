package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrmGerenciarEmprestimoTest {

    private FrmGerenciarEmprestimoFake frm;

    @BeforeEach
    public void setUp() {
        // ⚠️ Ativa o modo headless para ambientes como GitHub Actions
        System.setProperty("java.awt.headless", "true");

        frm = new FrmGerenciarEmprestimoFake(); // classe fake que evita abrir janelas
    }

    @Test
    public void testCarregaTabelaNaoLancaErro() {
        assertDoesNotThrow(() -> frm.carregaTabela());
        int linhas = frm.getTabelaEmprestimos().getRowCount();
        assertTrue(linhas >= 0);
    }

    @Test
    public void testMostrarMensagem() {
        frm.mostrarMensagem("Teste de mensagem");
        assertEquals("Teste de mensagem", frm.getUltimaMensagem());
    }

    @Test
    public void testDevolucaoSemSelecaoMostraMensagemDeErro() {
        frm.carregaTabela();
        frm.getTabelaEmprestimos().clearSelection();

        assertDoesNotThrow(() -> frm.getBotaoDevolucao().doClick());

        assertEquals("Primeiro Selecione um empréstimo para DEVOLVER", frm.getUltimaMensagem());
    }
}
