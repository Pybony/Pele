package br.com.chamados.view.situacao;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.SituacaoDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.Situacao;
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
public class JiSituacao extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JpDefault jpDefault;
    private JdBuscaSituacao jdBuscaSituacao;
    private Situacao situacao;

    public JiSituacao() {
        setTitle("JiSituacao - Manutenção de Situação - v1.00.00");
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        this.setSize(JpDefault.WIDTH + 30, JpDefault.HEIGHT + 150);
        jpSituacao.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpSituacao.add(jpDefault);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpSituacao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtDescricao = new javax.swing.JTextField();

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

        javax.swing.GroupLayout jpSituacaoLayout = new javax.swing.GroupLayout(jpSituacao);
        jpSituacao.setLayout(jpSituacaoLayout);
        jpSituacaoLayout.setHorizontalGroup(
            jpSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSituacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpSituacaoLayout.setVerticalGroup(
            jpSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSituacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSituacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSituacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JPanel jpSituacao;
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
        situacao = SituacaoDao.vaPara(vaPara);
        if (situacao != null) {
            jtId.setText(String.valueOf(situacao.getId()));
            jtDescricao.setText(situacao.getDescricao());
        } else {
            jtId.setText("");
            jtDescricao.setText("");
        }
    }

    @Override
    public void pesquisar() {
        if (jdBuscaSituacao == null) {
            jdBuscaSituacao = new JdBuscaSituacao();
        }
        jdBuscaSituacao.setModal(true);
        jdBuscaSituacao.setVisible(true);
        vaPara(jdBuscaSituacao.getIdRetorno());
    }

    @Override
    public void inserir() {
        jtId.setText(SituacaoDao.proximoId());
        jtDescricao.setText("");
        jtDescricao.setEnabled(true);
        jtDescricao.setEditable(true);
    }

    @Override
    public void alterar() {
        if (situacao != null) {
            jtDescricao.setEnabled(true);
            jtDescricao.setEditable(true);
        }
    }

    @Override
    public void deletar() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            SituacaoDao.deletar(situacao);
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
        situacao = new Situacao();
        if (!jtId.getText().equals(SituacaoDao.proximoId())) {
            situacao.setId(Integer.parseInt(jtId.getText()));
        }
        situacao.setDescricao(jtDescricao.getText());
        SituacaoDao.salvar(situacao);
        if (!jtId.getText().equals(SituacaoDao.proximoId())) {
            vaPara(jtId.getText());
        } else {
            vaPara("0");
        }
        Campos.desabilitar(jpSituacao);
    }

    @Override
    public void cancelar() {
        if (jtId.getText().equals(SituacaoDao.proximoId())) {
            vaPara("0");
        } else {
            vaPara(jtId.getText());
        }
        Campos.desabilitar(jpSituacao);
    }

    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpSituacao);
    }
}
