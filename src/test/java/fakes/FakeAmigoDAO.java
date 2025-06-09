package fakes;

import dao.AmigoDAO;
import modelo.Amigo;
import java.util.ArrayList;

public class FakeAmigoDAO extends AmigoDAO {

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
