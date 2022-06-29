package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar pessoa !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void update(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.find(Pessoa.class, pessoa.getId());
            entityManager.merge(pessoa);
            entityManager.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar pessoa !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void delete(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.find(Pessoa.class, pessoa.getId());
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
            System.out.println("Pessoa removida com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover pessoa !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public Pessoa findById(Pessoa pessoa) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            pessoa = entityManager.find(Pessoa.class, pessoa.getId());
        } catch (Exception e) {
            System.err.println("Erro ao buscar pessoa !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return pessoa;
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            pessoas = entityManager.createQuery("FROM Pessoa").getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar todos as pessoas !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return pessoas;
    }
}
