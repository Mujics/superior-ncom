package superior.ncom;

import java.text.DecimalFormat;

public class ComplejoPolar implements Mostrable{

	private Double modulo;
	private Double argumento;

    public ComplejoPolar(Double modulo, Double argumento) {
		this.modulo = modulo;
		this.argumento = argumento;
    }

    public ComplejoPolar(String modulo, String argumento) {
        this.modulo = Double.parseDouble(modulo);
        this.argumento = Double.parseDouble(argumento);
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
        cloneComplejo(thisBinomico);
    }

    public void suma(ComplejoBinomico complejoBinomico) {
        ComplejoBinomico thisBinomico = this.transformarABinomico();
        thisBinomico.suma(complejoBinomico);
        cloneComplejo(thisBinomico);
    }

    public void resta(ComplejoPolar complejoPolar) {
        ComplejoBinomico thisBinomico = this.transformarABinomico();
        ComplejoBinomico otherComplejo = complejoPolar.transformarABinomico();
        thisBinomico.resta(otherComplejo);
        cloneComplejo(thisBinomico);
    }

    public void resta(ComplejoBinomico complejoBinomico) {
        ComplejoBinomico thisBinomico = this.transformarABinomico();
        thisBinomico.resta(complejoBinomico);
        cloneComplejo(thisBinomico);
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
        modulo = this.modulo / complejoPolar.modulo;
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
        cloneComplejo(complejoBinomico);
    }

    private void cloneComplejo(ComplejoBinomico complejoBinomico) {
        ComplejoPolar complejoPolar = complejoBinomico.transformarAPolar();
        this.argumento = complejoPolar.argumento;
        this.modulo = complejoPolar.modulo;
    }

    public FuncionTrigonometrica convertirEnFuncion(Double frecuencia) {
        return new FuncionTrigonometrica(modulo, frecuencia, argumento);
    }
}
