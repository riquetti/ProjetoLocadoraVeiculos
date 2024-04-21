/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.entity;

/**
 *
 * @author Riquetti
 */
public class Carro {
    private int id;
    private String placa;
    private String cor;
    private boolean disponivel;
    private int ano;
    private double valor_locacao;
    private int id_fabricante;
    private int idModelo;
    private String Fabricante;
    private String Modelo;

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorLocacao() {
        return valor_locacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valor_locacao = valorLocacao;
    }

    public int getIdFabricante() {
        return id_fabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.id_fabricante = idFabricante;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }
    
    
}
