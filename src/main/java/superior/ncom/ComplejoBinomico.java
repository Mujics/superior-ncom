package superior.ncom;

import java.text.DecimalFormat;

public class ComplejoBinomico extends Complejo implements Mostrable {

    public ComplejoBinomico(Double parteReal, Double parteImaginaria) {
        super(parteReal, parteImaginaria);
    }

    @Override public String mostrar() {
        return getParteRealMostrable() + getParteImaginariaMostrable();
    }

    public ComplejoPolar transformarAPolar() {
        return new ComplejoPolar(this.parteReal, this.parteImaginaria);
    }

    private String getParteRealMostrable() {
        DecimalFormat df = new DecimalFormat("###.#");
        return df.format(this.parteReal);
    }

    private String getParteImaginariaMostrable() {
        String signo = " + ";
        if (parteImaginaria < 0) {
            signo = " - ";
        }
        DecimalFormat df = new DecimalFormat("###.#");
        return signo + df.format(Math.abs(this.parteImaginaria)) + "j";
    }
}
