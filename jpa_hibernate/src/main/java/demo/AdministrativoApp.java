package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {

        // Teste produto
        System.out.println("TESTES PRODUTO");
        ProdutoModel produtoModel = new ProdutoModel();

        Produto testeProduto = new Produto();
        testeProduto.setNome("Notebook");
        testeProduto.setPreco(5000.0);
        testeProduto.setQuantidade(5);
        testeProduto.setStatus(true);

        // 1 - Criando um produto
        produtoModel.create(testeProduto);
        System.out.println(testeProduto);

        // 2 - Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Listar todos:");
        System.out.println("Qtde de produtos encontrados : " + produtos.size());
        produtos.forEach(System.out::println);

        // 3 - Buscar por id
        Produto produtoBusca = produtoModel.findById(testeProduto);
        System.out.println("Busca por id:");
        System.out.println(produtoBusca);

        // 4 - Atualizar produto
        testeProduto.setNome("Notebook Dell");
        testeProduto.setPreco(5000.0);
        testeProduto.setQuantidade(0);
        testeProduto.setStatus(false);
        produtoModel.update(testeProduto);
        System.out.println(testeProduto);

        // 5 - Removendo produto
        produtoModel.delete(testeProduto);
        produtoBusca = produtoModel.findById(testeProduto);
        System.out.println("Qtde de produtos encontrados : " + produtoBusca);

        // Teste pessoa
        System.out.println("TESTES PESSOA");
        PessoaModel pessoaModel = new PessoaModel();

        Pessoa testePessoa = new Pessoa();
        testePessoa.setNome("Ederson");
        testePessoa.setEmail("ederson@ederson.com");
        testePessoa.setIdade(33);
        testePessoa.setCpf("123.456.789-00");
        testePessoa.setDataNascimento(LocalDate.of(1988,10,11));

        // 1 - Criando uma pessoa
        pessoaModel.create(testePessoa);
        System.out.println(testePessoa);

        // 2 - Buscando todas as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Listar todos:");
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());
        pessoas.forEach(System.out::println);

        // 3 - Buscar por id
        Pessoa pessoaBusca = pessoaModel.findById(testePessoa);
        System.out.println("Busca por id:");
        System.out.println(pessoaBusca);

        // 4 - Atualizar pessoa
        testePessoa.setNome("Ederson Rafael Nonnemacher");
        testePessoa.setEmail("ederson@ederson.com.br");
        testePessoa.setIdade(34);
        testePessoa.setCpf("111.111.111-11");
        pessoaModel.update(testePessoa);
        System.out.println(testePessoa);

        // 5 - Removendo pessoa
        pessoaModel.delete(testePessoa);
        pessoaBusca = pessoaModel.findById(testePessoa);
        System.out.println("Qtde de pessoas encontradas : " + pessoaBusca);
    }
}