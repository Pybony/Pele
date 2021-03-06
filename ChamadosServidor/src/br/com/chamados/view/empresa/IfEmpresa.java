/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view.empresa;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.EmpresaDao;
import br.com.chamados.dao.EstadoDao;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Empresa;
import br.com.chamados.utils.CombosDAO;
import br.com.chamados.utils.ItemCombo;
import javax.swing.JTable;
import org.apache.log4j.Logger;

/**
 *
 * @author buiu73
 */
public class IfEmpresa extends javax.swing.JDialog {

    /**
     * Creates new form IfEmpresa
     */
    private Logger logger = Logger.getLogger(LogChamados.class);
    private int empresaId;
    private Empresa empresa;
    private JFEmpresa telaEmpresa;
    
    public IfEmpresa() {
        initComponents();
        EmpresaDao.popularTabela(JtBusca, null);
        EstadoDao.preencherCombo(JcbBEstado);
    }
    
    public IfEmpresa(JFEmpresa telaEmpresa) {
        initComponents();
        EmpresaDao.popularTabela(JtBusca, null);
        EstadoDao.preencherCombo(JcbBEstado);
        this.telaEmpresa = telaEmpresa;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JpBusca = new javax.swing.JPanel();
        JspBusca = new javax.swing.JScrollPane();
        JtBusca = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JtfBNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JtfBcgc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JcbBEstado = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        JcbBCidade = new javax.swing.JComboBox();
        JbBuscar = new javax.swing.JButton();
        JbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JtBusca.setModel(new javax.swing.table.DefaultTableModel(
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
        JtBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtBuscaMouseClicked(evt);
            }
        });
        JspBusca.setViewportView(JtBusca);

        jLabel1.setText("Nome:");

        jLabel2.setText("CGC:");

        jLabel3.setText("Estado:");

        JcbBEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbBEstadoActionPerformed(evt);
            }
        });

        jLabel4.setText("Cidade:");

        JbBuscar.setText("Buscar");
        JbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbBuscarActionPerformed(evt);
            }
        });

        JbCancelar.setText("Cancelar");
        JbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpBuscaLayout = new javax.swing.GroupLayout(JpBusca);
        JpBusca.setLayout(JpBuscaLayout);
        JpBuscaLayout.setHorizontalGroup(
            JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpBuscaLayout.createSequentialGroup()
                .addGroup(JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JspBusca, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JpBuscaLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpBuscaLayout.createSequentialGroup()
                                .addComponent(JcbBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(JcbBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JtfBcgc, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(JtfBNome)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JbBuscar)
                        .addGap(53, 53, 53)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBuscaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(JbCancelar)
                .addGap(48, 48, 48))
        );
        JpBuscaLayout.setVerticalGroup(
            JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpBuscaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JtfBNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JtfBcgc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JpBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JcbBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(JcbBCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(JspBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(JbCancelar))
        );

        JspBusca.getAccessibleContext().setAccessibleParent(JspBusca);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JpBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JpBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_JbCancelarActionPerformed

    private void JcbBEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbBEstadoActionPerformed
        JcbBCidade.removeAllItems();
        if (JcbBEstado.getSelectedIndex() > 0) {
            new CombosDAO().popularCidade(JcbBCidade,
                    JcbBEstado.getSelectedIndex());
            JcbBCidade.setEnabled(true);
        }
    }//GEN-LAST:event_JcbBEstadoActionPerformed

    private void JbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbBuscarActionPerformed
        Empresa empresa = new Empresa();
        empresa.setNome(JtfBNome.getText());
        empresa.setCgc(JtfBcgc.getText());
        Cidade cidade = new Cidade();
        cidade.setId(((ItemCombo)JcbBCidade.getSelectedItem()).getCodigo());
        empresa.setCidade(cidade);
        EmpresaDao.popularTabela(JtBusca, empresa);
    }//GEN-LAST:event_JbBuscarActionPerformed

    private void JtBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtBuscaMouseClicked
        if (evt.getClickCount() == 2) {
            selecionarEmpresa();
            this.setVisible(false);
        }
    }//GEN-LAST:event_JtBuscaMouseClicked
    
    private void selecionarEmpresa() {

        empresaId = (int) JtBusca.getValueAt(JtBusca.getSelectedRow(), 0);
        Empresa empresaB = new Empresa();
        empresaB.setId(empresaId);
        
        empresa = EmpresaDao.obterEmpresa(empresaB).get(0);
        
        this.telaEmpresa.setFormEmpresa(empresa);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IfEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IfEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IfEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IfEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IfEmpresa().setVisible(true);
            }
        });
    }
    
    public JTable getTabela(){
        return JtBusca;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbBuscar;
    private javax.swing.JButton JbCancelar;
    private javax.swing.JComboBox JcbBCidade;
    private javax.swing.JComboBox JcbBEstado;
    private javax.swing.JPanel JpBusca;
    private javax.swing.JScrollPane JspBusca;
    private javax.swing.JTable JtBusca;
    private javax.swing.JTextField JtfBNome;
    private javax.swing.JTextField JtfBcgc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
