/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojframe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Clasificar {
    
    // esta variable tiene asignada la expresion regular que separa el texto sin incluir simbolos
    private String ExR = "[\\s\\W]+(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
    
    // esta variable tiene asignada la expresion regular que separa todos los simbolos 
    private String Simbolos = "[\\w\\s\\'\\\"]+";
    
    // array list para las palabras reservadas de su respectivo archivo de texto
    private ArrayList<String> PalabrasReservadas = new ArrayList<String>();
    
    // array list para los operadores relacionales de su respectivo archivo de texto
    private ArrayList<String> OperadoresRelacionales = new ArrayList<String>();
    
    // array list para los operadores de su respectivo archivo de texto
    private ArrayList<String> Operadores = new ArrayList<String>();
    
    // esta funcion separa en partes de textos con la expresion regular para separar el texto
    public String[] Separar(String texto) {
        
        // separa el texto con slit
        String[] textos = texto.split(this.ExR);
        
        // regresa el array del texto separado
        return textos;
    }
    
    // esta funcion separa en partes de textos con la expresion regular para separar el texto
    public String[] SepararSimbolos(String texto) {
        
        // separa el texto con slit
        String[] textos = texto.split(this.Simbolos);
        
        // regresa el array del texto separado
        return textos;
    }
    
    // esta funcion retorna el array list de palabras reservadas 
    public ArrayList palabrasReservadas() {
        ArrayList<String> palabras = this.PalabrasReservadas;
        return palabras;
    }
    
    // esta funcion retorna el array list de operadores relacionales
    public ArrayList operadoresRelacionales() {
        ArrayList<String> operadores = this.OperadoresRelacionales;
        return operadores;
    }
    
    // esta funcion retorna el array list de los operadores
    public ArrayList operadores() {
        ArrayList<String> operadores = this.Operadores;
        return operadores;
    }

    /* Esta funcion lee los archivos de texto con la informacion necesaria para
       llenar los array list, en total son tres archivos los cuales son operadorese.txt,
       operadoresRelacionales.txt y palabras reservadas */
    public Clasificar() {
        
        // esta varible nos ayudara a tener el archivo para poder abrirlo
        File archivo = null;
        
        // esta variable ayudara ala variable BufferedReader a leer el archivo linea por linea
        FileReader fr = null;
        
        // esta variable leera el archivo linea por linea
        BufferedReader br = null;

        try {
            //Abrir el archivo y crear el FileReader y el BufferedReader
            archivo = new File("src/proyectojframe/palabras.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            //Leer el archivo linea por linea
            String linea;
            while((linea = br.readLine()) != null) {
                // añade cada linea al array list
                this.PalabrasReservadas.add(linea);
            }

        } catch (IOException e) {
        } finally {
            // Cerramos el Fichero, para asegurar que todo vaya bien ira en un try and catch
            try {
                
                // si la variable fr no es nula el archivo si pudo abrise entonces debemos cerrarlo
                if (null != fr) {
                    
                    // cierra el archivo
                    fr.close();
                }
            } catch (IOException e) {
            }
        }
        
        try {
            //Abrir el archivo y crear el FileReader y el BufferedReader
            archivo = new File("src/proyectojframe/operadoresRelacionales.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            //Leer el archivo linea por linea
            String linea;
            while((linea = br.readLine()) != null) {
                
                // añade cada linea al array list
                this.OperadoresRelacionales.add(linea);
            }

        } catch (IOException e) {
        } finally {
            // Cerramos el Fichero, para asegurar que todo vaya bien ira en un try and catch
            try {
                
                // si la variable fr no es nula el archivo si pudo abrise entonces debemos cerrarlo
                if(null != fr) {
                    
                    // cierra el archivo
                    fr.close();
                }
            } catch (IOException e) {
            }
        }
        
        try {
            //Abrir el archivo y crear el FileReader y el BufferedReader
            archivo = new File("src/proyectojframe/operadores.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            //Leer el archivo linea por linea
            String linea;
            while((linea = br.readLine()) != null) {
                
                // añade cada linea al array list
                this.Operadores.add(linea);
            }

        } catch (IOException e) {
        } finally {
            // Cerramos el Fichero, para asegurar que todo vaya bien ira en un try and catch
            try {
                
                // si la variable fr no es nula el archivo si pudo abrise entonces debemos cerrarlo
                if (null != fr) {
                    
                    // cierra el archivo
                    fr.close();
                }
            } catch (IOException e) {
            }
        }
    }
    
}
