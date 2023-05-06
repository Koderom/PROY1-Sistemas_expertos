/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author MIRKO
 */
public class Escalar extends Variable{
    private ArrayList<String> conjuntoValores;
    
    public Escalar(String nombre) {
        super(nombre, 'E');
        this.conjuntoValores = new ArrayList<>();
    }
    public Escalar(String nombre, String descripcion) {
        super(nombre, descripcion, 'E');
        this.conjuntoValores = new ArrayList<>();
    }
    public Escalar(String nombre, String descripcion, ArrayList<String> conjuntoValores) {
        super(nombre, descripcion, 'E');
        this.conjuntoValores = conjuntoValores;
    }

    public List<String> getConjuntoValores() {
        return conjuntoValores;
    }

    public void setConjuntoValores(ArrayList<String> conjuntoValores) {
        this.conjuntoValores = conjuntoValores;
    }
    public void addValor(String valor){
        if(conjuntoValores.contains(valor)) return;
        conjuntoValores.add(valor);
    }
    public void removeValor(String valor){
        if(conjuntoValores.contains(valor)) return;
        conjuntoValores.remove(valor);
    }
    public boolean contiene(String valor){
        return this.conjuntoValores.contains(valor);
    }
    public static Escalar EscalarFromJson(String json){
        JSONObject jsonObj = new JSONObject(json);
        String nombre = jsonObj.getString("nombre");
        String descripcion = jsonObj.getString("descripcion");
        
        ArrayList<String> valorer = (ArrayList)jsonObj.getJSONArray("valores").toList();
        Escalar escalar = new Escalar(nombre, descripcion, valorer);
        return escalar;
    }
    @Override
    public String toString(){
        return nombre +" : "+ this.conjuntoValores;
    }

    @Override
    public boolean esUnValorValido(Object valor) {
        if(!(valor instanceof String)) return false;
        return this.contiene((String)valor);
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
        jsonObj.put("valores", this.conjuntoValores);
        return jsonObj;
    }
    @Override
    public Variable clone(){
        return new Escalar(nombre, descripcion, conjuntoValores);
    }
}
