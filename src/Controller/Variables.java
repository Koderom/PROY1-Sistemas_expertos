/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Escalar;
import Model.Numerica;
import Model.Variable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MIRKO
 */
public class Variables {
    ArrayList<Variable> variables = new ArrayList<>();
    
    public Variables(){
    
    }
    public Variables(ArrayList<Variable> variables){
        this.variables = variables;
    }
    public void addVariableEscalar(String nombre, String descripcion, ArrayList<String> valores){
        if(exist(nombre)) return;
        Escalar nuevoEscalar = new Escalar(nombre, descripcion,valores);
        this.variables.add(nuevoEscalar);
        System.out.println(nuevoEscalar);
    }
    public void addVariableNumerica(String nombre, String descripcion, double min, double max, boolean hasMax, boolean hasMin){
        if(exist(nombre)) return;
        Numerica nuevoNumerica = new Numerica(nombre, descripcion);
        nuevoNumerica.setIntervalo(min, max);
        nuevoNumerica.hasIntervalo(hasMax, hasMin);
        this.variables.add(nuevoNumerica);
        System.out.println(nuevoNumerica);
    }
    public void removeVariable(String name){
        if(!exist(name))return;
        for(int i = 0 ; i < variables.size(); i++)  {
            Variable variable = variables.get(i);
            if(variable.getNombre().equals(name)){
                variables.remove(i);
                return;
            }
        }
    }
    public Variable getVariable(int index){
        return this.variables.get(index);
    }
    public void editarVariableNumerica(Variable variable, String nombre, String descripcion, double min, double max, boolean hasMax, boolean hasMin){
        if(!variable.getNombre().equals(nombre) && this.exist(nombre)){
            JOptionPane.showMessageDialog(null, "El nombre ya esta en uso por otra variable");
            return;
        }
        if(variable.getTipo() == 'E'){
            this.removeVariable(variable.getNombre());
            this.addVariableNumerica(nombre, descripcion, min, max, hasMax, hasMin);
        }else{
            Numerica varnum = (Numerica)this.getVariable(variable.getNombre());
            
            varnum.setNombre(nombre);
            varnum.setDescripcion(descripcion);
            varnum.setIntervalo(min, max);
            varnum.hasIntervalo(hasMax, hasMin);
        }
    }
    public void editarVariableEscalar(Variable variable, String nombre, String descripcion, ArrayList<String> valores){
        if(!variable.getNombre().equals(nombre) && this.exist(nombre)){
            JOptionPane.showMessageDialog(null, "El nombre ya esta en uso por otra variable");
            return;
        }
        if(variable.getTipo() == 'N'){
            this.removeVariable(variable.getNombre());
            this.addVariableEscalar(nombre, descripcion, valores);
        }else{
            Escalar varesca = (Escalar)this.getVariable(variable.getNombre());
            varesca.setNombre(nombre);
            varesca.setDescripcion(descripcion);
            varesca.setConjuntoValores(valores);
        }
    }
    public boolean exist(String nombre){
        for(Variable variable: variables)
            if(variable.getNombre().equals(nombre)) return true;
        return false;
    }
    public Variable getVariable(String name){
        for(Variable variable: variables)
            if(variable.getNombre().equals(name)) return variable;
        return null;
    }
    public ArrayList<Variable> getVariables(){
        return this.variables;
    }
    
    
    
}
