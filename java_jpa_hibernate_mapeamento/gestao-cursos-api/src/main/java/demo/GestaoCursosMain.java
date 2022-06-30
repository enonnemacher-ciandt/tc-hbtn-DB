package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GestaoCursosMain {

    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua");
        endereco.setEndereco("1");
        endereco.setNumero("111");
        endereco.setBairro("Teste");
        endereco.setCidade("Teutonia");
        endereco.setEstado("RS");
        endereco.setCep(95890000);

        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua");
        endereco2.setEndereco("2");
        endereco2.setNumero("222");
        endereco2.setBairro("Teste 2");
        endereco2.setCidade("Teutonia");
        endereco2.setEstado("RS");
        endereco2.setCep(95890000);

        Telefone telefone = new Telefone();
        telefone.setDdd("51");
        telefone.setNumero("99999-9999");

        Telefone telefone2 = new Telefone();
        telefone2.setDdd("51");
        telefone2.setNumero("88888-8888");

        Aluno aluno1 = new Aluno();
        aluno1.setNomeCompleto("Ederson");
        aluno1.setMatricula("2022");
        aluno1.setNascimento(Date.from(Instant.now()));
        aluno1.setEmail("ederson@ederson.com");
        aluno1.setEnderecos(Arrays.asList(endereco));
        aluno1.setTelefones(Arrays.asList(telefone));

        Aluno aluno2 = new Aluno();
        aluno2.setNomeCompleto("Beltrano");
        aluno2.setMatricula("2021");
        aluno2.setNascimento(Date.from(Instant.now()));
        aluno2.setEmail("beltrano@beltrano.com");
        aluno2.setEnderecos(Arrays.asList(endereco2));
        aluno2.setTelefones(Arrays.asList(telefone2));

        MaterialCurso materialCurso = new MaterialCurso("www.google.com.br");

        Professor professor = new Professor();
        professor.setNomeCompleto("Fulano Ciclano");
        professor.setMatricula("2022");
        professor.setEmail("fulano@fulano.com.br");

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno2);

        Curso curso = new Curso("JAVA", "Java", professor, materialCurso, alunos);
        List<Curso> cursos = new ArrayList<>();
        cursos.add(curso);

        professor.setCursos(cursos);

        // Teste aluno
        // 1 - Criando um aluno
        alunoModel.create(aluno1);
        alunoModel.create(aluno2);

        // 2 - Buscando todos os alunos na base de dados
        List<Aluno> listaAlunos = alunoModel.findAll();
        System.out.println("Listar todos:");
        System.out.println("Qtde de alunos encontrados : " + listaAlunos.size());
        listaAlunos.forEach(System.out::println);

        // 3 - Buscar por id
        Aluno alunoBusca = alunoModel.findById(aluno1);
        System.out.println("Busca por id:");
        System.out.println(alunoBusca);

        // 4 - Atualizar aluno
        aluno1.setNomeCompleto("Ederson Rafael Nonnemacher");
        alunoModel.update(aluno1);
        System.out.println(aluno1);

        // 5 - Removendo aluno
        alunoModel.delete(aluno1);
        alunoBusca = alunoModel.findById(aluno1);
        System.out.println("Qtde de alunos encontrados : " + alunoBusca);

        // Teste curso
        // 1 - Criando um curso
        cursoModel.create(curso);
        System.out.println(curso);

        // 2 - Buscando todos os cursos na base de dados
        List<Curso> listaCursos = cursoModel.findAll();
        System.out.println("Listar todos:");
        System.out.println("Qtde de cursos encontrados : " + listaCursos.size());
        listaCursos.forEach(System.out::println);

        // 3 - Buscar por id
        Curso cursoBusca = cursoModel.findById(curso);
        System.out.println("Busca por id:");
        System.out.println(cursoBusca);

        // 4 - Atualizar curso
        curso.setNome("Java Avançado 2022");
        cursoModel.update(curso);
        System.out.println(curso);

        // 5 - Removendo curso
        cursoModel.delete(curso);
        cursoBusca = cursoModel.findById(curso);
        System.out.println("Qtde de cursos encontrados : " + cursoBusca);
    }
}
