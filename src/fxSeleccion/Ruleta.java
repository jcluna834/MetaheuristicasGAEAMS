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
public class Ruleta extends Seleccion {
    public Ruleta(Random rnd, int cantidad) {
        this.rand = rnd;
        this.cantidad = cantidad;
    }

    @Override
    public List<Individuo> seleccionar(Poblacion poblacion, int opcion) {
        double acumulado, aptitud;
        List<Individuo> seleccion = new ArrayList<>();
        Individuo[] individuos = poblacion.getIndividuos();
        acumulado = poblacion.getAptitud();
        do {
            double random = rand.nextDouble();
            for (Individuo individuo : individuos) {
                aptitud = individuo.getAptitud();
                double division = aptitud / acumulado;
                if (division > random) {
                    seleccion.add(individuo);
                }
            }
        }while(seleccion.size() < cantidad);
        return seleccion;
    }
}