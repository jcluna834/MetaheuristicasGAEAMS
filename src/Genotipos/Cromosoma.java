
package Genotipos;

import Abstract.Genotipo;
import java.math.BigDecimal;

/**
 *
 * @author CristianCamilo
 */
public class Cromosoma extends Abstract.Genotipo {
    private Double[] genes;
    
    /**
     * 
     * @param tam 
     */
    public Cromosoma(int tam) {
        genes = new Double[tam];
    }

    @Override
    public Double[] getGenes() {
        return genes;
    }
    
    @Override
    public Double getGen(int i) {
        return genes[i];
    }
    
    @Override
    public void setGen(int i, Double num) {
        genes[i] = new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

    @Override
    public void setGenes(Double[] cromosoma) {
        this.genes = cromosoma;
    }
    
    @Override
    public Genotipo copiar() {
        Genotipo copia = new Cromosoma(genes.length);
        Double[] aux = copia.getGenes();
        System.arraycopy(genes, 0, aux, 0, genes.length);
        copia.setGenes(aux);
        return copia;
    }
}
