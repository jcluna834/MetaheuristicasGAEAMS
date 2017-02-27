package Abstract;

import Individuos.Individuo;
import java.util.List;
import java.util.Random;

/**
 *
 * @author CristianCamilo
 */
public abstract class Seleccion {

    protected Random rand;
    protected int cantidad;

    /**
     *
     * @param poblacion
     * @param opcion
     * @return
     */
    public abstract List<Individuo> seleccionar(Poblacion poblacion, int opcion);

    protected boolean comparar(Individuo ind1, Individuo ind2, int opcion) {
        if (opcion == 0) {
            return (ind1.getAptitud() < ind2.getAptitud());
        }
        return (ind1.getAptitud() > ind2.getAptitud());
    }
}
