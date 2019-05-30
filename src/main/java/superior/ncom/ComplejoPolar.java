package superior.ncom;

import java.text.DecimalFormat;

public class ComplejoPolar implements Mostrable{

	private Double modulo;
	private Double argumento;

    public ComplejoPolar(double modulo, double argumento) {
		this.modulo = modulo;
		this.argumento = argumento;
    }

    @Override public String mostrar() {
        return "[ " + getModuloMostrable() + " ; " + getParteImaginariaMostrable() + "π ]";
    }

    private String getModuloMostrable() {
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(modulo);
    }

    private String getParteImaginariaMostrable() {
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(argumento);
    }

    public ComplejoBinomico transformarABinomico() {
        return ComplejoTransformer.convertirABinomico(modulo, argumento);
    }

    public void suma(ComplejoPolar complejoPolar) {
        ComplejoBinomico thisBinomico = this.transformarABinomico();
        ComplejoBinomico otherComplejo = complejoPolar.transformarABinomico();
        thisBinomico.suma(otherComplejo);
        ComplejoPolar thisPolar = thisBinomico.transformarAPolar();
        setParameters(thisPolar.modulo, thisPolar.argumento);
    }

    public void suma(ComplejoBinomico complejoBinomico) {
        ComplejoBinomico thisBinomico = this.transformarABinomico();
        thisBinomico.suma(complejoBinomico);
        ComplejoPolar complejoPolar = thisBinomico.transformarAPolar();
        setParameters(complejoPolar.modulo, complejoPolar.argumento);
    }

    public void resta(ComplejoPolar complejoPolar) {
        ComplejoBinomico thisBinomico = this.transformarABinomico();
        ComplejoBinomico otherComplejo = complejoPolar.transformarABinomico();
        thisBinomico.resta(otherComplejo);
        ComplejoPolar thisPolar = thisBinomico.transformarAPolar();
        setParameters(thisPolar.modulo, thisPolar.argumento);
    }

    public void resta(ComplejoBinomico complejoBinomico) {
        ComplejoBinomico thisBinomico = this.transformarABinomico();
        thisBinomico.resta(complejoBinomico);
        ComplejoPolar complejoPolar = thisBinomico.transformarAPolar();
        setParameters(complejoPolar.modulo, complejoPolar.argumento);
    }

    public void multiplica(ComplejoPolar complejoPolar){
        modulo = this.modulo * complejoPolar.modulo;
        argumento = this.argumento + complejoPolar.argumento;
    }

    public void multiplica(ComplejoBinomico complejoBinomico){
        ComplejoPolar complejoPolar = complejoBinomico.transformarAPolar();
        this.multiplica(complejoPolar);
    }

    public void dividi(ComplejoPolar complejoPolar){
        modulo = this.modulo * complejoPolar.modulo;
        argumento = this.argumento - complejoPolar.argumento;
    }

    public void dividi(ComplejoBinomico complejoBinomico){
        ComplejoPolar complejoPolar = complejoBinomico.transformarAPolar();
        this.dividi(complejoPolar);
    }

    public void potencia(Integer potencia) {
        modulo = Math.pow(this.modulo, potencia);
        argumento = argumento * potencia;
    }

    public void raizNesima(Double raiz) {
        ComplejoBinomico complejoBinomico = this.transformarABinomico();
        complejoBinomico.raizNesima(raiz);
        ComplejoPolar complejoPolar = complejoBinomico.transformarAPolar();
        setParameters(complejoPolar.modulo, complejoPolar.argumento);
    }

    private void setParameters(Double modulo, Double argumento) {
        this.argumento = argumento;
        this.modulo = modulo;
    }

    public FuncionTrigonometrica convertirEnFuncion(Double frecuencia) {
        return new FuncionTrigonometrica(modulo, frecuencia, argumento);
    }
}
