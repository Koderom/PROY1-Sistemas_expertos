/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author MIRKO
 */
public class Minterm {
    ArrayList<Literal> literales;
    
    public Minterm(Literal literal){
        literales = new ArrayList<>();
        literales.add(literal);
    }

    public ArrayList<Literal> getLiterales() {
        return literales;
    }
    
    public Minterm(ArrayList<Literal> literales){
        if(literales.size() > 0){
            this.literales = literales;
        }
    }
    public void addLiteral(Literal literal){
        literales.add(literal);
    }
    public void remove(Literal literal){
        literales.remove(literal);
    }
    
    public boolean usaVariable(Variable variable){
        for(Literal literal : this.literales)
            if(literal.usaVariable(variable)) return true;
        
        return false;
    }
    
    public JSONObject toJsonObject(){
        JSONObject json_obj = new JSONObject();
        JSONArray json_arr = new JSONArray();
        for(Literal literal : literales) json_arr.put(literal.toJsonObject());
        json_obj.put("literales", json_arr);
        return json_obj;
    }
    
    public static Minterm mintermFromJson(JSONObject json_obj, ArrayList<Variable> variables){
        JSONArray json_arr = json_obj.getJSONArray("literales");
        ArrayList<Literal> literales = new ArrayList<>();
        for(int i = 0; i < json_arr.length(); i++) 
            literales.add(Literal.literalFromJson(json_arr.getJSONObject(i), variables));
        return new Minterm(literales);
    }
}
