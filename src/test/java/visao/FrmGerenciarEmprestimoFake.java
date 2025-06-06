package visao;

import modelo.Emprestimo;
import javax.swing.JTable;
import javax.swing.JButton;

public class FrmGerenciarEmprestimoFake {

    private String ultimaMensagem;
    private Emprestimo objetoEmprestimo;

    public FrmGerenciarEmprestimoFake() {
        this.objetoEmprestimo = new Emprestimo();
    }

    public void mostrarMensagem(String mensagem) {
        this.ultimaMensagem = mensagem;
        System.out.println("Mensagem: " + mensagem);
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    public void carregaTabela() {
        // Deixe vazio ou simule se necessário
    }

    public JTable getTabelaEmprestimos() {
        return new JTable(); // Tabela vazia só para testes
    }

    public JButton getBotaoDevolucao() {
        JButton botao = new JButton();
        botao.addActionListener(e -> {
            try {
                JBDevolucaoAction();
            } catch (Exception ex) {
                mostrarMensagem(ex.getMessage());
            }
        });
        return botao;
    }

    public void JBDevolucaoAction() throws Exception {
        // Simula situação de devolução sem seleção
        throw new Mensagem("Primeiro Selecione um empréstimo para DEVOLVER");
    }
}
