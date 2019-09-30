/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author ieda
 */
public class TestePersistirAluno {

    public TestePersistirAluno() {
    }

    @Test
    public void teste() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Aluno a = new Aluno();
        a.setNome("Ieda");
        a.setEmail("iedarosana@gmail.com");
        a.setNascimento(Calendar.getInstance());
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();

    }

}
