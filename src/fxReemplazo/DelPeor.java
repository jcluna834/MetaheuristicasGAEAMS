package fxReemplazo;

import Abstract.Poblacion;
import Abstract.Reemplazo;
import Individuos.Individuo;
import java.util.List;

/**
 *
 * @author JulioCésar
 */
public class DelPeor extends Reemplazo {
    
    public DelPeor() {}

    private Individuo peorIndividuo(Poblacion poblacion, int opcion) {
        double peorAptitud = 0;
        Individuo peorIndividuo = null;
        for (Individuo individuo: poblacion.getIndividuos()) {
            if (peorIndividuo == null || comparar(peorIndividuo, individuo, opcion)) {
                peorIndividuo = individuo;
                peorAptitud = individuo.getAptitud();
            }
        }
        return peorIndividuo;
    }

    @Override
    public Poblacion reemplazar(Poblacion poblacion, List<Individuo> individuos, int opcion) {
        Poblacion nueva = poblacion.copiar(1);
        individuos.stream().forEach((ind) -> {
            Individuo peorIndividuo = peorIndividuo(poblacion, opcion);
            if (comparar(ind, peorIndividuo, opcion)) {
                int pos = getPosicion(peorIndividuo, poblacion);
                nueva.setIndividuo(pos, ind);
                poblacion.setIndividuo(pos, ind);
            }
        });
        return nueva;
    }

    private int getPosicion(Individuo peorIndividuo, Poblacion poblacion) {
        int i = 0;
        for(Individuo ind: poblacion.getIndividuos()) {
            if(ind.equals(peorIndividuo))
                break;
            i++;
        }
        return i;
    }
}
