/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author MIRKO
 */
public class Hecho {
    private Variable variable;
    private Object valor;
    
    public Hecho( Variable variable, Object valor) throws IllegalArgumentException{
        this.variable = variable;
        if(this.variable.esUnValorValido(valor)) this.valor = valor;
        else throw new IllegalArgumentException("El valor no esta permitido o fuera de rango");
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        if(this.variable.esUnValorValido(valor)) this.valor = valor;
        else throw new IllegalArgumentException("El valor no esta permitido o fuera de rango");
    }

    public Variable getVariable() {
        return variable;
    }
    public boolean usaVariable(Variable variable){
        return variable.getNombre().equals(this.variable.getNombre());
    }
    public String toJson(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("variable", this.variable.getNombre());
        if(variable.getTipo() == 'N') jsonObj.put("valor", (double) valor);
        else if (variable.getTipo() == 'E') jsonObj.put("valor", (String) valor);
        else throw new ClassFormatError("El valor no esta permitido");
        return jsonObj.toString();
    }
    
    public JSONObject toJsonObject(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("variable", this.variable.getNombre());
        if(variable.getTipo() == 'N') jsonObj.put("valor", (double) valor);
        else if (variable.getTipo() == 'E') jsonObj.put("valor", (String) valor);
        else throw new ClassFormatError("El valor no esta permitido");
        return jsonObj;
    }
    
    public static Hecho hechoFromJson(JSONObject json_obj, ArrayList<Variable> variables){
        Variable variable = null;
        String var_name = json_obj.getString("variable");
        for(Variable v : variables) if(var_name.equals(v.getNombre())) variable = v;
        Object valor = null;
        if(variable.getTipo() == 'E') valor = json_obj.getString("valor");
        if(variable.getTipo() == 'N') valor = json_obj.getDouble("valor");
        
        return new Hecho(variable, valor);
    }
}
