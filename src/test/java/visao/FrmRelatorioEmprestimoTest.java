package visao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import visao.FrmRelatorioEmprestimo;
import modelo.Emprestimo;
import dao.AmigoDAO;
import dao.FerramentaDAO;
import modelo.Amigo;
import modelo.Ferramenta;

import java.util.ArrayList;
import javax.swing.JLabel;
import org.junit.jupiter.api.BeforeAll;

public class FrmRelatorioEmprestimoTest {

    // ✅ Adicionado para rodar corretamente no ambiente CI (como GitHub Actions)
    @BeforeAll
    public static void configurarModoHeadless() {
        if (System.getenv("CI") != null) {
            System.setProperty("java.awt.headless", "true");
        }
    }

    static class FakeAmigoDAO extends AmigoDAO {

        @Override
        public ArrayList<Amigo> getListaAmigo() {
            ArrayList<Amigo> lista = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                Amigo a = new Amigo();
                a.setIdAmigo(i);
                a.setNomeAmigo("Amigo " + i);
                lista.add(a);
            }
            return lista;
        }

        @Override
        public Amigo carregaAmigoPorId(int id) {
            Amigo a = new Amigo();
            a.setIdAmigo(id);
            a.setNomeAmigo("Amigo " + id);
            return a;
        }
    }

    static class FakeFerramentaDAO extends FerramentaDAO {

        @Override
        public ArrayList<Ferramenta> getListaFerramenta() {
            ArrayList<Ferramenta> lista = new ArrayList<>();
            for (int i = 1; i <= 3; i++) {
                Ferramenta f = new Ferramenta();
                f.setIdFerramenta(i);
                f.setNomeFerramenta("Ferramenta " + i);
                f.setCusto(i * 10.0);
                lista.add(f);
            }
            return lista;
        }

        @Override
        public Ferramenta carregaFerramentaPorId(int id) {
            Ferramenta f = new Ferramenta();
            f.setIdFerramenta(id);
            f.setNomeFerramenta("Ferramenta " + id);
            f.setCusto(id * 10.0);
            return f;
        }
    }

    static class FakeEmprestimo extends Emprestimo {

        @Override
        public ArrayList<Emprestimo> getMinhaLista() {
            ArrayList<Emprestimo> lista = new ArrayList<>();

            // 2 emprestimos pendentes (ativos)
            for (int i = 1; i <= 2; i++) {
                Emprestimo e = new Emprestimo();
                e.setIdAmigo(i);
                e.setIdFerramenta(i);
                e.setDataEmprestimo("2024-01-01");
                e.setDataDevolucao(null);
                e.setPendente(true);
                lista.add(e);
            }

            // 1 emprestimo devolvido
            Emprestimo e = new Emprestimo();
            e.setIdAmigo(3);
            e.setIdFerramenta(3);
            e.setDataEmprestimo("2024-01-01");
            e.setDataDevolucao("2024-02-01");
            e.setPendente(false);
            lista.add(e);

            return lista;
        }
    }

    static class FrmRelatorioEmprestimoFake extends FrmRelatorioEmprestimo {

        public FrmRelatorioEmprestimoFake() {
            super();
            this.objetoAmigoDAO = new FakeAmigoDAO();
            this.objetoFerramentaDAO = new FakeFerramentaDAO();
            this.objetoEmprestimo = new FakeEmprestimo();
        }

        public JLabel getJLValorTotalFerramentas() {
            return JLValorTotalFerramentas;
        }

        public JLabel getJLAmigoMaisEmprestimos() {
            return JLAmigoMaisEmprestimos;
        }

        public JLabel getJLAmigoNuncaDevolveu() {
            return JLAmigoNuncaDevolveu;
        }

        public JLabel getJLIndicadorAmigoDevolver() {
            return JLIndicadorAmigoDevolver;
        }

        public JLabel getJLIndicadorAmigoEmprestimos() {
            return JLIndicadorAmigoEmprestimos;
        }
    }

    @Test
    public void testSomaValorFerramentas() {
        FrmRelatorioEmprestimoFake frame = new FrmRelatorioEmprestimoFake();
        frame.somaValorFerramentas();
        assertEquals("R$ 60,00", frame.getJLValorTotalFerramentas().getText());
    }

    @Test
    public void testAmigoMaisEmprestimos() {
        FrmRelatorioEmprestimoFake frame = new FrmRelatorioEmprestimoFake();
        frame.amigoMaisEmprestimos();
        assertTrue(frame.getJLAmigoMaisEmprestimos().getText().contains("Amigo"));
        assertNotNull(frame.getJLIndicadorAmigoEmprestimos().getText());
    }

    @Test
    public void testAmigoNuncaDevolveu() {
        FrmRelatorioEmprestimoFake frame = new FrmRelatorioEmprestimoFake();
        frame.amigoNuncaDevolveu();
        assertTrue(frame.getJLAmigoNuncaDevolveu().getText().contains("Amigo"));
        assertNotNull(frame.getJLIndicadorAmigoDevolver().getText());
    }
}
