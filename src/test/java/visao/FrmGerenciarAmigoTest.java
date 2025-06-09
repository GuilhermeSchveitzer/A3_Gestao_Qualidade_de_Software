package visao;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import visao.FrmGerenciarAmigo;
import modelo.Amigo;

public class FrmGerenciarAmigoTest {

    @BeforeClass
    public static void configurarModoHeadless() {
        if (System.getenv("CI") != null) {
            System.setProperty("java.awt.headless", "true");
        }
    }

    @Test
    public void testSalvarAmigo() {
        // Cria o formulário
        FrmGerenciarAmigo tela = new FrmGerenciarAmigo();

        // Preenche os campos de nome e telefone
        tela.getJTFNome().setText("Victor Teste");
        tela.getJTFTelefone().setText("123456789");

        // Simula clique no botão Salvar
        tela.getJBSalvar().doClick();

        // Verifica se o último amigo adicionado tem os dados certos
        Amigo ultimo = tela.getAmigo().getListaAmigo().get(tela.getAmigo().getListaAmigo().size() - 1);

        assertEquals("Victor Teste", ultimo.getNomeAmigo());
        assertEquals("123456789", ultimo.getTelefone());
    }
}
