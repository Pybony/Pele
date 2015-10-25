package br.com.chamados.view.estado;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.EstadoDao;
import br.com.chamados.dao.PaisDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.model.Estado;
import br.com.chamados.model.Pais;
import br.com.chamados.model.Permissoes;
import br.com.chamados.view.JpDefault;
import br.com.chamados.view.nivel.JdBuscaNivel;
import br.com.chamados.view.pais.JdBuscaPais;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class JiEstado extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JdBuscaPais jdBuscaPais;
    private JdBuscaEstado jdBuscaEstado;
    private Estado estado;

    public JiEstado() {
        setTitle("JiEstado - Manutenção de Estado - v1.00.00");
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
        jtSigla = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtIdPais = new javax.swing.JTextField();
        jtNomePais = new javax.swing.JTextField();
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
        jtId.setEnabled(false);

        jLabel2.setText("Nome");

        jtNome.setEditable(false);
        jtNome.setEnabled(false);

        jLabel3.setText("Sigla");

        jtSigla.setEditable(false);
        jtSigla.setEnabled(false);

        jLabel4.setText("Pais");

        jtIdPais.setEditable(false);
        jtIdPais.setEnabled(false);

        jtNomePais.setEditable(false);
        jtNomePais.setEnabled(false);

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
                        .addGap(0, 207, Short.MAX_VALUE)
                        .addComponent(jbFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtIdPais))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtNomePais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbBuscar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNomePais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        estado = new Estado();
        if (!jtId.getText().equals(EstadoDao.proximoId())) {
            estado.setId(Integer.parseInt(jtId.getText()));
        }
        estado.setNome(jtNome.getText());
        estado.setSigla(jtSigla.getText());
        Pais pais = PaisDao.vaPara(jtIdPais.getText());
        estado.setPais(pais);
        EstadoDao.salvar(estado);
        if (!jtId.getText().equals(EstadoDao.proximoId())) {
            jtNome.setEditable(false);
            jtSigla.setEditable(false);
            jtIdPais.setEditable(false);
            jbBuscar.setEnabled(false);
            jbSalvar.setEnabled(false);
        } else {
            vaPara("0");
            jtNome.setEditable(false);
            jtSigla.setEditable(false);
            jtIdPais.setEditable(false);
            jbBuscar.setEnabled(false);
            jbSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        hide();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtNome.setEditable(false);
        jtIdPais.setEditable(false);
        jbBuscar.setEnabled(false);
        jbSalvar.setEnabled(false);
        if (jtId.getText().equals(EstadoDao.proximoId())) {
            vaPara("0");
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (jdBuscaPais == null) {
            jdBuscaPais = new JdBuscaPais();
        }
        jdBuscaPais.setModal(true);
        jdBuscaPais.setVisible(true);
        Pais pais = PaisDao.vaPara(jdBuscaPais.getIdRetorno());
        jtIdPais.setText(String.valueOf(pais.getId()));
        jtNomePais.setText(pais.getNome());
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtIdPais;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtNomePais;
    private javax.swing.JTextField jtSigla;
    // End of variables declaration//GEN-END:variables

    @Override
    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
            if (vaPara == null || vaPara.equals("")) {
                vaPara = "0";
            }
        }
        estado = EstadoDao.vaPara(vaPara);
        if (estado != null) {
            jtId.setText(String.valueOf(estado.getId()));
            jtNome.setText(estado.getNome());
            jtSigla.setText(estado.getSigla());
            jtIdPais.setText(String.valueOf(estado.getPais().getId()));
            jtNomePais.setText(estado.getPais().getNome());
        } else {
            jtId.setText("");
            jtNome.setText("");
            jtSigla.setText("");
            jtIdPais.setText("");
            jtNomePais.setText("");
        }
    }

    @Override
    public void pesquisar() {
        if (jdBuscaEstado == null) {
            jdBuscaEstado = new JdBuscaEstado();
        }
        jdBuscaEstado.setModal(true);
        jdBuscaEstado.setVisible(true);
        vaPara(jdBuscaEstado.getIdRetorno());
    }

    @Override
    public void inserir() {
        jtId.setText(EstadoDao.proximoId());
        jtNome.setText("");
        jtNome.setEnabled(true);
        jtNome.setEditable(true);
        jtSigla.setText("");
        jtSigla.setEnabled(true);
        jtSigla.setEditable(true);
        jtIdPais.setText("");
        jtIdPais.setEnabled(true);
        jtIdPais.setEditable(true);
        jbBuscar.setEnabled(true);
        jbSalvar.setEnabled(true);
    }

    @Override
    public void alterar() {
        if (estado != null) {
            jtNome.setEnabled(true);
            jtNome.setEditable(true);
            jtSigla.setEnabled(true);
            jtSigla.setEditable(true);
            jtIdPais.setEnabled(true);
            jtIdPais.setEditable(true);
            jbBuscar.setEnabled(true);
            jbSalvar.setEnabled(true);
        }
    }

    @Override
    public void deletar() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            EstadoDao.deletar(estado);
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
