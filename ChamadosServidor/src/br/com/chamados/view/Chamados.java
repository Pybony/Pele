package br.com.chamados.view;

import br.com.chamados.config.LogChamados;
import br.com.chamados.control.DAO;
import br.com.chamados.model.Pessoa;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author lksbr
 */
public class Chamados {

    private static Logger logger = Logger.getLogger(LogChamados.class);

    public static void main(String[] args) {
        logger.info("Teste");
        DAO<Pessoa> dao = new DAO<Pessoa>();
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("01444099094");
        pessoa.setEndereco("Meu endereço");
        pessoa.setIdade(27);
        pessoa.setNome("Lucas Schneider");
        pessoa.setSexo("M");
        dao.insert(pessoa);

        logger.info(pessoa.toString());

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setCpf("014785236");
        pessoa1.setEndereco("Meu endereço 2");
        pessoa1.setIdade(24);
        pessoa1.setNome("Lucas Maciel");
        pessoa1.setSexo("M");
        dao.insert(pessoa1);

        logger.info(pessoa1.toString());

        List<Pessoa> listaPessoa = dao.queryList(Pessoa.class);
        for (Pessoa pessoas : listaPessoa) {
            logger.info(pessoas.toString());
        }

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setCpf("014785236");
        pessoa2.setEndereco("Meu endereço 2");
        pessoa2.setIdade(24);
        pessoa2.setNome("Lucas Pedro");
        pessoa2.setSexo("M");

        dao.update(pessoa2);

        Pessoa pessoaResult = dao.queryById("cpf", pessoa2.getCpf(), pessoa2.getClass());
        logger.info(pessoaResult.toString());
        
        dao.delete(pessoa2);

        List<Pessoa> lista2 = dao.query("SELECT x FROM Pessoa x WHERE cpf = '01444099'");
        for (Pessoa lista21 : lista2) {
            logger.info(lista21.toString());
        }

    }
}
