/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos;

import ProjetoLocadoraVeiculos.gui.TelaPrincipal;

// criar validação dos campos de entrada
// padronizar as consultas na bibliotecas
// corrigir filtros em telas com mais de um combobox
// colocar os telefones na seguradora e no cliente

/**
 *
 * @author Riquetti
 */
public class Main {
    public static void main(String[] args) {
        Conexao.iniciarBanco("localhost", "5432", "projetolocadoracarros", "postgres", "postgres");
        
        TelaPrincipal form = new TelaPrincipal();
        form.setVisible(true);
    }
}
