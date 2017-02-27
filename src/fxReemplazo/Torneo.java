package fxReemplazo;

import Abstract.Poblacion;
import Abstract.Reemplazo;
import Individuos.Individuo;
import java.util.List;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class Torneo extends Reemplazo {

    public Torneo(Random rand) {
        this.rand = rand;
    }

    @Override
    public Poblacion reemplazar(Poblacion poblacion, List<Individuo> individuos, int opcion) {
        Poblacion nueva = poblacion.copiar(1);
        individuos.stream().forEach((i) -> {
            int pos = (int) (rand.nextDouble() * poblacion.getIndividuos().length);
            if (comparar(i, poblacion.getIndividuo(pos), opcion)) {
                nueva.setIndividuo(pos, i);
            }
        });
        return nueva;
    }
}
