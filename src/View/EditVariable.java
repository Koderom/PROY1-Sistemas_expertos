/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Controller.Variables;
import Model.Escalar;
import Model.Numerica;
import Model.Variable;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author MIRKO
 */
public class EditVariable extends javax.swing.JDialog {
    Variables variables;
    Variable variable;
    VariablesPanelForm parenPanel;
    DefaultListModel<String> modelo = new DefaultListModel<>();
    /**
     * Creates new form EditVariable
     */
    public EditVariable(java.awt.Frame parent, boolean modal, JPanel parenPanel, Variable variable) {
        super(parent, modal);
        initComponents();
        this.parenPanel = (VariablesPanelForm)parenPanel;
        this.variable = variable.clone();
        this.variables = this.parenPanel.variables;
        this.lista_valores.setModel(modelo);
        cargarDatos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        valoresNumerica = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        limite_sup = new javax.swing.JTextField();
        limite_inf = new javax.swing.JTextField();
        limite_sup_activar = new javax.swing.JCheckBox();
        limite_inf_activar = new javax.swing.JCheckBox();
        tipo_variable = new javax.swing.JComboBox<>();
        nombre_variable = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        descripcion_variable = new javax.swing.JTextField();
        valoresEscalar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        valor_variable = new javax.swing.JTextField();
        adicion_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_valores = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Editar variable");

        jLabel2.setText("Nombre");

        jLabel3.setText("Tipo");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Limite superior");

        jLabel7.setText("Limite inferior");

        limite_sup.setText("100.0");

        limite_inf.setText("0.0");

        limite_sup_activar.setSelected(true);
        limite_sup_activar.setText("activar");

        limite_inf_activar.setSelected(true);
        limite_inf_activar.setText("activar");

        javax.swing.GroupLayout valoresNumericaLayout = new javax.swing.GroupLayout(valoresNumerica);
        valoresNumerica.setLayout(valoresNumericaLayout);
        valoresNumericaLayout.setHorizontalGroup(
            valoresNumericaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valoresNumericaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(valoresNumericaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(valoresNumericaLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limite_inf))
                    .addGroup(valoresNumericaLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limite_sup, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valoresNumericaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limite_sup_activar)
                    .addComponent(limite_inf_activar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        valoresNumericaLayout.setVerticalGroup(
            valoresNumericaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valoresNumericaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(valoresNumericaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(limite_sup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limite_sup_activar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(valoresNumericaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(limite_inf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limite_inf_activar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tipo_variable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numerica", "Escalar" }));
        tipo_variable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_variableActionPerformed(evt);
            }
        });

        jLabel4.setText("Descripcion");

        jLabel5.setText("Valor");

        adicion_btn.setText("Agregar");
        adicion_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicion_btnActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lista_valores);

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout valoresEscalarLayout = new javax.swing.GroupLayout(valoresEscalar);
        valoresEscalar.setLayout(valoresEscalarLayout);
        valoresEscalarLayout.setHorizontalGroup(
            valoresEscalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valoresEscalarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valoresEscalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(valoresEscalarLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valor_variable, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(adicion_btn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, valoresEscalarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        valoresEscalarLayout.setVerticalGroup(
            valoresEscalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valoresEscalarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valoresEscalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(valor_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicion_btn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(valoresNumerica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valoresEscalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nombre_variable))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(descripcion_variable))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tipo_variable, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5)))))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(descripcion_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tipo_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(valoresEscalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valoresNumerica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tipo = tipo_variable.getSelectedItem().toString();
        if(tipo == "Numerica") this.editarVariableNumerica();
        else this.editarVariableEscalar();
        VariablesPanelForm name = this.parenPanel;
        name.cargarDatosTabla();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tipo_variableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_variableActionPerformed
       
    }//GEN-LAST:event_tipo_variableActionPerformed

    private void adicion_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicion_btnActionPerformed
        String new_value = this.valor_variable.getText();
        for(int i = 0; i < modelo.getSize(); i++){
            if(modelo.get(i).equals(new_value)){
                JOptionPane.showMessageDialog(null, "El valor ya existe en la lista");
                return;
            }
        } 
        this.modelo.addElement(new_value);
    }//GEN-LAST:event_adicion_btnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = this.lista_valores.getSelectedIndex();
        
        this.modelo.remove(index);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditVariable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditVariable dialog = new EditVariable(new javax.swing.JFrame(), true, null , null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicion_btn;
    private javax.swing.JTextField descripcion_variable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField limite_inf;
    private javax.swing.JCheckBox limite_inf_activar;
    private javax.swing.JTextField limite_sup;
    private javax.swing.JCheckBox limite_sup_activar;
    private javax.swing.JList<String> lista_valores;
    private javax.swing.JTextField nombre_variable;
    private javax.swing.JComboBox<String> tipo_variable;
    private javax.swing.JTextField valor_variable;
    private javax.swing.JPanel valoresEscalar;
    private javax.swing.JPanel valoresNumerica;
    // End of variables declaration//GEN-END:variables

    private void desabilitarJpanel(JPanel panel){
        Component[] components = panel.getComponents();
        for(Component componente : components) componente.setEnabled(false);
        panel.setEnabled(false);
    }
    private void habilitarJpanel(JPanel panel){
        Component[] components = panel.getComponents();
        for(Component componente : components) componente.setEnabled(true);
        panel.setEnabled(true);
    }
    private void cargarDatos() {
        this.nombre_variable.setText(variable.getNombre());
        this.descripcion_variable.setText(variable.getDescripcion());
        if(this.variable.getTipo() == 'E'){
            desabilitarJpanel(valoresNumerica);
            habilitarJpanel(valoresEscalar);
            this.tipo_variable.setSelectedIndex(1);
            List<String> valores = ((Escalar)variable).getConjuntoValores();
            for(String elem : valores)this.modelo.addElement(elem);
        }else{
            habilitarJpanel(valoresNumerica);
            desabilitarJpanel(valoresEscalar);
            this.tipo_variable.setSelectedIndex(0);
            this.limite_sup.setText(String.valueOf(((Numerica)variable).getMaxIntervalo()));
            this.limite_inf.setText(String.valueOf(((Numerica)variable).getMinIntervalo()));
            this.limite_sup_activar.setSelected(((Numerica)variable).isHasMaxIntervalo());
            this.limite_inf_activar.setSelected(((Numerica)variable).isHasMinIntervalo());
        }
    }
    private void editarVariableNumerica() {
        String nombre = this.nombre_variable.getText();
        if(nombre.length() == 0) JOptionPane.showMessageDialog(null, "El campo nombre es requerido");
        String descripcion = this.descripcion_variable.getText();
        boolean lim_sup = this.limite_sup_activar.isSelected();
        boolean lim_inf = this.limite_inf_activar.isSelected();
        String regex = "^-?\\d+(\\.\\d+)?$";
        if(!this.limite_sup.getText().matches(regex)) JOptionPane.showMessageDialog(null, "Formato del campo Limite superior no es el correcto");
        else if(!this.limite_inf.getText().matches(regex)) JOptionPane.showMessageDialog(null, "Formato del campo Limite inferior no es el correcto");
        else{
            double max = Double.parseDouble(this.limite_sup.getText());
            double min = Double.parseDouble(this.limite_inf.getText());
            if(max < min && lim_sup && lim_inf){
                JOptionPane.showMessageDialog(null, "Limite superior es menor al limite inferior");
                return;
            }
            ((MainFrame)this.getParent()).variables.editarVariableNumerica(variable, nombre, descripcion, min, max, lim_sup, lim_inf);
        }
    }

    private void editarVariableEscalar() {
        String nombre = this.nombre_variable.getText();
        if(nombre.length() == 0) JOptionPane.showConfirmDialog(null, "El campo nombre es requerido");
        String descripcion = this.descripcion_variable.getText();
        ArrayList<String> valores = new ArrayList<>();
        for(int i = 0; i < this.lista_valores.getModel().getSize(); i++) 
            valores.add(this.lista_valores.getModel().getElementAt(i));
        ((MainFrame)this.getParent()).variables.editarVariableEscalar(variable, nombre, descripcion, valores);
    }
}
