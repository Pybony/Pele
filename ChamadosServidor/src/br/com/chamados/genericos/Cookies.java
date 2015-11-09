/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.genericos;

import br.com.chamados.model.Permissoes;
import br.com.chamados.model.Usuario;
import java.util.List;

/**
 *
 * @author lksbr
 */
public class Cookies {
    
    public static List<Permissoes> listaPermissoes;
    public static Usuario usuario;
    
    public static Permissoes getPermissao(String simpleName) {
        Permissoes permissao = null;
        for (Permissoes permissoes : Cookies.listaPermissoes) {
            if (permissoes.getTela().getDescricao().equalsIgnoreCase(simpleName)) {
                permissao = permissoes;
            }
        }
        if (permissao == null) {
            permissao = new Permissoes();
            permissao.setInserir(false);
            permissao.setAlterar(false);
            permissao.setConsultar(false);
            permissao.setDeletar(false);
        }
        return permissao;
    }
    
}
