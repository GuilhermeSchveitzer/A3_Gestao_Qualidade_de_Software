package visao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visao.FrmCadastroEmprestimo;

import static org.junit.jupiter.api.Assertions.*;

public class FrmCadastroEmprestimoTest {

    private FrmCadastroEmprestimo frm;

    @BeforeEach
    public void setUp() {
        frm = new FrmCadastroEmprestimo();
    }

    @Test
    public void testInicializacaoCampoData() {
        String data = frm.getJTFData().getText();
        assertNotNull(data, "Campo de data não pode ser nulo");
        assertTrue(data.matches("\\d{4}-\\d{2}-\\d{2}"), "Data deve estar no formato yyyy-MM-dd");
    }

    @Test
    public void testComponentesNaoNulos() {
        assertNotNull(frm.getJBVoltar(), "Botão Voltar deve estar inicializado");
        assertNotNull(frm.getJBPegar(), "Botão Pegar deve estar inicializado");
        assertNotNull(frm.getCBAmigo(), "ComboBox de amigo deve estar inicializada");
        assertNotNull(frm.getCBFerramenta(), "ComboBox de ferramenta deve estar inicializada");
    }
}