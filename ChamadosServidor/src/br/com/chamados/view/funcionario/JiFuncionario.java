package br.com.chamados.view.funcionario;

import br.com.chamados.config.LogChamados;
import br.com.chamados.dao.EmpresaDao;
import br.com.chamados.dao.FuncaoDao;
import br.com.chamados.dao.FuncionarioDao;
import br.com.chamados.dao.NivelDao;
import br.com.chamados.dao.PessoaDao;
import br.com.chamados.dao.SetorDao;
import br.com.chamados.genericos.AcoesPainel;
import br.com.chamados.genericos.Campos;
import br.com.chamados.genericos.Cookies;
import br.com.chamados.genericos.Util;
import br.com.chamados.model.Funcionario;
import br.com.chamados.model.Permissoes;
import br.com.chamados.view.JpDefault;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class JiFuncionario extends JInternalFrame implements AcoesPainel {

    private Logger logger = Logger.getLogger(LogChamados.class);
    private JpDefault jpDefault;
    private JdBuscaFuncionario jdBuscaFuncionario;
    private Funcionario funcionario;

    public JiFuncionario() {
        setTitle("JiFuncionario - Manutenção de Funcionário - v1.00.00");
        initComponents();
        initMyComponents();
    }

    private void initMyComponents() {
        jpDefault = new JpDefault();
        jpDefault.setBounds(JpDefault.X, JpDefault.Y, JpDefault.WIDTH, JpDefault.HEIGHT);
        this.setSize(JpDefault.WIDTH + 30, JpDefault.HEIGHT + 150);
        jpFuncionario.setBorder(BorderFactory.createEmptyBorder(70, 40, 0, 0));
        jpFuncionario.add(jpDefault);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFuncionario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtPessoaId = new javax.swing.JTextField();
        jtPessoaNome = new javax.swing.JTextField();
        jbPessoaBuscar = new javax.swing.JButton();
        jbFuncaoBuscar = new javax.swing.JButton();
        jtFuncaoDescricao = new javax.swing.JTextField();
        jtFuncaoId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtSetorId = new javax.swing.JTextField();
        JtSetorDescricao = new javax.swing.JTextField();
        jbSetorBuscar = new javax.swing.JButton();
        jbEmpresaBuscar = new javax.swing.JButton();
        jtEmpresaDescricao = new javax.swing.JTextField();
        jtEmpresaId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtDataAdmicao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtDataDesligamento = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Id");

        jtId.setEditable(false);
        jtId.setEnabled(false);

        jLabel2.setText("Pessoa");

        jtPessoaId.setEditable(false);
        jtPessoaId.setEnabled(false);

        jtPessoaNome.setEditable(false);
        jtPessoaNome.setEnabled(false);

        jbPessoaBuscar.setText("Buscar");

        jbFuncaoBuscar.setText("Buscar");

        jtFuncaoDescricao.setEditable(false);
        jtFuncaoDescricao.setEnabled(false);

        jtFuncaoId.setEditable(false);
        jtFuncaoId.setEnabled(false);

        jLabel3.setText("Função");

        jLabel4.setText("Setor");

        jtSetorId.setEditable(false);
        jtSetorId.setEnabled(false);

        JtSetorDescricao.setEditable(false);
        JtSetorDescricao.setEnabled(false);

        jbSetorBuscar.setText("Buscar");

        jbEmpresaBuscar.setText("Buscar");

        jtEmpresaDescricao.setEditable(false);
        jtEmpresaDescricao.setEnabled(false);

        jtEmpresaId.setEditable(false);
        jtEmpresaId.setEnabled(false);

        jLabel5.setText("Empresa");

        jLabel6.setText("Data Admição");

        jtDataAdmicao.setEditable(false);
        jtDataAdmicao.setEnabled(false);

        jLabel7.setText("Data Desligamento");

        jtDataDesligamento.setEditable(false);
        jtDataDesligamento.setEnabled(false);

        javax.swing.GroupLayout jpFuncionarioLayout = new javax.swing.GroupLayout(jpFuncionario);
        jpFuncionario.setLayout(jpFuncionarioLayout);
        jpFuncionarioLayout.setHorizontalGroup(
            jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addComponent(jtPessoaId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jtPessoaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbPessoaBuscar))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(16, 16, 16)
                        .addComponent(jtFuncaoId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jtFuncaoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbFuncaoBuscar))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)
                        .addComponent(jtSetorId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(JtSetorDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbSetorBuscar))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(jtDataAdmicao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(jtDataDesligamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(10, 10, 10)
                        .addComponent(jtEmpresaId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jtEmpresaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jbEmpresaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpFuncionarioLayout.setVerticalGroup(
            jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtPessoaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtPessoaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbPessoaBuscar))
                .addGap(11, 11, 11)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtFuncaoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtFuncaoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbFuncaoBuscar))
                .addGap(11, 11, 11)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtSetorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(JtSetorDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbSetorBuscar))
                .addGap(11, 11, 11)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtEmpresaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jtEmpresaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbEmpresaBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDataAdmicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtDataDesligamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpFuncionarioLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jpFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Util.centralizar(this);
        jpDefault.setAcoesCadastro(this);
        vaPara("0");
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JtSetorDescricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbEmpresaBuscar;
    private javax.swing.JButton jbFuncaoBuscar;
    private javax.swing.JButton jbPessoaBuscar;
    private javax.swing.JButton jbSetorBuscar;
    private javax.swing.JPanel jpFuncionario;
    private javax.swing.JTextField jtDataAdmicao;
    private javax.swing.JTextField jtDataDesligamento;
    private javax.swing.JTextField jtEmpresaDescricao;
    private javax.swing.JTextField jtEmpresaId;
    private javax.swing.JTextField jtFuncaoDescricao;
    private javax.swing.JTextField jtFuncaoId;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtPessoaId;
    private javax.swing.JTextField jtPessoaNome;
    private javax.swing.JTextField jtSetorId;
    // End of variables declaration//GEN-END:variables

    @Override
    public void vaPara(String vaPara) {
        if (vaPara.equals("")) {
            vaPara = JOptionPane.showInputDialog("Vá para");
            if (vaPara == null || vaPara.equals("")) {
                vaPara = "0";
            }
        }
        funcionario = FuncionarioDao.vaPara(vaPara);
        if (funcionario != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            jtId.setText(String.valueOf(funcionario.getId()));
            jtPessoaId.setText(String.valueOf(funcionario.getPessoa().getId()));
            jtPessoaNome.setText(funcionario.getPessoa().getNome());
            jtFuncaoId.setText(String.valueOf(funcionario.getFuncao().getId()));
            jtFuncaoDescricao.setText(funcionario.getFuncao().getDescricao());
            jtSetorId.setText(String.valueOf(funcionario.getSetor().getId()));
            JtSetorDescricao.setText(funcionario.getSetor().getDescricao());
            jtEmpresaId.setText(String.valueOf(funcionario.getEmpresa().getId()));
            jtEmpresaDescricao.setText(funcionario.getEmpresa().getNome());
            jtDataAdmicao.setText(sdf.format(funcionario.getDataAdmicao()));
            jtDataDesligamento.setText(sdf.format(funcionario.getDataDesligamento()));
        } else {
            jtId.setText("");
            jtPessoaId.setText("");
            jtPessoaNome.setText("");
            jtFuncaoId.setText("");
            jtFuncaoDescricao.setText("");
            jtSetorId.setText("");
            JtSetorDescricao.setText("");
            jtEmpresaId.setText("");
            jtEmpresaDescricao.setText("");
            jtDataAdmicao.setText("");
            jtDataDesligamento.setText("");
        }
    }

    @Override
    public void pesquisar() {
        if (jdBuscaFuncionario == null) {
            jdBuscaFuncionario = new JdBuscaFuncionario();
        }
        jdBuscaFuncionario.setModal(true);
        jdBuscaFuncionario.setVisible(true);
        vaPara(jdBuscaFuncionario.getIdRetorno());
    }

    @Override
    public void inserir() {
        jtId.setText(FuncionarioDao.proximoId());
        jtPessoaId.setText("");
        jtPessoaId.setEnabled(true);
        jtPessoaId.setEditable(true);
        jtFuncaoId.setText("");
        jtFuncaoId.setEnabled(true);
        jtFuncaoId.setEditable(true);
        jtSetorId.setText("");
        jtSetorId.setEnabled(true);
        jtSetorId.setEditable(true);
        jtEmpresaId.setText("");
        jtEmpresaId.setEnabled(true);
        jtEmpresaId.setEditable(true);
        jtDataAdmicao.setText("");
        jtDataAdmicao.setEnabled(true);
        jtDataAdmicao.setEditable(true);
        jtDataDesligamento.setText("");
        jtDataDesligamento.setEnabled(true);
        jtDataDesligamento.setEditable(true);
    }

    @Override
    public void alterar() {
        if (funcionario != null) {
            jtPessoaId.setEnabled(true);
            jtPessoaId.setEditable(true);
            jtFuncaoId.setEnabled(true);
            jtFuncaoId.setEditable(true);
            jtSetorId.setEnabled(true);
            jtSetorId.setEditable(true);
            jtEmpresaId.setEnabled(true);
            jtEmpresaId.setEditable(true);
            jtDataAdmicao.setEnabled(true);
            jtDataAdmicao.setEditable(true);
            jtDataDesligamento.setEnabled(true);
            jtDataDesligamento.setEditable(true);
        }
    }

    @Override
    public void deletar() {
        int opcao = JOptionPane.showConfirmDialog(null, "Confirma exclução do registro?", "Deletar Registro", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            FuncionarioDao.deletar(funcionario);
            vaPara("0");
        }
    }

    @Override
    public void salvar() {
        try {
            funcionario = new Funcionario();
            if (!jtId.getText().equals(FuncionarioDao.proximoId())) {
                funcionario.setId(Integer.parseInt(jtId.getText()));
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            funcionario.setPessoa(PessoaDao.vaPara(jtPessoaId.getText()));
            funcionario.setFuncao(FuncaoDao.vaPara(jtFuncaoId.getText()));
            funcionario.setSetor(SetorDao.vaPara(jtSetorId.getText()));
            funcionario.setEmpresa(EmpresaDao.vaPara(jtEmpresaId.getText()));
            funcionario.setDataAdmicao(sdf.parse(jtDataAdmicao.getText()));
            funcionario.setDataDesligamento(sdf.parse(jtDataDesligamento.getText()));
            FuncionarioDao.salvar(funcionario);
            if (!jtId.getText().equals(NivelDao.proximoId())) {
                vaPara(jtId.getText());
            } else {
                vaPara("0");
            }
            Campos.desabilitar(jpFuncionario);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(JiFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cancelar() {
        if (jtId.getText().equals(NivelDao.proximoId())) {
            vaPara("0");
        } else {
            vaPara(jtId.getText());
        }
        Campos.desabilitar(jpFuncionario);
    }

    @Override
    public void fechar() {
        hide();
        vaPara("0");
        Campos.desabilitar(jpFuncionario);
    }

    @Override
    public void checkEnabled(JButton jbInserir, JButton jbAlterar, JButton jbDeletar) {
        Permissoes permissoes = Cookies.getPermissao(this.getClass().getSimpleName());
        jbInserir.setEnabled(permissoes.getInserir());
        jbAlterar.setEnabled(permissoes.getAlterar());
        jbDeletar.setEnabled(permissoes.getDeletar());
    }
}
