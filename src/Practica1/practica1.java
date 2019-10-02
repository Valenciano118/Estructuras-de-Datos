package Practica1;

import java.util.*;

public class practica1 {

    /**
     * Método que toma dos conjuntos de enteros y separa los elementos entre aquellos que sólo aparecen una vez
     * y aquellos que aparecen repetidos. El método modifica los conjuntos que toma como parámetros.
     *
     * @param unicos    A la entrada un conjunto de enteros. A la sálida los elementos que solo aparecen en uno de
     *                  los conjuntos.
     * @param repetidos A la entrada un conjunto de enteros. A la salida los elementos que aparecen en ambos conjuntos.
     */
    static public void separa(Set<String> unicos, Set<String> repetidos) {
        Set<String> aux = new HashSet<>();
        aux.addAll(unicos);
        aux.addAll(repetidos);
        repetidos.retainAll(unicos);
        unicos.removeAll(repetidos);
        aux.removeAll(repetidos);
        unicos.addAll(aux);
    }

    /**
     * Toma un iterador a una colección de enteros positivos y devuelve como resultado un conjunto con aquellos elementos
     * de la colección que no son múltiplos de algún otro de la colección. Los ceros son descartados
     *
     * @param iter Iterador a una colección de enteros
     * @return Conjunto de de enteros.
     */
    static public Set<Integer> filtra(Iterator<Integer> iter) {
        int contador = 0, elem = 0;
        List<Integer> aux = new ArrayList<>();
        Set<Integer> resultado = new TreeSet<>();
        while (iter.hasNext()) {
            elem = iter.next();
            if (elem > 0)
                aux.add(elem);
        }

        for (int i = 0; i < aux.size(); i++) {
            contador = 0;
            for (int j = 0; j < aux.size(); j++)
                if (j != i && aux.get(j) != aux.get(i) && aux.get(i) % aux.get(j) == 0)
                    contador++;
            if (contador == 0)
                resultado.add(aux.get(i));
        }
        return resultado;
    }

    /**
     * Toma una colección de conjuntos de <i>String</i> y devuelve como resultado un conjunto con aquellos <i>String </i>
     * Que aparecen en al menos dos conjuntos de la colección.
     *
     * @param col Coleccion de conjuntos de <i>String</i>
     * @return Conjunto de <i>String</i> repetidos.
     */
    static public Set<String> repetidos(Collection<Set<String>> col) {
        Set<String> elem1;
        String elem2;

        Set<String> resultado = new HashSet<>();
        Set<String> aux = new HashSet<>();

        Iterator<Set<String>> it = col.iterator();

        while(it.hasNext()){
            elem1=it.next();
            Iterator<String> s = elem1.iterator();
            while(s.hasNext()){
                elem2=s.next();
                if(!aux.add(elem2)){
                     resultado.add(elem2);
                }
            }
        }
        return resultado;
    }
}
