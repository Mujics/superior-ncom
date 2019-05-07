package superior.ncom;

public class ComplejoPolar extends Complejo implements Mostrable{

	private Double modulo;
	private Double argumento;

    public ComplejoPolar(double modulo, double argumento) {
		this.modulo = modulo;
		this.argumento = argumento;
    }

    @Override public String mostrar() {
        return "[ " + modulo + " ; " + argumento + "π ]";
    }

    public ComplejoBinomico transformarABinomico() {
        return new ComplejoBinomico(modulo * Math.cos(argumento), modulo * Math.sin(argumento));
    }

	@Override
	public double getParteReal() {
		return modulo * Math.cos(argumento);
	}

	@Override
	public double getParteImaginaria() {
		return modulo * Math.sin(argumento);
	}
}
