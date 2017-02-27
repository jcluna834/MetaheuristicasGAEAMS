package fxMutacion;

import Abstract.Mutacion;
import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class Intercambio extends Mutacion {
    private int posicion1;
    private int posicion2;

    public Intercambio(Random rand) {
        this.rand = rand;
    }

    @Override
    public Individuo mutar(Individuo sujeto) {
        this.posicion1 = (int) (rand.nextDouble() * sujeto.getGenotipo().getGenes().length);
        do {
            this.posicion2 = (int) (rand.nextDouble() * sujeto.getGenotipo().getGenes().length);
        } while (posicion2 != posicion1);
        Double gen1 = sujeto.getGenotipo().getGen(posicion1);
        Double gen2 = sujeto.getGenotipo().getGen(posicion2);
        sujeto.getGenotipo().setGen(posicion1, gen2);
        sujeto.getGenotipo().setGen(posicion2, gen1);
        return sujeto;
    }
}
