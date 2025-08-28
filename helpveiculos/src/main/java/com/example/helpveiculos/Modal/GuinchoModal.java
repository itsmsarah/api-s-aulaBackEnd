package com.example.helpveiculos.Modal;

import jakarta.persistence.*;


@Entity
@Table(name="cliente")

public class GuinchoModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "cliente_id")
    private int clienteId;

    @Column(name = "placa_veiculo", nullable = false, length = 7)
    private String placaVeiculo;
    //nullable = false	O campo não pode ser nulo no banco (equivale a NOT NULL no SQL)

    @Column(name="nome_cliente")
    private String nomeCliente;

    @Column(name="nmr_celular")
    private String nmrCelular;

    @Column(name="endereco")
    private String endereco;

    @Column(name="cidade")
    private String cidade;


    public GuinchoModal (){

    }

    public GuinchoModal(int clienteId, String placaVeiculo, String nomeCliente, String nmrCelular, String endereco, String cidade) {
        this.clienteId = clienteId;
        this.placaVeiculo = placaVeiculo;
        this.nomeCliente = nomeCliente;
        this.nmrCelular = nmrCelular;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNmrCelular() {
        return nmrCelular;
    }

    public void setNmrCelular(String nmrCelular) {
        this.nmrCelular = nmrCelular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
