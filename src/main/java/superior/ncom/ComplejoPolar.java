package superior.ncom;

public class ComplejoPolar extends Complejo implements Mostrable{
    public ComplejoPolar(double modulo, double argumento) {
        super(modulo * Math.cos(argumento), modulo * Math.sin(argumento));
    }

    @Override public String mostrar() {
        return "[ " + calcularModulo() + " ; " + calcularArgumentoMostrable() + " ]";
    }

    public ComplejoBinomico transformarABinomico() {
        return new ComplejoBinomico(
                parteReal * Math.cos(parteImaginaria),
                parteReal * Math.sin(parteImaginaria)
        );
    }

	@Override
	public Double getParteImaginaria() {
//		return parteReal * Math.cos(parteImaginaria);
		return calcularArgumento();
	}

	@Override
	public Double getParteReal() {
//		return parteReal * Math.cos(parteImaginaria);
		return calcularModulo();
	}
}
