package superior.ncom;

import jdk.nashorn.internal.objects.annotations.Getter;

public abstract class Complejo {

    protected Double parteReal;
    protected Double parteImaginaria;

    public Complejo(Double parteReal, Double parteImaginaria) {
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

    public Double getParteReal() {
        return parteReal;
    }

    public Double getParteImaginaria() {
        return parteImaginaria;
    }

    public String calcularArgumentoMostrable() {
        return String.valueOf(calcularArgumento() + "π");
    }
}
