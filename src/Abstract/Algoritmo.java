package Abstract;

import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public abstract class Algoritmo {
    protected Cruce funcionCruce;
    protected Mutacion funcionMutacion;
    protected Seleccion funcionSeleccion;
    protected PaisajeAptitud funcionAptitud;
    protected Reemplazo funcionReemplazo;
    protected Poblacion poblacion;
    protected Random rand;
    protected int numIteraciones;
    
    /**
     * Ejecuta el algoritmo.
     * @return El mejor individuo (mejor solucion) al finalizar la ejecucion.
     */
    public abstract Individuo ejecutar();

    /**
     * Inicializa la clase algoritmo para posteriormente ejecutar.
     * @param funcionCruce
     * @param funcionMutacion
     * @param funcionSeleccion
     * @param funcionAptitud
     * @param funcionReemplazo
     * @param poblacion
     * @param numIteraciones 
     */
    public void inicializar(Cruce funcionCruce, Mutacion funcionMutacion, Seleccion funcionSeleccion, PaisajeAptitud funcionAptitud, Reemplazo funcionReemplazo, Poblacion poblacion, int numIteraciones) {
        this.funcionCruce = funcionCruce;
        this.funcionMutacion = funcionMutacion;
        this.funcionSeleccion = funcionSeleccion;
        this.funcionAptitud = funcionAptitud;
        this.funcionReemplazo = funcionReemplazo;
        this.poblacion = poblacion;
        this.numIteraciones = numIteraciones;
    }
    
    /**
     * 
     * @param p
     * @return 
     */
    public double Quality(Poblacion p) {
        if(funcionAptitud.getObjetivo() == 0) {
            return Integer.MAX_VALUE - funcionAptitud.evaluar(p);
        }else {
            return funcionAptitud.evaluar(p);
        }
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public double Quality(Individuo i) {
        if(funcionAptitud.getObjetivo() == 0) {
            return Integer.MAX_VALUE - funcionAptitud.evaluar(i);
        }else {
            return funcionAptitud.evaluar(i);
        }
    }
}
