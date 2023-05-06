 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.Literal;
import Model.Regla;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MIRKO
 */
public class ReglasPanelForm extends javax.swing.JPanel {
    MainFrame parent;
    /**
     * Creates new form ReglasPanelForm
     */
    public ReglasPanelForm(JFrame parent) {
        initComponents();
        this.parent = (MainFrame)parent;
        this.cargarTablaReglas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reglas = new javax.swing.JTable();
        boton_nueva_regla = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boton_editar_variable = new javax.swing.JButton();
        boton_eliminar_variable = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        tabla_reglas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Premisa", "Conclusion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_reglas);

        boton_nueva_regla.setText("Nueva regla");
        boton_nueva_regla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_nueva_reglaActionPerformed(evt);
            }
        });

        jLabel2.setText("Reglas creadas:");

        boton_editar_variable.setText("Editar");
        boton_editar_variable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_editar_variableActionPerformed(evt);
            }
        });

        boton_eliminar_variable.setText("Eliminar");
        boton_eliminar_variable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminar_variableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_nueva_regla)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(boton_editar_variable)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(boton_eliminar_variable))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(boton_nueva_regla)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_eliminar_variable)
                    .addComponent(boton_editar_variable))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boton_nueva_reglaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_nueva_reglaActionPerformed
        if(parent.variables.getVariables() == null || parent.variables.getVariables().size() == 0){
            JOptionPane.showMessageDialog(null, "No existen variables, agrega algunas para poder agregar reglas");
            return;
        } 
        CreateRegla crearRegla = new CreateRegla(this.parent, true, this);
        crearRegla.setVisible(true);
    }//GEN-LAST:event_boton_nueva_reglaActionPerformed

    private void boton_eliminar_variableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminar_variableActionPerformed
        int index = tabla_reglas.getSelectedRow();
        if(index == -1) return;
        
        parent.reglas.removeRegla(index);
        cargarTablaReglas();
    }//GEN-LAST:event_boton_eliminar_variableActionPerformed

    private void boton_editar_variableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_editar_variableActionPerformed
        int index = tabla_reglas.getSelectedRow();
        Regla regla = this.parent.reglas.getRegla(index);
        
        EditRegla editar = new EditRegla(parent, true, regla, this, index);
        editar.setVisible(true);
    }//GEN-LAST:event_boton_editar_variableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_editar_variable;
    private javax.swing.JButton boton_eliminar_variable;
    private javax.swing.JButton boton_nueva_regla;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reglas;
    // End of variables declaration//GEN-END:variables
    
    public void cargarTablaReglas(){
        String[] columnas = {"Premisa", "Conclusion"};
        DefaultTableModel modelo_tabla = new DefaultTableModel();
        modelo_tabla.setColumnIdentifiers(columnas);
        this.tabla_reglas.setModel(modelo_tabla);
        
        ArrayList<Regla> variables_cargar = this.parent.reglas.getReglas();
        for(Regla regla : variables_cargar){
            String premisa = "";
            for(Literal literal : regla.getPremisa().getLiterales()){
                if(literal.isNot()) premisa += "¬";
                premisa += String.format("(%s \t %s \t%s)",
                        literal.getHecho().getVariable().getNombre(),
                        literal.getOprel(),
                        literal.getHecho().getValor().toString());
                premisa += " ^ ";
            }
            premisa = premisa.substring(0, premisa.length()-2);
            String conclusion = regla.getConclusion().getVariable().getNombre() + " = " + regla.getConclusion().getValor().toString();
            String[] data = {premisa, conclusion};
            modelo_tabla.addRow(data);
        }
    }
}
