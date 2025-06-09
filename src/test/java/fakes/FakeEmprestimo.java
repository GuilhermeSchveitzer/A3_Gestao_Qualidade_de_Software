package fakes;

import modelo.Emprestimo;
import java.util.ArrayList;

public class FakeEmprestimo extends Emprestimo {

    @Override
    public ArrayList<Emprestimo> getMinhaLista() {
        ArrayList<Emprestimo> lista = new ArrayList<>();

        // Dois empréstimos pendentes (ativos)
        for (int i = 1; i <= 2; i++) {
            Emprestimo e = new Emprestimo();
            e.setIdAmigo(i); // Amigo 1 e 2
            e.setIdFerramenta(i); // Ferramenta 1 e 2
            e.setDataEmprestimo("2024-01-01");
            e.setDataDevolucao(null);
            e.setPendente(true);
            lista.add(e);
        }

        // Um empréstimo devolvido
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