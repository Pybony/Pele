/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.dao;

import br.com.chamados.control.DAO;
import br.com.chamados.model.Auditoria;
import java.sql.ResultSet;

/**
 *
 * @author lksbr
 */
public class AuditoriaDao {
    
    public static void limpaAuditoria(){
        DAO<Auditoria> dao = new DAO<>();
        dao.nrQuerySQL("CALL limpaAuditoria(0, 2)");
    }
    
}
