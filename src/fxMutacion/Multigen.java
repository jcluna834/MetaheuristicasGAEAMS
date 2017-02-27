package fxMutacion;

import Abstract.*;
import Individuos.Individuo;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class Multigen extends Mutacion {
    private final double limiteInferior;
    private final double limiteSuperior;

    public Multigen(Double limiteInferior, Double limiteSuperior, Random rand) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.rand = rand;
    }

    @Override
    public Individuo mutar(Individuo sujeto) {
        return sujeto;
    }
}
