/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity 
@Table(name = "disciplina")
@Inheritance(strategy = InheritanceType.JOINED)
public class Disciplina implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id",allocationSize =1)
    @GeneratedValue(generator = "seq_disciplina",strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser infrmado")
    @Length(max = 50,message = "O nome não pode ser mais que{max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    
    @NotBlank(message = "A descricao deve ser informada")
    @Column(name = "descricao", nullable = false)
    private String descricao;
    
    @Min(value = 0, message = "  A carga horária não pode ser negativa")
    @NotNull(message = "A carga horária deve ser informada")
    @Column(name = "cargaHoraria", nullable = false, columnDefinition = "numeric(10,2)")
    private Double cargaHoraria;
    
    @NotBlank(message = "Conhecimentos minimos  deve ser informado")
    @Length(max = 50,message = "Conhecimentos minimos não pode ser mais que{max} caracteres")
    @Column(name = "conhecimentosMinimos", nullable = false, length = 50)
    private String conhecimentosMinimos;
    
    @NotNull(message = "O  curso deve ser informado")
    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "Id", nullable = false)
    private Curso curso;
    
     public Disciplina(){
        
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

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }
    
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}