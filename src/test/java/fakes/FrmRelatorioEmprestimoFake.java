package fakes;

import visao.FrmRelatorioEmprestimo;
import javax.swing.JLabel;

public class FrmRelatorioEmprestimoFake extends FrmRelatorioEmprestimo {

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