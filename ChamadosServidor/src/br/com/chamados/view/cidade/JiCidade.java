package br.com.chamados.view.cidade;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.CidadeDao;
import br.com.chamados.dao.EstadoDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Estado;
import br.com.chamados.model.Permissoes;
import br.com.chamados.view.JpDefault;
import br.com.chamados.view.estado.JdBuscaEstado;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class JiCidade extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JpDefault jpDefault;
    private JdBuscaEstado jdBuscaEstado;
    private JdBuscaCidade jdBuscaCidade;
    private Cidade cidade;

    public JiCidade() {
        setTitle("JiCidade - Manutenção de Cidade - v1.00.00");
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        this.setSize(JpDefault.WIDTH + 30, JpDefault.HEIGHT + 180);
        jpCidade.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpCidade.add(jpDefault);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCidade = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtIdEstado = new javax.swing.JTextField();
        jtNomeEstado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtCep = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

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

        jLabel4.setText("Estado");

        jtIdEstado.setEditable(false);
        jtIdEstado.setEnabled(false);
        jtIdEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtIdEstadoFocusLost(evt);
            }
        });

        jtNomeEstado.setEditable(false);
        jtNomeEstado.setEnabled(false);

        jLabel3.setText("Cep");

        jtCep.setEditable(false);
        jtCep.setEnabled(false);

        jbBuscar.setText("Buscar");
        jbBuscar.setEnabled(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpCidadeLayout = new javax.swing.GroupLayout(jpCidade);
        jpCidade.setLayout(jpCidadeLayout);
        jpCidadeLayout.setHorizontalGroup(
            jpCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCidadeLayout.createSequentialGroup()
                        .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCidadeLayout.createSequentialGroup()
                        .addComponent(jtIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtNomeEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscar))
                    .addGroup(jpCidadeLayout.createSequentialGroup()
                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(288, 288, 288))
        );
        jpCidadeLayout.setVerticalGroup(
            jpCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(jpCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (jdBuscaEstado == null) {
            jdBuscaEstado = new JdBuscaEstado();
        }
        jdBuscaEstado.setModal(true);
        jdBuscaEstado.setVisible(true);
        Estado estado = EstadoDao.vaPara(jdBuscaEstado.getIdRetorno());
        if (estado != null) {
            jtIdEstado.setText(String.valueOf(estado.getId()));
            jtNomeEstado.setText(estado.getNome());
        } else {
            jtIdEstado.setText("");
            jtNomeEstado.setText("");
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Util.centralizar(this);
        jpDefault.setAcoesCadastro(this);
        vaPara("0");
    }//GEN-LAST:event_formComponentShown

    private void jtIdEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtIdEstadoFocusLost
        Estado estado = EstadoDao.vaPara(jtIdEstado.getText());
        if (estado != null) {
            jtIdEstado.setText(String.valueOf(estado.getId()));
            jtNomeEstado.setText(estado.getNome());
        } else {
            jtIdEstado.setText("");
            jtNomeEstado.setText("");
        }
    }//GEN-LAST:event_jtIdEstadoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JPanel jpCidade;
    private javax.swing.JTextField jtCep;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtIdEstado;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtNomeEstado;
    // End of variables declaration//GEN-END:variables

    @Override
    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
            if (vaPara == null || vaPara.equals("")) {
                vaPara = "0";
            }
        }
        cidade = CidadeDao.vaPara(vaPara);
        if (cidade != null) {
            jtId.setText(String.valueOf(cidade.getId()));
            jtNome.setText(cidade.getNome());
            jtCep.setText(cidade.getCep());
            jtIdEstado.setText(String.valueOf(cidade.getEstado().getId()));
            jtNomeEstado.setText(cidade.getEstado().getNome());
        } else {
            jtId.setText("");
            jtNome.setText("");
            jtCep.setText("");
            jtIdEstado.setText("");
            jtNomeEstado.setText("");
        }
    }

    @Override
    public void pesquisar() {
        if (jdBuscaCidade == null) {
            jdBuscaCidade = new JdBuscaCidade();
        }
        jdBuscaCidade.setModal(true);
        jdBuscaCidade.setVisible(true);
        vaPara(jdBuscaCidade.getIdRetorno());
    }

    @Override
    public void inserir() {
        jtId.setText(EstadoDao.proximoId());
        jtNome.setText("");
        jtNome.setEnabled(true);
        jtNome.setEditable(true);
        jtCep.setText("");
        jtCep.setEnabled(true);
        jtCep.setEditable(true);
        jtIdEstado.setText("");
        jtIdEstado.setEnabled(true);
        jtIdEstado.setEditable(true);
        jbBuscar.setEnabled(true);
    }

    @Override
    public void alterar() {
        if (cidade != null) {
            jtNome.setEnabled(true);
            jtNome.setEditable(true);
            jtCep.setEnabled(true);
            jtCep.setEditable(true);
            jtIdEstado.setEnabled(true);
            jtIdEstado.setEditable(true);
            jbBuscar.setEnabled(true);
        }
    }

    @Override
    public void deletar() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            CidadeDao.deletar(cidade);
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
        cidade = new Cidade();
        if (!jtId.getText().equals(CidadeDao.proximoId())) {
            cidade.setId(Integer.parseInt(jtId.getText()));
        }
        Estado estado = EstadoDao.vaPara(jtIdEstado.getText());
        cidade.setEstado(estado);
        cidade.setNome(jtNome.getText());
        cidade.setCep(jtCep.getText());
        CidadeDao.salvar(cidade);
        if (!jtId.getText().equals(EstadoDao.proximoId())) {
            vaPara(jtId.getText());
        } else {
            vaPara("0");
        }
        Campos.desabilitar(jpCidade);
    }

    @Override
    public void cancelar() {
        if (jtId.getText().equals(EstadoDao.proximoId())) {
            vaPara("0");
        } else {
            vaPara(jtId.getText());
        }
        Campos.desabilitar(jpCidade);
    }

    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpCidade);
    }
}
