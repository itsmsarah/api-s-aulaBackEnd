package com.example.api_alunos.Controller;

import com.example.api_alunos.Model.Aluno;

import com.example.api_alunos.Repository.AlunoRepositorio;
//permite que a classe atual use a interface AlunoRepositorio
//É uma interface de Spring que fornece métddos de acesso
//ao banco de dados.Com esse import, pode injetar o repositorio em sua classe

import org.springframework.beans.factory.annotation.Autowired;
//essa anotação é usada para realizar a injeçao de dependencia
//Ela pede ao SpringBoot para fornecer uma instancia de uma classe

import org.springframework.web.bind.annotation.GetMapping;
//mapeia requisições HTTP do tipo GET

import  org.springframework.web.bind.annotation.RequestMapping;
//usada  para definit o caminho base para todos os endoints em um controlador

import org.springframework.web.bind.annotation.RestController;
//marca a classe com um controlador RestFull

import java.util.List;
//permite que a classe utilize List do Java
//é usada para trabalhar com coleções de objetos.

//O uso dos imports permite o códgo Java conectar
//e utilizar funcionalidades de outras classes e bibliotecas


@RestController
//metodos que retornarão os dados diretamento no corpo de resposta HTTp

@RequestMapping("/api/alunos")
//define o caminho base para todas as requisições
//mapeadas neste controlador

public class AlunoController {
    @Autowired
    //utiliza a injeção de dependencia do Spring para obter uma instancia
    //do AlunoRepositorio, permitindo que o controlador intereja com o banco de dados

    private AlunoRepositorio alunoRepositorio;

    @GetMapping
    //mapeia requisições HTTP GET para o
    //*ListarAlunos().
    public List<Aluno>listarAluno(){
        return alunoRepositorio.findAll();
    }

    //Listar aluno - chama o metodo findAll que retorna
    //uma lista de todos os objetos aluno, ou seja,
    //lista todos os registros da tabela tbl_aluno
}
