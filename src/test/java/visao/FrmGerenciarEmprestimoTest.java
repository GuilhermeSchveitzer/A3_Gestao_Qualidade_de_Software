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
        assertTrue(linhas >= 0);
    }

    @Test
    public void testMostrarMensagem() {
        frm.mostrarMensagem("Teste de mensagem");
        assertEquals("Teste de mensagem", frm.getUltimaMensagem());
    }

    @Test
public void testDevolucaoSemSelecaoMostraMensagemDeErro() {
    frm.carregaTabela(); // carrega dados se houver
    frm.getTabelaEmprestimos().clearSelection(); // garante que nada está selecionado

    // Simula o clique no botão de devolução
    assertDoesNotThrow(() -> frm.getBotaoDevolucao().doClick());

    // Verifica se a mensagem correta foi exibida
    assertEquals("Primeiro Selecione um empréstimo para DEVOLVER", frm.getUltimaMensagem());
}
}
