package br.com.chamados.view.permissoes;

import br.com.chamados.dao.EstadoDao;
import br.com.chamados.dao.FuncionarioDao;
import br.com.chamados.dao.PermissoesDao;
import br.com.chamados.dao.TelaDao;
import br.com.chamados.dao.UsuarioDao;
import br.com.chamados.model.Estado;
import br.com.chamados.model.Funcionario;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Tela;
import br.com.chamados.model.Usuario;
import br.com.chamados.view.estado.JdBuscaEstado;
import br.com.chamados.view.tela.JdBuscaTela;
import br.com.chamados.view.usuario.JdBuscaUsuario;

/**
 *
 * @author lksbr
 */
public class JdMantPermissao extends javax.swing.JDialog {

    private JdBuscaUsuario jdBuscaUsuario;
    private JdBuscaTela jdBuscaTela;
    private Permissoes permissoes;
    private String idRetorno;

    public JdMantPermissao(Tela tela, Usuario usuario) {
        setTitle("JdMantPermissao - Manutenção de Permissão - v1.00.00");
        initComponents();
        jtTelaId.setText(String.valueOf(tela.getId()));
        jtTelaDescricao.setText(tela.getDescricao());
        if (usuario != null) {
            jtUsuarioId.setText(String.valueOf(usuario.getId()));
            jtUsuarioNome.setText(usuario.getLogin());
        }
    }

    public void initMyComponents(Permissoes permissoes) {
        this.permissoes = permissoes;
        if (permissoes != null) {
            jtUsuarioId.setText(String.valueOf(permissoes.getUsuario().getId()));
            jtUsuarioNome.setText("");
            jtTelaId.setText(String.valueOf(permissoes.getTela().getId()));
            jtTelaDescricao.setText(permissoes.getTela().getDescricao());
            jcInserir.setSelected(permissoes.getInserir());
            jcAlterar.setSelected(permissoes.getAlterar());
            jcDeletar.setSelected(permissoes.getDeletar());
            jcConsultar.setSelected(permissoes.getConsultar());
        }
    }

    public String getIdRetorno() {
        return idRetorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtUsuarioId = new javax.swing.JTextField();
        jtUsuarioNome = new javax.swing.JTextField();
        jbBuscarUsuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtTelaId = new javax.swing.JTextField();
        jtTelaDescricao = new javax.swing.JTextField();
        jcInserir = new javax.swing.JCheckBox();
        jcAlterar = new javax.swing.JCheckBox();
        jcDeletar = new javax.swing.JCheckBox();
        jcConsultar = new javax.swing.JCheckBox();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Usuario");

        jtUsuarioId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtUsuarioIdFocusLost(evt);
            }
        });

        jtUsuarioNome.setEditable(false);
        jtUsuarioNome.setEnabled(false);

        jbBuscarUsuario.setText("Buscar");
        jbBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Tela");

        jtTelaId.setEditable(false);
        jtTelaId.setEnabled(false);

        jtTelaDescricao.setEditable(false);
        jtTelaDescricao.setEnabled(false);

        jcInserir.setText("Inserir");

        jcAlterar.setText("Alterar");

        jcDeletar.setText("Deletar");

        jcConsultar.setText("Consultar");

        jbSalvar.setText("Salvar");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcInserir)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtTelaId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jcAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(jcDeletar)
                                .addGap(59, 59, 59)
                                .addComponent(jcConsultar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jtUsuarioNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbBuscarUsuario))
                            .addComponent(jtTelaDescricao))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtTelaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtTelaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtUsuarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcInserir)
                    .addComponent(jcAlterar)
                    .addComponent(jcDeletar)
                    .addComponent(jcConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        idRetorno = "0";
        dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (permissoes == null) {
            permissoes = new Permissoes();
        }
        Usuario usuario = UsuarioDao.vaPara(jtUsuarioId.getText());
        Tela tela = TelaDao.vaPara(jtTelaId.getText());
        permissoes.setTela(tela);
        permissoes.setUsuario(usuario);
        permissoes.setInserir(jcInserir.isSelected());
        permissoes.setAlterar(jcAlterar.isSelected());
        permissoes.setDeletar(jcDeletar.isSelected());
        permissoes.setConsultar(jcConsultar.isSelected());
        PermissoesDao.salvar(permissoes);
        idRetorno = jtTelaId.getText();
        dispose();
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarUsuarioActionPerformed
        if (jdBuscaUsuario == null) {
            jdBuscaUsuario = new JdBuscaUsuario();
        }
        jdBuscaUsuario.setModal(true);
        jdBuscaUsuario.setVisible(true);
        Usuario usuario = UsuarioDao.vaPara(jdBuscaUsuario.getIdRetorno());
        jtUsuarioId.setText(String.valueOf(usuario.getId()));
        jtUsuarioNome.setText(usuario.getFuncionario().getPessoa().getNome());
    }//GEN-LAST:event_jbBuscarUsuarioActionPerformed

    private void jtUsuarioIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtUsuarioIdFocusLost
        Usuario usuario = UsuarioDao.vaPara(jtUsuarioId.getText());
        if (usuario != null) {
            jtUsuarioId.setText(String.valueOf(usuario.getId()));
            jtUsuarioNome.setText(usuario.getLogin());
        } else {
            jtUsuarioId.setText("");
            jtUsuarioNome.setText("");
        }
    }//GEN-LAST:event_jtUsuarioIdFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbBuscarUsuario;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JCheckBox jcAlterar;
    private javax.swing.JCheckBox jcConsultar;
    private javax.swing.JCheckBox jcDeletar;
    private javax.swing.JCheckBox jcInserir;
    private javax.swing.JTextField jtTelaDescricao;
    private javax.swing.JTextField jtTelaId;
    private javax.swing.JTextField jtUsuarioId;
    private javax.swing.JTextField jtUsuarioNome;
    // End of variables declaration//GEN-END:variables
}
