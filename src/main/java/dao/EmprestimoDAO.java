package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date; // Esta importação não está sendo usada, pode ser removida se não houver uso futuro
import modelo.Emprestimo;
import conexao.Conexao;

// FEITO POR JOÃO
public class EmprestimoDAO {
    public static ArrayList<Emprestimo> minhaLista = new ArrayList<>();

    // retorna a lista com todos os emprestimos
    public ArrayList<Emprestimo> getMinhaLista() {
        minhaLista.clear();

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos")) {

            // loop para percorrer todas as linhas da tabela
            while (res.next()) {
                // vai buscar e retornar a lista com todos os objetos 'Emprestimo'
                int idEmprestimo = res.getInt("idEmprestimo");
                int idAmigo = res.getInt("idAmigo");
                int idFerramenta = res.getInt("idFerramenta");
                String dataEmprestimo = res.getString("dataEmprestimo");
                String dataDevolucao = res.getString("dataDevolucao");
                boolean pendente = res.getBoolean("pendente");

                Emprestimo objeto = new Emprestimo(idEmprestimo, idAmigo, idFerramenta, dataEmprestimo, dataDevolucao, pendente);
                minhaLista.add(objeto);
            }
        } catch (SQLException e) {
            // printando o erro específico no console
            e.printStackTrace();
            return null;
        }
        return minhaLista;
    }

    // retorna o Emprestimo procurado pela id
    public Emprestimo carregaEmprestimoPorId(int id) {
        Emprestimo objeto = new Emprestimo();
        objeto.setIdEmprestimo(id);

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_emprestimos WHERE idEmprestimo = " + id)) {

            if (res.next()) { // Verifica se há um resultado antes de tentar acessá-lo
                objeto.setIdAmigo(res.getInt("idAmigo"));
                objeto.setIdFerramenta(res.getInt("idFerramenta"));
                objeto.setDataEmprestimo(res.getString("dataEmprestimo"));
                objeto.setDataDevolucao(res.getString("dataDevolucao"));
                objeto.setPendente(res.getBoolean("pendente"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        return objeto;
    }

    // Método para cadastrar novo Emprestimo
    public boolean inserirEmprestimoBD(Emprestimo objeto) {
        // variável para guardar o comando SQL a ser executado pelo método
        String sql = "INSERT INTO tb_emprestimos(idEmprestimo, idAmigo, idFerramenta, dataEmprestimo, dataDevolucao, pendente) VALUES (?,?,?,?,?,?)";

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, objeto.getIdEmprestimo());
            stmt.setInt(2, objeto.getIdAmigo());
            stmt.setInt(3, objeto.getIdFerramenta());
            stmt.setString(4, objeto.getDataEmprestimo());
            stmt.setString(5, objeto.getDataDevolucao());
            stmt.setBoolean(6, objeto.getPendente());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            throw new RuntimeException(e);
        }
    }

    // método que retorna a maior ID da lista de empréstimos
    public int maiorID() {
        int maiorID = 0;

        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT MAX(idEmprestimo) idEmprestimo FROM tb_emprestimos")) {

            if (res.next()) { // Verifica se há um resultado antes de tentar acessá-lo
                maiorID = res.getInt("idEmprestimo");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        return maiorID;
    }

    // Método para deletar Emprestimo da BD
    public boolean deletarEmprestimoBD(int id) {
        try (Statement stmt = Conexao.getConexao().createStatement()) {
            stmt.executeUpdate("DELETE FROM tb_emprestimos WHERE idEmprestimo = " + id);
            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }

    // método para alterar algum emprestimo existente
    public boolean atualizarEmprestimoBD(Emprestimo objeto) {
        String sql = "UPDATE tb_emprestimos set idAmigo = ?, idFerramenta = ?, dataEmprestimo = ?, dataDevolucao = ?, pendente = ? WHERE idEmprestimo = ?";

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, objeto.getIdAmigo());
            stmt.setInt(2, objeto.getIdFerramenta());
            stmt.setString(3, objeto.getDataEmprestimo());
            stmt.setString(4, objeto.getDataDevolucao());
            stmt.setBoolean(5, objeto.getPendente());
            stmt.setInt(6, objeto.getIdEmprestimo());
            stmt.execute(); // Executando a operação

            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }
}