package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;
    @OneToOne(cascade = CascadeType.ALL)
    private MaterialCurso materialCurso;
    @ManyToMany
    private List<Aluno> alunos = new ArrayList<>();

    public Curso() {
    }

    public Curso(String nome, String sigla, Professor professor, MaterialCurso materialCurso, List<Aluno> alunos) {
        this.nome = nome;
        this.sigla = sigla;
        this.professor = professor;
        this.materialCurso = materialCurso;
        this.alunos = alunos;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setMaterialCurso(MaterialCurso materialCurso) {
        this.materialCurso = materialCurso;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
