package fxCruce;

import Abstract.*;
import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class DeNPuntos extends Cruce {

    public Individuo[] hijos;
    private int inicial;
    private int fin;

    public DeNPuntos(Random rand) {
        this.rand = rand;
        hijos = new Individuo[2];
    }

    @Override
    public Individuo[] cruzar(Individuo padre, Individuo madre) {
        this.inicial = (int) (rand.nextDouble() * madre.getGenotipo().getGenes().length);
        this.fin = (int) (rand.nextDouble() * padre.getGenotipo().getGenes().length);
        Individuo hijo1 = padre.copiar();
        Individuo hijo2 = madre.copiar();
        if (inicial > fin) {
            int aux = inicial;
            inicial = fin;
            fin = aux;
        }
        for (int i = inicial; i < fin; i++) {
            hijo1.getGenotipo().setGen(i, madre.getGenotipo().getGen(i));
            hijo2.getGenotipo().setGen(i, padre.getGenotipo().getGen(i));
        }
        hijos[0] = hijo1;
        hijos[1] = hijo2;
        return hijos;
    }

}
