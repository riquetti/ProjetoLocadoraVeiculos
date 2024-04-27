/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setRg(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setId_municipio(rs.getInt("id_municipio"));
                cliente.setId_estado(rs.getInt("id_estado"));
                cliente.setCnh(rs.getString("cnh"));
                cliente.setCnhdatavencimento(rs.getDate("cnhdatavencimento"));
                cliente.setEmail_cliente(rs.getString("email_cliente"));

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
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setRg(rs.getString("rg"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setId_municipio(rs.getInt("id_municipio"));
                cliente.setId_estado(rs.getInt("id_estado"));
                cliente.setCnh(rs.getString("cnh"));
                cliente.setCnhdatavencimento(rs.getDate("cnhdatavencimento"));
                cliente.setEmail_cliente(rs.getString("email_cliente"));

                return cliente;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *
     * @param nome
     * @param rg
     * @param cpf
     * @param logradouro
     * @param id_municipio
     * @param id_estado
     * @param cnh
     * @param cnhdatavencimento
     * @param email_cliente
     * @return
     */
    public int insert(String nome, String rg, String cpf,
            String logradouro, int id_municipio, int id_estado,
            String cnh, Date cnhdatavencimento, String email_cliente) {
        String query = "INSERT INTO public.cliente "
                + "(nome_cliente, rg, cpf, logradouro, id_municipio, id_estado, cnh, cnhdatavencimento, email_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = Conexao.getConn().prepareStatement(query)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, rg);
            pstmt.setString(3, cpf);
            pstmt.setString(4, logradouro);
            pstmt.setInt(5, id_municipio);
            pstmt.setInt(6, id_estado);
            pstmt.setString(7, cnh);
            pstmt.setDate(8, new java.sql.Date(cnhdatavencimento.getTime()));
            pstmt.setString(9, email_cliente);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int update(int id, String nome, String rg, String cpf,
            String logradouro, int id_municipio, int id_estado,
            String cnh, Date cnhdatavencimento, String email_cliente) {
        String query = "UPDATE public.cliente SET "
                + "nome_cliente=?, rg=?, cpf=?, logradouro=?, id_municipio=?, id_estado=?, "
                + "cnh=?, cnhdatavencimento=?, email_cliente=? WHERE id=?";

        try (PreparedStatement pstmt = Conexao.getConn().prepareStatement(query)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, rg);
            pstmt.setString(3, cpf);
            pstmt.setString(4, logradouro);
            pstmt.setInt(5, id_municipio);
            pstmt.setInt(6, id_estado);
            pstmt.setString(7, cnh);
            pstmt.setDate(8, new java.sql.Date(cnhdatavencimento.getTime()));
            pstmt.setString(9, email_cliente);
            pstmt.setInt(10, id);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int delete(int id) {
        String query = String.format("""
                           DELETE FROM cliente
                            WHERE
                            id = %d;
                           """, id);

        try (Statement stmt = Conexao.getConn().createStatement();) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
