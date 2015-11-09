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
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.Funcao;
import br.com.chamados.model.Nivel;
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
public class JiFuncao extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JpDefault jpDefault;
    private JdBuscaFuncao jdBuscaFuncao;
    private Funcao funcao;

    public JiFuncao() {
        setTitle("JiFuncao - Manutenção de Função - v1.00.00");
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        this.setSize(JpDefault.WIDTH + 30, JpDefault.HEIGHT + 150);
        jpFuncao.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpFuncao.add(jpDefault);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFuncao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcNivel = new javax.swing.JComboBox();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Id");

        jtId.setEditable(false);
        jtId.setEnabled(false);

        jLabel2.setText("Descrição");

        jtDescricao.setEditable(false);
        jtDescricao.setEnabled(false);

        jLabel3.setText("Nível");

        jcNivel.setEnabled(false);

        javax.swing.GroupLayout jpFuncaoLayout = new javax.swing.GroupLayout(jpFuncao);
        jpFuncao.setLayout(jpFuncaoLayout);
        jpFuncaoLayout.setHorizontalGroup(
            jpFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncaoLayout.createSequentialGroup()
                        .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFuncaoLayout.setVerticalGroup(
            jpFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jcNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFuncao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jcNivel;
    private javax.swing.JPanel jpFuncao;
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
    }

    @Override
    public void alterar() {
        if (funcao != null) {
            jtDescricao.setEnabled(true);
            jtDescricao.setEditable(true);
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
        Permissoes permissoes = Cookies.getPermissao(this.getClass().getSimpleName());
        jbInserir.setEnabled(permissoes.getInserir());
        jbAlterar.setEnabled(permissoes.getAlterar());
        jbDeletar.setEnabled(permissoes.getDeletar());
    }

    @Override
    public void salvar() {
        funcao = new Funcao();
        if (!jtId.getText().equals(FuncaoDao.proximoId())) {
            funcao.setId(Integer.parseInt(jtId.getText()));
        }
        Nivel nivel = NivelDao.getSelectedItemCombo(jcNivel);
        funcao.setNivel(nivel);
        funcao.setDescricao(jtDescricao.getText());
        FuncaoDao.salvar(funcao);
        if (!jtId.getText().equals(NivelDao.proximoId())) {
            vaPara(jtId.getText());
        } else {
            vaPara("0");
        }
        Campos.desabilitar(jpFuncao);
    }

    @Override
    public void cancelar() {
        if (jtId.getText().equals(NivelDao.proximoId())) {
            vaPara("0");
        } else {
            vaPara(jtId.getText());
        }
        Campos.desabilitar(jpFuncao);
    }

    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpFuncao);
    }
}
