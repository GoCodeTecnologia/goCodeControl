package gocodecontrol.GUI;

import gocodecontrol.DAO.CultivoDAO;
import gocodecontrol.DAO.ProdutoDAO;
import gocodecontrol.DAO.TalhaoDAO;
import gocodecontrol.DAO.UsuarioDAO;
import gocodecontrol.Models.Cultivo;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFrame;

public class FrmCultivo extends javax.swing.JFrame {

    public FrmCultivo() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_cultivo = new javax.swing.JTable();
        graficoQuantidade = new javax.swing.JButton();
        status_cultivo = new javax.swing.JButton();
        produtor_produto = new javax.swing.JButton();
        btnCadastrarCultivo = new java.awt.Button();
        btnListarDados1 = new java.awt.Button();
        codigo_apagar = new javax.swing.JTextField();
        apagarBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(115, 78, 166));

        label2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Cultivos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(630, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tabela_cultivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cód.", "Talhão", "Produto", "Responsável", "Início", "Colheita", "Andamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_cultivo);

        graficoQuantidade.setBackground(new java.awt.Color(0, 102, 102));
        graficoQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        graficoQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        graficoQuantidade.setText("Cultivo por Produto");
        graficoQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficoQuantidadeActionPerformed(evt);
            }
        });

        status_cultivo.setBackground(new java.awt.Color(0, 102, 102));
        status_cultivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        status_cultivo.setForeground(new java.awt.Color(255, 255, 255));
        status_cultivo.setText("Cultivo por Produtor");
        status_cultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                status_cultivoActionPerformed(evt);
            }
        });

        produtor_produto.setBackground(new java.awt.Color(0, 102, 102));
        produtor_produto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        produtor_produto.setForeground(new java.awt.Color(255, 255, 255));
        produtor_produto.setText("Cultivo porduto e Produtor");
        produtor_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtor_produtoActionPerformed(evt);
            }
        });

        btnCadastrarCultivo.setBackground(new java.awt.Color(0, 204, 51));
        btnCadastrarCultivo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCadastrarCultivo.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarCultivo.setLabel("Novo Cultivo +");
        btnCadastrarCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCultivoActionPerformed(evt);
            }
        });

        btnListarDados1.setBackground(new java.awt.Color(0, 204, 51));
        btnListarDados1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnListarDados1.setForeground(new java.awt.Color(255, 255, 255));
        btnListarDados1.setLabel("Carregar Dados Tabela");
        btnListarDados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarDados1ActionPerformed(evt);
            }
        });

        apagarBtn.setBackground(new java.awt.Color(255, 0, 0));
        apagarBtn.setForeground(new java.awt.Color(255, 255, 255));
        apagarBtn.setText("Apagar");
        apagarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Digite o código para apagar cultivo");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnCadastrarCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarDados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graficoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(produtor_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status_cultivo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(codigo_apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apagarBtn)))
                .addContainerGap(566, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarDados1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(produtor_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(graficoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status_cultivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo_apagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apagarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graficoQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficoQuantidadeActionPerformed
        // TODO add your handling code here:
        CultivoDAO cultivo = new CultivoDAO();
        ChartFrame frame = null;
        try {
            frame = new ChartFrame("Grafico de Quantidade", cultivo.graficoBarPorProduto());
        } catch (SQLException ex) {
            Logger.getLogger(FrmCultivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(600, 400);  
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_graficoQuantidadeActionPerformed

    private void status_cultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_status_cultivoActionPerformed
        // TODO add your handling code here:
        CultivoDAO cultivo = new CultivoDAO();
        ChartFrame frame = null;
        try {
            frame = new ChartFrame("Grafico de Quantidade", cultivo.graficoBarPorProdutor());
        } catch (SQLException ex) {
            Logger.getLogger(FrmCultivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(600, 400);  
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_status_cultivoActionPerformed

    private void produtor_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtor_produtoActionPerformed
        // TODO add your handling code here:
        CultivoDAO cultivo = new CultivoDAO();
        ChartFrame frame = null;
        try {
            frame = new ChartFrame("Grafico de Quantidade", cultivo.graficoBarPorProdutorEProduto());
        } catch (SQLException ex) {
            Logger.getLogger(FrmCultivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(600, 400);  
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }//GEN-LAST:event_produtor_produtoActionPerformed

    private void btnCadastrarCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCultivoActionPerformed
        // TODO add your handling code here:
        FrmCadCultivo cadCultivo = new FrmCadCultivo();
        cadCultivo.setVisible(true);
        cadCultivo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cadCultivo.setLocationRelativeTo(null);
        cadCultivo.setTitle("Cadastrar novo Cultivo");
    }//GEN-LAST:event_btnCadastrarCultivoActionPerformed

    private void btnListarDados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarDados1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cód.");
        modelo.addColumn("Talhão");
        modelo.addColumn("Produto");
        modelo.addColumn("Responsável");
        modelo.addColumn("Início");
        modelo.addColumn("Colheita");
        modelo.addColumn("Andamento");

        CultivoDAO c = new CultivoDAO();
        ArrayList<Cultivo> array = c.buscarTodos();

        for(Cultivo j : array) {
            try {
                TalhaoDAO talhao = new TalhaoDAO();
                String nomeTalhao = talhao.detalheTalhao(j.getCd_talhao()).getNm_talhao();
                ProdutoDAO produto = new ProdutoDAO();
                String nomeProduto = produto.nomeProduto(j.getCd_produto());
                UsuarioDAO usuario = new UsuarioDAO();
                String nomeUsuario = usuario.nomeUsuario(j.getCd_usuario());
                
                Object[] dado = {j.getCd_cultivo(), nomeTalhao, nomeProduto, nomeUsuario,
                    j.getDt_inicio(), j.getDt_colheita(), j.getAndamento()};
                modelo.addRow(dado);
            } catch (SQLException ex) {
                Logger.getLogger(FrmCultivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tabela_cultivo.setModel(modelo);
    }//GEN-LAST:event_btnListarDados1ActionPerformed

    private void apagarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarBtnActionPerformed
        // TODO add your handling code here:
        
        int verificacao = JOptionPane.showConfirmDialog(this,"Deseja mesmo excluir esse registro?");  
        if(verificacao == JOptionPane.YES_OPTION){ 
            int codigo = parseInt(this.codigo_apagar.getText());
            CultivoDAO cultivo = new CultivoDAO();
            boolean retorno = cultivo.apagarCultivo(codigo);
            if(retorno){
                JOptionPane.showMessageDialog (null, "O cultivo foi apagado com sucesso!");
            }else{
                JOptionPane.showMessageDialog (null, "O cultivo nao foi apagado!");
            }
        }else{
            JOptionPane.showMessageDialog (null, "Processo cancelado!");
        }

    }//GEN-LAST:event_apagarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCultivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCultivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCultivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCultivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCultivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apagarBtn;
    private java.awt.Button btnCadastrarCultivo;
    private java.awt.Button btnListarDados1;
    private javax.swing.JTextField codigo_apagar;
    private javax.swing.JButton graficoQuantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label2;
    private javax.swing.JButton produtor_produto;
    private javax.swing.JButton status_cultivo;
    private javax.swing.JTable tabela_cultivo;
    // End of variables declaration//GEN-END:variables
}
