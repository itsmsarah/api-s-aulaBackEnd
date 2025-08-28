package com.example.estacionamento.Controller;

import com.example.estacionamento.Model.Estacionamento;
import com.example.estacionamento.Repository.EstacionamentoRepository;
import com.example.estacionamento.Services.EstacionamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    //@PostMapping
    // public Estacionamento criarVeiculos(@RequestBody Estacionamento controleCarros) {
    //  return estacionamentoRepository.save(controleCarros);
    //  }

    @GetMapping
    public List<Estacionamento> listarCarros() {
        return estacionamentoRepository.findAll();
    }

    @GetMapping("/{carroId}")
    public Estacionamento buscarCarros(@PathVariable int carroId) {
        return estacionamentoRepository.findById(carroId).orElse(null);
    }

    @DeleteMapping("/{carroId}")
    public void excluirCarros(@PathVariable int carroId) {
        estacionamentoRepository.deleteById(carroId);
    }

    @Autowired
    private EstacionamentoService estacionamentoService;

    @PutMapping("/saida/{carro_id}")
    public ResponseEntity<Estacionamento> registrarSaida(@PathVariable Integer carro_id) {
        try {
            Estacionamento estacionamentoSaida = estacionamentoService.registrarSaida(carro_id);
            return new ResponseEntity<>(estacionamentoSaida, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Estacionamento criarVeiculos(@RequestBody Estacionamento controleCarros) {
        return estacionamentoService.registrarEntrada(controleCarros);

    }
}
