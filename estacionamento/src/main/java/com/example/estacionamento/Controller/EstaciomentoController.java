package com.example.estacionamento.Controller;


import com.example.estacionamento.Model.Estacionamento;
import com.example.estacionamento.Repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/veiculos")

public class EstaciomentoController {

    @Autowired

    private EstacionamentoRepository estacionamentoRepository;

    @PostMapping
    public Estacionamento criarVeiculos(@RequestBody Estacionamento controleCarros) {
        return estacionamentoRepository.save(controleCarros);
    }

    @GetMapping

    public List<Estacionamento> listarCarros(){
        return estacionamentoRepository.findAll();
    }

    @GetMapping("/{carroId}")
    public Estacionamento buscarCarros(@PathVariable int carroId) {
        return estacionamentoRepository.findById(carroId).orElse(null);
    }

    @DeleteMapping("{carroId}")
    public void excluirCarros(@PathVariable int carroId ) {
        estacionamentoRepository.deleteById(carroId);

    }
}
