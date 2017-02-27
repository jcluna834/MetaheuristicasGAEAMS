package fxAptitud;

import Abstract.*;
import Individuos.Individuo;

/**
 *
 * @author JulioCésar
 */
public class Coeficientes extends PaisajeAptitud {

    private final double matriz[][];

    /**
     *
     * @param limiteInferior
     * @param limiteSuperior
     * @param opc
     * @param matriz
     */
    public Coeficientes(Double limiteInferior, Double limiteSuperior, int opc, double matriz[][]) {
        this.opc = opc;
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.matriz = matriz;
    }

    @Override
    public double evaluar(Individuo individuo) {
        if (individuo.getAptitud() == null) {
            double sum = 0.0;
            Genotipo genes = individuo.getGenotipo();
            Double[] i = genes.getGenes();
            for (double[] aux : matriz) {
                double Fx = 0.0;
                Fx += (i[0] + (i[1] * aux[0]) + (i[2] * aux[1]) + (i[3] * aux[2]) + (i[4] * aux[3]) + (i[5] * aux[4]) + (i[6] * aux[5]) + (i[7] * aux[6]) + (i[8] * aux[7]) + (i[9] * aux[8]));
                Fx += (i[10] * aux[0] * aux[0]) + (i[11] * aux[0] * aux[1]) + (i[12] * aux[0] * aux[2]) + (i[13] * aux[0] * aux[3]) + (i[14] * aux[0] * aux[4]) + (i[15] * aux[0] * aux[5]) + (i[16] * aux[0] * aux[6]) + (i[17] * aux[0] * aux[7]) + (i[18] * aux[0] * aux[8]);
                Fx += (i[19] * aux[1] * aux[1]) + (i[20] * aux[1] * aux[2]) + (i[21] * aux[1] * aux[3]) + (i[22] * aux[1] * aux[4]) + (i[23] * aux[1] * aux[5]) + (i[24] * aux[1] * aux[6]) + (i[25] * aux[1] * aux[7]) + (i[26] * aux[1] * aux[8]);
                Fx += (i[27] * aux[2] * aux[2]) + (i[28] * aux[2] * aux[3]) + (i[29] * aux[2] * aux[4]) + (i[30] * aux[2] * aux[5]) + (i[31] * aux[2] * aux[6]) + (i[32] * aux[2] * aux[7]) + (i[33] * aux[2] * aux[8]);
                Fx += (i[34] * aux[3] * aux[3]) + (i[35] * aux[3] * aux[4]) + (i[36] * aux[3] * aux[5]) + (i[37] * aux[3] * aux[6]) + (i[38] * aux[3] * aux[7]) + (i[39] * aux[3] * aux[8]);
                Fx += (i[40] * aux[4] * aux[4]) + (i[41] * aux[4] * aux[5]) + (i[42] * aux[4] * aux[6]) + (i[43] * aux[4] * aux[7]) + (i[44] * aux[4] * aux[8]);
                Fx += (i[45] * aux[5] * aux[5]) + (i[46] * aux[5] * aux[6]) + (i[47] * aux[5] * aux[7]) + (i[48] * aux[5] * aux[8]);
                Fx += (i[49] * aux[6] * aux[6]) + (i[50] * aux[6] * aux[7]) + (i[51] * aux[6] * aux[8]);
                Fx += (i[52] * aux[7] * aux[7]) + (i[53] * aux[7] * aux[8]);
                Fx += (i[54] * aux[8] * aux[8]);
                sum += ((aux[9] - Fx) * (aux[9] - Fx));
            }
            individuo.setAptitud((sum / 1000.0));
        }
        return individuo.getAptitud();
    }
}
