/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author ieda
 */
@Entity 
@Table(name = "professor")
@Inheritance(strategy = InheritanceType.JOINED)
public class Professor implements Serializable {
    
   
    @NotBlank(message = " A titulacao deve ser informada")
    @Length(max = 50,message = "A titulacao não pode ser mais que{max} caracteres")
    @Column(name = "titulacao", nullable = false, length = 50)
    
    @Id
    private String titulacao;
    @NotBlank(message = " Tópicos de interesse deve ser informado")
    @Column(name = "topicosInteresse", nullable = false)
    private String topicosInteresse;
    
    @NotNull(message = "A especialidade deve ser informado")
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "Id", nullable = false)
    private Especialidade especialidade;
    
    public Professor (){
        
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTopicosInteresse() {
        return topicosInteresse;
    }

    public void setTopicosInteresse(String topicosInteresse) {
        this.topicosInteresse = topicosInteresse;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}