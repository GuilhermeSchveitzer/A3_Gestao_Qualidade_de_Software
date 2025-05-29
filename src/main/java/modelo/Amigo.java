package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    private int idAmigo;
    private String nomeAmigo;
    private String telefone;
    public AmigoDAO dao; // instanciando a classe amigoDAO para ter acesso aos seus métodos.

    public Amigo() {
        this(0, "", "");
    }

    // Construtor com valor 0 nos emprestimos já que todo amigo começa sem emprestimos
    public Amigo(int idAmigo, String nomeAmigo, String telefone) {
        this.idAmigo = idAmigo;
        this.nomeAmigo = nomeAmigo;
        this.telefone = telefone;
        this.dao = new AmigoDAO();
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public void setNomeAmigo(String nomeAmigo) {
        this.nomeAmigo = nomeAmigo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    // método para retornar uma string com todos os atributos
    public String toString() {
        return "idAmigo=" + idAmigo + ", nomeAmigo=" + nomeAmigo + ", telefone=" + telefone;
    }

    // método para alterar o telefone para oformato desejado caso o usuário coloque outros caracteres
    public String limparTelefone(String telefone) {
        telefone = telefone.replace("-", "");
        telefone = telefone.replace("(", "");
        telefone = telefone.replace(")", "");
        telefone = telefone.replace(" ", "");
        return telefone;
    }

    //Metodos de DAO:
    
    public ArrayList<Amigo> getListaAmigo() {
        return dao.getListaAmigo();
    }

    // retorna um amigo por ID
    public Amigo carregaAmigoPorId(int id) {
        return dao.carregaAmigoPorId(id);
    }

    // método para inserir um novo amigo
    public boolean inserirAmigoBD(int id, String nome, String telefone) {
        id = dao.maiorID() + 1;// ID atribuída automaticamene
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.inserirAmigoBD(objeto);
        return true;
    }

    // retorna a maior ID
    public int maiorID() {
        return dao.maiorID();
    }

    // deleta amigo
    public boolean deletarAmigoBD(int id) {
        dao.deletarAmigoBD(id);
        return true;
    }

    // altera algum amigo existente
    public boolean atualizarAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.atualizarAmigoBD(objeto);
        return true;
    }
   
    

}
