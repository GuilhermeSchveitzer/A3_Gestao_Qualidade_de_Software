package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.JButton;
import static org.junit.jupiter.api.Assertions.*;

public class FrmMenuPrincipalTest {

    private FrmMenuPrincipal frm;

@BeforeEach
public void setUp() {
    frm = new FrmMenuPrincipal() {
        @Override
        protected void encerrarAplicacao() {
            // Substitui o System.exit(0) nos testes
            System.out.println("Simulando saída sem fechar JVM");
        }
    };
    frm.setVisible(true); // necessário para carregar os botões
}

    @Test
    public void testFrameTitle() {
        assertEquals("Menu Principal", frm.getTitle(), "Título da janela está incorreto.");
    }

    @Test
    public void testCadastrarAlunoButtonExists() {
        JButton btn = getButton("Cadastrar Amigo");
        assertNotNull(btn, "Botão 'Cadastrar Amigo' não encontrado.");
    }

    @Test
    public void testAbrirFrmCadastroAmigo() {
        assertDoesNotThrow(() -> {
            frm.getBtnCadastrarAluno().doClick();
        }, "Erro ao abrir FrmCadastroAmigo.");
    }

    @Test
    public void testBotaoSairNaoFechaAplicacaoDuranteTeste() {
        assertDoesNotThrow(() -> {
            frm.getBtnSair().doClick(); // Não deve fechar a JVM se em teste
        }, "Botão 'Sair' lançou exceção ou encerrou JVM.");
    }

    // Método auxiliar para localizar botões por texto
    private JButton getButton(String text) {
    for (java.awt.Component comp : frm.getContentPane().getComponents()) {
        if (comp instanceof javax.swing.JPanel) {
            javax.swing.JPanel panel = (javax.swing.JPanel) comp;
            for (java.awt.Component sub : panel.getComponents()) {
                if (sub instanceof JButton) {
                    JButton btn = (JButton) sub;
                    if (btn.getText().equals(text)) {
                        return btn;
                    }
                }
            }
        }
    }
    return null;
    }
}