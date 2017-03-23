/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metdothompson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Afd {

    Metodos.Nodo raiz;
    Queue<Metodos.Nodo> cola = new LinkedList<>();
//    Stack<Integer> pila = new Stack<>();

    public Afd(ArrayList<Metodos.Nodo> raiz) {
        this.raiz = raiz.get(0);
    }

    public Afd() {

    }

    public void anchura() {
        Metodos.Nodo aux;
        if (raiz != null) {
            cola.add(raiz);//insertando la cabeza
            while (!cola.isEmpty()) {
                aux = cola.poll();
                System.out.println(aux.id);
                if (!(aux.izdo == null)) {
                    cola.add(aux.izdo);
                }
                if (!(aux.dcho == null)) {
                    cola.add(aux.dcho);
                }
            }
        }
    }

    public Metodos.Nodo buscar(int busq) {//recorre todo el árbol en búsca del nuevo nodo
        Queue<Metodos.Nodo> cola1 = new LinkedList<>();
        Metodos.Nodo retorno = null;
        Metodos.Nodo aux;
        if (raiz != null) {
            cola1.add(raiz);//insertando la cabeza
            while (!cola1.isEmpty()) {
                aux = cola1.poll();
                if (aux.id == busq && aux.usada == false) {//lo encontró
                    retorno = aux;
                    break;
                }
                if (!(aux.izdo == null)) {
                    cola1.add(aux.izdo);
                }
                if (!(aux.dcho == null)) {
                    cola1.add(aux.dcho);
                }
            }
        }
        return retorno;
    }

    public void recorrer() {
        System.out.println("------------------So------------------");
        Estado So = new Estado();
        HacerCerradura(raiz, So);

//        So.Mueve("f", 0);
        So.imprimirCerradura();
        So.imprimirMueve();

        System.out.println("------------------S1------------------");
        Estado S1 = new Estado();
        HacerCerradura(So.lstMueve.get(0).listNumeros.pop(), S1);
        HacerCerradura(So.lstMueve.get(0).listNumeros.pop(), S1);

        S1.imprimirCerradura();
        S1.imprimirMueve();
    }

    public void HacerCerradura(Metodos.Nodo nodo, Estado estado) {
        Metodos.Nodo aux;
        if (nodo != null) {
            cola.add(nodo);//insertando la cabeza
            while (!cola.isEmpty()) {
                aux = cola.poll();
//                System.out.println(aux.id);
//                pila.push(aux.id);
//                estado.epsilon.push(aux.id);
                estado.insertarEpsilon(aux.id);

                if (aux.izdo == null && aux.dcho == null) {//este nodo es el último
                    aux.usada = true;
//                    buscar(aux.id, nodo);
                    Metodos.Nodo temporal = buscar(aux.id);
                    if (temporal == null) {//no lo encontró
                        System.out.println("no lo encontró -> " + aux.id);
                    } else if (temporal.transicion.equals("e")) {
//                        estado.epsilon.pop();
                        HacerCerradura(temporal, estado);
                    }
                    aux.usada = false;
                } else {
                    if (!(aux.izdo == null)) {//para las hojas izquierdas
                        if (aux.izdo.transicion.equals("e")) {
                            cola.add(aux.izdo);
                        } else {
                            estado.Mueve(aux.izdo.transicion, aux.izdo);//ingresando a los mueve del estado en nodo completo
//                            System.out.println(aux.izdo.transicion + " | " + aux.izdo.id);
                            //lo ingreso a una lista
                        }
                    }
                    if (!(aux.dcho == null)) {//para las hojas derechas
                        if (aux.dcho.transicion.equals("e")) {
                            cola.add(aux.dcho);
                        } else {
                            estado.Mueve(aux.dcho.transicion, aux.dcho);//enviando todo el nodo
//                            System.out.println(aux.dcho.transicion + " | " + aux.dcho.id);
                            //lo ingreso a una lista
                        }
                    }
                }
            }
        }
    }

    public class Estado {

        Stack<Integer> eps = new Stack<>();
        ArrayList<Mueve> lstMueve = new ArrayList<>();

        public void insertarEpsilon(int numero) {
            Iterator< Integer> iterador = eps.iterator();
            boolean busqueda=false;//para no ingresar número repetidos
            while (iterador.hasNext()) {
                Integer a = iterador.next();
                if (a==numero) {
                    busqueda=true;
                }
            }
            if (!busqueda) {
                eps.push(numero);
            }

        }

        public void Mueve(String transicion, Metodos.Nodo nod) {//aquí recibe el nodo

            if (lstMueve.isEmpty()) {//se inicializa la lista
                Mueve muv = new Mueve();
                muv.transicion = transicion;
                muv.listNumeros.add(nod);//agregando el sub-árbol a los mueve
                lstMueve.add(muv);
            } else {
                Iterator< Mueve> iterador = lstMueve.iterator();
                while (iterador.hasNext()) {
                    iterador.next();
                    if (!buscarTransicion(transicion, nod)) {//no lo encontró

                        Mueve muv = new Mueve();
                        muv.transicion = transicion;
                        muv.listNumeros.add(nod);//se agrega el nodo-arbol a la lista del mueve
                        lstMueve.add(muv);
                        break;
                    } else {
                        break;
                    }
                }
            }

        }

        public boolean buscarTransicion(String transicion, Metodos.Nodo nod) {
            boolean retorno = false;
            Iterator< Mueve> iterador = lstMueve.iterator();
            while (iterador.hasNext()) {
                Mueve elemento = iterador.next();
                if (elemento.transicion.equals(transicion)) {//lo encontró, aquí debe de ingresarlo
                    elemento.listNumeros.add(nod);
                    //  elemento.listNumeros.push(numero);
                    //  lstMueve.get(i).list.add(numero);//debe de insertar en la lstMueve
                    retorno = true;
                    break;
                }
            }
            return retorno;
        }

        public void imprimirMueve() {

            Iterator<Mueve> iterador = lstMueve.iterator();
            while (iterador.hasNext()) {
                Mueve elemento = iterador.next();
                System.out.println(elemento.transicion + elemento.imprimir());
            }
        }

        public void imprimirCerradura() {
            String cadena = "epsilon -> ";
            while (!eps.isEmpty()) {
                cadena = cadena + "|" + eps.pop();
            }
            System.out.println(cadena);
        }
        /*
        public void mueve(String transicion) {
            while (!cerradura.cerradura.isEmpty()) {
                if (cerradura.transición.equals(transicion)) {
                    //ya esta en la lista
                }else{
                    Transicion transi=new Transicion();
                    transi.ltrTransicion=transicion;
                    cerradura.cerradura.add(pila)
                }
            }

        }*/
    }

    public class Mueve {

        String transicion;

        //ArrayList<Integer> listNumeros = new ArrayList<>();
        Stack<Metodos.Nodo> listNumeros = new Stack<>();

        public String imprimir() {
            String retorno = " ->";
            Iterator<Metodos.Nodo> iterador = listNumeros.iterator();

            while (iterador.hasNext()) {
                retorno = retorno + " | " + iterador.next().id;
            }
            return retorno;
        }

        public void insertarNumEnMueve(Metodos.Nodo nodo) {
            listNumeros.add(nodo);
        }
    }

}
