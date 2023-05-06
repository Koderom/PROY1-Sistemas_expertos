/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import Model.Escalar;
import Model.Hecho;
import Model.Literal;
import Model.Minterm;
import Model.Numerica;
import Model.OPREL;
import Model.Regla;
import Model.Variable;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author MIRKO
 */
public class EditRegla extends javax.swing.JDialog {
    Regla regla;
    ReglasPanelForm panelParent;
    MainFrame parent;
    int index;
    ArrayList<Literal> minterms = new ArrayList<>();
    /**
     * Creates new form EditRegla
     */
    public EditRegla(java.awt.Frame parent, boolean modal, Regla regla, ReglasPanelForm panelParent, int index) {
        super(parent, modal);
        initComponents();
        this.index = index;
        this.regla = regla.clone();
        this.panelParent = panelParent;
        this.parent = (MainFrame) parent;
        
        minterms = regla.getPremisa().getLiterales();
        cargarVariable();
        cargarConclusionVariables();
        cargarConclsionValores(opciones_conclusion_variable.getItemAt(0));
        cargarOprel(opciones_variable.getItemAt(0));
        cargarListaMinterms();
        cargarConclusion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opciones_conclusion_variable = new javax.swing.JComboBox<>();
        input_conclusion = new javax.swing.JTextField();
        opciones_valor_conclusion = new javax.swing.JComboBox<>();
        boton_guardar = new javax.swing.JButton();
        rango_valor_conclusion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        opciones_variable = new javax.swing.JComboBox<>();
        opciones_oprel = new javax.swing.JComboBox<>();
        opciones_valores = new javax.swing.JComboBox<>();
        input_valor = new javax.swing.JTextField();
        check_not = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_premisa = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        text_rango = new javax.swing.JLabel();
        boton_borrar_literal = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        opciones_conclusion_variable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opciones_conclusion_variableActionPerformed(evt);
            }
        });

        opciones_valor_conclusion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opciones_valor_conclusionActionPerformed(evt);
            }
        });

        boton_guardar.setText("Guardar");
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Crear nueva Regla");

        jLabel2.setText("Premisa:");

        opciones_variable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opciones_variableActionPerformed(evt);
            }
        });

        opciones_valores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opciones_valoresActionPerformed(evt);
            }
        });

        check_not.setText("NOT");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lista_premisa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(lista_premisa);

        jLabel3.setText("Minterms");

        boton_borrar_literal.setText("Borrar");
        boton_borrar_literal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_borrar_literalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(575, 575, 575))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(check_not)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opciones_variable, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opciones_oprel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(text_rango, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(input_valor, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opciones_valores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(boton_borrar_literal))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opciones_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opciones_oprel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opciones_valores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_not)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(text_rango, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_borrar_literal)))
                .addGap(18, 18, 18))
        );

        jLabel4.setText("Conclusion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opciones_conclusion_variable, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rango_valor_conclusion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input_conclusion, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opciones_valor_conclusion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(boton_guardar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opciones_conclusion_variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_conclusion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opciones_valor_conclusion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(boton_guardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(rango_valor_conclusion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opciones_conclusion_variableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opciones_conclusion_variableActionPerformed
        String valor = opciones_conclusion_variable.getSelectedItem().toString();
        cargarConclsionValores(valor);
    }//GEN-LAST:event_opciones_conclusion_variableActionPerformed

    private void opciones_valor_conclusionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opciones_valor_conclusionActionPerformed
        String valor = opciones_valor_conclusion.getSelectedItem().toString();
        input_conclusion.setText(valor);
    }//GEN-LAST:event_opciones_valor_conclusionActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        try{
            Minterm premisa = new Minterm(minterms);

            String val = input_conclusion.getText();;
            String nombre = opciones_conclusion_variable.getSelectedItem().toString();
            Variable variable = parent.variables.getVariable(nombre);

            Object valor = null;
            if(variable.getTipo() == 'N') valor = Double.parseDouble(val);
            else valor = val;
            Hecho conclusion = new Hecho(variable, valor);

            parent.reglas.editRegla(index, premisa, conclusion);
            panelParent.cargarTablaReglas();
            this.setVisible(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_boton_guardarActionPerformed

    private void opciones_variableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opciones_variableActionPerformed
        String valor = opciones_variable.getSelectedItem().toString();
        cargarValores(valor);
    }//GEN-LAST:event_opciones_variableActionPerformed

    private void opciones_valoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opciones_valoresActionPerformed
        input_valor.setText(opciones_valores.getSelectedItem().toString());
    }//GEN-LAST:event_opciones_valoresActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //adicionar literales a los minterms
        try{
            boolean isnot = check_not.isSelected();
            Variable variable = parent.variables.getVariable(opciones_variable.getSelectedItem().toString());
            OPREL opre = OPREL.valueOf(opciones_oprel.getSelectedItem().toString());
            Object valor = null;
            if(variable.getTipo() == 'E') valor = opciones_valores.getSelectedItem().toString();
            else{
                String regex = "^-?\\d+(\\.\\d+)?$";
                if(!input_valor.getText().matches(regex)) JOptionPane.showMessageDialog(null, "El valor no cuenta con el formato requerido");
                else valor = Double.valueOf(input_valor.getText());
            }
            Literal nuevoLiteral = new Literal(variable, valor, opre, isnot);
            this.minterms.add(nuevoLiteral);
            cargarListaMinterms();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void boton_borrar_literalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_borrar_literalActionPerformed
        int index = lista_premisa.getSelectedIndex();
        this.minterms.remove(index);
        this.cargarListaMinterms();
    }//GEN-LAST:event_boton_borrar_literalActionPerformed

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
            java.util.logging.Logger.getLogger(EditRegla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRegla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRegla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRegla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditRegla dialog = new EditRegla(new javax.swing.JFrame(), true, null, null,0);
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
    private javax.swing.JButton boton_borrar_literal;
    private javax.swing.JButton boton_guardar;
    private javax.swing.JCheckBox check_not;
    private javax.swing.JTextField input_conclusion;
    private javax.swing.JTextField input_valor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista_premisa;
    private javax.swing.JComboBox<String> opciones_conclusion_variable;
    private javax.swing.JComboBox<String> opciones_oprel;
    private javax.swing.JComboBox<String> opciones_valor_conclusion;
    private javax.swing.JComboBox<String> opciones_valores;
    private javax.swing.JComboBox<String> opciones_variable;
    private javax.swing.JLabel rango_valor_conclusion;
    private javax.swing.JLabel text_rango;
    // End of variables declaration//GEN-END:variables
    
    private void cargarVariable() {
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        opciones_variable.setModel(model);
        for(Variable variable : parent.variables.getVariables())
            model.addElement(variable.getNombre());
        
        
    }

    private void cargarOprel(String seleccionado) {
        System.out.println(seleccionado);
        Variable variable = parent.variables.getVariable(seleccionado);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        opciones_oprel.setModel(model);
        if(variable.getTipo() == 'N'){
            for(OPREL oprel : OPREL.values()){
                model.addElement(oprel);
            }
        }else{
            model.addElement(OPREL.IGUAL);
        }
    }

    private void cargarValores(String nombre) {
        opciones_valores.setEnabled(true);
        Variable variable = parent.variables.getVariable(nombre);
        if(variable.getTipo() == 'N'){
            opciones_valores.setEnabled(false);
            Numerica varnum = (Numerica)variable;
            String restriccion = "";
            if(varnum.isHasMaxIntervalo()) restriccion = "max: "+varnum.getMaxIntervalo();
            if(varnum.isHasMinIntervalo()) restriccion += ", min: "+varnum.getMinIntervalo();
            text_rango.setText(restriccion);
            input_valor.setText("");
        }else{
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            opciones_valores.setModel(model);
            for(String valor : ((Escalar)variable).getConjuntoValores()){
                model.addElement(valor);
            }
            input_valor.setText(opciones_valores.getItemAt(0));
            text_rango.setText("");
        }
        
        cargarOprel(nombre);
    }

    private void cargarListaMinterms() {
        try{
            DefaultListModel model = new DefaultListModel();
            lista_premisa.setModel(model);
            for(Literal literal : minterms){
                String elemento = "";
                if(literal.isNot()) elemento += "¬";
                elemento += String.format("(%s \t %s \t%s)",
                        literal.getHecho().getVariable().getNombre(),
                        literal.getOprel(),
                        literal.getHecho().getValor().toString());
                model.addElement(elemento);
            }
        }catch(Exception e){
            
        }
        
    }

    private void cargarConclusionVariables() {
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        opciones_conclusion_variable.setModel(model);
        for(Variable variable : parent.variables.getVariables())
            model.addElement(variable.getNombre());
    }

    private void cargarConclsionValores(String nombre) {
        opciones_valor_conclusion.setEnabled(true);
        Variable variable = parent.variables.getVariable(nombre);
        if(variable.getTipo() == 'N'){
            opciones_valor_conclusion.setEnabled(false);
            Numerica varnum = (Numerica)variable;
            String restriccion = "";
            if(varnum.isHasMaxIntervalo()) restriccion = "max: "+varnum.getMaxIntervalo();
            if(varnum.isHasMinIntervalo()) restriccion += ", min: "+varnum.getMinIntervalo();
            rango_valor_conclusion.setText(restriccion);
            input_conclusion.setText("");
        }else{
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            opciones_valor_conclusion.setModel(model);
            for(String valor : ((Escalar)variable).getConjuntoValores()){
                model.addElement(valor);
            }
            rango_valor_conclusion.setText("");
            input_conclusion.setText(opciones_valor_conclusion.getItemAt(0));
        }
        
    }

    private void cargarConclusion() {
        int index = 0;
        for(Variable variable : this.parent.variables.getVariables()){
            if(variable.getNombre().equals(regla.getConclusion().getVariable().getNombre())) break;
            else index++;
        }
        this.opciones_conclusion_variable.setSelectedIndex(index);
        input_conclusion.setText( regla.getConclusion().getValor().toString());
        Variable variab = parent.variables.getVariables().get(index);
        if(variab.getTipo() == 'N'){
            Numerica varnum = (Numerica)variab;
            String restriccion = "";
            if(varnum.isHasMaxIntervalo()) restriccion = "max: "+varnum.getMaxIntervalo();
            if(varnum.isHasMinIntervalo()) restriccion += ", min: "+varnum.getMinIntervalo();
            rango_valor_conclusion.setText(restriccion);
        }else{
            int indexval = 0;
            for(String valor: ((Escalar)variab).getConjuntoValores()){
                if(valor == regla.getConclusion().getValor().toString()) break;
                indexval++;
            }
            opciones_valor_conclusion.setSelectedIndex(indexval);
        }
        
    }
    
}