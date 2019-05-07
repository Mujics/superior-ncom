package superior.ncom;

import java.text.DecimalFormat;
import jdk.nashorn.internal.objects.annotations.Getter;

public class ComplejoBinomico extends Complejo implements Mostrable {

    protected Double parteReal;
    protected Double parteImaginaria;

    public ComplejoBinomico(Double parteReal, Double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public Complejo transformarAConjugado() {
        return new ComplejoConjugado(parteReal, parteImaginaria);
    }

    public Double calcularModulo() {
        return Math.floor(Math.hypot(parteReal, parteImaginaria) * 100) / 100;
    }

    public Double calcularArgumento() {
        Double argumento = Math.atan2(parteImaginaria,parteReal);
        if (parteImaginaria < 0 && parteReal < 0) {
            argumento += Math.PI;
        } else if (parteImaginaria < 0 && parteReal > 0) {
            argumento += Math.PI;
        }

        return Math.floor(argumento * 100) / 100;
    }

//    public ComplejoBinomico(Double parteReal, Double parteImaginaria) {
//        super(parteReal, parteImaginaria);
//    }

    @Override public String mostrar() {
        return getParteRealMostrable() + getParteImaginariaMostrable();
    }

    public ComplejoPolar transformarAPolar() {
        return new ComplejoPolar(calcularModulo(), calcularArgumento());
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

    @Override
    public double getParteReal() {
        return parteReal;
    }

    @Override
    public double getParteImaginaria() {
        return parteImaginaria;
    }
}
