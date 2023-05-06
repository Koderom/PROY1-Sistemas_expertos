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
public class Literal {
    Hecho hecho;
    OPREL oprel;
    boolean not;
    
    public Literal(Hecho hecho, OPREL oprel){
        this.hecho = hecho;
        if(hecho.getVariable().getTipo() == 'N') this.oprel = oprel;
        else if(oprel != OPREL.IGUAL) throw new IllegalArgumentException("El operador relacional no aplica para una variable tipo Escalar");
        else this.oprel = oprel;
    }
    public Literal(Variable variable, Object valor, OPREL oprel){
        Hecho hecho = new Hecho(variable, valor);
        this.hecho = hecho;
        this.oprel = oprel;
    }
    public Literal(Variable variable, Object valor, OPREL oprel, boolean not){
        this(variable, valor, oprel);
        this.not = not;
    }
    public Literal(Hecho hecho, OPREL oprel, boolean not){
        this(hecho, oprel);
        this.not = not;
    }

    public Hecho getHecho() {
        return hecho;
    }

    public OPREL getOprel() {
        return oprel;
    }

    public boolean isNot() {
        return not;
    }
    public boolean usaVariable(Variable variable){
        if(hecho.usaVariable(variable)) return true;
        return false;
    }
    public JSONObject toJsonObject(){
        JSONObject json_obj = new JSONObject();
        json_obj.put("hecho", hecho.toJsonObject());
        json_obj.put("not", not);
        json_obj.put("oprel", oprel);
        return json_obj;
    }
    
    public static Literal literalFromJson(JSONObject json_obj, ArrayList<Variable> variables){
        Hecho hecho = Hecho.hechoFromJson(json_obj.getJSONObject("hecho"), variables);
        boolean not = json_obj.getBoolean("not");
        OPREL oprel = OPREL.valueOf(json_obj.getString("oprel"));
        return new Literal(hecho, oprel, not);
    }
    
}
