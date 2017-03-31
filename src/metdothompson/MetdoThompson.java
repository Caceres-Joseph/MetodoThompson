/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metdothompson;

import java.io.StringReader;
import metdothompson.Afd.Estado;
import metdothompson.Metodos.Nodo;

/**
 *
 * @author joseph
 */
public class MetdoThompson {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        String  cadena = ".e*|e|dg";
        String cadena=".+|?a+b|c+d";//falla
        // String cadena="?.+|?ab|+jd";//falla
//        String cadena=".|.|ab|cd.ef|.gh|.ijk";
        //String cadena=".?|zw*||.ab.cd|.wx.ef";
//        String cadena="|+|a|e|i|ou+|p|q|r|st";
//        String cadena = ".*|*a+b|*a*b";//fallla douglas
//        String cadena="||..a*b.|.afc*|.|.ebd.*.ab|.afc.ef.*.cd.|a.ce*|.|b.fd.*.cd|a.ce.fe.*c.|.a.*|acb.b.|bca*|a|bc";//christian
//      String cadena="|.|.|ab|.|cdef|o|i.gh|jk.|kj|||.hgio.|f.e|dc|ba";
//        String cadena = ".*|b.*baa";
//        String cadena = ".b|j+d";
//        String  cadena = "||ab|cd";
//String cadena="|..a*b.|.afc*|.|.ebd.*.ab|.afc.ef.*.cd.|a.ce*|.|b.fd.*.cd|a.ce.fe"//Christian2;
//String cadena="..a*b.|.afc*|.|.zbd.*.ab|.afc.zf";//Christian3;
//String cadena="..a*b.|.afc*|g.zf"; 
//|..a*b.|.afc*|.|.ebd.*.ab|.afc.ef.*.cd.|a.ce*|.|b.fd.*.cd|a.ce.fe
//String cadena="|..a*b.|.afc*|.|.zbd.*.ab|.afc.zf.*.cd.|a.cz*|.|b.fd.*.cd|a.cz.fz";
//STri cadena="|..a*b.|.afc*|.|.zbd.*.ab|.afc.zf.*.cd.|a.cz*|.|b.fd.*.cd|a.cz.fz"
        new Sintactico(new Scanner(new StringReader(cadena))).parse();
        System.out.println("--------------------AFN----------------");
        System.out.println(Variables.graph.cadenaGraphivz);
        System.out.println("-----------AFD----------------------");
//        System.out.println(Variables.graph.cadenaGraphivz);

        Afd afd = new Afd(Variables.graph.pila.pop());

        afd.recorrer2();
        System.out.println("---------------Recorriendo-------------");
        System.out.println(afd.evaluarCadena("aabbbbcdda"));
//        afd.metodoPrueba();
//        afd.recorrerPila();
//afd.anchura();
//        Metodos graph =new Metodos();
//        graph.saludar();
//        String lal= "hola";
//        System.out.println(lal.substring(0,1));
    }

    public void prueba() {
        Metodos meto = new Metodos();
        meto.Or_0(2, "a", "b");

    }

    public void recorrer(Nodo a) {
        Nodo aux = a;
        while (aux.izdo != null) {
            System.out.println(aux.id);
            aux = aux.izdo;
        }
    }

}
