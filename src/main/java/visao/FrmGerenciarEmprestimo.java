package visao;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Emprestimo;

// FEITO POR JOÃO
public class FrmGerenciarEmprestimo extends javax.swing.JFrame {

    private Emprestimo objetoEmprestimo;

    public FrmGerenciarEmprestimo() {
        initComponents();

        this.objetoEmprestimo = new Emprestimo();
        this.carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBDevolucao = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBDevolucao.setText("Devolução");
        JBDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBDevolucaoActionPerformed(evt);
            }
        });

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome Amigo", "Nome Ferramenta", "ID emprestimo", "ID Amigo", "ID Ferramenta", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable);

        jLabel1.setText("Devolução de empréstimos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(JBDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBDevolucao)
                    .addComponent(JBVoltar))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBDevolucaoActionPerformed
        try {
            // validando dados da interface gráfica.
            // inicializando as variáveis
            int id = 0;
            int idAmigo = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 3).toString());
            int idFerramenta = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 4).toString());
            java.sql.Date dataEmprestimo = (java.sql.Date) objetoEmprestimo.carregaEmprestimoPorId(id).getDataEmprestimo();
            
            java.sql.Date dataDevolucao = new java.sql.Date(new Date().getTime());// data no formato SQL

            // caso não tenha selecionado nenhuma linha
            
            if (this.jTable.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione um empréstimo para DEVOLVER");
            } else {
                id = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 2).toString());
            }


            // retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja realizar a devolução do empréstimo?");

            if (respostaUsuario == 0) {// clicou em SIM
                // envia os dados para o objeto emprestimo processar

                if (this.objetoEmprestimo.atualizarEmprestimoBD(id, idAmigo, idFerramenta, dataEmprestimo, dataDevolucao, false)) {

                    JOptionPane.showMessageDialog(rootPane, "O amigo " + objetoEmprestimo.getAmigo().carregaAmigoPorId(idAmigo).getNomeAmigo() + " devolveu a ferramenta chamada " + objetoEmprestimo.getFerramenta().carregaFerramentaPorId(idFerramenta).getNomeFerramenta());
                }
            }
            // atualiza a tabela.
            System.out.println(this.objetoEmprestimo.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_JBDevolucaoActionPerformed

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void jTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMousePressed

    }//GEN-LAST:event_jTableMousePressed

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel(); // definindo o modelo da tabela
        modelo.setNumRows(0); // Posiciona na primeira linha da tabela
        // Carrega a lista de objetos emprestimo
        ArrayList<Emprestimo> listaEmprestimo = objetoEmprestimo.getMinhaLista();
        for (Emprestimo e : listaEmprestimo) {
            if (e.getPendente() == true) {
                modelo.addRow(new Object[]{
                e.getAmigo().carregaAmigoPorId(e.getIdAmigo()).getNomeAmigo(),
                e.getFerramenta().carregaFerramentaPorId(e.getIdFerramenta()).getNomeFerramenta(),
                e.getIdEmprestimo(),
                e.getIdAmigo(),
                e.getIdFerramenta(),
                e.getDataEmprestimo(),});
            }
            
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGerenciarEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciarEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBDevolucao;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
