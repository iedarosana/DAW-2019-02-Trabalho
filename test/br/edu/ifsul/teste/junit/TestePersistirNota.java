/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Nota;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author ieda
 */
public class TestePersistirNota {

    public TestePersistirNota() {
    }

    @Test
    public void teste() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Nota n = new Nota();
        n.setNota01(0.4);
        n.setNota02(0.4);
        n.setMedia(0.4);
        Aluno a = em.find(Aluno.class, 2);
        n.setAluno(a);
        Disciplina d = em.find(Disciplina.class, 9);
        n.setDisciplina(d);
        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();

    }

}
