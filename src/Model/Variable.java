/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import org.json.JSONObject;


/**
 *
 * @author MIRKO
 */
public abstract class Variable {
    String nombre;
    String descripcion;
    char  tipo;
    
    public Variable(String nombre, char tipo) {
        this(nombre, "", tipo);
    }
    public Variable(String nombre, String descripcion, char tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;    
    }
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public char getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    public static Variable VariableFromJson(String json){
        JSONObject jsonObj = new JSONObject(json);
        char tipo = (char)jsonObj.getInt("tipo");
        switch (tipo) {
            case 'N':
                return Numerica.NumericaFromJson(json);
            case 'E':
                return Escalar.EscalarFromJson(json);
            default:
                return null;
        }
    }
    
    public abstract Variable clone();
    public abstract boolean esUnValorValido(Object valor);
    public abstract String toJson();
    public abstract JSONObject toJsonObject();
}
