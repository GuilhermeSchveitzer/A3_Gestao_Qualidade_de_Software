package visao;

import modelo.Ferramenta;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmGerenciarFerramenta extends javax.swing.JFrame {

    private Ferramenta objetoferramenta;

    public FrmGerenciarFerramenta() {
        initComponents();
        this.objetoferramenta = new Ferramenta(); // carrega objetoferramenta de ferramenta
        this.carregaTabela();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JBApagar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JBVoltar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        JTFCusto = new javax.swing.JTextField();
        JTFNome = new javax.swing.JTextField();
        JTFMarca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gerência ferramentas:");

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

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Marca", "Custo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        JTFCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFCustoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Marca:");

        jLabel4.setText("Custo:");

        jLabel5.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JTFCusto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JBVoltar)
                                .addGap(29, 29, 29)
                                .addComponent(JBApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(JTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBVoltar)
                    .addComponent(JBApagar)
                    .addComponent(JBAlterar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JTFCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFCustoActionPerformed

    private void jTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMousePressed
        if (this.jTable.getSelectedRow() != -1) {
            String nome = this.jTable.getValueAt(this.jTable.getSelectedRow(), 1).toString();
            String marca = this.jTable.getValueAt(this.jTable.getSelectedRow(), 2).toString();
            String custo = this.jTable.getValueAt(this.jTable.getSelectedRow(), 3).toString();

            this.JTFNome.setText(nome);
            this.JTFCusto.setText(custo);
            this.JTFMarca.setText(marca);
        }
    }//GEN-LAST:event_jTableMousePressed

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        try {
            // validando dados da interface gráfica.
            int id = 0;
            if (this.jTable.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma Ferramenta para APAGAR");
            } else {
                id = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esta ferramenta ?");

            if (respostaUsuario == 0) {// clicou em SIM
                // envia os dados para a Ferramenta processar

                if (this.objetoferramenta.deletarFerramentaBD(id)) {
					// limpa os campos
					this.JTFNome.setText("");
					this.JTFCusto.setText("");
					this.JTFMarca.setText("");
					JOptionPane.showMessageDialog(rootPane, "Ferramenta apagada com Sucesso!");
                }
            }	
            // atualiza a tabela.
            System.out.println(this.objetoferramenta.getListaFerramenta().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_JBApagarActionPerformed

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        try {
            // recebendo e validando dados da interface grafica.
            int id = 0;
            String nome = "";
            String marca = "";
            double custo = 0.0;

            // vendo se o campo nome não está vazio
            if (this.JTFNome.getText().length() <= 0) {
                throw new Mensagem("Nome não pode estar vazio.");
            } else {
                nome = this.JTFNome.getText();
            }
            
            if (this.JTFMarca.getText().length() <= 0) {
                throw new Mensagem("Marca não pode estar vazia.");
            } else {
                marca = this.JTFMarca.getText();
            }

            // vendo se o valor não é 0 ou menor
            if (Double.parseDouble(objetoferramenta.corrigirVirgula(this.JTFCusto.getText())) < 0.0) {
                JOptionPane.showMessageDialog(null, "O custo não pode ser negativo!");
            } else {
                custo = Double.parseDouble(objetoferramenta.corrigirVirgula(this.JTFCusto.getText()));
            }

            // vendo se algo realmente foi selecionado
            if (this.jTable.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro Selecione uma Ferramenta para Alterar");
            } else {
                id = Integer.parseInt(this.jTable.getValueAt(this.jTable.getSelectedRow(), 0).toString());
            }

            // envia os dados para a Ferramenta processar
            
            if (this.objetoferramenta.atualizarFerramentaBD(id, nome, marca, custo)) {
                // limpa os campos
                this.JTFNome.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
                JOptionPane.showMessageDialog(null, "Ferramenta alterada com sucesso!");
            }
            
            // Exibe no console a ferramenta cadastrada
            System.out.println(this.objetoferramenta.getListaFerramenta().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTable.getModel();
        modelo.setNumRows(0); // Posiciona na primeira linha da tabela
        // Carrega a lista de objetos ferramenta
        ArrayList<Ferramenta> listaFerramenta = objetoferramenta.getListaFerramenta();
        for (Ferramenta a : listaFerramenta) {
            modelo.addRow(new Object[]{
                a.getIdFerramenta(),
                a.getNomeFerramenta(),
                a.getMarca(),
                "R$ " + a.getCusto(),});
        }
    }

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGerenciarFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTextField JTFNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
