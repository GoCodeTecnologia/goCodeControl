package gocodecontrol.GUI;

import gocodecontrol.Models.Usuario;

public class DashboardInicio extends javax.swing.JFrame {

    private Usuario usuario;
    
    public DashboardInicio() {
        initComponents();
    }
    
    public void carregaSession(Usuario usuario){
        this.usuario = usuario;      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        nome_usuario_label2 = new java.awt.Label();
        btnTalhao = new java.awt.Button();
        btnCultivo = new java.awt.Button();
        btnUsuario = new java.awt.Button();
        btnUnidade = new java.awt.Button();
        btnProduto = new java.awt.Button();
        btnComanda = new java.awt.Button();
        btnEntrega = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        nome_usuario_label = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 32, 89));
        jPanel1.setPreferredSize(new java.awt.Dimension(172, 511));

        panel1.setBackground(new java.awt.Color(115, 78, 166));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        nome_usuario_label2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nome_usuario_label2.setForeground(new java.awt.Color(255, 255, 255));
        nome_usuario_label2.setText("{nome_usuario}");

        btnTalhao.setBackground(new java.awt.Color(115, 78, 166));
        btnTalhao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTalhao.setForeground(new java.awt.Color(255, 255, 255));
        btnTalhao.setLabel("Talhão");
        btnTalhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTalhaoActionPerformed(evt);
            }
        });

        btnCultivo.setBackground(new java.awt.Color(242, 114, 174));
        btnCultivo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCultivo.setForeground(new java.awt.Color(255, 255, 255));
        btnCultivo.setLabel("Cultivo");
        btnCultivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCultivoActionPerformed(evt);
            }
        });
        btnCultivo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                btnCultivoPropertyChange(evt);
            }
        });

        btnUsuario.setBackground(new java.awt.Color(115, 78, 166));
        btnUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setLabel("Usuário");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btnUnidade.setBackground(new java.awt.Color(115, 78, 166));
        btnUnidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnUnidade.setForeground(new java.awt.Color(255, 255, 255));
        btnUnidade.setLabel("Unidade");
        btnUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidadeActionPerformed(evt);
            }
        });

        btnProduto.setBackground(new java.awt.Color(115, 78, 166));
        btnProduto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnProduto.setLabel("Produto");
        btnProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdutoActionPerformed(evt);
            }
        });

        btnComanda.setActionCommand("Comandas");
        btnComanda.setBackground(new java.awt.Color(242, 114, 174));
        btnComanda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnComanda.setForeground(new java.awt.Color(255, 255, 255));
        btnComanda.setLabel("Comandas");
        btnComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComandaActionPerformed(evt);
            }
        });

        btnEntrega.setActionCommand("Entrega");
        btnEntrega.setBackground(new java.awt.Color(242, 114, 174));
        btnEntrega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEntrega.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrega.setLabel("Entregas");
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(nome_usuario_label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTalhao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCultivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComanda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTalhao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(nome_usuario_label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(115, 78, 166));

        nome_usuario_label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nome_usuario_label.setForeground(new java.awt.Color(255, 255, 255));
        nome_usuario_label.setText("{nome_usuario}");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(578, Short.MAX_VALUE)
                .addComponent(nome_usuario_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(nome_usuario_label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdutoActionPerformed
        // TODO add your handling code here:
        FrmProduto produto = new FrmProduto();
        produto.setVisible(true);
        produto.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        produto.setLocationRelativeTo(null);
        produto.setTitle("GoCode Control - Produtos");
        produto.nome_usuario_label.setText(this.usuario.getNome_usuario());
    }//GEN-LAST:event_btnProdutoActionPerformed

    private void btnCultivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCultivoActionPerformed
        // TODO add your handling code here:
        FrmCultivo cultivo = new FrmCultivo();
        cultivo.setVisible(true);
        cultivo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cultivo.setLocationRelativeTo(null);
        cultivo.setTitle("GoCode Control - Cultivos");
        cultivo.nome_usuario_label.setText(this.usuario.getNome_usuario());
    }//GEN-LAST:event_btnCultivoActionPerformed

    private void btnCultivoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnCultivoPropertyChange
        // TODO add your handling code here:
        FrmProduto produto = new FrmProduto();
        produto.setVisible(true);
        produto.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        produto.setLocationRelativeTo(null);
        produto.setTitle("GoCode Control - Produtos");
    }//GEN-LAST:event_btnCultivoPropertyChange

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
        // TODO add your handling code here:
        FrmEntregas entrega = new FrmEntregas();
        entrega.setVisible(true);
        entrega.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        entrega.setLocationRelativeTo(null);
        entrega.setTitle("GoCode Control - Entregas");
        entrega.nome_usuario_label.setText(this.usuario.getNome_usuario());
    }//GEN-LAST:event_btnEntregaActionPerformed

    private void btnComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComandaActionPerformed
        // TODO add your handling code here:
        FrmComandas comanda = new FrmComandas();
        comanda.setVisible(true);
        comanda.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        comanda.setLocationRelativeTo(null);
        comanda.setTitle("GoCode Control - Comandas");
        comanda.nome_usuario_label.setText(this.usuario.getNome_usuario());
    }//GEN-LAST:event_btnComandaActionPerformed

    private void btnTalhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTalhaoActionPerformed
        // TODO add your handling code here:
        FrmTalhao talhao = new FrmTalhao();
        talhao.setVisible(true);
        talhao.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        talhao.setLocationRelativeTo(null);
        talhao.setTitle("GoCode Control - Talhões");
        talhao.nome_usuario_label.setText(this.usuario.getNome_usuario());
    }//GEN-LAST:event_btnTalhaoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
        FrmUsuario usuario = new FrmUsuario();
        usuario.setVisible(true);
        usuario.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        usuario.setLocationRelativeTo(null);
        usuario.setTitle("GoCode Control - Usuários");
        usuario.setFocusableWindowState(true);
        usuario.nome_usuario_label.setText(this.usuario.getNome_usuario());
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidadeActionPerformed
        // TODO add your handling code here:
        FrmUnidade unidades = new FrmUnidade();
        unidades.setVisible(true);
        unidades.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        unidades.setLocationRelativeTo(null);
        unidades.setTitle("GoCode Control - Unidades");
        unidades.nome_usuario_label.setText(this.usuario.getNome_usuario());
    }//GEN-LAST:event_btnUnidadeActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnComanda;
    private java.awt.Button btnCultivo;
    private java.awt.Button btnEntrega;
    private java.awt.Button btnProduto;
    private java.awt.Button btnTalhao;
    private java.awt.Button btnUnidade;
    private java.awt.Button btnUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public volatile java.awt.Label nome_usuario_label;
    public java.awt.Label nome_usuario_label2;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
