
package Abstract;

import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public abstract class Genotipo {
    protected Random rand;
    
    /**
     * 
     * @param i
     * @param gen 
     */
    public abstract void setGen(int i, Double gen);
    
    /**
     * 
     * @param i
     * @return 
     */
    public abstract Double getGen(int i);
    
    /**
     * 
     * @return 
     */
    public abstract Double[] getGenes();
    
    /**
     * 
     * @param cromosoma 
     */
    public abstract void setGenes(Double[] cromosoma);
    
    /**
     * 
     * @return 
     */
    public abstract Genotipo copiar();
}
