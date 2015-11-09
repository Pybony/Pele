/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view.trigger;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.AudTriggerDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.AudTrigger;
import br.com.chamados.model.Permissoes;
import br.com.chamados.view.JpDefault;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class JiTrigger extends JInternalFrame implements AcoesPainel {
    
    private Logger logger = Logger.getLogger(LogChamados.class);
    private JpDefault jpDefault;
    private JdBuscaTrigger jdBuscaTrigger;
    private AudTrigger trigger;
    
    public JiTrigger() {
        setTitle("JiTrigger - Manutenção de Trigger - v1.00.00");
        initComponents();
        initMyComponents();
    }
    
    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        jpDefault.setVisibleJbInserir(false);
        jpDefault.setVisibleJbDeletar(false);
        this.setSize(JpDefault.WIDTH - 90, JpDefault.HEIGHT + 160);
        jpTrigger.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpTrigger.add(jpDefault);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTrigger = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jcAtivo = new javax.swing.JCheckBox();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Id");

        jtId.setEditable(false);
        jtId.setEnabled(false);

        jLabel2.setText("Nome");

        jtNome.setEditable(false);
        jtNome.setEnabled(false);

        jcAtivo.setText("Ativo");
        jcAtivo.setEnabled(false);

        javax.swing.GroupLayout jpTriggerLayout = new javax.swing.GroupLayout(jpTrigger);
        jpTrigger.setLayout(jpTriggerLayout);
        jpTriggerLayout.setHorizontalGroup(
            jpTriggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTriggerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTriggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcAtivo)
                    .addGroup(jpTriggerLayout.createSequentialGroup()
                        .addGroup(jpTriggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpTriggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTriggerLayout.setVerticalGroup(
            jpTriggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTriggerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTriggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpTriggerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcAtivo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTrigger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTrigger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Util.centralizar(this);
        jpDefault.setAcoesCadastro(this);
        vaPara("0");
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JCheckBox jcAtivo;
    private javax.swing.JPanel jpTrigger;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtNome;
    // End of variables declaration//GEN-END:variables

    @Override
    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
            if (vaPara == null || vaPara.equals("")) {
                vaPara = "0";
            }
        }
        trigger = AudTriggerDao.vaPara(vaPara);
        if (trigger != null) {
            jtId.setText(String.valueOf(trigger.getId()));
            jtNome.setText(trigger.getNome());
            jcAtivo.setSelected(trigger.getSituacao());
        } else {
            jtId.setText("");
            jtNome.setText("");
            jcAtivo.setSelected(false);
        }
    }
    
    @Override
    public void pesquisar() {
        if (jdBuscaTrigger == null) {
            jdBuscaTrigger = new JdBuscaTrigger();
        }
        jdBuscaTrigger.setModal(true);
        jdBuscaTrigger.setVisible(true);
        vaPara(jdBuscaTrigger.getIdRetorno());
    }
    
    @Override
    public void inserir() {
    }
    
    @Override
    public void alterar() {
        if (trigger != null) {
            jtNome.setEnabled(true);
            jtNome.setEditable(true);
            jcAtivo.setEnabled(true);
        }
    }
    
    @Override
    public void deletar() {
    }
    
    @Override
    public void checkEnabled(JButton jbInserir, JButton jbAlterar, JButton jbDeletar) {
        Permissoes permissoes = Cookies.getPermissao(this.getClass().getSimpleName());
        jbInserir.setEnabled(permissoes.getInserir());
        jbAlterar.setEnabled(permissoes.getAlterar());
        jbDeletar.setEnabled(permissoes.getDeletar());
    }
    
    @Override
    public void salvar() {
        trigger = new AudTrigger();
        trigger.setId(Integer.parseInt(jtId.getText()));
        trigger.setNome(jtNome.getText());
        trigger.setSituacao(jcAtivo.isSelected());
        AudTriggerDao.salvar(trigger);
        vaPara(jtId.getText());
        Campos.desabilitar(jpTrigger);
    }
    
    @Override
    public void cancelar() {
        vaPara(jtId.getText());
        Campos.desabilitar(jpTrigger);
    }
    
    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpTrigger);
    }
}
