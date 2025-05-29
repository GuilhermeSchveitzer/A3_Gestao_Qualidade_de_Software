package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Emprestimo;
import modelo.Ferramenta;
import modelo.Amigo;
import static dao.AmigoDAO.verificaEmprestimoPendente;
import static dao.FerramentaDAO.verificaDisponibilidade;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

// FEITO POR JOÃO
public class FrmCadastroEmprestimo extends javax.swing.JFrame {

    private Emprestimo objetoEmprestimo;
    private Ferramenta objetoFerramenta;
    private Amigo objetoAmigo;

    public FrmCadastroEmprestimo() {
        initComponents();

        // inicializando os objetos
        this.objetoEmprestimo = new Emprestimo();
        this.objetoFerramenta = new Ferramenta();
        this.objetoAmigo = new Amigo();

        carregaCBAmigo(); // carregando a combo box de amigo
        carregaCBFerramenta(); // carregando o combo box de ferramenta

        // formatando a data para o formato do mySQL
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); // Define o formato de saída desejado
        String dataFormatada = formato.format(data);
        this.JTFData.setText(dataFormatada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JBVoltar = new javax.swing.JButton();
        JBPegar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTFData = new javax.swing.JTextPane();
        CBFerramenta = new javax.swing.JComboBox<>();
        CBAmigo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Emprestimo");

        jLabel1.setText("Amigo");

        jLabel2.setText("Ferramenta");

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JBPegar.setText("Pegar");
        JBPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBPegarActionPerformed(evt);
            }
        });

        jLabel3.setText("Data do empréstimo");

        jScrollPane3.setViewportView(JTFData);

        CBFerramenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBAmigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBAmigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap(419, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(JBPegar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(CBFerramenta, 0, 184, Short.MAX_VALUE)
                            .addComponent(CBAmigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBVoltar)
                    .addComponent(JBPegar))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFNomeEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JBPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBPegarActionPerformed

        // inicializando as variáveis que serão utilizadas
        int idAmigo = 0;
        int idFerramenta = 0;
        int idEmprestimo = objetoEmprestimo.maiorID() + 1; // definindo a ID do emprestimo automaticamente 
        Date dataEmprestimo = new Date();
        Boolean sair = false;
        
        ArrayList<Amigo> listaAmigo = objetoAmigo.getListaAmigo();
        ArrayList<Ferramenta> listaFerramenta = objetoFerramenta.getListaFerramenta();

        idAmigo = listaAmigo.get(CBAmigo.getSelectedIndex()).getIdAmigo(); // atribuindo a ID do amigo como sendo o index da combo box mais 1, pq a combo box começa com index 0
        idFerramenta = listaFerramenta.get(CBFerramenta.getSelectedIndex()).getIdFerramenta(); // atribuindo a ID da ferramenta como sendo o index da combo box mais 1
        Amigo amigoEscolhido = objetoAmigo.carregaAmigoPorId(idAmigo);// variável para guardar o amigo escolhido
        Ferramenta ferramentaEscolhida = objetoFerramenta.carregaFerramentaPorId(idFerramenta);// variável para guardar a ferramenta escolhido
        java.sql.Date sqlDate = new java.sql.Date(dataEmprestimo.getTime()); // pegando data no formato do SQL

        // verificando se o campo de data está preenchido corretamente
        if (JTFData != null) {
            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                dataEmprestimo = formato.parse(JTFData.getText());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Data de empréstimo inválida. Digite no formato yyyy-MM-dd.", "Erro de formato", JOptionPane.ERROR_MESSAGE);
            }
        }

        // loop while para se alguma condição ocorrer, o programa parar de rodar e não inserir nada na BD.
        while (sair == false) {
            // verificando se o amigo ja tem algum empréstimo para perguntar se pode emprestar mesmo assim
            if (verificaEmprestimoPendente(amigoEscolhido.getIdAmigo()))  {
                int confirmEmprestimo = JOptionPane.showConfirmDialog(null, "O amigo " + amigoEscolhido.getNomeAmigo() + " já possui um empréstimo ativo. Deseja conceder mesmo assim?");
                // condicional para ver se o usuário quer emprestar mesmo com o amigo ainda tendo pendencias e checando se a ferramenta está disponível
                if (confirmEmprestimo == 0 && verificaDisponibilidade(ferramentaEscolhida.getIdFerramenta())) {
                    this.objetoEmprestimo.inserirEmprestimoBD(idEmprestimo, amigoEscolhido.getIdAmigo(), ferramentaEscolhida.getIdFerramenta(), sqlDate, true,
                            ferramentaEscolhida, amigoEscolhido);

                    // mostrando mensagem confirmando que o empréstimo foi cadastrado, para quem e quando
                    JOptionPane.showMessageDialog(null, amigoEscolhido.getNomeAmigo() + " Pegou um(a) "
                            + ferramentaEscolhida.getNomeFerramenta() + " emprestado(a)." + " na data: " + dataEmprestimo);
                    carregaCBFerramenta();
                    sair = true;
                } else if (confirmEmprestimo == 1 || confirmEmprestimo == 2) {
                    // caso o usuário clique em NO ou Cancel
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                    sair = true;
                } else if (confirmEmprestimo == 0 && !verificaDisponibilidade(ferramentaEscolhida.getIdFerramenta())) {
                    // caso ele clique em sim mas a ferramenta já estiver emprestada
                    JOptionPane.showMessageDialog(null, "Ferramenta " + ferramentaEscolhida.getNomeFerramenta() + " indisponível, escolha outra!");
                    sair = true;
                }
            } else if (!verificaDisponibilidade(ferramentaEscolhida.getIdFerramenta())) {
                // se a ferramenta não estiver disponível nao concede o empréstimo
                JOptionPane.showMessageDialog(null, "Ferramenta " + ferramentaEscolhida.getNomeFerramenta() + " indisponível, escolha outra!");
                sair = true;
            } else {
                if (this.objetoEmprestimo.inserirEmprestimoBD(idEmprestimo, amigoEscolhido.getIdAmigo(), ferramentaEscolhida.getIdFerramenta(), sqlDate, true,
                        ferramentaEscolhida, amigoEscolhido)) {
                    // mostrando mensagem confirmando que o empréstimo foi cadastrado, para quem e quando
                    JOptionPane.showMessageDialog(null, amigoEscolhido.getNomeAmigo() + " Pegou um(a) "
                            + ferramentaEscolhida.getNomeFerramenta() + " emprestado(a)." + " na data: " + dataEmprestimo);
                    carregaCBFerramenta();
                    sair = true;
                }
            }
        }
        System.out.println(objetoEmprestimo.getMinhaLista().toString());
        this.dispose();
    }//GEN-LAST:event_JBPegarActionPerformed

    // método para carregar os amigos na lista do combo box
    public void carregaCBAmigo() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();// setando o modelo default do combo box para excluir os 4 itens padroes
        ArrayList<Amigo> listaAmigo = objetoAmigo.getListaAmigo();
        for (Amigo objeto : listaAmigo) { // loop para percorrer todas as posições do array list de amigos
            model.addElement(objeto.getNomeAmigo());// adicionando o elememento com ID e nome ao combo box 
            CBAmigo.setModel(model); // setando o modelo
        }
    }

    // mesmo método, só que para carregar ferramentas no combobox
    public void carregaCBFerramenta() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        ArrayList<Ferramenta> listaFerramenta = objetoFerramenta.getListaFerramenta();
        ArrayList<Emprestimo> listaEmprestimo = objetoEmprestimo.getMinhaLista();
        for (int i = 0; i < listaFerramenta.size(); i++) {
            boolean pendente = false;
            for (int y = 0; y < listaEmprestimo.size(); y++) {
                if (listaEmprestimo.get(y).getPendente() && listaEmprestimo.get(y).getIdFerramenta() == listaFerramenta.get(i).getIdFerramenta()) {
                    pendente = true;
                }
            }
            if (!pendente) {
                model.addElement(listaFerramenta.get(i).getNomeFerramenta());
                CBFerramenta.setModel(model);
            }
        }
    }

    private void CBAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBAmigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBAmigoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastroEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBAmigo;
    private javax.swing.JComboBox<String> CBFerramenta;
    private javax.swing.JButton JBPegar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextPane JTFData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
