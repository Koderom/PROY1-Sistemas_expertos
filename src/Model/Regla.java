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
public class Regla {
    Minterm premisa;
    Hecho conclusion;
    
    public Regla(Minterm premisa, Hecho conclusion){
        this.premisa = premisa;
        this.conclusion = conclusion;
    }

    public void setPremisa(Minterm premisa) {
        this.premisa = premisa;
    }

    public void setConclusion(Hecho conclusion) {
        this.conclusion = conclusion;
    }
    @Override
    public Regla clone(){
        return new Regla(this.premisa, this.conclusion);
    }
    public JSONObject toJsonObject(){
        JSONObject json_obj = new JSONObject();
        json_obj.put("premisa", this.premisa.toJsonObject());
        json_obj.put("conclusion", this.conclusion.toJsonObject());
        return json_obj;
    }
    
    public static Regla reglaFromJson(JSONObject json_obj, ArrayList<Variable> variables){
        Hecho hecho = Hecho.hechoFromJson(json_obj.getJSONObject("conclusion"), variables);
        Minterm premisa = Minterm.mintermFromJson(json_obj.getJSONObject("premisa"), variables);
        return new Regla(premisa, hecho);
    }

    public Minterm getPremisa() {
        return premisa;
    }

    public Hecho getConclusion() {
        return conclusion;
    }
    
    public boolean usaVariable(Variable variable){
        if(this.conclusion.usaVariable(variable)) return true;
        else if(this.premisa.usaVariable(variable)) return true;
        else return false;
    }
    @Override
    public String toString(){
        return this.toJsonObject().toString();
    }
}
