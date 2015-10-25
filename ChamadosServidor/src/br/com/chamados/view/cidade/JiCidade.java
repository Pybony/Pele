package br.com.chamados.view.cidade;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.CidadeDao;
import br.com.chamados.dao.EstadoDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Estado;
import br.com.chamados.model.Permissoes;
import br.com.chamados.view.JpDefault;
import br.com.chamados.view.estado.JdBuscaEstado;
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
    private JdBuscaEstado jdBuscaEstado;
    private JdBuscaCidade jdBuscaCidade;
    private Cidade cidade;

    public JiCidade() {
        setTitle("JiCidade - Manutenção de Cidade - v1.00.00");
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
        jtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtCep = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtIdEstado = new javax.swing.JTextField();
        jtNomeEstado = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();

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

        jLabel2.setText("Nome");

        jtNome.setEditable(false);
        jtNome.setEnabled(false);

        jLabel3.setText("Cep");

        jtCep.setEditable(false);
        jtCep.setEnabled(false);

        jLabel4.setText("Estado");

        jtIdEstado.setEditable(false);
        jtIdEstado.setEnabled(false);

        jtNomeEstado.setEditable(false);
        jtNomeEstado.setEnabled(false);

        jbBuscar.setText("Buscar");
        jbBuscar.setEnabled(false);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 138, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtNomeEstado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbBuscar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtIdEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbCancelar)
                    .addComponent(jbFechar))
                .addContainerGap())
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
        jtIdEstado.setText(String.valueOf(estado.getId()));
        jtNomeEstado.setText(estado.getNome());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        cidade = new Cidade();
        if (!jtId.getText().equals(CidadeDao.proximoId())) {
            cidade.setId(Integer.parseInt(jtId.getText()));
        }
        cidade.setNome(jtNome.getText());
        cidade.setCep(jtCep.getText());
        Estado estado = EstadoDao.vaPara(jtIdEstado.getText());
        cidade.setEstado(estado);
        CidadeDao.salvar(cidade);
        if (!jtId.getText().equals(EstadoDao.proximoId())) {
            jtNome.setEditable(false);
            jtCep.setEditable(false);
            jtIdEstado.setEditable(false);
            jbBuscar.setEnabled(false);
            jbSalvar.setEnabled(false);
        } else {
            vaPara("0");
            jtNome.setEditable(false);
            jtCep.setEditable(false);
            jtIdEstado.setEditable(false);
            jbBuscar.setEnabled(false);
            jbSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtNome.setEditable(false);
        jtCep.setEditable(false);
        jtIdEstado.setEditable(false);
        jbBuscar.setEnabled(false);
        jbSalvar.setEnabled(false);
        if (jtId.getText().equals(EstadoDao.proximoId())) {
            vaPara("0");
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        hide();
    }//GEN-LAST:event_jbFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbSalvar;
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
        jbSalvar.setEnabled(true);
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
            jbSalvar.setEnabled(true);
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
        for (Permissoes permissoes : Cookies.listaPermissoes) {
            if (permissoes.getTela().getDescricao().equalsIgnoreCase(this.getClass().getSimpleName())) {
                jbInserir.setEnabled(permissoes.getInserir());
                jbAlterar.setEnabled(permissoes.getAlterar());
                jbDeletar.setEnabled(permissoes.getDeletar());
            }
        }

    }
}
