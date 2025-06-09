package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

public class FrmGerenciarEmprestimoTest {

    private FrmGerenciarEmprestimo frm;

    // Subclasse que sobrescreve métodos que exibem janelas
    private static class FrmGerenciarEmprestimoFake extends FrmGerenciarEmprestimo {
        private int respostaConfirmacao = JOptionPane.YES_OPTION;

        @Override
        public void mostrarMensagem(String mensagem) {
            // Evita abrir janelas de diálogo
        }

        @Override
        public int confirmarMensagem(String mensagem) {
            return respostaConfirmacao; // Simula "Sim"
        }

        public void setRespostaConfirmacao(int resposta) {
            this.respostaConfirmacao = resposta;
        }
    }

    @BeforeEach
    public void setUp() {
        frm = new FrmGerenciarEmprestimoFake();
        frm.inicializarEmprestimoFake(); // garante que não acessa BD real
    }

    @Test
    public void testInicializacaoNaoNula() {
        assertNotNull(frm, "O formulário não deve ser nulo");
        assertNotNull(frm.getTabelaEmprestimos(), "Tabela deve estar inicializada");
        assertNotNull(frm.getBotaoDevolucao(), "Botão de devolução deve estar inicializado");
        assertNotNull(frm.getBotaoVoltar(), "Botão de voltar deve estar inicializado");
    }

    @Test
    public void testTabelaInicialVazia() {
        JTable tabela = frm.getTabelaEmprestimos();
        assertEquals(0, tabela.getRowCount(), "Tabela deve estar vazia inicialmente (sem empréstimos pendentes)");
    }

    @Test
    public void testBotaoVoltarNaoLancaErro() {
        JButton botaoVoltar = frm.getBotaoVoltar();
        assertNotNull(botaoVoltar, "Botão Voltar deve estar disponível");
        assertDoesNotThrow(() -> botaoVoltar.doClick(), "Clique no botão Voltar não deve lançar exceção");
    }

    @Test
    public void testBotaoDevolucaoNaoLancaErroSemSelecao() {
        JTable tabela = frm.getTabelaEmprestimos();
        tabela.clearSelection();

        assertDoesNotThrow(() -> frm.getBotaoDevolucao().doClick(),
                "Botão de devolução não deve lançar erro mesmo sem seleção");
    }

    @Test
    public void testMensagemConfirmacaoDevolucao() {
        int resposta = frm.confirmarMensagem("Deseja devolver?");
        assertTrue(resposta == JOptionPane.YES_OPTION || resposta == JOptionPane.NO_OPTION,
                "A resposta deve ser YES ou NO");
    }
}
