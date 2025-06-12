package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;
import conexao.Conexao;

public class AmigoDAO {

    public static ArrayList<Amigo> listaAmigo = new ArrayList<>();

    // retorna a lista com todos os amigos cadastrados
    public ArrayList<Amigo> getListaAmigo() {
        listaAmigo.clear();

        // usando o bloco try catch para tratar possíveis erros
        try (Statement stmt = Conexao.getConexao().createStatement(); // Linha 23: Corrigido com try-with-resources
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos")) { // ResultSet também no try-with-resources

            // loop para percorrer todas as linhas da tabela
            while (res.next()) {
                // vai buscar e retornar a lista com todos os objetos 'Amigo'
                int idAmigo = res.getInt("idAmigo");
                String nomeAmigo = res.getString("nomeAmigo");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(idAmigo, nomeAmigo, telefone);
                listaAmigo.add(objeto);
            }
        } catch (SQLException e) {
            // printando o erro específico no console
            e.printStackTrace();
            return null;
        }
        return listaAmigo;
    }

    // retorna o amigo procurado pela id
    public Amigo carregaAmigoPorId(int id) {
        Amigo objeto = new Amigo();
        objeto.setIdAmigo(id);

        // usando o bloco try catch para tratar possíveis erros
        try (Statement stmt = Conexao.getConexao().createStatement(); // Linha 57 (aproximada): Corrigido com try-with-resources
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE idAmigo = " + id)) { // ResultSet também no try-with-resources
            if (res.next()) { // Adicionado verificação para garantir que há um resultado
                objeto.setNomeAmigo(res.getString("nomeAmigo"));
                objeto.setTelefone(res.getString("telefone"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        return objeto;
    }

    // Método para cadastrar novo amigo
    public boolean inserirAmigoBD(Amigo objeto) {
        // variável para guardar o comando SQL a ser executado pelo método
        String sql = "INSERT INTO tb_amigos(idAmigo, nomeAmigo, telefone) VALUES (?,?,?)";

        // usando o bloco try catch para tratar possíveis erros
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) { // Corrigido com try-with-resources
            stmt.setInt(1, objeto.getIdAmigo());
            stmt.setString(2, objeto.getNomeAmigo());
            stmt.setString(3, objeto.getTelefone());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            throw new RuntimeException(e);
        }
    }

    // método para retornar a maior ID da lista da BD
    public int maiorID() {
        int maiorID = 0;

        try (Statement stmt = Conexao.getConexao().createStatement(); // Corrigido com try-with-resources
             ResultSet res = stmt.executeQuery("SELECT MAX(idAmigo) idAmigo FROM tb_amigos")) { // ResultSet também no try-with-resources

            if (res.next()) { // Adicionado verificação para garantir que há um resultado
                maiorID = res.getInt("idAmigo");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        return maiorID;
    }

    //Método para deletar amigo da BD
    public boolean deletarAmigoBD(int idAmigo) {
        try (Statement stmt = Conexao.getConexao().createStatement()) { // Linha 105 (aproximada): Corrigido com try-with-resources
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE idAmigo = " + idAmigo);
            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }

    // método para alterar dados de algum amigo
    public boolean atualizarAmigoBD(Amigo objeto) {
        String sql = "UPDATE tb_amigos set nomeAmigo = ? ,telefone = ? WHERE idAmigo = ?"; // script SQL a ser executado

        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) { // Corrigido com try-with-resources
            stmt.setString(1, objeto.getNomeAmigo());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getIdAmigo());
            stmt.execute(); // Executando a operação

            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }

    // método para verificar se o amigo possui algum empréstimo pendente
    public static boolean verificaEmprestimoPendente(int id) {
        String sql = "SELECT COUNT(*) FROM tb_emprestimos e "
                + "JOIN tb_amigos a ON e.idAmigo = a.idAmigo "
                + "WHERE a.idAmigo = ?";
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) { // ExecuteQuery movido para dentro do try-with-resources para fechar rs automaticamente
            stmt.setInt(1, id); // O parâmetro deve ser setado antes de executar a query

            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Possui empréstimo pendente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Não possui empréstimo pendente
    }
}