package fxSeleccion;

import Abstract.*;
import Individuos.Individuo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author JulioCésar
 */
public class Elitismo extends Seleccion {
    public Elitismo(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public List<Individuo> seleccionar(Poblacion poblacion, int opcion) {
        List<Individuo> seleccion = new ArrayList<>();
        Individuo[] individuos = poblacion.getIndividuos();
        if(opcion == 0)
            Arrays.sort(individuos);
        else
            Arrays.sort(individuos, Collections.reverseOrder());
        for (int i = 0; i < cantidad; i++) {
            seleccion.add(individuos[i]);
        }
        return seleccion;
    }
}