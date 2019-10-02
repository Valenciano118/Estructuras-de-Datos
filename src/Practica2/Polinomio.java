package Practica2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Polinomio {

    // La lista de monomios
    private List<Monomio> datos = new LinkedList<Monomio>();

    /**
     * Constructor por defecto. La lista de monomios está vacía
     */
    public Polinomio() {
    }

    ;

    /**
     * Constructor a partir de un vector. Toma los coeficientes de los monomios
     * de los valores almacenados en el vector, y los exponentes son las
     * posiciones dentro del vector. Si <code>v[i]</code> contiene
     * <code>a</code> el monomio contruido será aX^i. <br>
     * <p>
     * Por ejemplo: <br>
     * <p>
     * v = [-1, 0, 2] -> 2X^2 -1X^0
     *
     * @param v
     */
    public Polinomio(double v[]) {
        for (int i = 0; i < v.length; i++) {
            if (Cero.esCero(v[i])) {
                datos.add(new Monomio(v[i], i));
            }
        }
        // TODO Ejercicio 1
    }

    /**
     * Constructor copia
     *
     * @param otro
     * @throws <code>NullPointerException</code> si el parámetro es nulo
     */
    public Polinomio(Polinomio otro) {
        if (otro == null)
            throw new NullPointerException();

        for (Monomio item : otro.datos)
            datos.add(new Monomio(item));
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();


        boolean primero = true;

        for (int i = 0; i < datos.size(); i++) {
            Monomio item = datos.get(i);

            if (item.coeficiente < 0) {
                str.append('-');
                if (!primero)
                    str.append(' ');
            } else if (!primero)
                str.append("+ ");

            str.append(Math.abs(item.coeficiente));
            if (item.exponente > 0)
                str.append('X');
            if (item.exponente > 1)
                str.append("^" + item.exponente);

            if (i < datos.size() - 1)
                str.append(' ');

            primero = false;
        }
        if (primero)
            str.append("0.0");

        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Polinomio other = (Polinomio) obj;

        if (this.datos.size() != other.datos.size())
            return false;

        Iterator<Monomio> iter1 = this.datos.iterator();
        Iterator<Monomio> iter2 = other.datos.iterator();

        while (iter1.hasNext())
            if (!(iter1.next().equals(iter2.next())))
                return false;

        return true;
    }

    /**
     * Devuelve la lista de monomios
     */
    public List<Monomio> monomios() {
        return datos;
    }

    /**
     * Suma un polinomio sobre <code>this</code>, es decir, modificando el
     * polinomio local. Debe permitir la auto autosuma, es decir,
     * <code>polinomio.sumar(polinomio)</code> debe dar un resultado correcto.
     *
     * @param otro
     * @return <code>this<\code>
     * @throws <code>NullPointeExcepction</code> en caso de que el parámetro sea <code>null</code>.
     */
    public void sumar(Polinomio otro) {
    	/*int contador=0;
    	Monomio aux1=null,aux2=null;
		for(int i=0;i<datos.size();i++){
			aux1=datos.get(i);
			for(int j=0;j<otro.datos.size();j++){
				if(this.datos.get(i).exponente==otro.datos.get(j).exponente)
					contador++;
			}
			if(contador)

		}
		*/
        /*List<Monomio> aux = new LinkedList<Monomio>();
        for(int i=0;i<datos.size();i++)
        	aux.add(datos.get(i));
        for(int i=0;i<otro.datos.size();i++) {
			if(aux.contains(datos.get(i)))
				aux.get
        }*/

        /*Hacerlo con iteradores, en cada iteración del bucle leemos el siguiente monomio de cada lista. si tienen el mismo exponente se suman sin mas. Si el this es menor que
         otro avanzamos this, si el otro es menor se añade detrás del elemento actual de this. Si al sumar el coeficiente es 0 se deberá eliminar ese elemento.Si una de las listas
         llegan al final tendremos que añadir los elementos que queden*/
        Iterator<Monomio> it1 = this.datos.iterator();
        Iterator<Monomio> it2 = otro.datos.iterator();

        while(it1.hasNext() && it2.hasNext()){
        	if(it1.next().exponente==it2.next().exponente){

			}
		}

        //TODO Ejercicio 1
    }


    /**
     * Multiplica el polinomio <code>this</code> por un monomio.
     *
     * @param mono
     */
    public void multiplicarMonomio(Monomio mono) {
        for (Monomio item : this.datos) {
            item.coeficiente *= mono.coeficiente;
            item.exponente += mono.exponente;
        }
        // TODO Ejercicio 1
    }
}
