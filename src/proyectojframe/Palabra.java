/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojframe;

import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Palabra {
    
    private String token;
    private boolean reservada, id, operadorRacional, digito, operador, unknow;
    private int linea;
    private Clasificar cl = new Clasificar();
    
    public String getToken() {
        return token;
    }
    
    public String getTokenLower() {
        return token.toLowerCase();
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    public boolean isId() {
        return id;
    }

    public void setId(boolean id) {
        this.id = id;
    }

    public boolean isOperadorRacional() {
        return operadorRacional;
    }

    public void setOperadorRacional(boolean operadorRacional) {
        this.operadorRacional = operadorRacional;
    }

    public boolean isDigito() {
        return digito;
    }

    public void setDigito(boolean digito) {
        this.digito = digito;
    }

    public boolean isOperador() {
        return operador;
    }

    public void setOperador(boolean operador) {
        this.operador = operador;
    }

    public boolean isUnknow() {
        return unknow;
    }

    public void setUnknow(boolean unknow) {
        this.unknow = unknow;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }
    
    public void reservada() {
        ArrayList<String> palabrasReservadas = this.cl.palabrasReservadas();
        
        for(String t : palabrasReservadas) {
            if(t.equals(this.getTokenLower())) {
                this.setReservada(true);
                break;
            }
            else
                this.setReservada(false);
        }
    }
    
    public void operadorRelacional() {
        ArrayList<String> operadoresRelacionales = this.cl.operadoresRelacionales();
        
        for(String t : operadoresRelacionales) {
            if(t.equals(this.getToken())) {
                this.setOperadorRacional(true);
                break;
            }
            else
                this.setOperadorRacional(false);
        }
    }
    
    public void operador() {
        ArrayList<String> operadores = this.cl.operadores();
        
        for(String t : operadores) {
            if(t.equals(this.getToken())) {
                this.setOperador(true);
                break;
            }
            else
                this.setOperador(false);
        }
    }
    
    public void digito() {
        try {
            int digito = Integer.parseInt(this.getTokenLower());
            this.setDigito(true);
        } catch(NumberFormatException nfe) {
            nfe.getMessage();
            this.setDigito(false);
        }
    }
    
    public void variable(String linea) {
        ArrayList<String> operadoresRelacionales = this.cl.operadoresRelacionales();
        ArrayList<String> operadores = this.cl.operadores();
        
        for(String opR : operadoresRelacionales) {
            if((linea.contains(this.getToken() + " " + opR) || linea.contains(this.getToken() + opR)) && this.isDigito() == false) {
                
                this.setId(true);
                break;
            } 
            else if((linea.contains(opR + this.getToken()) || linea.contains(opR + " " + this.getToken())) && this.isDigito() == false) {

                this.setId(true);
                break;
            } 
            else {
                for(String op : operadores) {
                    if((linea.contains(this.getToken() + " " + op) || linea.contains(this.getToken() + op)) && this.isDigito() == false) {

                        this.setId(true);
                        break;
                    } 
                    else if((linea.contains(op + this.getToken()) || linea.contains(op + " " + this.getToken())) && this.isDigito() == false) {

                        this.setId(true);
                        break;
                    } 
                    else {
                        this.setId(false);
                    }
                }
            }
        }
        
    }
    
    public void desconocido() {
        if(!this.isDigito() && !this.isId() && !this.isOperador() && !this.isOperadorRacional() 
            && !this.isReservada()) {
            this.setUnknow(true);
        } else {
            this.setUnknow(false);
        }
    }
}
