/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity 
@Table(name = "curso")
@Inheritance(strategy = InheritanceType.JOINED)
public class Curso implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id",allocationSize =1)
    @GeneratedValue(generator = "seq_curso",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser infrmado")
    @Length(max = 50,message = "O nome não pode ser mais que{max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "A descricao deve ser informada")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @NotNull(message = "Informe se o curso está ativo ou não")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @NotNull(message = "O  inicio das atividades deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicioAtividades", nullable = false)
    private Calendar inicioAtividades;
    
    @NotNull(message = " A instituição deve ser informada")
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "Id", nullable = false)
    private Instituicao instituicao;
    
     public Curso(){
        this.ativo = true;//para deixar o valor de ativo default true
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }
    
     public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    
}