package br.com.chamados.dao;

import br.com.chamados.model.Funcionario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lksbr
 */
public class FuncionarioDao {

    public static Funcionario getFucionario(Set set) {
        Funcionario funcionario = null;
        for (Iterator iterator1 = set.iterator(); iterator1.hasNext();) {
            funcionario = (Funcionario) iterator1.next();
        }
        return funcionario;
    }

    public static List<Funcionario> getFuncionarios(Set set) {
        List<Funcionario> lista = new ArrayList<>();
        for (Iterator iterator1 = set.iterator(); iterator1.hasNext();) {
            Funcionario funcionario = (Funcionario) iterator1.next();
            lista.add(funcionario);
        }
        return lista;
    }

}
