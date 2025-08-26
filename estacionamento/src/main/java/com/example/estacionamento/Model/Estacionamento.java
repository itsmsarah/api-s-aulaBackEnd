package com.example.estacionamento.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.math.BigDecimal;

import java.math.RoundingMode;
//usa ele para definir como será  o arredondamento de números decimais com BigDecimal.
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="controle_carros")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "carro_id")
    private int carroId;

    @Column(name = "placa", nullable = false, length = 10)
    private String placa;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "horario_entrada")
    private LocalTime horarioEntrada;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "horario_saida")
    private LocalTime horarioSaida;

    @Column(name = "valor_hora", precision = 10, scale = 2)
    private BigDecimal valorHora = new BigDecimal("15.00");

    @Column(name = "valor_total", precision = 10, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "tempo_permanencia")
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

    //public void calcularHora() {
        //variavel temporaria so pra calcular
        //if (dataEntrada != null && horarioEntrada != null && dataSaida != null && horarioSaida != null ) {
            //long minutos = Duration.between( // e calcula a diferencia
                   // LocalDateTime.of(dataEntrada, horarioEntrada),
                  //  LocalDateTime.of(dataSaida, horarioSaida) // combina data e horario em Localdate
          //  ).toMinutes();//converte para minutos
     //   }


    @PrePersist
    @PreUpdate
    @JsonFormat(shape = JsonFormat.Shape.STRING) // serve para transformar a data em um data string para que fique certinho na hora de visualizar
    //a partir dessas anotações garante que sempre irá calcular antes de salvar ou atualizar
    public void calcularHora() {

        if (dataEntrada != null && horarioEntrada != null && dataSaida != null && horarioSaida != null && valorHora != null)
        //se todas essas variáveis forem diferentes de nulo, irá combinar da data e o horario em LocalDate
        //ou seja, garante que tudi isso esteja preenchido antes de realizar o cálcuko
        {
            LocalDateTime entrada = LocalDateTime.of(dataEntrada, horarioEntrada); // 1 junção
            LocalDateTime saida = LocalDateTime.of(dataSaida, horarioSaida); // 2 junção
            //junção da data e horario em dois objetos (LocalDateTime"

            long minutos = Duration.between(entrada, saida).toMinutes();
            //cria uma variavel muinutos, para ver a diferença  entre entrada e saida, ou seja a duração , e transforma em munitos
            this.tempoPermanencia = (int) minutos;
            //aqui ocorre o salvamento da permanência em minutos nesse atributo

            BigDecimal horas = new BigDecimal(minutos / 60.0).setScale(2, RoundingMode.HALF_UP);
            //converte os minutos em double, e aí como eu usei bigdecimal lá encima, preciso transformar para double novamente
            //mas para ficar certo, usa RoudingMode para o número ter 2 casas decimais


            this.valorTotal = valorHora.multiply(horas).setScale(2, RoundingMode.HALF_UP);// forçando dnv as casas decimais pq n foi
            //aqui ocorre a multiplicação do valor por hora pelo tempo que o carro ficou em horas
        }
    }


}
