package fakes;

import dao.FerramentaDAO;
import modelo.Ferramenta;
import java.util.ArrayList;

public class FakeFerramentaDAO extends FerramentaDAO {

    @Override
    public ArrayList<Ferramenta> getListaFerramenta() {
        ArrayList<Ferramenta> lista = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Ferramenta f = new Ferramenta();
            f.setIdFerramenta(i);
            f.setNomeFerramenta("Ferramenta " + i);
            f.setCusto(i * 10.0); // 10, 20, 30
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
