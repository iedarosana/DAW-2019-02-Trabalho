/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Professor;
import java.util.Calendar;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author ieda
 */
public class TestePersistirProfessor {
    
        public TestePersistirProfessor() {
    }

    @Test
    public void teste() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Professor p = new Professor();
        p.setNome("Ieda");
        p.setEmail("iedarosana@gmail.com");
        p.setNascimento(Calendar.getInstance());
        p.setTitulacao("Doutor");
        p.setTopicosInteresse("Testes");
        Especialidade e = em.find(Especialidade.class, 7);
        p.setEspecialidade(e);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

    }
    
}
