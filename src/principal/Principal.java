package principal;

import Abstract.*;
import fxAptitud.*;
import fxCruce.*;
import fxMutacion.*;
import fxReemplazo.*;
import fxSeleccion.*;
import Algoritmos.*;
import Archivos.Archivo;
import Individuos.*;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        Seleccion seleccion;
        Mutacion mutacion;
        Reemplazo reemplazo;
        Cruce cruce;
        PaisajeAptitud paisaje;
        Poblacion poblacion;
        Random rand;
        Double limiteInferior, limiteSuperior;
        int opcion, cantidadPoblacion, cantidadGenes, numIteraciones;
        Long semilla;
        Algoritmo algoritmo;
        Archivo archivo;
        archivo = new Archivo("ArchivoMetaHeuristica.txt");
        double [][] matriz = archivo.getMatriz();
        
        //Semilla
        semilla = new Long(1);
        //semilla = null;
        
        //Random
        if(semilla != null)
            rand = new Random(semilla);
        else
            rand = new Random();
        
        //limites
        limiteInferior = -10.0;
        limiteSuperior = 10.0;
        
        //opcion
        opcion = 0; //Minimizar
        //opcion = 1; //Maximizar
        
        //Cantidad de Poblacion
        cantidadPoblacion = 100;
        //Cantidad de Genes
        cantidadGenes = ((matriz[0].length * matriz[0].length)/2 + (matriz[0].length/2));
        
        //Numero de iteraciones
        numIteraciones = 20000;
        
        //Algoritmo 
        algoritmo = new GA();
        //algoritmo = new EA();
        //GA con cromosomas numeros reales
        cruce = new DeUnPunto(rand);
        mutacion = new Gen(limiteInferior, limiteSuperior, rand);
        seleccion = new Elitismo(2);
        paisaje = new Coeficientes(limiteInferior, limiteSuperior, opcion, matriz);
        poblacion = new PwC(paisaje, rand, cantidadPoblacion, cantidadGenes);
        reemplazo = new DelPeor();
        algoritmo.inicializar(cruce, mutacion, seleccion, paisaje, reemplazo, poblacion, numIteraciones);
        Individuo ind = algoritmo.ejecutar();
        System.out.println("\nMejor Individuo");
        ind.mostrar();
        System.out.println("Cantidad De Lineas: " + matriz.length);
        System.out.println("Dimensiones : " + matriz[0].length);
        System.out.println("Numero de iteraciones: " + numIteraciones);
        System.out.println("Coeficientes esperados: " + cantidadGenes);
        System.out.println("Poblacion: " + cantidadPoblacion);
    }
}
