package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.ActionListener;
import static org.junit.jupiter.api.Assertions.*;

public class FrmCadastroFerramentaTest {

    private FrmCadastroFerramenta frm;

    @BeforeEach
    public void setUp() {
        frm = new FrmCadastroFerramenta();
        frm.setVisible(false); // evita abrir janela na execução do teste
    }

    @Test
    public void testCadastroComDadosValidos() {
        // Preenche os campos com dados válidos
        frm.getJTFNomeFerramenta().setText("Martelo");
        frm.getJTFMarca().setText("Tramontina");
        frm.getJTFCusto().setText("49.90");

        // Simula clique no botão "Cadastrar"
        JButton botaoCadastrar = frm.getJBCadastrar();
        for (ActionListener al : botaoCadastrar.getActionListeners()) {
            al.actionPerformed(null); // simula clique
        }

        // Após o cadastro, os campos devem estar limpos
        assertEquals("", frm.getJTFNomeFerramenta().getText());
        assertEquals("", frm.getJTFMarca().getText());
        assertEquals("", frm.getJTFCusto().getText());
    }

    @Test
    public void testCadastroComNomeInvalido() {
        frm.getJTFNomeFerramenta().setText("A"); // inválido
        frm.getJTFMarca().setText("MarcaX");
        frm.getJTFCusto().setText("10.00");

        JButton botaoCadastrar = frm.getJBCadastrar();
        for (ActionListener al : botaoCadastrar.getActionListeners()) {
            al.actionPerformed(null);
        }

        // Nome inválido: campo não deve ser limpo
        assertEquals("A", frm.getJTFNomeFerramenta().getText());
    }
}
