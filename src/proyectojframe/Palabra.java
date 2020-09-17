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

    public String getToken() {
        return token;
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
    
    public void Reservada() {
        Clasificar cl = new Clasificar();
        ArrayList<String> palabrasReservadas = cl.Palabras();
        
        for(String t : palabrasReservadas) {
            if(t.equals(this.getToken())) {
                this.setReservada(true);
                break;
            }
            else
                this.setReservada(false);
        }
    }
    
    public void OperadorRelacional() {
        String[] operador = {"<",">","=","!","<=",">=","!=","==","++","--","||","&&"};
        
        for(String t : operador) {
            if(t.equals(this.getToken())) {
                this.setOperadorRacional(true);
                break;
            }
            else
                this.setOperadorRacional(false);
        }
    }
    
    public void Operador() {
        String[] operador = {"/","*","-","+","%"};
        
        for(String t : operador) {
            if(t.equals(this.getToken())) {
                this.setOperador(true);
                break;
            }
            else
                this.setOperador(false);
        }
    }
    
    public void Digito() {
        try {
            int digito = Integer.parseInt(this.getToken());
            this.setDigito(true);
        } catch(NumberFormatException nfe) {
            nfe.getMessage();
            this.setDigito(false);
        }
    }
    
    public void Variable(String linea) {
        if((linea.contains(this.getToken() + " =") || linea.contains(this.getToken() + "=") ||
           linea.contains(this.getToken() + "!=" ) || linea.contains(this.getToken() + " !=") ||
           linea.contains(this.getToken() + ">") || linea.contains(this.getToken() + " >") ||
           linea.contains(this.getToken() + "<=") || linea.contains(this.getToken() + " <=") ||
           linea.contains(this.getToken() + "<") || linea.contains(this.getToken() + " <") ||
           linea.contains(this.getToken() + ">=") || linea.contains(this.getToken() + " >=") ||
           linea.contains(this.getToken() + "++") || linea.contains(this.getToken() + "--")) && this.isDigito() == false) {
            
            this.setId(true);
        } 
        else if((linea.contains("=" + this.getToken()) || linea.contains("= " + this.getToken()) ||
           linea.contains("!=" + this.getToken()) || linea.contains("!= " + this.getToken()) ||
           linea.contains(">" + this.getToken()) || linea.contains("> " + this.getToken()) ||
           linea.contains("<=" + this.getToken()) || linea.contains("<= " + this.getToken()) ||
           linea.contains("<" + this.getToken()) || linea.contains("< " + this.getToken()) ||
           linea.contains(">=" + this.getToken()) || linea.contains(">= " + this.getToken())) && this.isDigito() == false) {
            
            this.setId(true);
        } 
        else {
            this.setId(false);
        }
    }
    
    public void Unknow() {
        if(!this.isDigito() && !this.isId() && !this.isOperador() && !this.isOperadorRacional() 
            && !this.isReservada()) {
            this.setUnknow(true);
        } else {
            this.setUnknow(false);
        }
    }
}
