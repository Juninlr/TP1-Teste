package br.unitins.tp1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Memoria extends DefaultEntity {
    
    private String marca;
    private String modelo;
    private String gigas;
    private String velocidade;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getGigas() {
        return gigas;
    }
    public void setGigas(String gigas) {
        this.gigas = gigas;
    }
    public String getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }  

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
