/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Seguradora;
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
public class SeguradoraDAO {

    public List<Seguradora> select() {
        List<Seguradora> listaSeguradora = new ArrayList<>();
        String query = String.format("""
                       SELECT s.id_seguradora, s.nome, s.cnpj , s.email ,
                         s.valor , s.id_municipio, s.id_estado,
                          m.descricao AS municipio ,
                          e.descricao AS estado 
                        FROM seguradora s
                        INNER JOIN municipio m on s.id_municipio = m.id_municipio
                        INNER JOIN estado e on s.id_estado = e.id_estado;              
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Seguradora seguradora = new Seguradora();
                seguradora.setId(rs.getInt("id_seguradora"));
                seguradora.setNome(rs.getString("nome"));
                seguradora.setCnpj(rs.getString("cnpj"));
                seguradora.setEmail(rs.getString("email"));
                seguradora.setValor(rs.getDouble("valor"));
                seguradora.setId_municipio(rs.getInt("id_municipio"));
                seguradora.setId_estado(rs.getInt("id_estado"));
                seguradora.setMunicipio(rs.getString("municipio"));
                seguradora.setEstado(rs.getString("estado"));

                listaSeguradora.add(seguradora);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaSeguradora;
    }

    public Seguradora select(int id) {
        String query = String.format("""
                       SELECT * FROM seguradora WHERE id_seguradora = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                Seguradora seguradora = new Seguradora();
                seguradora.setId(rs.getInt("id_seguradora"));
                seguradora.setNome(rs.getString("nome"));
                seguradora.setCnpj(rs.getString("cnpj"));
                seguradora.setEmail(rs.getString("email"));
                seguradora.setValor(rs.getDouble("valor"));
                seguradora.setId_municipio(rs.getInt("id_municipio"));
                seguradora.setId_estado(rs.getInt("id_estado"));

                return seguradora;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int insert(String nome, String cnpj, String email,
            double valor, int id_municipio, int id_estado) {
        String query = String.format("""
                   INSERT INTO public.seguradora 
                    (nome, cnpj, email, valor, id_municipio, id_estado)
                      VALUES
                       ('%s', '%s', '%s', %s, %d, %d);
                   """, nome, cnpj, email, valor,
                id_municipio, id_estado);

        try (Statement stmt = Conexao.getConn().createStatement()) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int update(String nome, String cnpj, String email,
            double valor, int id_municipio, int id_estado, int id) {
        String query = 
                "UPDATE public.seguradora SET nome=?, cnpj=?, email=?, valor=?, id_municipio=?, id_estado=? WHERE id_seguradora=?";

        try (PreparedStatement pstmt = Conexao.getConn().prepareStatement(query)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, cnpj);
            pstmt.setString(3, email);
            pstmt.setDouble(4, valor);
            pstmt.setInt(5, id_municipio);
            pstmt.setInt(6, id_estado);
            pstmt.setInt(7, id);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int delete(int id) {
        String query = String.format("""
                           DELETE FROM seguradora
                            WHERE
                            id_seguradora= %d;
                           """, id);

        try (Statement stmt = Conexao.getConn().createStatement();) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }    
}
