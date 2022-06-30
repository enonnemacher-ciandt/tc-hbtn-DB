package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar aluno !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void update(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(aluno);
            entityManager.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar aluno !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            aluno = entityManager.find(Aluno.class, aluno.getId());
            entityManager.remove(aluno);
            entityManager.getTransaction().commit();
            System.out.println("Aluno removido com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover aluno !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public Aluno findById(Aluno aluno) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            aluno = entityManager.find(Aluno.class, aluno.getId());
        } catch (Exception e) {
            System.err.println("Erro ao buscar aluno !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return aluno;
    }

    public List<Aluno> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Aluno> alunos = new ArrayList<>();
        try {
            alunos = entityManager.createQuery("FROM Aluno").getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar todos os alunos !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return alunos;
    }
}
