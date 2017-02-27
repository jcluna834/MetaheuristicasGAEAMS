
package Abstract;

import Individuos.Individuo;
import java.util.List;
import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public abstract class Reemplazo {
    protected Random rand;
    
    /**
     * 
     * @param poblacion
     * @param individuos
     * @param opcion
     * @return 
     */
    public abstract Poblacion reemplazar(Poblacion poblacion, List<Individuo> individuos, int opcion);
    
    protected boolean comparar(Individuo ind1, Individuo ind2, int opcion) {
        if (opcion == 0) {
            return (ind1.getAptitud() < ind2.getAptitud());
        }
        return (ind1.getAptitud() > ind2.getAptitud());
    }
}
