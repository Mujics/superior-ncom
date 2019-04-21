package superior.ncom;

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
        return  Math.floor(Math.hypot(parteReal, parteImaginaria) * 100) / 100;
    }

    public double calcularArgumento() {
        return Math.floor(Math.atan2(parteReal, parteImaginaria) * 100) / 100;
    }
}
