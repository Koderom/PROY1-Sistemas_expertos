/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Model.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author MIRKO
 */
public class Util {
    
    public static HashMap<String, Object> loadFromFile(String name){
        HashMap<String, Object> resultado = new HashMap<>();
        ArrayList<Variable> variables = new ArrayList<>();
        ArrayList<Regla> reglas = new ArrayList<>();
        
        String json = load(name);
        JSONObject json_data = new JSONObject(json);
        
        JSONArray json_variables = json_data.getJSONArray("variables");
        for(int i = 0; i < json_variables.length(); i++){
            Variable variable = Variable.VariableFromJson(json_variables.getJSONObject(i).toString());
            variables.add(variable);
        }
        resultado.put("variables", variables);
        
        JSONArray json_reglas = json_data.getJSONArray("reglas");
        for(int i = 0; i < json_reglas.length(); i++){
            Regla regla = Regla.reglaFromJson(json_reglas.getJSONObject(i), variables);
            reglas.add(regla);
        }
        resultado.put("reglas", reglas);
        
        return resultado;        
    }
    private static String load(String name){
        String path = "./data/" + name + ".BC";
        String json = "";
        BufferedReader reader = null;
        File archivo = new File(path);
        if(!archivo.exists()) return null;
        try {
            reader = new BufferedReader(new FileReader(archivo));
            StringBuilder texto = new StringBuilder();
            String linea;
            while((linea = reader.readLine()) != null){
                texto.append(linea);
            }
            json = texto.toString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return json;
    }
    public static void saveToFile(String name, ArrayList<Variable> variables, ArrayList<Regla> reglas){
        JSONArray json_variables = new JSONArray();
        for(Variable variable : variables) json_variables.put(variable.toJsonObject());
        JSONArray json_reglas = new JSONArray();
        for(Regla regla : reglas) json_reglas.put(regla.toJsonObject());
        JSONObject json_data = new JSONObject();
        json_data.put("variables", json_variables);
        json_data.put("reglas", json_reglas);
        save(name, json_data.toString());
    }
    private static void save(String name, String contenido){
        String path = "./data/";
        File directorio = new File(path);
        File archivo = new File(directorio.getPath()+"/"+name+".BC");
        try {
            if(!directorio.exists()) directorio.mkdirs();
            if(!archivo.exists()) archivo.createNewFile();
            PrintWriter pw = new PrintWriter(archivo);
            pw.println(contenido);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<String> archivosGuardados(){
        List<String> archivos = new ArrayList<String>();
        File guardado = new File("./data/");
        File[] guardados = guardado.listFiles();
        for(File someFile : guardados)
            if(someFile.isFile()) archivos.add(someFile.getName());
        return archivos;
    }
}
