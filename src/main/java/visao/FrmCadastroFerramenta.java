
package visao;
import javax.swing.JOptionPane;
import modelo.Ferramenta;

public class FrmCadastroFerramenta extends javax.swing.JFrame {

    private Ferramenta objetoFerramenta; //Criando o vínculo com a classe Ferramenta
   
    public FrmCadastroFerramenta() {
        initComponents();
        setLocationRelativeTo(null);
        this.objetoFerramenta = new Ferramenta(); // instancia o objeto de ferramenta vazio
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTFNomeFerramenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFCusto = new javax.swing.JTextField();
        JBVoltar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro De Ferramentas");

        jLabel1.setText("Nome Da Ferramenta:");

        jLabel2.setText("Marca Da Ferramenta:");

        JTFMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFMarcaActionPerformed(evt);
            }
        });

        jLabel3.setText("Custo De Aquisição:");

        JTFCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFCustoActionPerformed(evt);
            }
        });

        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        jLabel4.setText("R$:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBCadastrar))
                    .addComponent(JTFMarca)
                    .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFCusto)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBVoltar)
                    .addComponent(JBCadastrar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFCustoActionPerformed

    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBVoltarActionPerformed

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        // TODO add your handling code here:
        // iniciando as variáveis 
        int idFerramenta = objetoFerramenta.maiorID() + 1; // atribuindo a ID automáticamente
        String nomeFerramenta = "";
        String marca = "";
        double custo = 0.0;
        
        // Loop while para que caso algum dos campos sejam inválidos o programa pare de rodar e não insira campos vazios na BD
        while (true) {
            // caso a ferramenta tenha menos de 3 caracteres
            if (this.JTFNomeFerramenta.getText().length() < 3) {
                JOptionPane.showMessageDialog(null, "O nome deve ter ao menos 3 caracteres");
                break;
            } else {
                nomeFerramenta = this.JTFNomeFerramenta.getText();
            }

            // caso a marca tenha menos do que 3 caracteres
            if (this.JTFMarca.getText().length() < 3) {
                JOptionPane.showMessageDialog(null, "A marca deve ter ao menos 3 caracteres");
                break;
            } else {
                marca = this.JTFMarca.getText();
            }
			
            // caso o valor seja menor que 0
			// ou tenha mais de 2 dígitos após a vírgula
			
			String[] decimais = objetoFerramenta.corrigirVirgula(this.JTFCusto.getText()).split("\\.");
            
			if (Double.parseDouble(objetoFerramenta.corrigirVirgula(this.JTFCusto.getText())) < 0.0) {
                JOptionPane.showMessageDialog(null, "O custo não pode ser negativo!");
                break;
            } else if (decimais[1].length() > 2) {
				JOptionPane.showMessageDialog(null, "O custo não deve ter mais de 2 casas decimais!");
				break;
			} else {
                custo = Double.parseDouble(objetoFerramenta.corrigirVirgula(this.JTFCusto.getText()));
            }

            // inserindo Ferramenta novo na BD
            if (this.objetoFerramenta.inserirFerramentaBD(idFerramenta, nomeFerramenta, marca, custo)) {
                JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com Sucesso!");
                // limpa campos da interface
                this.JTFNomeFerramenta.setText("");
                this.JTFMarca.setText("");
                this.JTFCusto.setText("");
                break;
            }

        }

        // printando no console a lista de Ferramentas que está na BD
        System.out.println(this.objetoFerramenta.getListaFerramenta().toString());
        this.dispose();
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void JTFMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFMarcaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFCusto;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTextField JTFNomeFerramenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
