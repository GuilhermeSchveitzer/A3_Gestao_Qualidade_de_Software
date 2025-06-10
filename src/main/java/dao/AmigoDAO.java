package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;
import conexao.Conexao;

// FEITO POR JOÃO
public class AmigoDAO {

    public static ArrayList<Amigo> listaAmigo = new ArrayList<>();

    // retorna a lista com todos os amigos cadastrados
    public ArrayList<Amigo> getListaAmigo() {
        listaAmigo.clear();

        // Usando try-with-resources para garantir o fechamento de Statement e ResultSet
        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos")) {

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
            e.printStackTrace();
            return null;
        }
        return listaAmigo;
    }

    // retorna o amigo procurado pela id
    public Amigo carregaAmigoPorId(int id) {
        Amigo objeto = new Amigo();
        objeto.setIdAmigo(id);

        // **CORREÇÃO:** Usando PreparedStatement para evitar Injeção de SQL
        String sql = "SELECT * FROM tb_amigos WHERE idAmigo = ?";
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, id); // Define o parâmetro de forma segura

            try (ResultSet res = stmt.executeQuery()) { // Executa a query sem concatenar
                if (res.next()) { // Adicionado verificação para garantir que há um resultado
                    objeto.setNomeAmigo(res.getString("nomeAmigo"));
                    objeto.setTelefone(res.getString("telefone"));
                }
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

        // Usando try-with-resources para PreparedStatement
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
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

        // **CORREÇÃO:** Embora esta query não receba input externo, usar Statement é aceitável,
        // mas se a regra do Sonar estiver muito estrita, o ideal seria PreparedStatement sempre
        // que houver chance de mudar a query. Para este caso, está OK, pois a query é estática.
        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT MAX(idAmigo) idAmigo FROM tb_amigos")) {

            if (res.next()) {
                maiorID = res.getInt("idAmigo");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        return maiorID;
    }

    //Método para deletar amigo da BD
    public boolean deletarAmigoBD(int idAmigo) {
        // **CORREÇÃO:** Usando PreparedStatement para evitar Injeção de SQL
        String sql = "DELETE FROM tb_amigos WHERE idAmigo = ?";
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, idAmigo); // Define o parâmetro de forma segura
            stmt.executeUpdate(); // Usa executeUpdate para DELETE

            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }

    // método para alterar dados de algum amigo
    public boolean atualizarAmigoBD(Amigo objeto) {
        String sql = "UPDATE tb_amigos set nomeAmigo = ? ,telefone = ? WHERE idAmigo = ?";

        // Usando try-with-resources para PreparedStatement
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeAmigo());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getIdAmigo());
            stmt.execute();

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
        // Este método já estava usando PreparedStatement corretamente.
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, id); // O parâmetro deve ser setado antes de executar a query

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}