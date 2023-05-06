/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author MIRKO
 */
 
public class Numerica extends Variable{
    private double minIntervalo;
    private double maxIntervalo;
    private boolean hasMinIntervalo;
    private boolean hasMaxIntervalo;
    
    public Numerica(String nombre) {
        this(nombre, "");
        this.maxIntervalo = Double.MAX_VALUE;
        this.minIntervalo = Double.MIN_VALUE;
        this.hasMinIntervalo = false;
        this.hasMaxIntervalo = false;
    }    
    public Numerica(String nombre, String descripcion) {
        super(nombre, descripcion, 'N');
    }
    
    public void setIntervalo(double min, double max){
        setMaxIntervalo(max);
        setMinIntervalo(min);
    }

    public double getMinIntervalo() {
        return minIntervalo;
    }

    public double getMaxIntervalo() {
        return maxIntervalo;
    }

    public boolean isHasMinIntervalo() {
        return hasMinIntervalo;
    }

    public boolean isHasMaxIntervalo() {
        return hasMaxIntervalo;
    }
    
    public void setMinIntervalo(double min){
        this.minIntervalo = min;
        this.hasMinIntervalo = true;
    }
    public void setMaxIntervalo(double max){
        this.maxIntervalo = max;
        this.hasMaxIntervalo = true;
    }
    public void activarMinIntervalo(){
        this.hasMinIntervalo = true;
    }
    public void activarMaxIntervalo(){
        this.hasMaxIntervalo = true;
    }
    public void desactivarMinIntervalo(){
        this.hasMinIntervalo = false;
    }
    public void desactivarMaxIntervalo(){
        this.hasMaxIntervalo = true;
    }
    public void hasIntervalo(boolean max, boolean min){
        this.hasMaxIntervalo = max;
        this.hasMinIntervalo = min;
    }
    public boolean isValorPermitido(Double valor){
        if(!(hasMinIntervalo && hasMaxIntervalo)) return true;
        
        boolean min = true;
        boolean max = true;
        if(hasMaxIntervalo) max = valor <= this.maxIntervalo;
        if(hasMinIntervalo) min = valor >= this.minIntervalo;
        return max && min;
    }
    public static Numerica NumericaFromJson(String json){
        JSONObject jsonObj = new JSONObject(json);
        String nombre = jsonObj.getString("nombre");
        String descripcion = jsonObj.getString("descripcion");
        Numerica numerica = new Numerica(nombre, descripcion);
        double min = jsonObj.getDouble("min");
        double max = jsonObj.getDouble("max");
        numerica.setIntervalo(min, max);
        if(!jsonObj.getBoolean("hasMin")) numerica.desactivarMinIntervalo();
        if(!jsonObj.getBoolean("hasMax")) numerica.desactivarMaxIntervalo();
        return numerica;
    }
    @Override
    public boolean esUnValorValido(Object valor) {
        if(!(valor instanceof Double)) return false;
        return isValorPermitido((Double)valor);
    }
    @Override
    public String toString(){
        return this.nombre;
    }
    @Override
    public String toJson() {
        JSONObject jsonObj = this.toJsonObject();
        return jsonObj.toString();
    }

    @Override
    public JSONObject toJsonObject() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("nombre", super.nombre);
        jsonObj.put("descripcion", super.descripcion);
        jsonObj.put("tipo", super.tipo);
        jsonObj.put("min", this.minIntervalo);
        jsonObj.put("max", this.maxIntervalo);
        jsonObj.put("hasMin", this.hasMinIntervalo);
        jsonObj.put("hasMax", this.hasMaxIntervalo);
        return jsonObj;
    }
    
    @Override
    public Variable clone(){
        return new Numerica(nombre, descripcion);
    }
}
