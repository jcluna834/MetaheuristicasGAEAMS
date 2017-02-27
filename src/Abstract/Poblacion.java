package Abstract;

import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public abstract class Poblacion {
    protected Individuo[] individuos;
    protected Double aptitud;
    protected Random rand;
    
    /**
     * 
     * @return 
     */
    public Individuo[] getIndividuos() {
        return individuos;
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public Individuo getIndividuo(int i){
        return individuos[i];
    }
    
    /**
     * 
     * @param i
     * @param nuevo 
     */
    public void setIndividuo(int i, Individuo nuevo){
        individuos[i] = nuevo;
    }
    
    /**
     * 
     * @param aptitud 
     */
    public void setAptitud(Double aptitud) {
        this.aptitud = aptitud;
    }
    
    /**
     * 
     * @return 
     */
    public Double getAptitud() {
        return aptitud;
    }
    
    /**
     * 
     * @param limiteInferior
     * @param limiteSuperior 
     */
    public abstract void inicializar(double limiteInferior, double limiteSuperior);

    public abstract Poblacion copiar(int i);

    public void addChild(Individuo x) {
        int i = 0;
        while(i < getIndividuos().length && getIndividuo(i)!=null && !getIndividuo(i).esVacio()) {i++;}
        if(i<getIndividuos().length)
            setIndividuo(i, x);
    }
    
    public void mostrar() {
        if(getAptitud()!=null)
            System.out.println("Aptitud Poblacion: " + getAptitud());
        for(Individuo i: individuos)
            i.mostrar();
        System.out.println();
    }
}
