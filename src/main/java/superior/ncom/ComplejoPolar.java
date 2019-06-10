package superior.ncom;

import java.text.DecimalFormat;

public class ComplejoPolar extends Complejo {

	private Double modulo;
	private Double argumento;

    public ComplejoPolar(Double modulo, Double argumento) {
		this.modulo = modulo;
		this.argumento = argumento;
    }

    @Override public String mostrar() {
        DecimalFormat df = new DecimalFormat("###.##");
        return "[" + df.format(modulo) + ";" + df.format(argumento) + "]";
    }

    public ComplejoBinomico transformar() {
        return ComplejoTransformer.convertirABinomico(modulo, argumento);
    }

    public void suma(ComplejoPolar complejoPolar) {
        ComplejoBinomico thisBinomico = this.transformar();
        ComplejoBinomico otherComplejo = complejoPolar.transformar();
        thisBinomico.suma(otherComplejo);
        cloneComplejo(thisBinomico);
    }

    public void suma(ComplejoBinomico complejoBinomico) {
        ComplejoBinomico thisBinomico = this.transformar();
        thisBinomico.suma(complejoBinomico);
        cloneComplejo(thisBinomico);
    }

    public void resta(ComplejoPolar complejoPolar) {
        ComplejoBinomico thisBinomico = this.transformar();
        ComplejoBinomico otherComplejo = complejoPolar.transformar();
        thisBinomico.resta(otherComplejo);
        cloneComplejo(thisBinomico);
    }

    public void resta(ComplejoBinomico complejoBinomico) {
        ComplejoBinomico thisBinomico = this.transformar();
        thisBinomico.resta(complejoBinomico);
        cloneComplejo(thisBinomico);
    }

    public void multiplica(ComplejoPolar complejoPolar){
        modulo = this.modulo * complejoPolar.modulo;
        argumento = this.argumento + complejoPolar.argumento;
    }

    public void multiplica(ComplejoBinomico complejoBinomico) throws Exception {
        Complejo complejoPolar = complejoBinomico.transformar();
        this.multiplica(complejoPolar);
    }

    public void dividi(ComplejoPolar complejoPolar){
        modulo = this.modulo / complejoPolar.modulo;
        argumento = this.argumento - complejoPolar.argumento;
    }

    public void dividi(ComplejoBinomico complejoBinomico) throws Exception {
        Complejo complejoPolar = complejoBinomico.transformar();
        this.dividi(complejoPolar);
    }

    public void potencia(Double potencia) {
        modulo = Math.pow(this.modulo, potencia);
        argumento = argumento * potencia;
    }

    public void raizNesima(Double raiz) {
        ComplejoBinomico complejoBinomico = this.transformar();
        complejoBinomico.raizNesima(raiz);
        cloneComplejo(complejoBinomico);
    }

    private void cloneComplejo(ComplejoBinomico complejoBinomico) {
        ComplejoPolar complejoPolar = (ComplejoPolar) complejoBinomico.transformar();
        this.argumento = complejoPolar.argumento;
        this.modulo = complejoPolar.modulo;
    }

    public FuncionTrigonometrica convertirEnFuncion(Double frecuencia) {
        return new FuncionTrigonometrica(modulo, frecuencia, argumento);
    }
}
