
package visao;


import dao.AmigoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;


public class FrmGerenciarAmigo extends javax.swing.JFrame {

     private Amigo amigo;

    public FrmGerenciarAmigo() {
        initComponents();
        this.amigo = new Amigo(); // initialize AmigoDAO
        this.carregaTabela();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        JBApagar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        JBSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTFNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFTelefone = new javax.swing.JTextField();

        textField1.setText("textField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gereciador de amigos");
        setResizable(false);

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JBVoltar.setText("Cancelar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JBSalvar.setText("Salvar");
        JBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("Gerencia Amigo");

        jLabel2.setText("Nome:");

        JTFNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFNomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Telefone:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1)))
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(JTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAlterar)
                    .addComponent(JBSalvar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBApagar)
                    .addComponent(JBVoltar))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
    try {
            if (this.jTable.getSelectedRow() == -1) {
                throw new Exception("Primeiro Selecione um Amigo para APAGAR");
            }

            int amigoId = this.amigo.getListaAmigo().get(this.jTable.getSelectedRow()).getIdAmigo();

            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esse Amigo?");
            if (respostaUsuario == 0) {
                if (this.amigo.deletarAmigoBD(amigoId)) {
                    this.JTFNome.setText("");
                    this.JTFTelefone.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Amigo apagado com Sucesso!");
                }
            }

            carregaTabela();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela();
        }

    }//GEN-LAST:event_JBApagarActionPerformed

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
  // TODO add your handling code here:
     try {
            String nome = "";
            String telefone = "";

            if (this.JTFNome.getText().length() <= 0) {
                throw new Exception("Nome não pode estar vazio.");
            } else {
                nome = this.JTFNome.getText();
            }

            if (this.JTFTelefone.getText().length() <= 0) {
                throw new Exception("Telefone não pode estar vazio.");
            } else {
                telefone = this.JTFTelefone.getText();
            }

            if (this.jTable.getSelectedRow() == -1) {
                throw new Exception("Primeiro Selecione um Amigo para Alterar");
            } else {
                int amigoId = this.amigo.getListaAmigo().get(this.jTable.getSelectedRow()).getIdAmigo();
                if (this.amigo.atualizarAmigoBD(amigoId, nome, telefone)) {
                    this.JTFNome.setText("");
                    this.JTFTelefone.setText("");
                    JOptionPane.showMessageDialog(null, "Amigo alterado com sucesso!");
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela();
        }
    
    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
     this.dispose();

    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalvarActionPerformed
       try {
            String nome = "";
            String telefone = "";

            if (this.JTFNome.getText().length() <= 0) {
                throw new Exception("Nome não pode estar vazio.");
            } else {
                nome = this.JTFNome.getText();
            }

            if (this.JTFTelefone.getText().length() <= 0) {
                throw new Exception("Telefone não pode estar vazio.");
            } else {
                telefone = this.JTFTelefone.getText();
            }

            int id = amigo.maiorID() + 1;

            if (this.amigo.inserirAmigoBD(id, nome, telefone)) {
                this.JTFNome.setText("");
                this.JTFTelefone.setText("");
                JOptionPane.showMessageDialog(rootPane, "Amigo salvo com Sucesso!");
            }

            carregaTabela();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela();
        }

    }//GEN-LAST:event_JBSalvarActionPerformed

    private void jTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMousePressed
        // TODO add your handling code here:
        if (this.jTable.getSelectedRow() != -1) {
            String nome = this.jTable.getValueAt(this.jTable.getSelectedRow(), 1).toString();
            String telefone = this.jTable.getValueAt(this.jTable.getSelectedRow(), 2).toString();

            this.JTFNome.setText(nome);
            this.JTFTelefone.setText(telefone);
        }
    }//GEN-LAST:event_jTableMousePressed

    private void JTFNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFNomeActionPerformed
    // TODO add your handling code here:


    public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0);

        ArrayList<Amigo> listaAmigo = amigo.getListaAmigo();
        for (Amigo a : listaAmigo) {
            modelo.addRow(new Object[]{
                a.getNomeAmigo(),
                a.getTelefone()
            });
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarAmigo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciarAmigo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBSalvar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JTextField JTFTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
