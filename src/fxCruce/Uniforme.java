package fxCruce;

import Abstract.*;
import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class Uniforme extends Cruce {

    private final Individuo[] hijos;
    private int[] mascara;

    public Uniforme(Random rand) {
        this.rand = rand;
        hijos = new Individuo[2];
    }

    @Override
    public Individuo[] cruzar(Individuo padre, Individuo madre) {
        mascara = new int[padre.getGenotipo().getGenes().length];
        Individuo hijo1 = madre.copiar();
        Individuo hijo2 = padre.copiar();
        for (int i = 0; i < padre.getGenotipo().getGenes().length; i++) {
            mascara[i] = (int) Math.floor(rand.nextDouble());
        }
        for (int i = 0; i < padre.getGenotipo().getGenes().length; i++) {
            if (mascara[i] == 0) {
                hijo1.getGenotipo().setGen(i, madre.getGenotipo().getGen(i));
                hijo2.getGenotipo().setGen(i, padre.getGenotipo().getGen(i));
            } else {
                hijo1.getGenotipo().setGen(i, padre.getGenotipo().getGen(i));
                hijo2.getGenotipo().setGen(i, madre.getGenotipo().getGen(i));
            }
        }
        hijos[0] = hijo1;
        hijos[1] = hijo2;
        return hijos;
    }
}
