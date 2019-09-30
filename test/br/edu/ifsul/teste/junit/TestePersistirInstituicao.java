/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author ieda
 */
public class TestePersistirInstituicao {

    public TestePersistirInstituicao() {
    }

    @Test
    public void teste() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Instituicao i = new Instituicao();
        i.setNome("Ifsul");
        i.setAnoFundacao(Calendar.getInstance());
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();

    }

}
