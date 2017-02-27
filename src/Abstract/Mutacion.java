package Abstract;

import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public abstract class Mutacion {
    protected Random rand;
    /**
     * 
     * @param sujeto
     * @return 
     */
    public abstract Individuo mutar(Individuo sujeto);
}
