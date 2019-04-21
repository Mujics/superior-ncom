package superior.ncom;

public class ComplejoPolar extends Complejo implements Mostrable{
    public ComplejoPolar(double real, double imaginaria) {
        super(real, imaginaria);
    }

    @Override public String mostrar() {
        return "[ " + calcularModulo() + " ; " + calcularArgumentoMostrable() + " ]";
    }

    public ComplejoBinomico transformarABinomico() {
        return new ComplejoBinomico(parteReal, parteImaginaria);
    }
}
