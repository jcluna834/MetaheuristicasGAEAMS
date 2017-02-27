package fxCruce;

import Abstract.Cruce;
import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class DeUnPunto extends Cruce {
    private int cruce;

    public DeUnPunto(Random rand) {
        this.rand = rand;
    }

    @Override
    public Individuo[] cruzar(Individuo padre, Individuo madre) {
        Individuo[] hijos = new Individuo[2];
        cruce = (int) (rand.nextDouble() * padre.getGenotipo().getGenes().length);
        hijos[0] = madre.copiar();
        hijos[1] = padre.copiar();
        for (int i = 0; i < cruce; i++) {
            hijos[0].getGenotipo().setGen(i, padre.getGenotipo().getGen(i));
            hijos[1].getGenotipo().setGen(i, madre.getGenotipo().getGen(i));
        }
        return hijos;
    }
}