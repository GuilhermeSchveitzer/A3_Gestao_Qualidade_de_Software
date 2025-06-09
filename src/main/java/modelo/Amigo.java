package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    private int idAmigo;
    private String nomeAmigo;
    private String telefone;
    public AmigoDAO dao;

    public Amigo() {
        this(0, "", "");
    }

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
    public String toString() {
        return "idAmigo=" + idAmigo + ", nomeAmigo=" + nomeAmigo + ", telefone=" + telefone;
    }

    public String limparTelefone(String telefone) {
        telefone = telefone.replace("-", "")
                           .replace("(", "")
                           .replace(")", "")
                           .replace(" ", "");
        return telefone;
    }

    // Métodos de DAO

    public ArrayList<Amigo> getListaAmigo() {
        return dao.getListaAmigo();
    }

    public Amigo carregaAmigoPorId(int id) {
        Amigo a = dao.carregaAmigoPorId(id);
        // Ajuste: retorna null se nenhum amigo com o ID for encontrado
        if (a == null || a.getIdAmigo() == 0) {
            return null;
        }
        return a;
    }

    public boolean inserirAmigoBD(int id, String nome, String telefone) {
        id = dao.maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.inserirAmigoBD(objeto);
        return true;
    }

    public int maiorID() {
        return dao.maiorID();
    }

    public boolean deletarAmigoBD(int id) {
        dao.deletarAmigoBD(id);
        return true;
    }

    public boolean atualizarAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.atualizarAmigoBD(objeto);
        return true;
    }
}
