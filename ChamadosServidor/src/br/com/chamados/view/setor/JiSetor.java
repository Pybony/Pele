package br.com.chamados.view.setor;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.SetorDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Setor;
import br.com.chamados.view.JpDefault;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class JiSetor extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JdBuscaSetor jdBuscaSetor;
    private Setor setor;

    public JiSetor() {
        setTitle("JiSetor - Manutenção de Setor - v1.00.00");
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {
        JpDefault jpDefault = new JpDefault();
        jpDefault.setBounds(10, 10, 450, 180);
        this.add(jpDefault);
        jpDefault.setAcoesCadastro(this);
        vaPara("0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtDescricao = new javax.swing.JTextField();

        jbSalvar.setText("Salvar");
        jbSalvar.setEnabled(false);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 191, Short.MAX_VALUE)
                        .addComponent(jbFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtDescricao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbCancelar)
                    .addComponent(jbFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        hide();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtDescricao.setEditable(false);
        jbSalvar.setEnabled(false);
        if (jtId.getText().equals(SetorDao.proximoId())) {
            vaPara("0");
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        setor = new Setor();
        if (!jtId.getText().equals(SetorDao.proximoId())) {
            setor.setId(Integer.parseInt(jtId.getText()));
        }
        setor.setDescricao(jtDescricao.getText());
        SetorDao.salvar(setor);
        if (!jtId.getText().equals(SetorDao.proximoId())) {
            jtDescricao.setEditable(false);
            jbSalvar.setEnabled(false);
        } else {
            vaPara("0");
            jtDescricao.setEditable(false);
            jbSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbSalvar;
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
        setor = SetorDao.vaPara(vaPara);
        if (setor != null) {
            jtId.setText(String.valueOf(setor.getId()));
            jtDescricao.setText(setor.getDescricao());
        } else {
            jtId.setText("");
            jtDescricao.setText("");
        }
    }

    @Override
    public void pesquisar() {
        if (jdBuscaSetor == null) {
            jdBuscaSetor = new JdBuscaSetor();
        }
        jdBuscaSetor.setModal(true);
        jdBuscaSetor.setVisible(true);
        vaPara(jdBuscaSetor.getIdRetorno());
    }

    @Override
    public void inserir() {
        jtId.setText(SetorDao.proximoId());
        jtDescricao.setText("");
        jtDescricao.setEnabled(true);
        jtDescricao.setEditable(true);
        jbSalvar.setEnabled(true);
    }

    @Override
    public void alterar() {
        if (setor != null) {
            jtDescricao.setEnabled(true);
            jtDescricao.setEditable(true);
            jbSalvar.setEnabled(true);
        }
    }

    @Override
    public void deletar() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            SetorDao.deletar(setor);
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