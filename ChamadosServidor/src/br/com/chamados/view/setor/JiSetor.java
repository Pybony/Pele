package br.com.chamados.view.setor;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.SetorDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Setor;
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
public class JiSetor extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JpDefault jpDefault;
    private JdBuscaSetor jdBuscaSetor;
    private Setor setor;

    public JiSetor() {
        setTitle("JiSetor - Manutenção de Setor - v1.00.00");
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        this.setSize(JpDefault.WIDTH + 30, JpDefault.HEIGHT + 150);
        jpSetor.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpSetor.add(jpDefault);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpSetor = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jpSetorLayout = new javax.swing.GroupLayout(jpSetor);
        jpSetor.setLayout(jpSetorLayout);
        jpSetorLayout.setHorizontalGroup(
            jpSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(jpSetorLayout.createSequentialGroup()
                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpSetorLayout.setVerticalGroup(
            jpSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JPanel jpSetor;
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
    }

    @Override
    public void alterar() {
        if (setor != null) {
            jtDescricao.setEnabled(true);
            jtDescricao.setEditable(true);
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
        Permissoes permissoes = Cookies.getPermissao(this.getClass().getSimpleName());
        jbInserir.setEnabled(permissoes.getInserir());
        jbAlterar.setEnabled(permissoes.getAlterar());
        jbDeletar.setEnabled(permissoes.getDeletar());
    }

    @Override
    public void salvar() {
        setor = new Setor();
        if (!jtId.getText().equals(SetorDao.proximoId())) {
            setor.setId(Integer.parseInt(jtId.getText()));
        }
        setor.setDescricao(jtDescricao.getText());
        SetorDao.salvar(setor);
        if (!jtId.getText().equals(SetorDao.proximoId())) {
            vaPara(jtId.getText());
        } else {
            vaPara("0");
        }
        Campos.desabilitar(jpSetor);
    }

    @Override
    public void cancelar() {
        if (jtId.getText().equals(SetorDao.proximoId())) {
            vaPara("0");
        } else {
            vaPara(jtId.getText());
        }
        Campos.desabilitar(jpSetor);
    }

    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpSetor);
    }
}
