/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author ieda
 */
public class TestePersistirCurso {

    public TestePersistirCurso() {
    }

    @Test
    public void teste() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Curso c = new Curso();
        c.setNome("Ciência da Computação");
        c.setDescricao("Curso ciência da computação voltado para profissionais....");
        c.setInicioAtividades(Calendar.getInstance());
        Instituicao i = em.find(Instituicao.class, 3);
        c.setInstituicao(i);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

    }

}
