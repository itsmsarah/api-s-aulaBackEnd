package com.example.estacionamento.Repository;

import com.example.estacionamento.Model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento,Integer> {
}
