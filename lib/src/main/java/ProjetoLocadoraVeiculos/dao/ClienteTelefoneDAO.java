/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.ClienteTelefone;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riquetti
 */
public class ClienteTelefoneDAO {

    public List<ClienteTelefone> select() {
        List<ClienteTelefone> listaClienteTelefone = new ArrayList<>();
        String query = String.format("""
                       SELECT ct.id_telefone, ct.id_cliente,
                          ct.telefone, c.nome_cliente as cliente
                          from clientetelefone ct
                          INNER JOIN cliente c on ct.id_cliente = c.id;
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ClienteTelefone clienteTelefone = new ClienteTelefone();
                clienteTelefone.setId_telefone(rs.getInt("id_telefone"));
                clienteTelefone.setId_cliente(rs.getInt("id_cliente"));
                clienteTelefone.setTelefone(rs.getString("telefone"));
                clienteTelefone.setCliente(rs.getString("cliente"));

                listaClienteTelefone.add(clienteTelefone);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaClienteTelefone;
    }

    public ClienteTelefone select(int id) {
        String query = String.format("""
                       SELECT * FROM clientetelefone WHERE id_telefone = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                ClienteTelefone clienteTelefone = new ClienteTelefone();
                clienteTelefone.setId_telefone(rs.getInt("id_telefone"));
                clienteTelefone.setId_cliente(rs.getInt("id_cliente"));
                clienteTelefone.setTelefone(rs.getString("telefone"));

                return clienteTelefone;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
        public int insert(int idCliente, String telefoneCliente) {
        String query = String.format("""
                   INSERT INTO public.clientetelefone
                    (id_cliente, telefone)
                      VALUES
                       (%d, '%s');
                   """,  idCliente, telefoneCliente
        );

        try (Statement stmt = Conexao.getConn().createStatement()) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int update(int idCliente,
            String telefoneCliente, int id) {
        String query
                = "UPDATE public.clientetelefone SET "
                + "id_cliente=?, telefone=? WHERE id_telefone=?";

        try (PreparedStatement pstmt = Conexao.getConn().prepareStatement(query)) {
            pstmt.setInt(1, idCliente);
            pstmt.setString(2, telefoneCliente);
            pstmt.setInt(3, id);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        public int delete(int id) {
        String query = String.format("""
                           DELETE FROM clientetelefone
                            WHERE
                            id_telefone= %d;
                           """, id);

        try (Statement stmt = Conexao.getConn().createStatement();) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
