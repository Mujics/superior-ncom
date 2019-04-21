package superior.ncom;

import java.text.DecimalFormat;

public class ComplejoBinomico extends Complejo implements Mostrable {

    public ComplejoBinomico(Double parteReal, Double parteImaginaria) {
        super(parteReal, parteImaginaria);
    }

    public Double calcularModulo() {
        return Math.hypot(parteReal, parteImaginaria);
    }

    public double calcularArgumento() {
        return Math.atan2(parteReal, parteImaginaria);
    }

    @Override public String mostrar() {
        DecimalFormat df = new DecimalFormat("###.#");
        String signo = " + ";
        if (parteImaginaria < 0) {
            signo = " - ";
        }
        return df.format(parteReal) + signo + df.format(Math.abs(parteImaginaria)) + "j";
    }

    public ComplejoPolar transformarAPolar() {
        return new ComplejoPolar(this.parteReal, this.parteImaginaria);
    }
}
