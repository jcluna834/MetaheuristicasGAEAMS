package fxSeleccion;

import Abstract.*;
import Individuos.Individuo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author JulioCésar
 */
public class Torneo extends Seleccion {
    private List<Individuo> seleccion;

    public Torneo(Random rand, int cantidad) {
        this.rand = rand;
        this.cantidad = cantidad;
    }

    private Individuo[] aletorio(Poblacion poblacion) {
        Individuo[] individuos = new Individuo[2];
        int x = rand.nextInt(poblacion.getIndividuos().length);
        int y = rand.nextInt(poblacion.getIndividuos().length);
        while(y==x)
            y = rand.nextInt(poblacion.getIndividuos().length);
        individuos[0] = poblacion.getIndividuo(x);
        individuos[1] = poblacion.getIndividuo(y);
        return individuos;
    }

    @Override
    public List<Individuo> seleccionar(Poblacion poblacion, int opcion) {
        seleccion = new ArrayList<>();
        do {
            Individuo ind[] = aletorio(poblacion);
            if (comparar(ind[0], ind[1], opcion)) {
                seleccion.add(ind[0]);
            } else {
                seleccion.add(ind[1]);
            }
        }while(seleccion.size()!=cantidad);
        return seleccion;
    }
}