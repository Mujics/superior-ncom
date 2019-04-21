package superior.ncom;

public class ComplejoPolar extends Complejo implements Mostrable{
    public ComplejoPolar(double real, double imaginaria) {
        super(real, imaginaria);
    }

    @Override public String mostrar() {
        double sumaCuadrados = Math.pow(parteReal,2) + Math.pow(parteImaginaria,2);
        double r = Math.sqrt(sumaCuadrados);
        double phi = Math.atan(parteImaginaria / parteReal);
        return "[ " + (int) r + " ; " + phi + "π ]";
    }

    public ComplejoBinomico transformarABinomico() {
        return new ComplejoBinomico(parteReal, parteImaginaria);
    }
}
