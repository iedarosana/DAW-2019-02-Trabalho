/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.teste.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;
import org.junit.Test;

/**
 *
 * @author ieda
 */
public class TestePersistirEspecialidade {
    
       public TestePersistirEspecialidade() {
    }
    @Test
    public void teste(){
        EntityManager em = EntityManagerUtil.getEntityManager();
        Especialidade e = new Especialidade();
        e.setNome("Desenvolvimento");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    
}
    
}
