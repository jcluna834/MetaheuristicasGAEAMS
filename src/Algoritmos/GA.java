package Algoritmos;

import Abstract.Algoritmo;
import Abstract.Poblacion;
import Individuos.Individuo;
import java.util.List;

/**
 *
 * @author CristianCamilo
 */
public class GA extends Algoritmo {
    private int tamañoPoblacion;

    public GA() {}

    @Override
    public Individuo ejecutar() {
        Individuo Best = null;
        poblacion.inicializar(funcionAptitud.getLimiteInferior(), funcionAptitud.getLimiteSuperior());
        tamañoPoblacion = poblacion.getIndividuos().length;
        int i = 0;
        funcionAptitud.evaluar(poblacion);
        do {
            for (int j = 0; j < tamañoPoblacion; j++) {
                if (Best == null || Quality(poblacion.getIndividuo(j)) > Quality(Best)) {
                    Best = poblacion.getIndividuo(j);
                }
            }
            Individuo padre;
            Individuo madre;
            Poblacion Q = poblacion.copiar(0);
            int div = (tamañoPoblacion / 2);
            if(div%2 != 0)
                div ++;
            for (int j = 0; j < div; j++) {
                List<Individuo> seleccionados = funcionSeleccion.seleccionar(poblacion, (int) funcionAptitud.getObjetivo());
                padre = seleccionados.get(0);
                madre = seleccionados.get(1);
                Individuo hijos[] = funcionCruce.cruzar(padre, madre);
                Q.addChild(funcionMutacion.mutar(hijos[0]));
                Q.addChild(funcionMutacion.mutar(hijos[1]));
            }
            poblacion = Q;
            funcionAptitud.evaluar(poblacion);
            i++;
        }while(i<numIteraciones && Best.getAptitud() != funcionAptitud.getObjetivo());
        return Best;
    }
}
