package fxMutacion;

import Abstract.*;
import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class Gen extends Mutacion {
    private final double limiteInferior;
    private final double limiteSuperior;

    public Gen(Double limiteInferior, Double limiteSuperior, Random rand) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.rand = rand;
    }

    @Override
    public Individuo mutar(Individuo sujeto) {
        int aleatorio = (int) (rand.nextDouble() * sujeto.getGenotipo().getGenes().length);
        double nuevoGen = limiteInferior + (rand.nextDouble() * (limiteSuperior - limiteInferior));
        if(rand.nextDouble() >= 0.5)
            nuevoGen = 0.0;
        sujeto.getGenotipo().setGen(aleatorio, nuevoGen);
        sujeto.setAptitud(null);
        return sujeto;
    }
}
