/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metdothompson;

import java.util.ArrayList;
import java.util.Arrays;
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

    public void LimpiarEnAnchura() {
        Metodos.Nodo aux;
        if (raiz != null) {
            cola.add(raiz);//insertando la cabeza
            while (!cola.isEmpty()) {
                aux = cola.poll();
                aux.usada = false;
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
        //hola
    }

    public static Stack<Integer> sort(Stack<Integer> s) {//ordenar pilas enteras de mayor a menor

        if (s.isEmpty()) {
            return s;
        }
        int pivot = s.pop();
        // partition
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        while (!s.isEmpty()) {
            int y = s.pop();
            if (y < pivot) {
                left.push(y);
            } else {
                right.push(y);
            }
        }
        sort(left);
        sort(right);

        // merge
        Stack<Integer> tmp = new Stack<>();
        while (!right.isEmpty()) {
            tmp.push(right.pop());
        }
        tmp.push(pivot);
        while (!left.isEmpty()) {
            tmp.push(left.pop());
        }
        while (!tmp.isEmpty()) {
            s.push(tmp.pop());
        }
        return s;
    }

    static <T> boolean compareStacks(Stack<T> a, Stack<T> b) {
        if (a.isEmpty() != b.isEmpty()) {
            return false;
        }
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        T element_a = a.pop();
        T element_b = b.pop();
        try {
            if (((element_a == null) && (element_b != null)) || (!element_a.equals(element_b))) {
                return false;
            }
            return compareStacks(a, b);
        } finally { // restore elements
            a.push(element_a);
            b.push(element_b);
        }
    }

    public Estado retornoEstado(Mueve mueve) {//aqui le pongo a donde va el muv
        Estado retorno = null;
        Iterator<Metodos.Nodo> itNodo = mueve.listNum.iterator();//recorriendo los nodos del muevee
        Estado estadoPrueba = new Estado();
        while (itNodo.hasNext()) {//lista de subarboles
            Metodos.Nodo nod = itNodo.next();
            HacerCerraduraChafa(nod, estadoPrueba);
            LimpiarEnAnchura();
//            HacerCerradura(nod, est);
        }
        estadoPrueba.eps = sort(estadoPrueba.eps);

        if (estadoPrueba.eps != null) {
            boolean loEncontro = false;
            Iterator<Cerradura> iter = listaCerraduras.iterator();
            while (iter.hasNext()) {
                Cerradura cer = iter.next();
                Stack<Integer> temp = cer.num;

//                System.out.print(Arrays.toString(temp.toArray()));
//                System.out.println(Arrays.toString(estadoPrueba.eps.toArray()));
                if (compareStacks(temp, estadoPrueba.eps)) {
//                    System.out.println("igual");
                    loEncontro = true;
                    mueve.estado = cer.estado;
                    break;
                }
//                if (temp==estadoPrueba.eps) {
//                    
//                }
            }
            if (loEncontro) {

                retorno = null;

//                System.out.println("si esta en la lista de cerraduras");
            } else {//aquí hay que crear un nuevo estado
                Estado nuevoEstado = new Estado();
//                System.out.println("no esta en la lista de cerraduras");
                nuevoEstado.nombre = "S" + String.valueOf(contadorDeEstados);
                mueve.estado = "S" + String.valueOf(contadorDeEstados);
                retorno = nuevoEstado;
                //
            }

        }

        return retorno;
    }

    public void recorrer3() {

    }

    public void recorrer2() {
        Estado So = new Estado();
        So.nombre = "S0";
        HacerCerraduraChafa(raiz, So);
        So.eps = sort(So.eps); //ordena
        LimpiarEnAnchura();

//      So.imprimirCerradura();
        recorrerTrue(So);
//        imprimirCerraduras();

        estadosDeAceptacion();
//        listaDeEstados1();
        /*Stack<Integer> num1=new Stack<>();
        Stack<Integer> num2=new Stack<>();
        num1.push(1);
        num1.push(2);
        num1.push(3);
        
        num2.push(3);
        num2.push(2);
        num2.push(1);
        num2=sort(num2);
        if (compareStacks(num1, num2)) {
            System.out.println("iguales");
        }else{
            System.out.println("no iguales");
        }*/
    }
// Stack<Estado> pilaEstados = new Stack<>();
//    public ArrayList<Stack<Integer>> listaCerraduras = new ArrayList<>();
    public ArrayList<Cerradura> listaCerraduras = new ArrayList<>();

    int contadorDeEstados = 1;

    public void imprimirCerraduras() {
        System.out.println("------------------Cerraduras---------------");
        Iterator<Cerradura> it = listaCerraduras.iterator();
        while (it.hasNext()) {
            Cerradura cer = it.next();
            System.out.println(cer.estado + "->" + Arrays.toString(cer.num.toArray()));
        }
    }

    public int elMasGrande() {
        int retorno = 0;

        Iterator<Cerradura> it = listaCerraduras.iterator();
        while (it.hasNext()) {
            Cerradura cer = it.next();
            Iterator<Integer> itNum = cer.num.iterator();
            while (itNum.hasNext()) {
                int num = itNum.next();
                if (num > retorno) {
                    retorno = num;
                }
            }
        }
        return retorno;
    }
    ArrayList<String> listaDeEstadosDeAceptacion = new ArrayList<>();

    public boolean esEstadoDeAceptacion(String estado) {
        boolean retorno = false;
        if (listaDeEstadosDeAceptacion.isEmpty()) {
             estadosDeAceptacion();//llenando la lista de estados de aceptacion
        }
        Iterator<String> it = listaDeEstadosDeAceptacion.iterator();
        while (it.hasNext()) {
            String dato = it.next();
            if (dato.equals(estado)) {
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    public void estadosDeAceptacion() {
        System.out.println("-------------------Estados de Aceptacion-------------------");
        int ultimoNumero = elMasGrande();
        String estadosDeAceptacion = "";
        Iterator<Cerradura> it = listaCerraduras.iterator();
        while (it.hasNext()) {//recorriendo lista de cerraduras
            Cerradura cer = it.next();
//            System.out.println(cer.estado + "->" + Arrays.toString(cer.num.toArray()));
            Iterator<Integer> itNum = cer.num.iterator();
            boolean esDeAceptacion = false;
            while (itNum.hasNext()) {
                int num = itNum.next();
                if (num == ultimoNumero) {
                    esDeAceptacion = true;
                }
            }
            if (esDeAceptacion) {
                listaDeEstadosDeAceptacion.add(cer.estado);
                estadosDeAceptacion = estadosDeAceptacion + "|" + cer.estado;
            }

        }
        System.out.println(estadosDeAceptacion);
    }
    ArrayList<Estado> listaDeEstados = new ArrayList<>();

    public boolean evaluarCadena(String cadena) {
        Stack<Estado> pilaEstado = new Stack<>();
        pilaEstado.push(BuscarEstado("S0"));//inicio con el primer estado
        boolean retorno = false;
        boolean bandera2=true;
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println("Caracter " + i + ": " + cadena.charAt(i));
            Estado est = pilaEstado.pop();
            Boolean bandera = false;
            Iterator<Mueve> it = est.lstMueve.iterator();

            while (it.hasNext()) {
                Mueve muv = it.next();

                if (muv.transicion.equals(String.valueOf(cadena.charAt(i)))) {//encontro la transicion
                    System.out.println(est.nombre + "-->" + muv.transicion + "--->" + muv.estado);
                    pilaEstado.push(BuscarEstado(muv.estado));
                    bandera = true;
                    break;
                }
            }
            if (!bandera) {
                bandera2=false;
                pilaEstado.push(est);
                System.out.println("no lo encontro");
            }

        }
        
        if (esEstadoDeAceptacion(pilaEstado.pop().nombre)&&bandera2) {
            retorno=true;
        }
        
        return retorno;
    }

    public Estado BuscarEstado(String estadoABuscar) {
        Iterator<Estado> it = listaDeEstados.iterator();
        Estado retorno = null;
        while (it.hasNext()) {
            Estado est = it.next();
            if (estadoABuscar.equals(est.nombre)) {
                retorno = est;
                break;
            }

        }
        return retorno;
    }

    public void listaDeEstados1() {
        Iterator<Estado> it = listaDeEstados.iterator();
        while (it.hasNext()) {
            Estado est = it.next();
//            System.out.println("-> "+est.nombre);
            Iterator<Mueve> itMu = est.lstMueve.iterator();
            while (itMu.hasNext()) {
                Mueve muv = itMu.next();
//                String cadena="";
                System.out.println(est.nombre + "-->" + muv.transicion + "--->" + muv.estado);

//                Iterator<Metodos.Nodo> itNum=muv.listNum.iterator();
//                
//                while (itNum.hasNext()) {                    
//                    Metodos.Nodo nod= itNum.next();
//                    cadena=cadena+","+nod.id;
//                }
//                 System.out.println(cadena);
            }
        }
    }

    public void recorrerTrue(Estado estdo) {//este estado ya tiene que venir con cerraduras
//       HacerCerradura(sub_arbol, estdo);
//        estdo.imprimirCerradura();
        Cerradura cerr = new Cerradura();
        cerr.estado = estdo.nombre;
        cerr.num = estdo.eps;
        listaCerraduras.add(cerr);
        listaDeEstados.add(estdo);
        // System.out.println(estdo.nombre + "->" + Arrays.toString(estdo.eps.toArray()));
        Iterator<Mueve> itMuv = estdo.lstMueve.iterator(); //recorriendo los mueve, para hacer mas estados, o cerraduras
        while (itMuv.hasNext()) {//aquí creo los estados nuevos//primer mueve
            Mueve muv = itMuv.next();//avanzo con cada mueve
            Estado estd = retornoEstado(muv);//el nuevo estado
//            LimpiarEnAnchura();
            if (estd != null) {//vuelve a recorrer el estado
                Iterator<Metodos.Nodo> itNodo = muv.listNum.iterator();//recorriendo los nodos del muevee
                //aquí limpio
                while (itNodo.hasNext()) {
                    Metodos.Nodo nod = itNodo.next();

                    HacerCerraduraChafa(nod, estd);
                    estd.eps = sort(estd.eps);
                }
                LimpiarEnAnchura();
                contadorDeEstados++;//incrementamos el contador de esatados;

//                System.out.println(muv.imprimir());
                recorrerTrue(estd);
                //lista de estados con cerradura

            }
//            System.out.println("-----------------------");
            String dot = "";
            dot = "\"" + estdo.nombre + "\" -> " + muv.imprimir();
//            listaDeEstados.add(estd);//agrego a la lista de estados
//            System.out.print(estdo.nombre+" -> ");
//            System.out.println(muv.imprimir());
            System.out.println(dot);
//            
            // S1 -> S0 [label="a"];
        }
    }

    public void recorrer() {
        Estado So = new Estado();
        Stack<Estado> pilaEstados = new Stack<>();
        HacerCerradura(raiz, So);
        pilaEstados.add(So);
//        Metodos.Nodo aux = raiz;
        int i = 0;
        while (!pilaEstados.isEmpty()) {//recorriendo los etados
            System.out.println("ab");
            Estado est = pilaEstados.pop();

            Iterator<Mueve> itMuv = est.lstMueve.iterator();//creando el otro iterador para recorrer los mueves
            if (i == 0) {

                while (itMuv.hasNext()) {//aquí creo los estados nuevos
                    Mueve muv = itMuv.next();
                    System.out.println(muv.imprimir());

                    muv.estado = "so";

                }
                i++;
            } else {
                while (itMuv.hasNext()) {
                    Mueve muv = itMuv.next();
                    Iterator<Metodos.Nodo> itNodo = muv.listNum.iterator();//recorriendo los nodos del muevee
                    while (itNodo.hasNext()) {
                        Metodos.Nodo nod = itNodo.next();
                        HacerCerradura(nod, est);

                    }
                    est.imprimirMueve();
                }
            }
        }

    }

    public Estado estdo(Mueve mueve) {
        Estado retorno = new Estado();

        return retorno;

    }

    public void recorrer1() {
        /*System.out.println("------------------So------------------");
        Estado So = new Estado();
        HacerCerradura(raiz, So);
        So.eps = sort(So.eps);//Ordenando
        So.imprimirCerradura();
        So.imprimirMueve();

        System.out.println("------------------S1------------------");
        Estado S1 = new Estado();
        HacerCerradura(So.lstMueve.get(0).listNum.pop(), S1);
        HacerCerradura(So.lstMueve.get(0).listNum.pop(), S1);
        S1.eps = sort(S1.eps);//Ordenando
        S1.imprimirCerradura();
        S1.imprimirMueve();
         */
        Estado So = new Estado();
//        HacerCerradura(raiz, So);

//        ArrayList<Estado> lstEstados = new ArrayList<>();
        Stack<Estado> pilaEstados = new Stack<>();
        HacerCerradura(raiz, So);
        pilaEstados.add(So);
        Iterator<Estado> it = pilaEstados.iterator();
        while (!pilaEstados.isEmpty()) {//recorriendo los etados
            System.out.println("entro");

            int contador = 0;
            Estado est = it.next();
            Iterator<Mueve> itMuv = est.lstMueve.iterator();//creando el otro iterador para recorrer los mueves

            if (contador == 0) {//para el primer estado

//                est.imprimirMueve();
//                est.imprimirCerradura();
//                Estado es = new Estado();
//                contador = 1;
//                lstEstados.add(es);
            } else {
//                System.out.println("segunda iteración");
                while (itMuv.hasNext()) {
                    Mueve muv = itMuv.next();
                    Iterator<Metodos.Nodo> itNodo = muv.listNum.iterator();//recorriendo los nodos del muevee
                    while (itNodo.hasNext()) {
                        Metodos.Nodo nod = itNodo.next();
                        HacerCerradura(nod, est);
                    }
                    est.imprimirMueve();
//                Estado S1 = new Estado();
//                HacerCerradura(So.lstMueve.get(0).listNum.pop(), S1);
                }
            }
        }
    }

    public void metodoPrueba() {
        /*   ArrayList<Integer> list = new ArrayList<>();
//         list.add(1);
        
        list.add(0);
        Iterator<Integer> it = list.iterator();
//        int contador = 1;
      
        while (it.hasNext()) {
            Integer a = it.next();
            System.out.println(String.valueOf(a));
//            list.add(contador);
list.add(1);
//            contador++;
        }*/
        Stack<Integer> pila = new Stack<>();
        int contador = 0;
        pila.push(contador);

        while (!pila.isEmpty()) {
            System.out.println(" entro");
            System.out.println(pila.pop());
            pila.push(null);
            contador++;
        }
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
//                        System.out.println("no lo encontró -> " + aux.id);
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

    public void HacerCerraduraChafa(Metodos.Nodo nodo, Estado estado) {
        Metodos.Nodo aux;
        if (nodo != null) {
            Queue<Metodos.Nodo> cola = new LinkedList<>();
            cola.add(nodo);//insertando la cabeza a una coola
            while (!cola.isEmpty()) {//recorre en anchura
                aux = cola.poll();//saca de la cola
                estado.insertarEpsilon(aux.id);//lo meto a la pila de epsilon del estado

                if (aux.izdo == null && aux.dcho == null && aux.usada == false) {//este nodo es el último
                    aux.usada = true;//bandera para no volver a recorrerlo
                    Metodos.Nodo temporal = buscar(aux.id);//hace la búsqueda

                    if (temporal == null) {//no lo encontró
//                        System.out.println("no lo encontró -> " + aux.id);
                    } else if (temporal.transicion.equals("e")) {
                        String cadena = "";
                        if (temporal.izdo != null && temporal.dcho != null) {
                            cadena = temporal.id + "-->izdo-" + temporal.izdo.transicion + "|" + temporal.izdo.id + "-dcho-" + temporal.dcho.transicion + "|" + temporal.dcho.id;
                        } else if (temporal.izdo != null && temporal.dcho == null) {
                            cadena = temporal.id + "-->izdo-" + temporal.izdo.transicion + "|" + temporal.izdo.id;

                        } else if (temporal.izdo == null && temporal.dcho != null) {
                            cadena = temporal.id + "-->dcho-" + temporal.dcho.transicion + "|" + temporal.dcho.id;

                        } else if (temporal.izdo == null && temporal.dcho == null) {
                            cadena = temporal.id + "-->los dos nulos";
                        }
//                        System.out.println(cadena);
                        HacerCerraduraChafa(temporal, estado);

                    }
//                    aux.usada = false;
                } else {
                    if (!(aux.izdo == null)) {//para las hojas izquierdas
                        if (aux.izdo.transicion.equals("e")) {
                            cola.add(aux.izdo);
                        } else {
                            estado.Mueve(aux.izdo.transicion, aux.izdo);//ingresando a los mueve del estado en nodo completo
//                            System.out.println(aux.izdo.transicion + " | " + aux.izdo.id);
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

    public class Cerradura {

        String estado;
        Stack<Integer> num = new Stack<>();
    }

    public class Estado {

        String nombre;
        Stack<Integer> eps = new Stack<>();
        ArrayList<Mueve> lstMueve = new ArrayList<>();

        public void insertarEpsilon(int numero) {
            Iterator< Integer> iterador = eps.iterator();
            boolean busqueda = false;//para no ingresar número repetidos
            while (iterador.hasNext()) {
                Integer a = iterador.next();
                if (a == numero) {
                    busqueda = true;
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
//                muv.listNumeros.add(nod);
                muv.insert(nod);//agregando el sub-árbol a los mueve
                lstMueve.add(muv);
            } else {
                Iterator< Mueve> iterador = lstMueve.iterator();
                while (iterador.hasNext()) {
                    iterador.next();
                    if (!buscarTransicion(transicion, nod)) {//no lo encontró

                        Mueve muv = new Mueve();
                        muv.transicion = transicion;
//                        muv.listNumeros.add(nod);
                        muv.insert(nod);//se agrega el nodo-arbol a la lista del mueve
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
                    elemento.insert(nod);
                    //  elemento.listNumeros.push(numero);
                    //  lstMueve.get(i).list.add(numero);//debe de insertar en la lstMueve
                    retorno = true;
                    break;
                }
            }
            return retorno;
        }

        public void imprimirMueve1() {//se puede borrar

            Iterator<Mueve> iterador = lstMueve.iterator();
            while (iterador.hasNext()) {
                Mueve elemento = iterador.next();
                System.out.println(elemento.imprimir1());
            }
        }

        public void imprimirMueve() {

            Iterator<Mueve> iterador = lstMueve.iterator();
            while (iterador.hasNext()) {
                Mueve elemento = iterador.next();
                System.out.println(elemento.transicion + elemento.imprimir());
            }
        }

        public void imprimirCerradura() {
            String cadena = nombre + " -> ";
            while (!eps.isEmpty()) {
                cadena = cadena + "|" + eps.pop();
            }
            System.out.println(cadena);
        }
    }

    public class Mueve {

        String transicion;
        String estado;

        //ArrayList<Integer> listNumeros = new ArrayList<>();
        Stack<Metodos.Nodo> listNum = new Stack<>();

        public String imprimir() {
//            String retorno = "\"" + transicion + "\" -> " + estado ;
            String retorno = "\"" + estado + "\"" + "[label =" + "\"" + transicion + "\"];";
            //S1 -> S0 [label="a"];
            //String retorno = transicion + "|" + estado + " -> ";
            Iterator<Metodos.Nodo> iterador = listNum.iterator();

            while (iterador.hasNext()) {
//                retorno = retorno + " | " + iterador.next().id;
                iterador.next();
            }
            return retorno;
        }

        public String imprimir1() {//se puede eliminar
//            String retorno = "\"" + transicion + "\" -> " + estado ;
//            String retorno = "\"" + estado + "\"" + "[label =" + "\"" + transicion + "\"];";
            //S1 -> S0 [label="a"];
            String retorno = transicion + " -> ";
            Iterator<Metodos.Nodo> iterador = listNum.iterator();

            while (iterador.hasNext()) {
                retorno = retorno + " | " + iterador.next().id;
                iterador.next();
            }
            return retorno;
        }

        public void insert(Metodos.Nodo nodoNuevo) {

            Iterator<Metodos.Nodo> iterador = listNum.iterator();
            boolean busqueda = false;//para no ingresar número repetidos
            while (iterador.hasNext()) {
                Integer a = iterador.next().id;
                if (a == nodoNuevo.id) {
                    busqueda = true;
                }
            }
            if (!busqueda) {
                listNum.push(nodoNuevo);
            }

        }
    }

}
