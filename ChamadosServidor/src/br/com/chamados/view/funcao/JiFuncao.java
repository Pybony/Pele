/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view.funcao;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.FuncaoDao;
import br.com.chamados.dao.NivelDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.model.Funcao;
import br.com.chamados.model.Nivel;
import br.com.chamados.model.Permissoes;
import br.com.chamados.view.JpDefault;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class JiFuncao extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JdBuscaFuncao jdBuscaFuncao;
    private Funcao funcao;

    public JiFuncao() {
        setTitle("JiFuncao - Manutenção de Função - v1.00.00");
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {
        JpDefault jpDefault = new JpDefault();
        jpDefault.setBounds(10, 10, 450, 180);
        this.add(jpDefault);
        jpDefault.setAcoesCadastro(this);
        FuncaoDao.popularCombo(jcNivel);
        vaPara("0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalvar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcNivel = new javax.swing.JComboBox();
        jbCancelar = new javax.swing.JButton();

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        jtId.setEditable(false);
        jtId.setEnabled(false);

        jLabel2.setText("Descrição");

        jtDescricao.setEditable(false);
        jtDescricao.setEnabled(false);

        jLabel3.setText("Nivel");

        jcNivel.setEnabled(false);

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcNivel, 0, 95, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jcNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbFechar)
                    .addComponent(jbCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        hide();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        funcao = new Funcao();
        if (!jtId.getText().equals(FuncaoDao.proximoId())) {
            funcao.setId(Integer.parseInt(jtId.getText()));
        }
        funcao.setDescricao(jtDescricao.getText());
        Nivel nivel = NivelDao.getSelectedItemCombo(jcNivel);
        funcao.setNivel(nivel);
        FuncaoDao.salvar(funcao);
        if (!jtId.getText().equals(NivelDao.proximoId())) {
            jtDescricao.setEditable(false);
            jcNivel.setEnabled(false);
            jbSalvar.setEnabled(false);
        } else {
            vaPara("0");
            jtDescricao.setEditable(false);
            jcNivel.setEnabled(false);
            jbSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtDescricao.setEditable(false);
        jbSalvar.setEnabled(false);
        if (jtId.getText().equals(NivelDao.proximoId())) {
            vaPara("0");
        }
    }//GEN-LAST:event_jbCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox jcNivel;
    private javax.swing.JTextField jtDescricao;
    private javax.swing.JTextField jtId;
    // End of variables declaration//GEN-END:variables

    @Override
    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
            if (vaPara == null || vaPara.equals("")) {
                vaPara = "0";
            }
        }
        funcao = FuncaoDao.vaPara(vaPara);
        if (funcao != null) {
            jtId.setText(String.valueOf(funcao.getId()));
            jtDescricao.setText(funcao.getDescricao());
            NivelDao.setSelectedItemCombo(jcNivel, funcao.getNivel());
        } else {
            jtId.setText("");
            jtDescricao.setText("");
            jcNivel.setSelectedItem(0);
        }
    }

    @Override
    public void pesquisar() {
        if (jdBuscaFuncao == null) {
            jdBuscaFuncao = new JdBuscaFuncao();
        }
        jdBuscaFuncao.setModal(true);
        jdBuscaFuncao.setVisible(true);
        vaPara(jdBuscaFuncao.getIdRetorno());
    }

    @Override
    public void inserir() {
        jtId.setText(FuncaoDao.proximoId());
        jtDescricao.setText("");
        jtDescricao.setEnabled(true);
        jtDescricao.setEditable(true);
        jcNivel.setEnabled(true);
        jbSalvar.setEnabled(true);
    }

    @Override
    public void alterar() {
        if (funcao != null) {
            jtDescricao.setEnabled(true);
            jtDescricao.setEditable(true);
            jbSalvar.setEnabled(true);
            jcNivel.setEnabled(true);
        }
    }

    @Override
    public void deletar() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            FuncaoDao.deletar(funcao);
            vaPara("0");
        }
    }

    @Override
    public void checkEnabled(JButton jbInserir, JButton jbAlterar, JButton jbDeletar) {
        for (Permissoes permissoes : Cookies.listaPermissoes) {
            if (permissoes.getTela().getDescricao().equalsIgnoreCase(this.getClass().getSimpleName())) {
                jbInserir.setEnabled(permissoes.getInserir());
                jbAlterar.setEnabled(permissoes.getAlterar());
                jbDeletar.setEnabled(permissoes.getDeletar());
            }
        }
    }
}
