package visao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionListener;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class FrmCadastroFerramentaTest {

    private FrmCadastroFerramenta frm;

    @BeforeAll
public static void configurarModoHeadless() {
    if (System.getenv("CI") != null) {
        System.setProperty("java.awt.headless", "true");
    }
}

    @BeforeEach
    public void setUp() {
        frm = new FrmCadastroFerramenta();
        frm.setVisible(false); // evita abrir janela na execução do teste

        // Fecha automaticamente janelas de diálogo após 500 ms
        new javax.swing.Timer(500, e -> {
            for (Window w : Window.getWindows()) {
                if (w.isShowing() && w instanceof JDialog) {
                    w.dispose(); // Fecha o JOptionPane como se clicasse em "OK"
                }
            }
        }).start();
    }

    @Test
    public void testCadastroComDadosValidos() {
        frm.getJTFNomeFerramenta().setText("Martelo");
        frm.getJTFMarca().setText("Tramontina");
        frm.getJTFCusto().setText("49.90");

        JButton botaoCadastrar = frm.getJBCadastrar();
        for (ActionListener al : botaoCadastrar.getActionListeners()) {
            al.actionPerformed(null);
        }

        assertEquals("", frm.getJTFNomeFerramenta().getText());
        assertEquals("", frm.getJTFMarca().getText());
        assertEquals("", frm.getJTFCusto().getText());
    }

    @Test
    public void testCadastroComNomeInvalido() {
        frm.getJTFNomeFerramenta().setText("A");
        frm.getJTFMarca().setText("MarcaX");
        frm.getJTFCusto().setText("10.00");

        JButton botaoCadastrar = frm.getJBCadastrar();
        for (ActionListener al : botaoCadastrar.getActionListeners()) {
            al.actionPerformed(null);
        }

        assertEquals("A", frm.getJTFNomeFerramenta().getText());
    }
}
