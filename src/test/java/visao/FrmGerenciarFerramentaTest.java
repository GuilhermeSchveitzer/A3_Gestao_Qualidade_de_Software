package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class FrmGerenciarFerramentaTest {

    private FrmGerenciarFerramenta frm;

    @BeforeEach
    public void setUp() {
        frm = new FrmGerenciarFerramenta();
        frm.setVisible(true); // importante para testar visibilidade e clique
    }

    @Test
    public void testComponentesNaoSaoNulos() {
        assertNotNull(frm.getTabela(), "Tabela não deve ser nula");
        assertNotNull(frm.getJTFNome(), "Campo Nome não deve ser nulo");
        assertNotNull(frm.getJTFMarca(), "Campo Marca não deve ser nulo");
        assertNotNull(frm.getJTFCusto(), "Campo Custo não deve ser nulo");
        assertNotNull(frm.getJBVoltar(), "Botão Voltar não deve ser nulo");
        assertNotNull(frm.getJBAlterar(), "Botão Alterar não deve ser nulo");
        assertNotNull(frm.getJBApagar(), "Botão Apagar não deve ser nulo");
    }

    @Test
    public void testBotaoVoltarFechaJanela() {
        assertTrue(frm.isDisplayable(), "Janela deve estar visível antes do clique em Voltar");
        frm.getJBVoltar().doClick();
        assertFalse(frm.isDisplayable(), "Janela deve ser fechada após clique no botão Voltar");
    }

    @Test
    public void testTabelaInicialTem4Colunas() {
        JTable tabela = frm.getTabela();
        assertEquals(4, tabela.getColumnCount(), "A tabela deve ter 4 colunas (Id, Nome, Marca, Custo)");
    }
}
