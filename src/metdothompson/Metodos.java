/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metdothompson;

import java.util.ArrayList;
import java.util.Stack;

public class Metodos {

    public Nodo cabeza;
    String cadenaGraphivz = "";

    public ArrayList<Nodo> Interrog_0(int inicial, String a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "e");
        Nodo nodo3 = new Nodo(inicial + 2, a);
        Nodo nodo4 = new Nodo(inicial + 3, "e");
        Nodo nodo5 = new Nodo(inicial + 3, "e");

        nodo1.izdo = nodo2;
        graf(nodo1, nodo2);
        nodo1.dcho = nodo5;
        graf(nodo1, nodo5);

        nodo2.izdo = nodo3;
        graf(nodo2, nodo3);

        nodo3.izdo = nodo4;
        graf(nodo3, nodo4);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Interrog_1(int inicial, ArrayList<Nodo> list_a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "e";
        Nodo nodo3 = list_a.get(1);
        Nodo nodo4 = new Nodo(inicial + 1, "e");
        Nodo nodo5 = new Nodo(inicial + 1, "e");

        nodo1.izdo = nodo2;
        graf(nodo1, nodo2);
        nodo1.dcho = nodo5;
        graf(nodo1, nodo5);

        nodo3.izdo = nodo4;
        graf(nodo3, nodo4);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Mas_0(int inicial, String a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "e");
        Nodo nodo3 = new Nodo(inicial + 2, a);
        Nodo nodo4 = new Nodo(inicial + 3, "e");

        Nodo nodo6 = new Nodo(inicial + 1, "e");

        nodo1.izdo = nodo2;
        graf(nodo1, nodo2);

        nodo2.izdo = nodo3;
        graf(nodo2, nodo3);

        nodo3.izdo = nodo4;
        graf(nodo3, nodo4);
        nodo3.dcho = nodo6;
        graf(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Mas_1(int inicial, ArrayList<Nodo> list_a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "e";
        Nodo nodo3 = list_a.get(1);
        Nodo nodo4 = new Nodo(inicial + 1, "e");
        Nodo nodo6 = new Nodo(nodo2.id, "e");

        nodo1.izdo = nodo2;
        graf(nodo1, nodo2);

        nodo3.izdo = nodo4;
        graf(nodo3, nodo4);
        nodo3.dcho = nodo6;
        graf(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Aster_1(int inicial, ArrayList<Nodo> list_a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "e";
        Nodo nodo3 = list_a.get(1);
        Nodo nodo4 = new Nodo(inicial + 1, "e");
        Nodo nodo5 = new Nodo(inicial + 1, "e");
        Nodo nodo6 = new Nodo(nodo2.id, "e");

        nodo1.izdo = nodo2;
        graf(nodo1, nodo2);
        nodo1.dcho = nodo5;
        graf(nodo1, nodo5);

        nodo3.izdo = nodo4;
        graf(nodo3, nodo4);
        nodo3.dcho = nodo6;
        graf(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> Aster_0(int inicial, String a) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "e");
        Nodo nodo3 = new Nodo(inicial + 2, a);
        Nodo nodo4 = new Nodo(inicial + 3, "e");
        Nodo nodo5 = new Nodo(inicial + 3, "e");
        Nodo nodo6 = new Nodo(inicial + 1, "e");

        nodo1.izdo = nodo2;
        graf(nodo1, nodo2);
        nodo1.dcho = nodo5;
        graf(nodo1, nodo5);

        nodo2.izdo = nodo3;
        graf(nodo2, nodo3);

        nodo3.izdo = nodo4;
        graf(nodo3, nodo4);
        nodo3.dcho = nodo6;
        graf(nodo3, nodo6);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);

        return listaNodos;
    }

    public ArrayList<Nodo> And_0(int inicial, String a, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, a);
        Nodo nodo3 = new Nodo(inicial + 2, b);

        cabezaOr = nodo1;

        cabezaOr.izdo = nodo2;
        graf(cabezaOr, nodo2);
        nodo2.izdo = nodo3;
        graf(nodo2, nodo3);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo3);

        return listaNodos;
    }

    public ArrayList<Nodo> And_1(int inicial, ArrayList<Nodo> list, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;

        Nodo nodo1 = list.get(0);
        Nodo nodo2 = list.get(1);
        Nodo nodo3 = new Nodo(inicial, b);

        cabezaOr = nodo1;
        nodo2.izdo = nodo3;
        graf(nodo2, nodo3);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo3);

        return listaNodos;
    }

    public ArrayList<Nodo> And_2(int inicial, ArrayList<Nodo> list_a, ArrayList<Nodo> list_b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo nodo1 = list_a.get(0);

        Nodo nodo2 = list_a.get(1);
        Nodo nodo3 = list_b.get(0);
        nodo3.transicion = "e";
        Nodo nodo4 = list_b.get(1);

        nodo2.izdo = nodo3;
        graf(nodo2, nodo3);

        listaNodos.add(nodo1);
        listaNodos.add(nodo4);
        return listaNodos;
    }

    public ArrayList<Nodo> Or_0(int inicial, String a, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();
        Nodo cabezaOr;

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = new Nodo(inicial + 1, "e");
        Nodo nodo3 = new Nodo(inicial + 2, "e");
        Nodo nodo4 = new Nodo(inicial + 3, a);
        Nodo nodo5 = new Nodo(inicial + 4, b);
        Nodo nodo6 = new Nodo(inicial + 5, "e");
        Nodo nodo7 = new Nodo(inicial + 5, "e");

        cabezaOr = nodo1;

        cabezaOr.izdo = nodo2;
        graf(cabezaOr, nodo2);

        nodo2.izdo = nodo4;
        graf(nodo2, nodo4);

        nodo4.izdo = nodo6;
        graf(nodo4, nodo6);

        cabezaOr.dcho = nodo3;
        graf(cabezaOr, nodo3);

        nodo3.izdo = nodo5;
        graf(nodo3, nodo5);

        nodo5.izdo = nodo7;
        graf(nodo5, nodo7);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo6);

        return listaNodos;
    }

    public ArrayList<Nodo> Or_1(int inicial, ArrayList<Nodo> list, String b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;

        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list.get(0);
        nodo2.transicion = "e";
        Nodo nodo3 = new Nodo(inicial + 1, "e");
        Nodo nodo4 = list.get(1);
        Nodo nodo5 = new Nodo(inicial + 2, b);
        Nodo nodo6 = new Nodo(inicial + 3, "e");
        Nodo nodo7 = new Nodo(inicial + 3, "e");

        cabezaOr = nodo1;

        cabezaOr.izdo = nodo2;
        graf(cabezaOr, nodo2);

        nodo4.izdo = nodo6;
        graf(nodo4, nodo6);

        cabezaOr.dcho = nodo3;
        graf(cabezaOr, nodo3);
        nodo3.izdo = nodo5;
        graf(nodo3, nodo5);
        nodo5.izdo = nodo7;
        graf(nodo5, nodo7);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo6);

        return listaNodos;
    }

    public ArrayList<Nodo> Or_2(int inicial, ArrayList<Nodo> list_a, ArrayList<Nodo> list_b) {
        ArrayList<Nodo> listaNodos = new ArrayList<>();

        Nodo cabezaOr;
        Nodo nodo1 = new Nodo(inicial);
        Nodo nodo2 = list_a.get(0);
        nodo2.transicion = "e";
        Nodo nodo3 = list_b.get(0);
        nodo3.transicion = "e";

        Nodo nodo4 = list_a.get(1);
        Nodo nodo5 = list_b.get(1);

        Nodo nodo6 = new Nodo(inicial + 1, "e");
        Nodo nodo7 = new Nodo(inicial + 1, "e");

        cabezaOr = nodo1;

        cabezaOr.dcho = nodo3;
        graf(cabezaOr, nodo3);
        cabezaOr.izdo = nodo2;
        graf(cabezaOr, nodo2);

        nodo4.izdo = nodo6;
        graf(nodo4, nodo6);
        nodo5.izdo = nodo7;
        graf(nodo5, nodo7);

        listaNodos.add(cabezaOr);
        listaNodos.add(nodo6);

        return listaNodos;
    }

    public void graf(Nodo a, Nodo b) {
        cadenaGraphivz = cadenaGraphivz + String.valueOf(a.id) + " -> " + String.valueOf(b.id) + " [label=\"" + b.transicion + "\"];\n";

    }

    public int indice = 1;
//    ArrayList<Metodos.Nodo> lis_a;
//    ArrayList<Metodos.Nodo> listaA;
//    ArrayList<Metodos.Nodo> listaB;
//    ArrayList<Metodos.Nodo> listaC;
    ArrayList<Metodos.Nodo> temporal;
    Stack<ArrayList<Nodo>> pila=new Stack<ArrayList<Nodo>>();
    
    public void hacerGrafo(String token_a, String token_b, String operacion) {

        String primer_a = token_a.substring(0, 1);
        String primer_b = token_b.substring(0, 1);

        switch (operacion) {
            case "And":
                if (!primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = And_0(indice, token_a, token_b);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = And_1(indice, pila.pop(), token_b);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (!primer_a.equals("(") && primer_b.equals("(")) {
                    temporal = And_1(indice, pila.pop(), token_a);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && primer_b.equals("(")) {
                    ArrayList<Metodos.Nodo> primero=pila.pop();
                    ArrayList<Metodos.Nodo> segundo=pila.pop();
                    
                    temporal = And_2(indice, segundo,primero);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            case "Or":
                if (!primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = Or_0(indice, token_a, token_b);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = Or_1(indice, pila.pop(), token_b);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (!primer_a.equals("(") && primer_b.equals("(")) {
                    temporal = Or_1(indice, pila.pop(), token_a);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && primer_b.equals("(")) {
                    temporal = Or_2(indice, pila.pop(), pila.pop());
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            case "Aster":
                if (!primer_a.equals("(")) {
                    temporal = Aster_0(indice, token_a);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    temporal = Aster_1(indice, pila.pop());
//                    Limpiar();
                   pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            case "Interrog":
                if (!primer_a.equals("(")) {
                    temporal = Interrog_0(indice, token_a);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    temporal = Interrog_1(indice,pila.pop());
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            case "Mas":
                if (!primer_a.equals("(")) {
                    temporal = Mas_0(indice, token_a);
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    temporal = Mas_1(indice, pila.pop());
                    pila.push(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            default:
                break;
        }
    }
    /*
     public void hacerGrafo45(String token_a, String token_b, String operacion) {

        String primer_a = token_a.substring(0, 1);
        String primer_b = token_b.substring(0, 1);

        switch (operacion) {
            case "And":
                if (!primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = And_0(indice, token_a, token_b);
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = And_1(indice, agarrarUltimo(), token_b);
                    borrarUltimo();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (!primer_a.equals("(") && primer_b.equals("(")) {
                    temporal = And_1(indice, agarrarUltimo(), token_a);
                    borrarUltimo();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && primer_b.equals("(")) {
                    ArrayList<ArrayList> listas=agarrarUltimosDos();
                    temporal = And_2(indice, listas.get(0), listas.get(1));
                    borrarPar();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;

                }
                break;
            case "Or":
                if (!primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = Or_0(indice, token_a, token_b);
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && !primer_b.equals("(")) {
                    temporal = Or_1(indice, agarrarUltimo(), token_b);
                    borrarUltimo();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (!primer_a.equals("(") && primer_b.equals("(")) {
                    temporal = Or_1(indice, agarrarUltimo(), token_a);
                    borrarUltimo();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(") && primer_b.equals("(")) {
                    ArrayList<ArrayList> listas=agarrarUltimosDos();
                    temporal = Or_2(indice, listas.get(0), listas.get(1));
                    borrarPar();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            case "Aster":
                if (!primer_a.equals("(")) {
                    temporal = Aster_0(indice, token_a);
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    temporal = Aster_1(indice, listaA);
//                    Limpiar();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            case "Interrog":
                if (!primer_a.equals("(")) {
                    temporal = Interrog_0(indice, token_a);
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    temporal = Interrog_1(indice, listaA);
//                    Limpiar();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            case "Mas":
                if (!primer_a.equals("(")) {
                    temporal = Mas_0(indice, token_a);
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                } else if (primer_a.equals("(")) {
                    temporal = Mas_1(indice, listaA);
//                    Limpiar();
                    LLenar(temporal);
                    indice = temporal.get(1).id + 1;
                }
                break;
            default:
                break;
        }
    }

    public void LLenar(ArrayList<Nodo> lista) {

        if (listaA == null) {///lista a esta vacía
            listaA = lista;
            System.out.println("--LenandoA---");
        } else if (listaB == null) {//lista a llena, pero b vacía
            listaB = lista;
            System.out.println("--LenandoB--");
        } else if (listaC == null) {
            listaC = lista;
            System.out.println("--LenandoC--");
        } else {
            System.out.println("<ERROR>LLena<Se pasó del limite>");
        }
    }

    public void borrarPar() {

        if (!(listaC == null) && !(listaB == null) && !(listaA == null)) {//el ultimo null
            listaC = null;
            listaB = null;
            System.out.println("BorrandoPar--->ListaB|ListaC");
        } else if ((listaC == null) && !(listaB == null) && !(listaA == null)) {//ninguno null
            listaB = null;
            listaA = null;
            System.out.println("BorrandoPar----> listaA|listaB");
        } else {
            System.out.println("<ERROR>BorrarPar<No se borró par>");
        }
    }

    public void borrarUltimo() {
        if (!(listaC == null) && !(listaB == null) && !(listaA == null)) {
            listaC = null;
            System.out.println("--BorrandoUltimo---> listaC");
        } else if ((listaC == null) && !(listaB == null) && !(listaA == null)) {
            listaB = null;
            System.out.println("--BorrandoUltimo---> listaB");
        } else if ((listaC == null) && (listaB == null) && !(listaA == null)) {
            listaA = null;
            System.out.println("--BorrandoUltimo---> listaA");
        } else {
            System.out.println("<ERROR>BorrarUltimo<A=null>");
        }
    }

    public ArrayList<Nodo> agarrarUltimo() {
        ArrayList<Nodo> retorno;
        if (!(listaC == null) && !(listaB == null) && !(listaA == null)) {//los tres tienen algo
            retorno = listaC;
            System.out.println("--AgarrarUltimo---> ListaC");
        } else if ((listaC == null) && !(listaB == null) && !(listaA == null)) {//los primero dos tienen algo
            retorno = listaB;
            System.out.println("--AgarrarUltimo---> ListaB");
        } else if ((listaC == null) && (listaB == null) && !(listaA == null)) {//el primero tiene algo
            retorno = listaA;
            System.out.println("--AgarrarUltimo---> ListaA");
        } else {
            retorno = null;
            System.out.println("<ERROR>AgarrarUltimo<TodosNull>");
        }
        return retorno;
    }

    public ArrayList<ArrayList> agarrarUltimosDos() {
        ArrayList<ArrayList> retorno;
        ArrayList<ArrayList> temps = new ArrayList<>();
        if ((listaC == null) && !(listaB == null) && !(listaA == null)) {//los tres tienen algo
            temps.add(listaA);
            temps.add(listaB);
            retorno = temps;
            System.out.println("---AgarrarUltimosDos----->ListaA|ListaB");
        } else if (!(listaC == null) && !(listaB == null) && !(listaA == null)) {//los primero dos tienen algo
            temps.add(listaB);
            temps.add(listaC);

            retorno = temps;
            System.out.println("---AgarrarUltimosDos----->ListaB|ListaC");

        } else {
            retorno = null;
            System.out.println("<ERROR>AgarrarUltimosDos<SoloA_tieneAlgo>");
        }
        return retorno;
    }
*/

    public class Nodo {

        public int id;
        public String transicion;
        public Nodo dcho;
        public Nodo izdo;
        public boolean usada;
        
        public Nodo(int id, String transicion) {
            this.id = id;
            this.transicion = transicion;
        }

        public Nodo(int id) {
            this.id = id;
        }

        public Nodo(String transicion) {
            this.transicion = transicion;
        }

        public Nodo() {

        }
    }

}
