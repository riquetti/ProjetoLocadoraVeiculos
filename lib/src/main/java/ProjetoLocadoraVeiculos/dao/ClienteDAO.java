/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riquetti
 */
public class ClienteDAO {

    public List<Cliente> select() {
        List<Cliente> listaCliente = new ArrayList<>();
        String query = String.format("""
                       SELECT * FROM cliente;
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setRg(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setId_municipio(rs.getInt("id_municipio"));
                cliente.setId_estado(rs.getInt("id_estado"));
                cliente.setCnh(rs.getString("cnh"));
                cliente.setData_nascimento(rs.getDate("data_nascimento"));
                cliente.setCnh(rs.getString("email"));

                listaCliente.add(cliente);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaCliente;
    }

    public Cliente select(int id) {
        String query = String.format("""
                       SELECT * FROM cliente WHERE id = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setRg(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setId_municipio(rs.getInt("id_municipio"));
                cliente.setId_estado(rs.getInt("id_estado"));
                cliente.setCnh(rs.getString("cnh"));
                cliente.setData_nascimento(rs.getDate("data_nascimento"));
                cliente.setCnh(rs.getString("email"));

                return cliente;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
