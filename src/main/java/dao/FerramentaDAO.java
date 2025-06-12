package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;
import conexao.Conexao;

public class FerramentaDAO {

    public static ArrayList<Ferramenta> listaFerramenta = new ArrayList<>();

    // retorna a lista com todas as Ferramentas cadastradas
    public ArrayList<Ferramenta> getListaFerramenta() {
        listaFerramenta.clear();

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas")) {

            // loop para percorrer todas as linhas da tabela
            while (res.next()) {
                // vai buscar e retornar a lista com todos os objetos 'Ferramenta'
                int idFerramenta = res.getInt("idFerramenta");
                String nomeFerramenta = res.getString("nomeFerramenta");
                String marca = res.getString("marca");
                double custo = res.getDouble("custo");

                Ferramenta objeto = new Ferramenta(idFerramenta, nomeFerramenta, marca, custo);
                listaFerramenta.add(objeto);
            }
        } catch (SQLException e) {
            // printando o erro específico no console
            e.printStackTrace();
            return null;
        }
        return listaFerramenta;
    }

    // retorna a Ferramenta procurada pela id
    public Ferramenta carregaFerramentaPorId(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setIdFerramenta(id);

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas WHERE idFerramenta = " + id)) {

            if (res.next()) { // Verifica se há um resultado antes de tentar acessá-lo
                objeto.setNomeFerramenta(res.getString("nomeFerramenta"));
                objeto.setMarca(res.getString("marca"));
                objeto.setCusto(res.getDouble("custo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        return objeto;
    }

    // Método para cadastrar nova Ferramenta
    public boolean inserirFerramentaBD(Ferramenta objeto) {
        // variável para guardar o comando SQL a ser executado pelo método
        String sql = "INSERT INTO tb_ferramentas(idFerramenta, nomeFerramenta, marca, custo) VALUES (?,?,?,?)";

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setInt(1, objeto.getIdFerramenta());
            stmt.setString(2, objeto.getNomeFerramenta());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());

            stmt.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            throw new RuntimeException(e);
        }
    }

    // método para retornar maior ID da lista de ferramentas
    public int maiorID() {
        int maiorID = 0;

        try (Statement stmt = Conexao.getConexao().createStatement();
             ResultSet res = stmt.executeQuery("SELECT MAX(idFerramenta) idFerramenta FROM tb_ferramentas")) {

            if (res.next()) { // Verifica se há um resultado antes de tentar acessá-lo
                maiorID = res.getInt("idFerramenta");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }

        return maiorID;
    }

    // Método para deletar Ferramenta da BD
    public boolean deletarFerramentaBD(int id) {
        try (Statement stmt = Conexao.getConexao().createStatement()) {
            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE idFerramenta = " + id);
            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }

    // método para alterar dados de alguma Ferramenta
    public boolean atualizarFerramentaBD(Ferramenta objeto) {
        String sql = "UPDATE tb_ferramentas set nomeFerramenta = ? ,marca = ? ,custo = ? WHERE idFerramenta = ?";

        // usando o bloco try-with-resources para tratar possíveis erros e fechar recursos
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
            stmt.setString(1, objeto.getNomeFerramenta());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getIdFerramenta());
            stmt.execute(); // Executando a operação

            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }

    // método para verificar se a ferramenta está emprestada
    public static boolean verificaDisponibilidade(int idFerramenta) {
        String sql = "SELECT COUNT(*) FROM tb_emprestimos "
                + "WHERE idFerramenta = ? AND pendente = 1";
        // Já estava correto, mas mantive o padrão para consistência
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) { // O ResultSet também deve ser gerenciado automaticamente
            stmt.setInt(1, idFerramenta); // Este setInt deve vir antes de executar a query

            if (rs.next() && rs.getInt(1) > 0) {
                return false; // Não está disponível (possui empréstimo pendente)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true; // Disponível para empréstimo
    }
}