package com.example.estacionamento.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="controle_carros")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="carro_id")
    private int carroId;

    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @Column(name ="data_entrada")
    private LocalDate dataEntrada;

    @Column(name ="horario_entrada")
    private LocalTime horarioEntrada;

    @Column(name ="data_saida")
    private LocalDate dataSaida;

    @Column(name ="horario_saida")
    private LocalTime horarioSaida;

    @Column(name = "valor_hora", precision = 10, scale = 2)
    private BigDecimal valorHora;

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name="tempo_permanencia")
    private int tempoPermanencia;

    public Estacionamento() {
    }

    public Estacionamento(int carroId, String placa, LocalDate dataEntrada, LocalTime horarioEntrada,
                          LocalDate dataSaida, LocalTime horarioSaida, BigDecimal valorHora,
                          BigDecimal valorTotal, int tempoPermanencia) {
        this.carroId = carroId;
        this.placa = placa;
        this.dataEntrada = dataEntrada;
        this.horarioEntrada = horarioEntrada;
        this.dataSaida = dataSaida;
        this.horarioSaida = horarioSaida;
        this.valorHora = valorHora;
        this.valorTotal = valorTotal;
        this.tempoPermanencia = tempoPermanencia;
    }
    public int getCarroId() {
        return carroId;
    }

    public void setCarroId(int carroId) {
        this.carroId = carroId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public int getTempoPermanencia() {
        return tempoPermanencia;
    }

    public void setTempoPermanencia(int tempoPermanencia) {
        this.tempoPermanencia = tempoPermanencia;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}