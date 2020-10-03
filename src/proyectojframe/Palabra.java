/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojframe;

import java.util.ArrayList;

public class Palabra {
    
    // Variables declaradas globales dentro de la clase
    private String token;
    private boolean reservada, id, operadorRacional, digito, operador, unknow;
    private int linea;
    private Clasificar cl = new Clasificar();
    
    // retorna lo que contenga token
    public String getToken() {
        return token;
    }

    // Ingresa un valor a token
    public void setToken(String token) {
        this.token = token;
    }
    
    // retorna lo que contenga token pero siempre en minusculas
    public String getTokenLower() {
        return token.toLowerCase();
    }

    // retorna lo que contenga reserva
    public boolean isReservada() {
        return reservada;
    }

    // Ingresa un valor booleano a reserva
    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    // retorna el valor que contenga id
    public boolean isId() {
        return id;
    }

    // ingresa un valor booleano a id
    public void setId(boolean id) {
        this.id = id;
    }

    // retorna el valor que contenga operadorRacional
    public boolean isOperadorRacional() {
        return operadorRacional;
    }

    // ingresa un valor booleano a operadorRacional
    public void setOperadorRacional(boolean operadorRacional) {
        this.operadorRacional = operadorRacional;
    }

    // retorna el valor que contenga digito
    public boolean isDigito() {
        return digito;
    }

    // ingresa un valor booleano a digito
    public void setDigito(boolean digito) {
        this.digito = digito;
    }

    // retorna el valor que contiene operador
    public boolean isOperador() {
        return operador;
    }

    // ingresa un valor booleano a operador
    public void setOperador(boolean operador) {
        this.operador = operador;
    }

    // retorna el valor de unknow
    public boolean isUnknow() {
        return unknow;
    }

    // ingresa un valor booleano a unknow
    public void setUnknow(boolean unknow) {
        this.unknow = unknow;
    }
    
    // retorna el valor que contiene linea
    public int getLinea() {
        return linea;
    }

    // ingresar un valor numerico a linea
    public void setLinea(int linea) {
        this.linea = linea;
    }
    
    /* Funcion que verifica si el token es una palabra reservada
       que se encuentra en el array list palabrasReservadas.
    */
    public void reservada() {
        
        /* se llama a la funcion palabrasReservadas para tener el array list 
           de las palabras reservadas que se encuentra en la clase Clasificar
        */
        ArrayList<String> palabrasReservadas = this.cl.palabrasReservadas();
        
        // Este for accede a cada elemento del array list
        for(String t : palabrasReservadas) {
            
            // este if compara el token con el elemento del array list
            if(t.equals(this.getTokenLower())) {
                
                /* si el if se cumple se ingresa un true(que el token si 
                es una palabra reservada) a reservada */
                this.setReservada(true);
                // termina la función
                break;
            }
            else /*si no se cumple el if se ingresa false(que el token no es palabra reservada)
                en reservada */
                this.setReservada(false);
        }
    }
    
    /* Funcion que verifica si el token es un operador racional
       que se encuentra en el array list operadoresRacionales */
    public void operadorRelacional() {
        
        /* se llama a la funcion operadoresRelacionales para tener el array list 
           de los operadores racionales que se encuentra en la clase Clasificar */
        ArrayList<String> operadoresRelacionales = this.cl.operadoresRelacionales();
        
        // Este for accede a cada elemento del array list
        for(String t : operadoresRelacionales) {
            
            // este if compara el token con el elemento del array list
            if(t.equals(this.getToken())) {
                
                /* si el if se cumple se ingresa un true(que el token si es un operador racional)
                operadorRacional  */
                this.setOperadorRacional(true);
                // termina la función
                break;
            }
            else /*si no se cumple el if se ingresa false(que el token no es operador racional)
                en operador racional */
                this.setOperadorRacional(false);
        }
    }
    
    /* Funcion que verifica si el token es un operador
       que se encuentra en el array list operadores */
    public void operador() {
        
        /* se llama a la funcion operadores para tener el array list 
           de los operadores que se encuentra en la clase Clasificar */
        ArrayList<String> operadores = this.cl.operadores();
        
        // Este for accede a cada elemento del array list
        for(String t : operadores) {
            
            // este if compara el token con el elemento del array list
            if(t.equals(this.getToken())) {
                
                /* si el if se cumple se ingresa un true(que el token si es un operador)
                a operador */
                this.setOperador(true);
                // termina la función
                break;
            }
            else /*si no se cumple el if se ingresa false(que el token no es operador)
                en operador */
                this.setOperador(false);
        }
    }
    
    // Funcion que verifica si el token es un digito
    public void digito() {
        
        try {
            
            // convierte el string a un int para hacer la verificación
            // si se logra convertir se ingresa true a digito
            int digito = Integer.parseInt(this.getTokenLower());
            this.setDigito(true);
            
        } catch(NumberFormatException nfe) {
            
            // si no se logra convertir string a int se declara digito como false
            nfe.getMessage();
            this.setDigito(false);
        }
    }
    
    /* Funcion que verifica si el token es un id llamada en la funcion variable,                                                    
       se crean dos array list uno para operadores relacionales y otro para operadores */
    public void variable(String linea) {
        
        /* se llama a la funcion operadoresRelacionales para tener el array list 
           de los operadores racionales que se encuentra en la clase Clasificar */
        ArrayList<String> operadoresRelacionales = this.cl.operadoresRelacionales();
        
        /* se llama a la funcion operadores para tener el array list 
           de los operadores que se encuentra en la clase Clasificar */
        ArrayList<String> operadores = this.cl.operadores();
        
        // Este for accede a cada elemento del array list de operadores relacionales
        for(String opR : operadoresRelacionales) {
            
            /* este if verifica la linea donde se encuentra el token sumandole al string 
               del token el operador racional del for para saber si esta rodiado de ese 
               operador racional así clasificarlo como id(variable), este if verifica 
               el lado izquierdo */
            if((linea.contains(this.getToken() + " " + opR) || linea.contains(this.getToken() + opR))
                    && this.isDigito() == false) {
                
                // si cumple con la condicion se ingresa true al id
                this.setId(true);
                break;
            }
            /* este if verifica la linea donde se encuentra el token sumandole al string 
               del token el operador racional del for para saber si esta rodiado de ese 
               operador racional así clasificarlo como id(variable), este if verifica el 
               lado derecho */
            else if((linea.contains(opR + this.getToken()) || 
                    linea.contains(opR + " " + this.getToken())) && this.isDigito() == false) {
                
                // si cumple con la condicion se ingresa true al id
                this.setId(true);
                break;
            } 
            /* si no se cumple con los operadores racionales se hara la verificacion 
            con los operadores */
            else {
                
                // Este for accede a cada elemento del array list de operadores
                for(String op : operadores) {
                    
                    /* este if verifica la linea donde se encuentra el token sumandole al string 
                       del token el operador del for para saber si esta rodiado de ese 
                       operador así clasificarlo como id(variable), este if verifica el 
                       lado izquierdo */
                    if((linea.contains(this.getToken() + " " + op) || 
                            linea.contains(this.getToken() + op)) && this.isDigito() == false) {
                        
                        // si cumple con la condicion se ingresa true al id
                        this.setId(true);
                        break;
                    } 
                    /* este if verifica la linea donde se encuentra el token sumandole al string 
                       del token el operador del for para saber si esta rodiado de ese 
                       operador así clasificarlo como id(variable),, este if verifica 
                    el lado derecho */
                    else if((linea.contains(op + this.getToken()) || 
                            linea.contains(op + " " + this.getToken())) && this.isDigito() == false) {

                        // si cumple con la condicion se ingresa true al id
                        this.setId(true);
                        break;
                    } 
                    else {
                        /* si no se cumplen ninguna de las condiciones anteriores se 
                        ingresa false al id*/
                        this.setId(false);
                    }
                }
            }
        }
        
    }
    
    /* Funcion que verifica si el token no es identificado en ninguna de las funciones anteriores
       si es haci se le asignara al token como desconocido */
    public void desconocido() {
        
        /* este if verifica que las clasificaciones esten en false para poder 
           darle como desconocido al token */
        if(!this.isDigito() && !this.isId() && !this.isOperador() && !this.isOperadorRacional() 
            && !this.isReservada()) {
            // se asigna true a unknow
            this.setUnknow(true);
        } else {
            // se asigna false a unknow
            this.setUnknow(false);
        }
    }
}
