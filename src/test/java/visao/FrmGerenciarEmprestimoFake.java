package visao;

public class FrmGerenciarEmprestimoFake extends FrmGerenciarEmprestimo {

    private String ultimaMensagem;

    public FrmGerenciarEmprestimoFake() {
        super(); // chama o construtor original
        setVisible(false); // impede abrir a janela durante testes
    }

    @Override
    public void mostrarMensagem(String mensagem) {
        this.ultimaMensagem = mensagem;
        System.out.println("Mensagem exibida: " + mensagem);
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
}