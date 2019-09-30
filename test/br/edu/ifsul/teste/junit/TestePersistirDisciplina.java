/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Curso;
import br.edu.ifsul.modelo.Disciplina;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author ieda
 */
public class TestePersistirDisciplina {

    public TestePersistirDisciplina() {
    }

    @Test
    public void teste() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Disciplina d = new Disciplina();
        d.setNome("Programação para Web");
        d.setDescricao("Disciplina Programação para Web voltado para profissionais....");
        d.setCargaHoraria(40.4);
        d.setConhecimentosMinimos("Conhecimentos em Desenvolvimento Java");
        Curso c = em.find(Curso.class, 9);
        d.setCurso(c);
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();

    }

}
