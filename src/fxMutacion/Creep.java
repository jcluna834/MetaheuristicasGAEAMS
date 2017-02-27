package fxMutacion;

import Abstract.*;
import Individuos.Individuo;

/**
 *
 * @author JulioCésar
 */
public class Creep extends Mutacion{

    @Override
    public Individuo mutar(Individuo sujeto) {
        return sujeto;
    }
    
}
