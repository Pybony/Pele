package br.com.chamados.view.permissoes;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.PermissoesDao;
import br.com.chamados.dao.TelaDao;
import br.com.chamados.dao.UsuarioDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Tela;
import br.com.chamados.model.Usuario;
import br.com.chamados.view.JpDefault;
import br.com.chamados.view.tela.JdBuscaTela;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class JiPermissao extends JInternalFrame implements AcoesPainel {
    
    private Logger logger = Logger.getLogger(LogChamados.class);
    private JpDefault jpDefault;
    private JdBuscaTela jdBuscaTela;
    private Permissoes permissoes;
    private JdMantPermissao jdMantPermissao;
    
    public JiPermissao() {
        setTitle("JiPermissao - Manutenção de Permissão - v1.00.00");
        initComponents();
        initMyComponents();
    }
    
    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        jpDefault.setVisibleJbSalvar(false);
        jpDefault.setVisibleJbCancelar(false);
        this.setSize(JpDefault.WIDTH - 100, JpDefault.HEIGHT + 350);
        jpPermissao.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpPermissao.add(jpDefault);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPermissao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtTelaId = new javax.swing.JTextField();
        jtTelaDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Tela");

        jtTelaId.setEditable(false);
        jtTelaId.setEnabled(false);
        jtTelaId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtTelaIdFocusLost(evt);
            }
        });

        jtTelaDescricao.setEditable(false);

        jLabel2.setText("Usuários");

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Inserir", "Alterar", "Excluir", "Consultar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuarios);
        if (jtUsuarios.getColumnModel().getColumnCount() > 0) {
            jtUsuarios.getColumnModel().getColumn(0).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(1).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(2).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(3).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(4).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jpPermissaoLayout = new javax.swing.GroupLayout(jpPermissao);
        jpPermissao.setLayout(jpPermissaoLayout);
        jpPermissaoLayout.setHorizontalGroup(
            jpPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPermissaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPermissaoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTelaId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTelaDescricao))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpPermissaoLayout.setVerticalGroup(
            jpPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPermissaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtTelaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtTelaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPermissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpPermissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTelaIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtTelaIdFocusLost
        Tela tela = TelaDao.vaPara(jdBuscaTela.getIdRetorno());
        jtTelaId.setText(String.valueOf(tela.getId()));
        jtTelaDescricao.setText(tela.getDescricao());
    }//GEN-LAST:event_jtTelaIdFocusLost

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Util.centralizar(this);
        jpDefault.setAcoesCadastro(this);
        jpDefault.setEnabledJbAlterar(false);
        vaPara("0");
    }//GEN-LAST:event_formComponentShown

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        if (jtUsuarios.getSelectedRow() >= 0) {
            jpDefault.setEnabledJbAlterar(true);
            jpDefault.setEnabledJbDeletar(true);
        }
    }//GEN-LAST:event_jtUsuariosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpPermissao;
    private javax.swing.JTextField jtTelaDescricao;
    private javax.swing.JTextField jtTelaId;
    private javax.swing.JTable jtUsuarios;
    // End of variables declaration//GEN-END:variables

    @Override
    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
            if (vaPara == null || vaPara.equals("")) {
                vaPara = "0";
            }
        }
        Tela tela = TelaDao.vaPara(vaPara);
        jtTelaId.setText(String.valueOf(tela.getId()));
        jtTelaDescricao.setText(tela.getDescricao());
        PermissoesDao.popularTabela(jtUsuarios, tela);
        if (tela != null) {
            jtTelaId.setText(String.valueOf(tela.getId()));
            jtTelaDescricao.setText(tela.getDescricao());
            PermissoesDao.popularTabela(jtUsuarios, tela);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar uma tela.");
            jtTelaId.setText("");
            jtTelaDescricao.setText("");
        }
    }
    
    @Override
    public void pesquisar() {
        if (jdBuscaTela == null) {
            jdBuscaTela = new JdBuscaTela();
        }
        jdBuscaTela.setModal(true);
        jdBuscaTela.setVisible(true);
        vaPara(jdBuscaTela.getIdRetorno());
    }
    
    @Override
    public void inserir() {
        jpDefault.setEnabledJbAlterar(false);
        jpDefault.setEnabledJbDeletar(false);
        Tela tela = TelaDao.vaPara(jtTelaId.getText());
        jdMantPermissao = new JdMantPermissao(tela, null);
        jdMantPermissao.initMyComponents(null);
        jdMantPermissao.setModal(true);
        jdMantPermissao.setVisible(true);
        vaPara(jdMantPermissao.getIdRetorno());
    }
    
    @Override
    public void alterar() {
        if (jtUsuarios.getSelectedRow() >= 0) {
            String idUsuario = String.valueOf(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 0));
            Usuario usuario = UsuarioDao.vaPara(idUsuario);
            Tela tela = TelaDao.vaPara(jtTelaId.getText());
            jdMantPermissao = new JdMantPermissao(tela, usuario);
            permissoes = PermissoesDao.vaPara(jtTelaId.getText(), idUsuario);
            jdMantPermissao.initMyComponents(permissoes);
            jdMantPermissao.setModal(true);
            jdMantPermissao.setVisible(true);
            vaPara(jdMantPermissao.getIdRetorno());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha.");
        }
    }
    
    @Override
    public void deletar() {
        if (jtUsuarios.getSelectedRow() >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
            if (opcao == 0) {
                String idUsuario = String.valueOf(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 0));
                if (idUsuario.equals("1")) {
                    JOptionPane.showMessageDialog(null, "Este usuário não pode ser deletado.");
                } else {
                    permissoes = PermissoesDao.vaPara(jtTelaId.getText(), idUsuario);
                    PermissoesDao.deletar(permissoes);
                    vaPara("0");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha.");
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
    }
    
    @Override
    public void cancelar() {
    }
    
    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpPermissao);
    }
}
