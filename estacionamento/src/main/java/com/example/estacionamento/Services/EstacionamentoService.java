package com.example.estacionamento.Services;

import com.example.estacionamento.Model.Estacionamento;
import com.example.estacionamento.Repository.EstacionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Estacionamento registrarEntrada(Estacionamento estacionamento) {
        estacionamento.setDataEntrada(LocalDate.now());
        estacionamento.setHorarioEntrada(LocalTime.now());
        return estacionamentoRepository.save(estacionamento);
    }

    public Estacionamento registrarSaida(Integer carroId) {
        Optional<Estacionamento> estacionamentoOptional = estacionamentoRepository.findById(carroId);

        if (estacionamentoOptional.isPresent()) {
            Estacionamento estacionamento = estacionamentoOptional.get();
            estacionamento.setDataSaida(LocalDate.now());
            estacionamento.setHorarioSaida(LocalTime.now());
            //calculo feito pro PreUpdate antes
            return estacionamentoRepository.save(estacionamento);
        }

        throw new RuntimeException("Veículo não encontrado");
    }

    public List<Estacionamento> listarVeiculos() {
        return estacionamentoRepository.findAll();
    }
}
