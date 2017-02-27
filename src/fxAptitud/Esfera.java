package fxAptitud;

import Abstract.*;
import Individuos.Individuo;

/**
 *
 * @author CristianCamilo
 */
public class Esfera extends PaisajeAptitud {

    private double res;

    public Esfera(Double limiteInferior, Double limiteSuperior, int opc) {
        this.opc = opc;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
    }

    @Override
    public double evaluar(Individuo individuo) {
        if (individuo.getAptitud() == null) {
            res = 0.0;
            for (int i = 0; i < individuo.getGenotipo().getGenes().length; i++) {
                res += Math.pow((double) individuo.getGenotipo().getGen(i), 2);
            }
            individuo.setAptitud(res);
        }
        return individuo.getAptitud();
    }
}
