/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Hecho;
import Model.Minterm;
import Model.Regla;
import Model.Variable;
import java.util.ArrayList;

/**
 *
 * @author MIRKO
 */
public class Reglas {
    ArrayList<Regla> reglas = new ArrayList<>();
    
    public Reglas(){}
    
    public Reglas(ArrayList<Regla> reglas){
        this.reglas = reglas;
    }
    public void addRegla(Minterm premisa, Hecho conclusion){
        Regla regla = new Regla(premisa, conclusion);
        reglas.add(regla);
    }
    public void editRegla(int index, Minterm premisa, Hecho conclusio){
        Regla regla = this.reglas.get(index);
        regla.setConclusion(conclusio);
        regla.setPremisa(premisa);
    }

    
    public void removeRegla(int index){
        this.reglas.remove(index);
    }
    public Regla getRegla(int index){
        return reglas.get(index);
    }
    public ArrayList<Regla> getReglas(){
        return this.reglas;
    }
   
    public boolean variableEsUsada(Variable variable){
        for(Regla regla : this.reglas)
            if(regla.usaVariable(variable)) return true;
        return false;
    }
}
