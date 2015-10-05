/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view.empresa;

import br.com.chamados.control.DAO;
import br.com.chamados.control.GridEmpresa;
import br.com.chamados.dao.EmpresaDao;
import br.com.chamados.dao.EstadoDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.model.Cidade;
import br.com.chamados.model.Empresa;
import br.com.chamados.model.Permissoes;
import br.com.chamados.utils.CampoInteiro;
import br.com.chamados.utils.CombosDAO;
import br.com.chamados.genericos.campos.DesabilitaCampos;
import br.com.chamados.genericos.campos.HabilitaCampos;
import br.com.chamados.utils.ItensCombo;
import br.com.chamados.genericos.campos.LimparCampos;
import br.com.chamados.model.Estado;
import br.com.chamados.view.JpDefault;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author Jonas C. Rosa
 */
public class JFEmpresa extends JFrame implements AcoesPainel {

    /**
     * Creates new form JFEmpresa
     */
    public JFEmpresa() {
        initComponents();
        initMyComponents();
        this.setTitle("Empresas");
    }

    private void initMyComponents() {
        JpDefault jpDefault = new JpDefault();
        jpDefault.setBounds(10, 10, 450, 180);
        this.add(jpDefault);
        jpDefault.setAcoesCadastro(this);
        EstadoDao.preencherCombo(jcEstado);
        EmpresaDao.popularTabela(jTable1, null);

//        vaPara("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtEmpresa = new javax.swing.JTabbedPane();
        jpEmpresa = new javax.swing.JPanel();
        jtNome = new javax.swing.JTextField();
        jlNomeEmpresa = new javax.swing.JLabel();
        jlEmailEmpresa = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jlTelefoneEmpresa = new javax.swing.JLabel();
        jtTelefone = new javax.swing.JTextField();
        jlCgc = new javax.swing.JLabel();
        jtCgc = new CampoInteiro();
        jlCidadeEmpresa = new javax.swing.JLabel();
        jcEstado = new javax.swing.JComboBox();
        jlBairroEmpresa = new javax.swing.JLabel();
        jcCidade = new javax.swing.JComboBox();
        jlEmailEmpresa1 = new javax.swing.JLabel();
        jtEndereco = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbSalvar.setText("Salvar");
        jbSalvar.setEnabled(false);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");

        jtEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpresaMouseClicked(evt);
            }
        });

        jtNome.setEnabled(false);
        jtNome.setName("Nome"); // NOI18N

        jlNomeEmpresa.setText("Nome");

        jlEmailEmpresa.setText("Email");

        jtEmail.setEnabled(false);
        jtEmail.setName("Email"); // NOI18N

        jlTelefoneEmpresa.setText("Telefone");

        jtTelefone.setEnabled(false);
        jtTelefone.setName("Telefone"); // NOI18N

        jlCgc.setText("CGC");

        jtCgc.setEnabled(false);
        jtCgc.setName("CGC"); // NOI18N

        jlCidadeEmpresa.setText("Estado");

        jcEstado.setEnabled(false);
        jcEstado.setName("Estado"); // NOI18N
        jcEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEstadoActionPerformed(evt);
            }
        });

        jlBairroEmpresa.setText("Cidade");

        jcCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcCidade.setEnabled(false);
        jcCidade.setName("Cidade"); // NOI18N

        jlEmailEmpresa1.setText("Endereço");

        jtEndereco.setEnabled(false);
        jtEndereco.setName("Endereço"); // NOI18N

        javax.swing.GroupLayout jpEmpresaLayout = new javax.swing.GroupLayout(jpEmpresa);
        jpEmpresa.setLayout(jpEmpresaLayout);
        jpEmpresaLayout.setHorizontalGroup(
            jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpresaLayout.createSequentialGroup()
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEmpresaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jlNomeEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpEmpresaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlCidadeEmpresa)
                            .addComponent(jlCgc)
                            .addComponent(jlEmailEmpresa1)
                            .addComponent(jlEmailEmpresa)
                            .addComponent(jlTelefoneEmpresa))
                        .addGap(18, 18, 18)
                        .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEmpresaLayout.createSequentialGroup()
                                .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jlBairroEmpresa)
                                .addGap(18, 18, 18)
                                .addComponent(jcCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCgc, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpEmpresaLayout.setVerticalGroup(
            jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpresaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNomeEmpresa)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCgc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCgc))
                .addGap(18, 18, 18)
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCidadeEmpresa)
                    .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBairroEmpresa)
                    .addComponent(jcCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmailEmpresa1))
                .addGap(18, 18, 18)
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlEmailEmpresa))
                .addGap(18, 18, 18)
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTelefoneEmpresa))
                .addGap(20, 20, 20))
        );

        jtNome.getAccessibleContext().setAccessibleName("Nome");
        jtEmail.getAccessibleContext().setAccessibleName("E-mail");
        jtTelefone.getAccessibleContext().setAccessibleName("Telefone");
        jtTelefone.getAccessibleContext().setAccessibleDescription("");
        jtCgc.getAccessibleContext().setAccessibleName("CGC");
        jcEstado.getAccessibleContext().setAccessibleName("Estado");
        jcCidade.getAccessibleContext().setAccessibleName("Cidade");
        jtEndereco.getAccessibleContext().setAccessibleName("Endereço");
        jtEndereco.getAccessibleContext().setAccessibleDescription("");

        jtEmpresa.addTab("Empresa", jpEmpresa);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jtEmpresa.addTab("Busca", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtEmpresa, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalvar)
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jtEmpresa)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            Cidade cidade = new Cidade();
            cidade.setId(jcCidade.getSelectedIndex());
            Empresa empresa = new Empresa();
            empresa.setNome(jtNome.getText());
            empresa.setCgc(jtCgc.getText());
            empresa.setEndereco(jtEndereco.getText());
            empresa.setEmail(jtEmail.getText());
            empresa.setTelefone(jtTelefone.getText());
            empresa.setCidade(cidade);
            if (Campos.validar(jpEmpresa)) {
                EmpresaDao.save(empresa);
                JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                DesabilitaCampos.run(jpEmpresa);
                LimparCampos.run(jpEmpresa);
            }
            jbSalvar.setEnabled(false);
        } catch (HibernateException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jcEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEstadoActionPerformed
        jcCidade.removeAllItems();
        if (jcEstado.getSelectedIndex() > 0) {
            new CombosDAO().popularCidade(jcCidade,
                    jcEstado.getSelectedIndex());
            jcCidade.setEnabled(true);
        }
    }//GEN-LAST:event_jcEstadoActionPerformed

    private void jtEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpresaMouseClicked
        EmpresaDao.popularTabela(jTable1, null);

    }//GEN-LAST:event_jtEmpresaMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox jcCidade;
    private javax.swing.JComboBox jcEstado;
    private javax.swing.JLabel jlBairroEmpresa;
    private javax.swing.JLabel jlCgc;
    private javax.swing.JLabel jlCidadeEmpresa;
    private javax.swing.JLabel jlEmailEmpresa;
    private javax.swing.JLabel jlEmailEmpresa1;
    private javax.swing.JLabel jlNomeEmpresa;
    private javax.swing.JLabel jlTelefoneEmpresa;
    private javax.swing.JPanel jpEmpresa;
    private javax.swing.JTextField jtCgc;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTabbedPane jtEmpresa;
    private javax.swing.JTextField jtEndereco;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtTelefone;
    // End of variables declaration//GEN-END:variables

    public void vaPara(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pesquisar() {
        jtEmpresa.setSelectedIndex(1);

    }

    @Override
    public void inserir() {
        Campos.habilitar(jpEmpresa);
        Campos.limpar(jpEmpresa);
        jbSalvar.setEnabled(true);
    }

    @Override
    public void alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkEnabled(JButton jbInserir, JButton jbAlterar, JButton jbDeletar) {
        for (Permissoes permissoes : Cookies.listaPermissoes) {
            if (permissoes.getTela().getDescricao().equalsIgnoreCase("JfPais")) {
                jbInserir.setEnabled(permissoes.getInserir());
                jbAlterar.setEnabled(permissoes.getAlterar());
                jbDeletar.setEnabled(permissoes.getDeletar());
            }
        }
    }

    @Override
    public void vaPara() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}