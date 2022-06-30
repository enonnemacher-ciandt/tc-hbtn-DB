package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {

    public void create(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(curso);
            entityManager.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar curso !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void update(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(curso);
            entityManager.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar curso !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void delete(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            curso = entityManager.find(Curso.class, curso.getId());
            entityManager.remove(curso);
            entityManager.getTransaction().commit();
            System.out.println("Curso removido com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover curso !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public Curso findById(Curso curso) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            curso = entityManager.find(Curso.class, curso.getId());
        } catch (Exception e) {
            System.err.println("Erro ao buscar curso !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return curso;
    }

    public List<Curso> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Curso> cursos = new ArrayList<>();
        try {
            cursos = entityManager.createQuery("FROM Curso").getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar todos os cursos !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return cursos;
    }
}
