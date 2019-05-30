package superior.ncom;

import java.text.DecimalFormat;
import java.util.Objects;

public class ComplejoBinomico implements Mostrable {

    private Double parteReal;
    private Double parteImaginaria;

    public ComplejoBinomico(Double parteReal, Double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public void transformarAConjugado() {
        parteImaginaria = -parteImaginaria;
    }

    @Override public String mostrar() {
        return getParteRealMostrable() + getParteImaginariaMostrable();
    }

    public ComplejoPolar transformarAPolar() {
        return ComplejoTransformer.convertirAPolar(parteReal, parteImaginaria);
    }

    private String getParteRealMostrable() {
        DecimalFormat df = new DecimalFormat("###.#");
        String valueFormatted = df.format(this.parteReal);
        if (Objects.equals(valueFormatted, "0")) {
            return "";
        } else {
            return valueFormatted;
        }
    }

    private String getParteImaginariaMostrable() {
        String signo = " + ";
        if (parteImaginaria < 0) {
            signo = " - ";
        }
        if (Objects.equals(getParteRealMostrable(), "")) {
            signo = "";
        }
        DecimalFormat df = new DecimalFormat("###.#");
        String parteImaginariaFormatted =  df.format(Math.abs(this.parteImaginaria));
        if (!Objects.equals(parteImaginariaFormatted, "0")) {
            return signo + parteImaginariaFormatted + "j";
        }
        return "";
    }

    public void suma(ComplejoBinomico complejoBinomico){
        parteReal += complejoBinomico.parteReal;
        parteImaginaria += complejoBinomico.parteImaginaria;
    }

    public void suma(ComplejoPolar complejoPolar) {
        ComplejoBinomico complejoBinomico = complejoPolar.transformarABinomico();
        this.suma(complejoBinomico);
    }

    public void resta(ComplejoBinomico complejoBinomico){
        parteReal -= complejoBinomico.parteReal;
        parteImaginaria -= complejoBinomico.parteImaginaria;
    }

    public void resta(ComplejoPolar complejoPolar) {
        ComplejoBinomico complejoBinomico = complejoPolar.transformarABinomico();
        this.resta(complejoBinomico);
    }

    public void multiplica(ComplejoBinomico complejoBinomico) {
        ComplejoPolar thisPolar = this.transformarAPolar();
        ComplejoPolar otherPolar = complejoBinomico.transformarAPolar();
        thisPolar.multiplica(otherPolar);
        ComplejoBinomico thisBinomico = thisPolar.transformarABinomico();
        parteReal = thisBinomico.parteReal;
        parteImaginaria = thisBinomico.parteImaginaria;
    }

    public void multiplica(ComplejoPolar complejoPolar) {
        ComplejoPolar thisPolar = this.transformarAPolar();
        thisPolar.multiplica(complejoPolar);
        ComplejoBinomico thisBinomico = thisPolar.transformarABinomico();
        parteReal = thisBinomico.parteReal;
        parteImaginaria = thisBinomico.parteImaginaria;
    }

    public void dividi(ComplejoBinomico complejoBinomico) {
        ComplejoPolar thisPolar = this.transformarAPolar();
        ComplejoPolar otherPolar = complejoBinomico.transformarAPolar();
        thisPolar.dividi(otherPolar);
        ComplejoBinomico thisBinomico = thisPolar.transformarABinomico();
        parteReal = thisBinomico.parteReal;
        parteImaginaria = thisBinomico.parteImaginaria;
    }

    public void dividi(ComplejoPolar complejoPolar) {
        ComplejoPolar thisPolar = this.transformarAPolar();
        thisPolar.dividi(complejoPolar);
        ComplejoBinomico thisBinomico = thisPolar.transformarABinomico();
        parteReal = thisBinomico.parteReal;
        parteImaginaria = thisBinomico.parteImaginaria;
    }

    public void potencia(Integer potencia) {
        ComplejoPolar thisPolar = this.transformarAPolar();
        thisPolar.potencia(potencia);
        ComplejoBinomico thisBinomico = thisPolar.transformarABinomico();
        parteReal = thisBinomico.parteReal;
        parteImaginaria = thisBinomico.parteImaginaria;
    }

    public void raizNesima(Double raiz) {
        parteReal = Math.pow(Math.E, Math.log(parteReal / raiz));
        parteImaginaria = parteImaginaria + (2*0*Math.PI)/raiz ;
        for(Double k=0.00; k<raiz; k++) {
            System.out.println("las Partes imaginarias son" + (parteImaginaria + (2*k*Math.PI)/raiz));
        }
    }
}
