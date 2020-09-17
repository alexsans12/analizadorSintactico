/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojframe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Clasificar {
    
    private String ExR = "[\\s\\-\\+\\<\\>\\=\\(\\)\\{\\}\\!]+(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
    private String Simbolos = "[\\w\\s\\'\\\"]+";
    private ArrayList<String> PalabrasReservadas = new ArrayList<String>();
    
    
    public String[] Separar(String texto) {
        String[] textos = texto.split(this.ExR);
        return textos;
    }
    
    public String[] SepararSimbolos(String texto) {
        String[] textos = texto.split(this.Simbolos);
        return textos;
    }
    
    public ArrayList Palabras() {
        ArrayList<String> palabras = this.PalabrasReservadas;
        return palabras;
    }

    public Clasificar() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            //Abrir el archivo y crear el FileReader y el BufferedReader
            archivo = new File("/Users/alex/NetBeansProjects/proyectoJframe/src/proyectojframe/palabras.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            //Leer el archivo linea por linea
            String linea;
            while((linea = br.readLine()) != null) {
                this.PalabrasReservadas.add(linea);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerramos el Fichero, para asegurar que todo vaya bien ira en un try and catch
            try {
                if(null != fr) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
