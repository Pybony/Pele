/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view.empresa;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.CidadeDao;
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
import br.com.chamados.genericos.campos.LimparCampos;
import br.com.chamados.utils.ItemCombo;
import br.com.chamados.view.JpDefault;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Jonas C. Rosa
 */
public class JFEmpresa extends JInternalFrame implements AcoesPainel {

    /**
     * Creates new form JFEmpresa
     */
    private Logger logger = Logger.getLogger(LogChamados.class);
    private IfEmpresa iFEmpresa;
    private Empresa empresa;

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
//        EmpresaDao.popularTabela(jTable1, null);

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

        JdEmpresas = new javax.swing.JDesktopPane();
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
        jLabel1 = new javax.swing.JLabel();
        jtCampo = new javax.swing.JTextField();
        jbCancelar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();

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

        jcCidade.setEnabled(false);
        jcCidade.setName("Cidade"); // NOI18N

        jlEmailEmpresa1.setText("Endereço");

        jtEndereco.setEnabled(false);
        jtEndereco.setName("Endereço"); // NOI18N

        jLabel1.setText("Id");

        jtCampo.setEditable(false);

        javax.swing.GroupLayout jpEmpresaLayout = new javax.swing.GroupLayout(jpEmpresa);
        jpEmpresa.setLayout(jpEmpresaLayout);
        jpEmpresaLayout.setHorizontalGroup(
            jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpresaLayout.createSequentialGroup()
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEmpresaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlCidadeEmpresa)
                            .addComponent(jlCgc))
                        .addGap(18, 18, 18)
                        .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEmpresaLayout.createSequentialGroup()
                                .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jlBairroEmpresa)
                                .addGap(18, 18, 18)
                                .addComponent(jcCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtCgc, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpEmpresaLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlNomeEmpresa)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpEmpresaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpEmpresaLayout.createSequentialGroup()
                                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlEmailEmpresa1)
                                    .addComponent(jlEmailEmpresa)
                                    .addComponent(jlTelefoneEmpresa))
                                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpEmpresaLayout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEmpresaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpEmpresaLayout.setVerticalGroup(
            jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEmpresaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                .addGap(18, 18, 18)
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
                .addContainerGap(87, Short.MAX_VALUE))
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

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.setEnabled(false);
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JdEmpresasLayout = new javax.swing.GroupLayout(JdEmpresas);
        JdEmpresas.setLayout(JdEmpresasLayout);
        JdEmpresasLayout.setHorizontalGroup(
            JdEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JdEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtEmpresa)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JdEmpresasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalvar)))
                .addContainerGap())
        );
        JdEmpresasLayout.setVerticalGroup(
            JdEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdEmpresasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtEmpresa)
                .addGap(18, 18, 18)
                .addGroup(JdEmpresasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalvar))
                .addGap(21, 21, 21))
        );
        JdEmpresas.setLayer(jtEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdEmpresas.setLayer(jbCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        JdEmpresas.setLayer(jbSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JdEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(JdEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            Cidade cidade = new Cidade();
            cidade.setId(((ItemCombo) jcCidade.getSelectedItem()).getCodigo());
            Empresa empresa = new Empresa();
            if (!jtCampo.getText().equals(EmpresaDao.proximoId())) {
                empresa.setId(Integer.parseInt(jtCampo.getText()));
            }
            empresa.setNome(jtNome.getText());
            empresa.setCgc(jtCgc.getText());
            empresa.setEndereco(jtEndereco.getText());
            empresa.setEmail(jtEmail.getText());
            empresa.setTelefone(jtTelefone.getText());
            empresa.setCidade(cidade);
            if (Campos.validar(jpEmpresa)) {
                EmpresaDao.save(empresa);
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
//        EmpresaDao.popularTabela(jTable1, null);

    }//GEN-LAST:event_jtEmpresaMouseClicked

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        hide();
    }//GEN-LAST:event_jbCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JdEmpresas;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTextField jtCampo;
    private javax.swing.JTextField jtCgc;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTabbedPane jtEmpresa;
    private javax.swing.JTextField jtEndereco;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtTelefone;
    // End of variables declaration//GEN-END:variables

    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
            if (vaPara == null || vaPara.equals("")) {
                vaPara = "0";
            }
        }
        empresa = EmpresaDao.vaPara(vaPara);
        if (empresa != null) {

            jtCampo.setText(String.valueOf(empresa.getId()));
            jtNome.setText(empresa.getNome());
            jtCgc.setText(empresa.getCgc());
            jtTelefone.setText(empresa.getTelefone());
            jtEndereco.setText(empresa.getEndereco());
            jtEmail.setText(empresa.getEmail());

            ItemCombo uf = new ItemCombo();
            Cidade cidade = CidadeDao.getEstadoId(empresa.getCidade().getId());
            uf.setCodigo(cidade.getEstado().getId());
            new CombosDAO().definirItemCombo(jcEstado, uf);

            jcCidade.setEnabled(true);
            ItemCombo c = new ItemCombo();
            c.setCodigo(cidade.getId());
            new CombosDAO().definirItemCombo(jcCidade, c);

        } else {
            Campos.limpar(jpEmpresa);
            Campos.desabilitar(jpEmpresa);
        }
    }

    @Override
    public void pesquisar() {
        if (iFEmpresa == null) {
            iFEmpresa = new IfEmpresa(this);
        }
        EmpresaDao.popularTabela(iFEmpresa.getTabela(), null);
        iFEmpresa.setModal(true);
        iFEmpresa.setVisible(true);
        jbSalvar.setEnabled(true);
    }

    @Override
    public void inserir() {
        Campos.habilitar(jpEmpresa);
        Campos.limpar(jpEmpresa);
        jtCampo.setText(EmpresaDao.proximoId());
        jtCampo.setEditable(false);
        jbSalvar.setEnabled(true);
    }

    @Override
    public void alterar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            EmpresaDao.deletar(empresa);
            Campos.limpar(jpEmpresa);
            Campos.desabilitar(jpEmpresa);
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

    public void setFormEmpresa(Empresa empresa) {
        this.empresa = empresa;
        jtCampo.setText(String.valueOf(empresa.getId()));
        jtNome.setText(empresa.getNome());
        jtCgc.setText(empresa.getCgc());
        jtTelefone.setText(empresa.getTelefone());
        jtEndereco.setText(empresa.getEndereco());
        jtEmail.setText(empresa.getEmail());

        ItemCombo uf = new ItemCombo();
        Cidade cidade = CidadeDao.getEstadoId(empresa.getCidade().getId());
        uf.setCodigo(cidade.getEstado().getId());
        new CombosDAO().definirItemCombo(jcEstado, uf);

        jcCidade.setEnabled(true);
        ItemCombo c = new ItemCombo();
        c.setCodigo(cidade.getId());
        new CombosDAO().definirItemCombo(jcCidade, c);

        Campos.habilitar(jpEmpresa);
        jbSalvar.setEnabled(true);
    }

    public Empresa obterFromEmpresa() {
        return this.empresa;
    }
}
