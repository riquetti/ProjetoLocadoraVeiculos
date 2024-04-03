/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Municipio;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riquetti
 */
public class MunicipioDAO {
    public List<Municipio> select() {
        List<Municipio> listaMunicipio = new ArrayList<>();
        String query = String.format("""
                       select m.id_municipio, m.descricao, m.id_estado ,e.descricao as estado
                       from municipio m
                       inner join estado e 
                       on m.id_estado = e.id_estado;
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Municipio municipio = new Municipio();
                municipio.setId_municipio(rs.getInt("id_estado"));
                municipio.setDescricao(rs.getString("descricao"));
                municipio.setId_estado(rs.getInt("id_estado"));
                municipio.setEstado(rs.getString("estado"));

                listaMunicipio.add(municipio);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaMunicipio;
    }
    
    public Municipio select(int id) {
        String query = String.format("""
                       SELECT * FROM municipio WHERE id = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                Municipio municipio = new Municipio();
                municipio.setId_municipio(rs.getInt("id_estado"));
                municipio.setDescricao(rs.getString("descricao"));
                municipio.setId_estado(rs.getInt("id_estado"));
                municipio.setEstado(rs.getString("estado"));

                return municipio;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
