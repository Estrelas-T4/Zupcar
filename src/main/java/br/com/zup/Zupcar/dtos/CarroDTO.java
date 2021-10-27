package br.com.zup.Zupcar.dtos;

public class CarroDTO {
    private String modelo;
    private String cor;
    private String motor;
    private int ano;

    public CarroDTO() {
    }

    public CarroDTO(String modelo, String cor, String motor, int ano) {
        this.modelo = modelo;
        this.cor = cor;
        this.motor = motor;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
