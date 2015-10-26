package br.com.chamados.view.Permissoes;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.PermissoesDao;
import br.com.chamados.dao.TelaDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Tela;
import br.com.chamados.view.JpDefault;
import br.com.chamados.view.estado.JdBuscaEstado;
import br.com.chamados.view.tela.JdBuscaTela;
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
    private JdBuscaTela jdBuscaTela;
    private Permissoes permissoes;
    private JdMantPermissao jdMantPermissao;
    
    public JiPermissao() {
        setTitle("JiPermissao - Manutenção de Permissão - v1.00.00");
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

        jLabel1 = new javax.swing.JLabel();
        jtTelaId = new javax.swing.JTextField();
        jtTelaDescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tela");

        jtTelaId.setEditable(false);
        jtTelaId.setEnabled(false);
        jtTelaId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtTelaIdFocusLost(evt);
            }
        });

        jtTelaDescricao.setEditable(false);

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
        jScrollPane1.setViewportView(jtUsuarios);
        if (jtUsuarios.getColumnModel().getColumnCount() > 0) {
            jtUsuarios.getColumnModel().getColumn(0).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(1).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(2).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(3).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(4).setResizable(false);
            jtUsuarios.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setText("Usuários");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTelaId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTelaDescricao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtTelaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtTelaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTelaIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtTelaIdFocusLost
        Tela tela = TelaDao.vaPara(jdBuscaTela.getIdRetorno());
        jtTelaId.setText(String.valueOf(tela.getId()));
        jtTelaDescricao.setText(tela.getDescricao());
    }//GEN-LAST:event_jtTelaIdFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtTelaDescricao;
    private javax.swing.JTextField jtTelaId;
    private javax.swing.JTable jtUsuarios;
    // End of variables declaration//GEN-END:variables

    @Override
    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
        }
        Tela tela = TelaDao.vaPara(vaPara);
        jtTelaId.setText(String.valueOf(tela.getId()));
        jtTelaDescricao.setText(tela.getDescricao());
        PermissoesDao.popularTabela(jtUsuarios, tela);
    }
    
    @Override
    public void pesquisar() {
        if (jdBuscaTela == null) {
            jdBuscaTela = new JdBuscaTela();
        }
        jdBuscaTela.setModal(true);
        jdBuscaTela.setVisible(true);
        Tela tela = TelaDao.vaPara(jdBuscaTela.getIdRetorno());
        jtTelaId.setText(String.valueOf(tela.getId()));
        jtTelaDescricao.setText(tela.getDescricao());
    }
    
    @Override
    public void inserir() {
        if (jdMantPermissao == null) {
            jdMantPermissao = new JdMantPermissao();
        }
        jdMantPermissao.initMyComponents(null);
        jdMantPermissao.setModal(true);
        jdMantPermissao.setVisible(true);
        vaPara(jdMantPermissao.getIdRetorno());
    }
    
    @Override
    public void alterar() {
        if (jtUsuarios.getSelectedRow() >= 0) {
            if (jdMantPermissao == null) {
                jdMantPermissao = new JdMantPermissao();
            }
            String idUsuario = String.valueOf(jtUsuarios.getValueAt(jtUsuarios.getSelectedRow(), 0));
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
    public void checkEnabled(JButton jbInserir, JButton jbAlterar, JButton jbDeletar
    ) {
        for (Permissoes permissoes : Cookies.listaPermissoes) {
            if (permissoes.getTela().getDescricao().equalsIgnoreCase(this.getClass().getSimpleName())) {
                jbInserir.setEnabled(permissoes.getInserir());
                jbAlterar.setEnabled(permissoes.getAlterar());
                jbDeletar.setEnabled(permissoes.getDeletar());
            }
        }
    }
}
