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
        
         // usando o bloco try catch para tratar possíveis erros
        try {
            // instanciando interface Statement para utilizar métodos SQL
            Statement stmt = Conexao.getConexao().createStatement();

            // usando a classe resultSet para utilizar métodos getters do SQL
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");

            // loop para percorrer todas as linhas da tabela
            while (res.next()) {
                // vai buscar e retornar a lista com todos os objetos 'Amigo'
                int idAmigo = res.getInt("idAmigo");
                String nomeAmigo = res.getString("nomeAmigo");
                String telefone = res.getString("telefone");

                Amigo objeto = new Amigo(idAmigo, nomeAmigo, telefone);
                listaAmigo.add(objeto);

                
            }
            res.close();
            stmt.close();
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

         // usando o blocm try catch para tratar possíveis erros
        try {
            Statement stmt = Conexao.getConexao().createStatement();

            // usando a classe resultSet para utilizar métodos getters referentes a tipos de dado do SQL
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos WHERE idAmigo = " + id);
            res.next();

            objeto.setNomeAmigo(res.getString("nomeAmigo"));
            objeto.setTelefone(res.getString("telefone"));

            stmt.close();

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
        try {
            //objeto que representa uma instrução SQL a ser executada
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getIdAmigo());
            stmt.setString(2, objeto.getNomeAmigo());
            stmt.setString(3, objeto.getTelefone());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
            throw new RuntimeException(e);
        }
    }

    // método para retornar a maior ID da lista da BD
    public int maiorID() {
        int maiorID = 0;

        try {
            Statement stmt = Conexao.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(idAmigo) idAmigo FROM tb_amigos");

            res.next();
            maiorID = res.getInt("idAmigo");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        
        return maiorID;
    }
    
    //Método para deletar amigo da BD
    public boolean deletarAmigoBD (int idAmigo) {
         try {
            Statement stmt = Conexao.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_amigos WHERE idAmigo = " +  idAmigo);
            stmt.close();
            
            return true;

        } catch (SQLException e) {
            System.out.println("Erro:" + e);
            throw new RuntimeException(e);
        }
    }
    
    // método para alterar dados de algum amigo
    public boolean atualizarAmigoBD (Amigo objeto) {
        String sql = "UPDATE tb_amigos set nomeAmigo = ? ,telefone = ? WHERE idAmigo = ?"; // script SQL a ser executado
        
        try {
            //objeto que representa uma instrução SQL a ser executada
            PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
            
            
            stmt.setString(1, objeto.getNomeAmigo());
            stmt.setString(2, objeto.getTelefone());
            stmt.setInt(3, objeto.getIdAmigo());
            stmt.execute(); // Executando a operação
            
            stmt.close();
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
        try (PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql)) {
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery();

          if (rs.next() && rs.getInt(1) > 0) {
            return true; // Possui empréstimo pendente
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }

        return false; // Não possui empréstimo pendente
    }

  
}

