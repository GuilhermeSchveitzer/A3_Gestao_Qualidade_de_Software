package visao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.awt.GraphicsEnvironment;

import javax.swing.DefaultComboBoxModel;

import modelo.Amigo;

import org.junit.jupiter.api.Test;

public class TestFrmCadastroEmprestimo {

    @Test
    public void testCarregaCBAmigoComUmAmigo() {
        // Ativa modo headless só se não houver display (ex: em GitHub Actions)
        if (GraphicsEnvironment.isHeadless()) {
            System.setProperty("java.awt.headless", "true");
        }

        // Cria um amigo fake
        Amigo amigo = new Amigo();
        amigo.setIdAmigo(1);
        amigo.setNomeAmigo("João Teste");

        ArrayList<Amigo> listaAmigo = new ArrayList<>();
        listaAmigo.add(amigo);

        // Cria um objeto Amigo personalizado que retorna a lista fake
        Amigo amigoFake = new Amigo() {
            @Override
            public ArrayList<Amigo> getListaAmigo() {
                return listaAmigo;
            }
        };

        // Instancia o formulário e injeta o amigo fake
        FrmCadastroEmprestimo frm = new FrmCadastroEmprestimo();
        frm.setObjetoAmigo(amigoFake);

        // Executa o método que queremos testar
        frm.carregaCBAmigo();

        // Verifica o resultado no combo box
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) frm.CBAmigo.getModel();

        // Asserções
        assertEquals(1, model.getSize()); // deve ter um item
        assertEquals("João Teste", model.getElementAt(0)); // deve ser o nome do amigo
    }
}
