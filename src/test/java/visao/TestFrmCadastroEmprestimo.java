package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TestFrmCadastroEmprestimo {

    private FrmCadastroEmprestimo frm;

    @BeforeEach
    void setUp() {
        frm = new FrmCadastroEmprestimo();
        frm.setVisible(false); // evita exibir a interface durante o teste
    }

    @Test
    void testDataInicialEhPreenchidaCorretamente() {
        String dataTexto = frm.getJTFData().getText();
        assertNotNull(dataTexto, "A data não deve ser nula");
        assertEquals(10, dataTexto.length(), "A data deve estar no formato yyyy-MM-dd");
    }

    @Test
    void testComboBoxAmigoNaoEstaVazia() {
        ComboBoxModel<String> model = frm.getCBAmigo().getModel();
        assertTrue(model.getSize() > 0, "ComboBox de Amigo deve conter itens");
    }

    @Test
    void testComboBoxFerramentaNaoEstaVazia() {
        ComboBoxModel<String> model = frm.getCBFerramenta().getModel();
        assertTrue(model.getSize() > 0, "ComboBox de Ferramenta deve conter itens");
    }

    @Test
    void testBotaoVoltarFechaJanela() {
        frm.getJBVoltar().doClick();
        assertFalse(frm.isDisplayable(), "Janela deveria ser fechada após clicar em Voltar");
    }
}
