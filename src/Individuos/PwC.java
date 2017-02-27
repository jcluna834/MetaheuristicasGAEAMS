package Individuos;

import Abstract.PaisajeAptitud;
import Abstract.Poblacion;
import Genotipos.Cromosoma;
import java.util.Random;

/**
 * Representacion de una poblacion de tamaño fijo cuyos individuos estan
 * compuestos de cromosomas de tamaño fijo.
 *
 * @author CristianCamilo
 */
public class PwC extends Poblacion {
    private PaisajeAptitud funcion;

    /**
     * Constructor de poblacion de tamaño fijo cuyos individuos estan compuestos
     * de cromosomas de tamaño fijo.
     * @param funcion
     * @param rand
     * @param cantidadPoblacion
     * @param cantidadGenes 
     */
    public PwC(PaisajeAptitud funcion, Random rand, int cantidadPoblacion, int cantidadGenes) {
        this.rand = rand;
        aptitud = null;
        individuos = new Individuo[cantidadPoblacion];
        this.funcion = funcion;
        for (int i = 0; i < cantidadPoblacion; i++) {
            individuos[i] = new Individuo(funcion);
            individuos[i].setGenotipo(new Cromosoma(cantidadGenes));
        }
    }

    @Override
    public void inicializar(double limiteInferior, double limiteSuperior) {
        for (Individuo individuo : individuos) {
            for (int j = 0; j < individuo.getGenotipo().getGenes().length; j++) {
                individuo.getGenotipo().setGen(j, (Double)nextRandomNumber(1, limiteInferior, limiteSuperior));
            }   
        }
    }
    
    /**
     * 
     * @param opc
     * @param limiteInferior
     * @param limiteSuperior
     * @return 
     */
    private Object nextRandomNumber(int opc, double limiteInferior, double limiteSuperior) {
        Object value;
        switch(opc) {
            case 0:
                value = rand.nextInt(2);
                break;
            case 1:
                value = ((rand.nextDouble()*(limiteSuperior - limiteInferior)) + limiteInferior);
                break;
            default:
                value = rand.nextInt((int)(limiteSuperior + 1)) + limiteInferior;
                break;
        }
        return value;
    }

    @Override
    public Poblacion copiar(int i) {
        Poblacion nueva = new PwC(funcion, rand, getIndividuos().length, getIndividuos()[0].getGenotipo().getGenes().length);
        if(i==1) {
            int j = 0;
            for(Individuo x: getIndividuos()) {
                nueva.setIndividuo(j, x.copiar());
                j++;
            }
        }
        return nueva;
    }
}
