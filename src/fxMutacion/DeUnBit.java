package fxMutacion;

import Abstract.Mutacion;
import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class DeUnBit extends Mutacion {

    private int value;

    public DeUnBit(Random rand) {
        this.rand = rand;
    }

    @Override
    public Individuo mutar(Individuo sujeto) {
        value = (int) (rand.nextDouble() * sujeto.getGenotipo().getGenes().length);
        if (sujeto.getGenotipo().getGen(value) == 0.0) {
            sujeto.getGenotipo().setGen(value, new Double(1));
        } else {
            sujeto.getGenotipo().setGen(value, new Double(0));
        }
        return sujeto;
    }
}
