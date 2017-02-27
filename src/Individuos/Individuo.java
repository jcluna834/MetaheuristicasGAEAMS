package Individuos;

import Abstract.Genotipo;
import Abstract.PaisajeAptitud;

/**
 *
 * @author CristianCamilo
 */
public class Individuo implements Comparable<Individuo> {

    private Genotipo estructura;
    private Double aptitud;
    private final PaisajeAptitud funcion;

    public Individuo(PaisajeAptitud funcion) {
        this.funcion = funcion;
        aptitud = null;
    }

    public Genotipo getGenotipo() {
        return estructura;
    }

    public void setGenotipo(Genotipo nuevo) {
        estructura = nuevo;
    }

    public void setAptitud(Double aptitud) {
        if(aptitud == null)
            this.aptitud = funcion.evaluar(this);
        else
            this.aptitud = aptitud;
    }

    public Double getAptitud() {
        return aptitud;
    }

    public Individuo copiar() {
        Individuo copia = new Individuo(funcion);
        copia.setGenotipo(estructura.copiar());
        return copia;
    }

    @Override
    public int compareTo(Individuo o) {
        if (aptitud < o.getAptitud()) {
            return -1;
        }
        if (aptitud > o.getAptitud()) {
            return 1;
        }
        return 0;
    }
    
    public void mostrar() {
        if(getAptitud() != null)
            System.out.println("Aptitud: " + getAptitud());
        for(Object o: getGenotipo().getGenes()) {
            System.out.print( o + " ");
        }
        System.out.println();
    }

    public boolean esVacio() {
        return (getGenotipo().getGen(0)==null);
    }
}
