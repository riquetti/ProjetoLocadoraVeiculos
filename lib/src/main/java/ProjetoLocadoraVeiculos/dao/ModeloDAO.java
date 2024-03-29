/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Modelo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riquetti
 */
public class ModeloDAO {

    public List<Modelo> select() {
        List<Modelo> listaModelo = new ArrayList<>();
        String query = String.format("""
                       SELECT * FROM modelo;
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setId_fabricante(rs.getInt("id_fabricante"));
                modelo.setNome(rs.getString("nome"));

                listaModelo.add(modelo);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaModelo;
    }
    
    public Modelo select(int id) {
        String query = String.format("""
                       SELECT * FROM modelo WHERE id = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                Modelo modelo = new Modelo();
                modelo.setId(rs.getInt("id"));
                modelo.setId_fabricante(rs.getInt("id_fabricante"));
                modelo.setNome(rs.getString("nome"));

                return modelo;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int insert(int id_fabricante, String nome) {
        String query = String.format("""
                       INSERT INTO 
                       public.modelo
                       (id_fabricante, nome)
                       VALUES
                       (%d, '%s');
                       """,id_fabricante, nome);

        try (Statement stmt = Conexao.getConn().createStatement();) {
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int update(int id, String nome){
            String query = String.format("""
                           UPDATE public.modelo
                           SET 
                            nome = '%s'
                           WHERE
                            id= %d;
                           """, nome, id);

            try (Statement stmt = Conexao.getConn().createStatement();) {
                return stmt.executeUpdate(query);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } 
    
    public int delete(int id){
            String query = String.format("""
                           DELETE FROM modelo
                            WHERE
                            id= %d;
                           """, id);

            try (Statement stmt = Conexao.getConn().createStatement();) {
                return stmt.executeUpdate(query);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
}
