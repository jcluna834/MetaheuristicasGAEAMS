package Abstract;

import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public abstract class Cruce {
    protected Random rand;
    
    /**
     * 
     * @param padre
     * @param madre
     * @return 
     */
    public abstract Individuo[] cruzar(Individuo padre, Individuo madre);
}
