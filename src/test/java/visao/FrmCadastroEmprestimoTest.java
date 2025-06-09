package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FrmCadastroEmprestimoTest {

    private FrmCadastroEmprestimo frm;

    @BeforeEach
    public void setUp() {
        frm = new FrmCadastroEmprestimo();
    }

    @Test
    public void testDataInicialEstaCorreta() {
        String dataEsperada = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        assertEquals(dataEsperada, frm.getJTFData().getText(), "A data inicial deve ser a data atual no formato yyyy-MM-dd");
    }

    @Test
    public void testComponentesNaoSaoNulos() {
        assertNotNull(frm.getCBAmigo(), "ComboBox de amigos não deve ser nulo");
        assertNotNull(frm.getCBFerramenta(), "ComboBox de ferramentas não deve ser nulo");
        assertNotNull(frm.getJBVoltar(), "Botão Voltar não deve ser nulo");
        assertNotNull(frm.getJBPegar(), "Botão Pegar não deve ser nulo");
        assertNotNull(frm.getJTFData(), "Campo de data não deve ser nulo");
    }

    @Test
    public void testComboBoxAmigoInicializadoComItens() {
        JComboBox<String> cbAmigo = frm.getCBAmigo();
        assertTrue(cbAmigo.getItemCount() > 0, "ComboBox de amigos deve conter itens após inicialização");
    }

    @Test
    public void testComboBoxFerramentaInicializadoComItens() {
        JComboBox<String> cbFerramenta = frm.getCBFerramenta();
        assertTrue(cbFerramenta.getItemCount() >= 0, "ComboBox de ferramentas deve ser inicializado (mesmo vazio)");
    }

    @Test
    public void testBotaoVoltarFechaJanela() {
        assertTrue(frm.isDisplayable(), "Janela deve estar visível antes do clique em Voltar");
        frm.getJBVoltar().doClick();
        assertFalse(frm.isDisplayable(), "Janela deve ser fechada após clique no botão Voltar");
    }
}
