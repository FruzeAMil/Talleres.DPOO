package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros() {
        int[] x = new int[arregloEnteros.length];
        for (int i = 0; i < arregloEnteros.length; i++) {
            x[i] = arregloEnteros[i];
        }
        return x;
    }


    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] x = new String[arregloCadenas.length];
		for (int i = 0; i< arregloCadenas.length; i++) {
			x[i] = arregloCadenas[i];
		}
    	return x;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero(int entero) {
        int[] x = new int[arregloEnteros.length + 1];
        for (int i = 0; i < arregloEnteros.length; i++) {
            x[i] = arregloEnteros[i];
        }
        x[arregloEnteros.length] = entero;
        arregloEnteros = x;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena(String cadena) {
        String[] x = new String[arregloCadenas.length + 1];
        for (int i = 0; i < arregloCadenas.length; i++) {
            x[i] = arregloCadenas[i];
        }
        x[arregloCadenas.length] = cadena;
        arregloCadenas = x; 
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int i = 0;
    	for (int numero: arregloEnteros) {
    		if (numero!= valor) {
    		i++;
    		}
    	}
    	int[] x = new int[i];
    	int j = 0;
    	for(int numero: arregloEnteros) {
    		if (numero != valor) {
    			x[j++]= numero;
    		}
    	}
    	arregloEnteros= x;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int i = 0;
        for (String str : arregloCadenas) {
            if (!str.equals(cadena)) {
            i++;
            }
        }
        String[] x = new String[i];
        int j = 0;
        for (String str : arregloCadenas) {
            if (!str.equals(cadena)) {
                x[j++] = str;
            }
        }
        arregloCadenas = x;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int n = arregloEnteros.length;
        int[] x = new int[n + 1];
        posicion = Math.max(0, Math.min(posicion, n));
        for (int i = 0, j = 0; i < n + 1; i++) {
            if (i == posicion) {
                x[i] = entero;
            } else {
                x[i] = arregloEnteros[j++];
            }
        }
        arregloEnteros = x;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion(int posicion) {
        int t = arregloEnteros.length;
        if (posicion < 0 || posicion >= t) {
            return;
        }
        int[] x = new int[t - 1];
        int j = 0;
        for (int i = 0; i < t; i++) {
            if (i != posicion) {
                x[j++] = arregloEnteros[i];
            }
        }
        arregloEnteros = x;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	arregloEnteros = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            arregloEnteros[i] = (int) valores[i];
        }
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	arregloCadenas = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            arregloCadenas[i] = objetos[i].toString();
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int u = arregloEnteros.length;
    	int[] x = new int[u];
    	int j =0;
    	for (int i: arregloEnteros) {
            if (i < 0) {
                i *= -1;
            }
            x[j]=i;
            j++;
        }
    	arregloEnteros=x;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int i = 0;
        for (int numeros : arregloEnteros) {
            if (numeros == valor) {
            i++;
            }
        }
        return i;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int i = 0;
        for (String str : arregloCadenas) {
            if (str.equalsIgnoreCase(cadena)) {
            i++;
            }
        }
        return i;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int j = contarApariciones(valor);
        int[] posiciones = new int[j];
        int k = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[k++] = i;
            }
        }
        return posiciones;    
        }
   

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros.length == 0) {
    		return new int[0];
    	}
        int min = 2000000000;
        int max = -900000000;
        for (int numero : arregloEnteros) {
            if (numero < min) {
            	min = numero;
            } 
            if (numero > max) {
            	max = numero;
            }
        }
        return new int[]{min, max};
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();
        for (int numero : arregloEnteros) {
            histograma.put(numero, histograma.getOrDefault(numero, 0) + 1);
        }
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	HashMap<Integer, Integer> hist = calcularHistograma();
        int i = 0;
        for (int frecuencia : hist.values()) {
            if (frecuencia > 1) {
            	i++;
            }
        }
        return i;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	return Arrays.equals(arregloEnteros, otroArreglo);
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	int[] c1 = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        int[] c2 = Arrays.copyOf(otroArreglo, otroArreglo.length);
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
        arregloEnteros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = minimo + (int) (Math.random() * (maximo - minimo + 1));
        }
    }

}
