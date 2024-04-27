/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.entity;

import java.time.LocalDate;

/**
 *
 * @author Riquetti
 */
public class Cliente {

    private int id;
    private String nome_cliente;
    private String rg;
    private String cpf;
    private String logradouro;
    private int id_municipio;
    private int id_estado;
    private String cnh;
    private LocalDate cnhdatavencimento;
    private String email_cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome_cliente;
    }

    public void setNome(String nome) {
        this.nome_cliente = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public LocalDate getCnhdatavencimento() {
        return cnhdatavencimento;
    }

    public void setCnhdatavencimento(java.sql.Date data) {
        if (data != null) {
            this.cnhdatavencimento = data.toLocalDate();
        } else {
            this.cnhdatavencimento = null;
        }
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email) {
        this.email_cliente = email;
    }

}
