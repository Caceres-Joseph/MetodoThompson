/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metdothompson;

import java.util.ArrayList;
import metdothompson.Metodos.Nodo;

/**
 *
 * @author joseph
 */
public class Variables {

    public static Metodos graph = new Metodos();
    public static ArrayList<Nodo> listaA = new ArrayList<>();
    public static ArrayList<Nodo> listaB = new ArrayList<>();

    public static void LLenar(ArrayList<Nodo> lista) {
        if (listaA == null) {///lista a esta vacía
            listaA = lista;
        } else {//lista a llena, pero b vacía
            listaB = lista;
           
        }
    }
    public static void Limpiar(){
        listaA=null;
        listaB=null;
    }
    public static int cont=0;
    public static int contador(){
        
        return cont++;
    }
    
}
