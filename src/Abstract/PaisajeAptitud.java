package Abstract;

import Individuos.Individuo;
import java.math.BigDecimal;

/**
 *
 * @author CristianCamilo
 */
public abstract class PaisajeAptitud {
    protected Double limiteInferior;
    protected Double limiteSuperior;
    protected double opc;
    /**
     * 
     * @param poblacion
     * @return 
     */
    public double evaluar(Poblacion poblacion) {
        if (poblacion.getAptitud() == null) {
            double aptitudTotal = 0.0;
            for (Individuo i : poblacion.getIndividuos()) {
                Double aptitud = i.getAptitud();
                if (aptitud == null)
                    aptitud = evaluar(i);
                aptitudTotal += aptitud;
            }
            poblacion.setAptitud(aptitudTotal);
        }
        return poblacion.getAptitud();
    }
    
    /**
     * 
     * @param individuo
     * @return 
     */
    public abstract double evaluar(Individuo individuo);
    
    /**
     * 
     * @return 
     */
    public Double getLimiteInferior() {
        return limiteInferior;
    }
    
    /**
     * 
     * @return 
     */
    public Double getLimiteSuperior() {
        return limiteSuperior;
    }

    /**
     * 
     * @return 
     */
    public double getObjetivo() {
        return opc;
    }
}
