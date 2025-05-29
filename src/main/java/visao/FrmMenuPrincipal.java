
package visao;


public class FrmMenuPrincipal extends javax.swing.JFrame {

 
    public FrmMenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);// para a janela ficar no meio da tela
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JBcadastrarAluno = new javax.swing.JButton();
        JBCadastrarFerramentas = new javax.swing.JButton();
        JBGerenciarAmigo = new javax.swing.JButton();
        JBGerenciarFerramentas = new javax.swing.JButton();
        JBCadastrarEmprestimo = new javax.swing.JButton();
        JBGerenciarEmprestimo = new javax.swing.JButton();
        JBRelatorioEmprestimo = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JBcadastrarAluno.setText("Cadastrar Amigo");
        JBcadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBcadastrarAlunoActionPerformed(evt);
            }
        });

        JBCadastrarFerramentas.setText("Cadastro Ferramenta");
        JBCadastrarFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarFerramentasActionPerformed(evt);
            }
        });

        JBGerenciarAmigo.setText("Gerenciar Amigo");
        JBGerenciarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGerenciarAmigoActionPerformed(evt);
            }
        });

        JBGerenciarFerramentas.setText("Gerenciar Ferramentas");
        JBGerenciarFerramentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGerenciarFerramentasActionPerformed(evt);
            }
        });

        JBCadastrarEmprestimo.setText("Cadastro Emprestimo");
        JBCadastrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarEmprestimoActionPerformed(evt);
            }
        });

        JBGerenciarEmprestimo.setText("Devolução empréstimos");
        JBGerenciarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGerenciarEmprestimoActionPerformed(evt);
            }
        });

        JBRelatorioEmprestimo.setText("Emitir relatório");
        JBRelatorioEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBRelatorioEmprestimoActionPerformed(evt);
            }
        });

        JBSair.setText("Sair");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JBcadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBGerenciarAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBCadastrarFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBCadastrarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JBGerenciarFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBRelatorioEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBGerenciarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBcadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCadastrarFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCadastrarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGerenciarAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBGerenciarFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBRelatorioEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(JBGerenciarEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Bem Vindo tio-Avô!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBGerenciarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGerenciarAmigoActionPerformed
        // TODO add your handling code here:
        FrmGerenciarAmigo objetoTela = new FrmGerenciarAmigo();
        objetoTela.setVisible(true);
    }//GEN-LAST:event_JBGerenciarAmigoActionPerformed

    private void JBCadastrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarEmprestimoActionPerformed
        // TODO add your handling code here:
        FrmCadastroEmprestimo objetoTela = new FrmCadastroEmprestimo();
        objetoTela.setVisible(true);
    }//GEN-LAST:event_JBCadastrarEmprestimoActionPerformed

    private void JBGerenciarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGerenciarEmprestimoActionPerformed
        // TODO add your handling code here:
        FrmGerenciarEmprestimo objetoTela = new FrmGerenciarEmprestimo();
        objetoTela.setVisible(true);
        
    }//GEN-LAST:event_JBGerenciarEmprestimoActionPerformed

    private void JBcadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBcadastrarAlunoActionPerformed
        FrmCadastroAmigo objetoTela = new FrmCadastroAmigo();
        objetoTela.setVisible(true);
    }//GEN-LAST:event_JBcadastrarAlunoActionPerformed

    private void JBCadastrarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarFerramentasActionPerformed
        // TODO add your handling code here:
        FrmCadastroFerramenta objetoTela = new FrmCadastroFerramenta();
        objetoTela.setVisible(true);
    }//GEN-LAST:event_JBCadastrarFerramentasActionPerformed

    private void JBRelatorioEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBRelatorioEmprestimoActionPerformed
        // TODO add your handling code here:
        FrmRelatorioEmprestimo objetoTela = new FrmRelatorioEmprestimo();
        objetoTela.setVisible(true); 
    }//GEN-LAST:event_JBRelatorioEmprestimoActionPerformed

    private void JBGerenciarFerramentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGerenciarFerramentasActionPerformed
        // TODO add your handling code here:
        FrmGerenciarFerramenta objetoTela = new FrmGerenciarFerramenta();
        objetoTela.setVisible(true);
    }//GEN-LAST:event_JBGerenciarFerramentasActionPerformed

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_JBSairActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrarEmprestimo;
    private javax.swing.JButton JBCadastrarFerramentas;
    private javax.swing.JButton JBGerenciarAmigo;
    private javax.swing.JButton JBGerenciarEmprestimo;
    private javax.swing.JButton JBGerenciarFerramentas;
    private javax.swing.JButton JBRelatorioEmprestimo;
    private javax.swing.JButton JBSair;
    private javax.swing.JButton JBcadastrarAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
