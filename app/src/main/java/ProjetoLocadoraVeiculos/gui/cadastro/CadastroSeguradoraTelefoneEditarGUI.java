/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ProjetoLocadoraVeiculos.gui.cadastro;

import ProjetoLocadoraVeiculos.dao.SeguradoraDAO;
import ProjetoLocadoraVeiculos.dao.SeguradoraTelefoneDAO;
import ProjetoLocadoraVeiculos.entity.Seguradora;
import ProjetoLocadoraVeiculos.entity.SeguradoraTelefone;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Riquetti
 */
public class CadastroSeguradoraTelefoneEditarGUI extends javax.swing.JDialog {

    private SeguradoraTelefoneDAO dao = new SeguradoraTelefoneDAO();
    private SeguradoraTelefone seguradoraTelefoneEditar = null;
    private CadastroSeguradoraTelefoneGUI parentDialog;

    /**
     * Creates new form CadastroFabricanteEditarGUI
     */
    public CadastroSeguradoraTelefoneEditarGUI(java.awt.Frame parent, boolean modal, CadastroSeguradoraTelefoneGUI dialogParent) {
        super(parent, modal);
        parentDialog = dialogParent;

        initComponents();

        carregarComboSeguradoraNome();
    }

    

    public void carregarSeguradoraTelefone(int id) {
        seguradoraTelefoneEditar = dao.select(id);
       
        txtTelefone.setText(String.valueOf(seguradoraTelefoneEditar.getTelefone_seguradora()));

    }
    
    
    
    private void carregarComboSeguradoraNome() {
        SeguradoraDAO dao = new SeguradoraDAO();
        List<Seguradora> listaSeguradora = dao.select();

        Object[] items = new Object[listaSeguradora.size()];

        int contador = 0;

        for (Seguradora seguradora : listaSeguradora) {
            items[contador] = seguradora;

            contador++;
        }

        ComboBoxModel model = new DefaultComboBoxModel(items);

        cboSeguradora.setModel(model);
    }

    private void limparCampos() {
        txtTelefone.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jMenuItem1 = new javax.swing.JMenuItem();
        lblSeguradora = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        cboSeguradora = new javax.swing.JComboBox<>();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblSeguradora.setText("Seguradora");

        lblTelefone.setText("Telefone");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 316, Short.MAX_VALUE)
                                .addComponent(btnFechar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(52, 52, 52)
                                            .addComponent(btnSalvar))
                                        .addComponent(lblTelefone))
                                    .addComponent(lblSeguradora))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboSeguradora, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblSeguradora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboSeguradora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (seguradoraTelefoneEditar == null) {

            String nome = txtTelefone.getText();

            Seguradora seguradoraSelecionado = (Seguradora) cboSeguradora.getModel().getSelectedItem();

            int id_seguradora = seguradoraSelecionado.getId();

            try {
                dao.insert(id_seguradora, nome);
                JOptionPane.showMessageDialog(this, "Telefone Inserido com Sucesso!", "SUCESS", JOptionPane.INFORMATION_MESSAGE);

                parentDialog.carregarListaTelefone();

                limparCampos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            String telefoneSeguradora = txtTelefone.getText();

            Seguradora seguradoraSelecionado = (Seguradora) cboSeguradora.getModel().getSelectedItem();

            int id_seguradora = seguradoraSelecionado.getId();

            int id = seguradoraTelefoneEditar.getId_seguradora_telefone();

            try {
                dao.update(id_seguradora, telefoneSeguradora, id);
                JOptionPane.showMessageDialog(this, "Telefone da Seguradora Editado com Sucesso!", "SUCESS", JOptionPane.INFORMATION_MESSAGE);

                parentDialog.carregarListaTelefone();

                this.dispose();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cboSeguradora;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel lblSeguradora;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
