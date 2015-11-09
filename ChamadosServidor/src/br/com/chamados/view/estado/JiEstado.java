package br.com.chamados.view.estado;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.EstadoDao;
import br.com.chamados.dao.PaisDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.Estado;
import br.com.chamados.model.Pais;
import br.com.chamados.model.Permissoes;
import br.com.chamados.view.JpDefault;
import br.com.chamados.view.pais.JdBuscaPais;
import javax.swing.BorderFactory;
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
    private JpDefault jpDefault;
    private JdBuscaPais jdBuscaPais;
    private JdBuscaEstado jdBuscaEstado;
    private Estado estado;
    
    public JiEstado() {
        setTitle("JiEstado - Manutenção de Estado - v1.00.00");
        initComponents();
        initMyComponents();
    }
    
    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        this.setSize(JpDefault.WIDTH + 30, JpDefault.HEIGHT + 180);
        jpEstado.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpEstado.add(jpDefault);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpEstado = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jpEstadoLayout = new javax.swing.GroupLayout(jpEstado);
        jpEstado.setLayout(jpEstadoLayout);
        jpEstadoLayout.setHorizontalGroup(
            jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpEstadoLayout.createSequentialGroup()
                        .addGroup(jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpEstadoLayout.createSequentialGroup()
                                .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(jpEstadoLayout.createSequentialGroup()
                                .addComponent(jtIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtNomePais, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpEstadoLayout.setVerticalGroup(
            jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtIdPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNomePais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Util.centralizar(this);
        jpDefault.setAcoesCadastro(this);
        vaPara("0");
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JPanel jpEstado;
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
        Permissoes permissoes = Cookies.getPermissao(this.getClass().getSimpleName());
        jbInserir.setEnabled(permissoes.getInserir());
        jbAlterar.setEnabled(permissoes.getAlterar());
        jbDeletar.setEnabled(permissoes.getDeletar());
    }
    
    @Override
    public void salvar() {
        estado = new Estado();
        if (!jtId.getText().equals(EstadoDao.proximoId())) {
            estado.setId(Integer.parseInt(jtId.getText()));
        }
        Pais pais = PaisDao.vaPara(jtIdPais.getText());
        estado.setPais(pais);
        estado.setNome(jtNome.getText());
        estado.setSigla(jtSigla.getText());
        EstadoDao.salvar(estado);
        if (!jtId.getText().equals(EstadoDao.proximoId())) {
            vaPara(jtId.getText());
        } else {
            vaPara("0");
        }
        Campos.desabilitar(jpEstado);
    }
    
    @Override
    public void cancelar() {
        if (jtId.getText().equals(EstadoDao.proximoId())) {
            vaPara("0");
        } else {
            vaPara(jtId.getText());
        }
        Campos.desabilitar(jpEstado);
    }
    
    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpEstado);
    }
}
