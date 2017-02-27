package Archivos;

/**
 *
 * @author CristianCamilo
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    private final File f;

    public Archivo(String archivo) {
        f = new File(archivo);
    }

    public void ingresarLinea(String line) throws IOException {
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.write(line + "\r\n");
            fw.close();
        }
    }

    public void leerArchivo() throws IOException {
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String p;
            while ((p = br.readLine()) != null) {
                System.out.println(p);
            }
        }
    }

    public int CantidadLineas() throws IOException {
        int x = 0;
        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr)) {
            String p = null;
            while ((p = br.readLine()) != null) {
                x++;
            }
        }
        return x;
    }

    // devuelve la linea que corresponde a la posicion
    public String getElemento(int pos) throws IOException {
        if (pos < 0 || pos > CantidadLineas()) {
            return null;
        } else {
            String p, dato;
            int tam = 0, prioridad;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            p = br.readLine();
            while (i < pos) {
                p = br.readLine();
                i++;
            }
            return p;
        }
    }

    // devuelve todas las lineas del archivo en un vector de string
    public String[] getArray() throws IOException {
        int i = 0;
        String[] x = new String[CantidadLineas()];
        String p;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while ((p = br.readLine()) != null) {
            x[i] = p;
            i++;
        }
        return x;
    }

    public List<double[]> getList() throws IOException {
        List<double[]> x = new ArrayList<>();
        String p;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while ((p = br.readLine()) != null) {
            String[] aux = p.split(";");
            double[] datos = new double[aux.length];
            int i = 0;
            for (String d : aux) {
                datos[i] = Double.parseDouble(d);
                i++;
            }
            x.add(datos);
        }
        return x;
    }

    public void borrarLineas() throws IOException {
        try (FileWriter fw = new FileWriter(f, false)) {
            fw.write("");
            fw.close();
        }
    }
    
    public double[][] getMatriz() throws IOException {
        double[][] x = new double[CantidadLineas()][10];
        String p;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        int j = 0;
        while ((p = br.readLine()) != null) {
            String[] aux = p.split(";");
            int i = 0;
            for (String d : aux) {
                x[j][i] = Double.parseDouble(d);
                i++;
            }
            j++;
        }
        return x;
    }
}
