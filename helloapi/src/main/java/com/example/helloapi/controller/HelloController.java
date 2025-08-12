package com.example.helloapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//Request Mapping - anotação utilizada para implementar url ,
//ela suporta os metodos POST,GET, PUT, DELETE
import org.springframework.web.bind.annotation.RestController;
//controlador usado para serviços RestFull,serviços web que seguem os princípios do estilo arquitetural

@RestController
//indica que esta classe é controlador
@RequestMapping("/api") // define o caminho base da API
public class HelloController {
    @GetMapping("/hello") //Usada para mapear requisição
    //HTTP GET para um método dentro do controlador
    //quando uma requisição HTTP GET é feita para um determinado URL,
    // o método anotado com @GetMapping será executado para lidar com essa requisição.

    public String sayHello(){
        return "Olá mundo, seja bem-vindo...";
    }


}
