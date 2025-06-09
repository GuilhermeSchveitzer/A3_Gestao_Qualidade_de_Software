package visao;

import org.junit.jupiter.api.*;
import visao.FrmGerenciarAmigo;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FrmGerenciarAmigoTest {

    FrmGerenciarAmigo frame;

    @BeforeEach
    void setUp() {
        // Roda na thread do Swing
        SwingUtilities.invokeLater(() -> {
            frame = new FrmGerenciarAmigo();
            frame.setVisible(true);
        });
        try {
            Thread.sleep(500); // tempo para abrir a janela
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        SwingUtilities.invokeLater(() -> frame.dispose());
    }

    @Test
    void testSalvarComCamposPreenchidos() {
        SwingUtilities.invokeLater(() -> {
            frame.getJTFNome().setText("João");
            frame.getJTFTelefone().setText("123456789");
            frame.getJBSalvar().doClick();

            // Verifica se a tabela foi atualizada
            assertTrue(frame.getAmigo().getListaAmigo().size() > 0);
        });
    }

    @Test
    void testSalvarComNomeVazio() {
        SwingUtilities.invokeLater(() -> {
            frame.getJTFNome().setText("");
            frame.getJTFTelefone().setText("999999999");
            frame.getJBSalvar().doClick();

            // Não deve adicionar novo amigo
            assertEquals(0, frame.getAmigo().getListaAmigo().size());
        });
    }

    @Test
    void testSalvarComTelefoneVazio() {
        SwingUtilities.invokeLater(() -> {
            frame.getJTFNome().setText("Maria");
            frame.getJTFTelefone().setText("");
            frame.getJBSalvar().doClick();

            // Não deve adicionar novo amigo
            assertEquals(0, frame.getAmigo().getListaAmigo().size());
        });
    }
}
