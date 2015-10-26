/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.view;

import br.com.chamados.genericos.Cookies;
import br.com.chamados.view.pais.JiPais;
import br.com.chamados.view.Permissoes.JiPermissao;
import br.com.chamados.view.cidade.JiCidade;
import br.com.chamados.view.empresa.JFEmpresa;
import br.com.chamados.view.estado.JiEstado;
import br.com.chamados.view.funcao.JiFuncao;
import br.com.chamados.view.nivel.JiNivel;
import br.com.chamados.view.pessoa.JFPessoa;
import br.com.chamados.view.setor.JiSetor;
import br.com.chamados.view.tela.JiTela;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author lksbr
 */
public class JfMenu extends javax.swing.JFrame {

    private static JiPais jiPais;
    private static JFEmpresa JFEmpresa;
    private static JFPessoa JFPessoa;
    private static JiPermissao jiPermissao;
    private static JiNivel jiNivel;
    private static JiFuncao jiFuncao;
    private static JiTela jiTela;
    private static JiEstado jiEstado;
    private static JiSetor jiSetor;
    private static JiCidade jiCidade;

    /**
     * Creates new form JfMenu
     */
    public JfMenu() {
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        desktop.setSize(3000, 3000);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuEmpresa = new javax.swing.JMenuItem();
        jMenuPessoa = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jMenu1.setText("Locais");

        jMenuItem1.setText("País");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem8.setText("Estado");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem10.setText("Cidade");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastro");

        jMenuEmpresa.setText("Empresas");
        jMenuEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEmpresaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuEmpresa);

        jMenuPessoa.setText("Pessoa");
        jMenuPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPessoaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuPessoa);

        jMenuItem5.setText("Nivel");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Função");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Tela");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem9.setText("Setor");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Permissão");

        jMenuItem2.setText("Usuários");
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Telas");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Permissões");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (jiPais == null) {
            jiPais = new JiPais();
            desktop.add(jiPais);
            jiPais.setVisible(true);
        } else {
            jiPais.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEmpresaActionPerformed
        if (JFEmpresa == null) {
            JFEmpresa = new JFEmpresa();
            desktop.add(JFEmpresa);
            JFEmpresa.setVisible(true);
        } else {
            JFEmpresa.setVisible(true);
        }
    }//GEN-LAST:event_jMenuEmpresaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (jiPermissao == null) {
            jiPermissao = new JiPermissao();
            desktop.add(jiPermissao);
            jiPermissao.setVisible(true);
        } else {
            jiPermissao.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (jiNivel == null) {
            jiNivel = new JiNivel();
            desktop.add(jiNivel);
            jiNivel.setVisible(true);
        } else {
            jiNivel.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (jiFuncao == null) {
            jiFuncao = new JiFuncao();
            desktop.add(jiFuncao);
            jiFuncao.setVisible(true);
        } else {
            jiFuncao.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (jiTela == null) {
            jiTela = new JiTela();
            desktop.add(jiTela);
            jiTela.setVisible(true);
        } else {
            jiTela.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (jiEstado == null) {
            jiEstado = new JiEstado();
            desktop.add(jiEstado);
            jiEstado.setVisible(true);
        } else {
            jiEstado.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if (jiSetor == null) {
            jiSetor = new JiSetor();
            desktop.add(jiSetor);
            jiSetor.setVisible(true);
        } else {
            jiSetor.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        if (jiCidade == null) {
            jiCidade = new JiCidade();
            desktop.add(jiCidade);
            jiCidade.setVisible(true);
        } else {
            jiCidade.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPessoaActionPerformed
        if (JFPessoa == null) {
            JFPessoa = new JFPessoa();
            desktop.add(JFPessoa);
            JFPessoa.setVisible(true);
        } else {
            JFPessoa.setVisible(true);
        }
    }//GEN-LAST:event_jMenuPessoaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuEmpresa;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuPessoa;
    // End of variables declaration//GEN-END:variables
}
