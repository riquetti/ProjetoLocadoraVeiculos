/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author Riquetti
 */
public class CarroDAO {

    public List<Carro> select() {
        List<Carro> listaCarro = new ArrayList<>();
        String query = String.format("""
                       SELECT c.id, c.placa, c.cor, c.disponivel, c.ano,
                            c.valorlocacao, c.id_fabricante, c.id_modelo,
                            f.nome AS fabricante, m.nome AS modelo
                       FROM carro c
                       INNER JOIN fabricante f ON c.id_fabricante = f.id
                       INNER JOIN modelo m ON c.id_modelo = m.id;
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("id"));
                carro.setPlaca(rs.getString("placa"));
                carro.setCor(rs.getString("cor"));
                carro.setDisponivel(rs.getBoolean("disponivel"));
                carro.setAno(rs.getInt("ano"));
                carro.setValorLocacao(rs.getDouble("valorlocacao"));
                carro.setIdFabricante(rs.getInt("id_fabricante"));
                carro.setIdModelo(rs.getInt("id_modelo"));
                carro.setFabricante(rs.getString("fabricante"));
                carro.setModelo(rs.getString("modelo"));

                listaCarro.add(carro);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaCarro;
    }

    public Carro select(int id) {
        String query = String.format("""
                       SELECT * FROM carro WHERE id = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("id"));
                carro.setPlaca(rs.getString("placa"));
                carro.setCor(rs.getString("cor"));
                carro.setDisponivel(rs.getBoolean("disponivel"));
                carro.setAno(rs.getInt("ano"));
                carro.setValorLocacao(rs.getDouble("valorlocacao"));
                carro.setIdFabricante(rs.getInt("id_fabricante"));
                carro.setIdModelo(rs.getInt("id_modelo"));

                return carro;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int insert(String placa, String cor, boolean disponivel,
                  int ano, double valorLocacao, int idFabricante, int idModelo) {
    String disponivelStr = disponivel ? "true" : "false";
    String valorLocacaoFormatted = String.format(Locale.US, "%.2f", valorLocacao);
    String query = String.format("""
                   INSERT INTO public.carro 
                   (placa, cor, disponivel, ano, valorlocacao, id_fabricante, id_modelo)
                   VALUES
                   ('%s', '%s', %s, %d, %s, %d, %d);
                   """, placa, cor, disponivelStr, ano,
                   valorLocacaoFormatted, idFabricante, idModelo);

    try (Statement stmt = Conexao.getConn().createStatement()) {
        return stmt.executeUpdate(query);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}


public int update(String placa, String cor, boolean disponivel,
    Integer ano, Double valorLocacao, Integer idFabricante, Integer idModelo, int id) {
    String query = "UPDATE public.carro SET placa=?, cor=?, disponivel=?, ano=?, valorlocacao=?, id_fabricante=?, id_modelo=? WHERE id=?";

    try (PreparedStatement pstmt = Conexao.getConn().prepareStatement(query)) {
        pstmt.setString(1, placa);
        pstmt.setString(2, cor);
        pstmt.setBoolean(3, disponivel);
        pstmt.setInt(4, ano);
        pstmt.setDouble(5, valorLocacao);
        pstmt.setInt(6, idFabricante);
        pstmt.setInt(7, idModelo);
        pstmt.setInt(8, id);

        return pstmt.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}


    public int delete(int id) {
        String query = String.format("""
                           DELETE FROM carro
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
