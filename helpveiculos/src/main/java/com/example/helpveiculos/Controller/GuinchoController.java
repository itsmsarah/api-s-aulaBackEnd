package com.example.helpveiculos.Controller;

import com.example.helpveiculos.Modal.GuinchoModal;
import com.example.helpveiculos.Repository.GuinchoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.theme.CookieThemeResolver;

import java.util.List;

@RestController
@RequestMapping("/api/helpveiculos")
public class GuinchoController {
    @Autowired

    private GuinchoRepository guinchoRepository;

    @PostMapping
    public GuinchoModal criarCadastro(@RequestBody GuinchoModal controleClientes){

    return guinchoRepository.save(controleClientes);
    }

    @GetMapping
    public List<GuinchoModal>listarClientes(){
        return guinchoRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public GuinchoModal buscarCliente(@PathVariable int clienteId){
        return guinchoRepository.findById(clienteId).orElse(null);
    }

    @DeleteMapping("/{clienteId}")
    public void exluirCliente(@PathVariable int clienteId){
        guinchoRepository.deleteById(clienteId);
    }





}
