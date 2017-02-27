package fxReemplazo;

import Abstract.*;
import Individuos.Individuo;
import java.util.List;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class Aletorio extends Reemplazo {
    public Aletorio(Random rand) {
        this.rand = rand;
    }

    @Override
    public Poblacion reemplazar(Poblacion poblacion, List<Individuo> individuos, int opcion) {
        Poblacion nueva = poblacion.copiar(1);
        individuos.stream().forEach((i) -> {
            nueva.setIndividuo((int) (rand.nextDouble() * poblacion.getIndividuos().length), i);
        });
        return nueva;
    }

}
