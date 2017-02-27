package Algoritmos;

import Individuos.Individuo;
import Abstract.Algoritmo;
import Abstract.Poblacion;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Generational Evolutionary Algorithm
 *
 * @author CristianCamilo
 */
public class EA extends Algoritmo {
    private int tamañoPoblacion;

    public EA() {}

    @Override
    public Individuo ejecutar() {
        poblacion.inicializar(funcionAptitud.getLimiteInferior(), funcionAptitud.getLimiteSuperior());
        Individuo Best = null;
        tamañoPoblacion = poblacion.getIndividuos().length;
        funcionAptitud.evaluar(poblacion);
        int i = 0;
        do {
            for (int j = 0; j < tamañoPoblacion; j++) {
                if (Best == null || Quality(poblacion.getIndividuo(j)) > Quality(Best)) {
                    Best = poblacion.getIndividuo(j);
                }
            }
            poblacion = funcionReemplazo.reemplazar(poblacion, breed(poblacion), (int) funcionAptitud.getObjetivo());
            funcionAptitud.evaluar(poblacion);
            i++;
        } while (i < numIteraciones && Best.getAptitud() != funcionAptitud.getObjetivo());
        return Best;
    }

    private List<Individuo> breed(Poblacion poblacion) {
        List<Individuo> hijos = new ArrayList<>();
        List<Individuo> padres = funcionSeleccion.seleccionar(poblacion, (int) funcionAptitud.getObjetivo());
        padres.stream().forEach((padre) -> {
            hijos.add(funcionMutacion.mutar(padre.copiar()));
        });
        return hijos;
    }
}