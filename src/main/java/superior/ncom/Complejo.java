package superior.ncom;

import java.util.Objects;

public class Complejo {
    private final double parte_real;
    private final double parte_imaginaria;

    public static Boolean numeroEntero(double n) {
        return Math.abs(n - (int) n) == 0;
    }

    public Complejo(double real, double imaginaria) {
        parte_real = real;
        parte_imaginaria = imaginaria;
    }

    public double obtenerParteReal() { return parte_real; }
    public double obtenerParteImaginaria() { return parte_imaginaria; }

    public String formaBinomica() {
        return parte_real + " + " + parte_imaginaria + "j";
    }

    public String formaPolar() {
        double sumaCuadrados = Math.pow(parte_real,2) + Math.pow(parte_imaginaria,2);
        double r = Math.sqrt(sumaCuadrados);
        double phi = Math.atan(parte_imaginaria / parte_real);

        if(numeroEntero(r)){
            return "[ " + (int) r + " ; " + phi + "π ]";
        }
        else {
            return "[ √" + (int) sumaCuadrados + " ; " + phi + "π ]";
        }
    }

    public static String polarABinomica(String n) {
        String[] partes = n.replaceAll("[\\s]", "").replaceAll("\\[", "").replaceAll("\\]","").replaceAll("π","").split(";");
        double a = Double.parseDouble(partes[0]) * Math.cos(Double.parseDouble(partes[1]));
        double b = Double.parseDouble(partes[0]) * Math.sin(Double.parseDouble(partes[1]));
        return a + " + " + b + "j";
    }

    public double modulo() {
        return Math.hypot(parte_real, parte_imaginaria);
    }

    public Complejo conjugado() {
        return new Complejo(parte_real, -parte_imaginaria);
    }
}
