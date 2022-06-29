package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ProdutoModel {

    public void create(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void update(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            produto = entityManager.find(Produto.class, produto.getId());
            entityManager.merge(produto);
            entityManager.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void delete(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            produto = entityManager.find(Produto.class, produto.getId());
            entityManager.remove(produto);
            entityManager.getTransaction().commit();
            System.out.println("Produto removido com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao remover o produto !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public Produto findById(Produto produto) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            produto = entityManager.find(Produto.class, produto.getId());
        } catch (Exception e) {
            System.err.println("Erro ao buscar o produto !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return produto;
    }

    public List<Produto> findAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Produto> produtos = new ArrayList<>();
        try {
            produtos = entityManager.createQuery("FROM Produto").getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar todos os produtos !!!" + e.getMessage());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return produtos;
    }
}
