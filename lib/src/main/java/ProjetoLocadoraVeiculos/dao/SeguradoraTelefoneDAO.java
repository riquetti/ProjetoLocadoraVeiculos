/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Seguradora;
import ProjetoLocadoraVeiculos.entity.SeguradoraTelefone;
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
public class SeguradoraTelefoneDAO {

    public List<SeguradoraTelefone> select() {
        List<SeguradoraTelefone> listaSeguradoraTelefone = new ArrayList<>();
        String query = String.format("""
                       SELECT st.id_seguradora_telefone, st.id_seguradora,
                        st.telefone_seguradora, ss.nome as seguradora
                       from seguradoratelefone st
                       INNER JOIN seguradora ss on st.id_seguradora = ss.id_seguradora;              
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                SeguradoraTelefone seguradoraTelefone = new SeguradoraTelefone();
                seguradoraTelefone.setId_seguradora_telefone(rs.getInt("id_seguradora_telefone"));
                seguradoraTelefone.setId_seguradora(rs.getInt("id_seguradora"));
                seguradoraTelefone.setTelefone_seguradora(rs.getString("telefone_seguradora"));
                seguradoraTelefone.setNome_seguradora(rs.getString("seguradora"));

                listaSeguradoraTelefone.add(seguradoraTelefone);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaSeguradoraTelefone;
    }

    public SeguradoraTelefone select(int id) {
        String query = String.format("""
                       SELECT * FROM seguradoratelefone WHERE id_seguradora_telefone = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                SeguradoraTelefone seguradoraTelefone = new SeguradoraTelefone();
                seguradoraTelefone.setId_seguradora_telefone(rs.getInt("id_seguradora_telefone"));
                seguradoraTelefone.setId_seguradora(rs.getInt("id_seguradora"));
                seguradoraTelefone.setTelefone_seguradora(rs.getString("telefone_seguradora"));
//                seguradoraTelefone.setNome_seguradora(rs.getString("seguradora"));

                return seguradoraTelefone;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int insert(int idSeguradora, String telefoneSeguradora) {
        String query = String.format("""
                   INSERT INTO public.seguradoratelefone
                    (id_seguradora, telefone_seguradora)
                      VALUES
                       (%d, '%s');
                   """,  idSeguradora, telefoneSeguradora
        );

        try (Statement stmt = Conexao.getConn().createStatement()) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int update(int idSeguradora,
            String telefoneSeguradora, int id) {
        String query
                = "UPDATE public.seguradoratelefone SET "
                + "id_seguradora=?, telefone_seguradora=? WHERE id_seguradora_telefone=?";

        try (PreparedStatement pstmt = Conexao.getConn().prepareStatement(query)) {
            pstmt.setInt(1, idSeguradora);
            pstmt.setString(2, telefoneSeguradora);
            pstmt.setInt(3, id);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        public int delete(int id) {
        String query = String.format("""
                           DELETE FROM seguradoratelefone
                            WHERE
                            id_seguradora_telefone= %d;
                           """, id);

        try (Statement stmt = Conexao.getConn().createStatement();) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
