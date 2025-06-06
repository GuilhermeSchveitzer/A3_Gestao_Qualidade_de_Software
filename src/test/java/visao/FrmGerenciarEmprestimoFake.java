package visao;

public class FrmGerenciarEmprestimoFake extends FrmGerenciarEmprestimo {
    
    private String ultimaMensagem;

  

    @Override
    public void mostrarMensagem(String mensagem) {
        this.ultimaMensagem = mensagem;
        System.out.println("Mensagem: " + mensagem);
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

}