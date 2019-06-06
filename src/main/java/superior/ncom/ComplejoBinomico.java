package superior.ncom;

import java.text.DecimalFormat;
import java.util.Objects;

public class ComplejoBinomico extends Complejo {

    private Double parteReal;
    private Double parteImaginaria;

    public ComplejoBinomico(Double parteReal, Double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public ComplejoBinomico(String parteReal, String parteImaginaria) {
        this.parteReal = Double.parseDouble(parteReal);
        this.parteImaginaria = Double.parseDouble(parteImaginaria);
    }

    public ComplejoBinomico(String resultado) {
        this.parteReal = Double.parseDouble(resultado.substring(0, resultado.indexOf(" ")));
        this.parteImaginaria = Double.parseDouble(resultado.substring(resultado.indexOf(" ") + 2, resultado.indexOf("j")));
    }

    public void transformarAConjugado() {
        parteImaginaria = -parteImaginaria;
    }

    @Override public String mostrar() {
        return getParteRealMostrable() + getParteImaginariaMostrable();
    }

    public Complejo transformar() {
        return ComplejoTransformer.convertirAPolar(parteReal, parteImaginaria);
    }

    private String getParteRealMostrable() {
        DecimalFormat df = new DecimalFormat("###.##");
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
        DecimalFormat df = new DecimalFormat("###.##");
        String parteImaginariaFormatted =  df.format(Math.abs(this.parteImaginaria));
        if (!Objects.equals(parteImaginariaFormatted, "0")) {
            return signo + parteImaginariaFormatted + "j (binomico)";
        }
        return "";
    }

    public void suma(ComplejoBinomico complejoBinomico){
        parteReal += complejoBinomico.parteReal;
        parteImaginaria += complejoBinomico.parteImaginaria;
    }

    public void suma(ComplejoPolar complejoPolar) {
        ComplejoBinomico complejoBinomico = complejoPolar.transformar();
        this.suma(complejoBinomico);
    }

    public void resta(ComplejoBinomico complejoBinomico){
        parteReal -= complejoBinomico.parteReal;
        parteImaginaria -= complejoBinomico.parteImaginaria;
    }

    public void resta(ComplejoPolar complejoPolar) {
        ComplejoBinomico complejoBinomico = complejoPolar.transformar();
        this.resta(complejoBinomico);
    }

    public void multiplica(ComplejoBinomico complejoBinomico) {
        Complejo thisPolar = this.transformar();
        Complejo otherPolar = complejoBinomico.transformar();
        thisPolar.multiplica(otherPolar);
        cloneComplejo(thisPolar);
    }

    public void multiplica(ComplejoPolar complejoPolar) {
        Complejo thisPolar = this.transformar();
        thisPolar.multiplica(complejoPolar);
        cloneComplejo(thisPolar);
    }

    public void dividi(ComplejoBinomico complejoBinomico) {
        Complejo thisPolar = this.transformar();
        Complejo otherPolar = complejoBinomico.transformar();
        thisPolar.dividi(otherPolar);
        cloneComplejo(thisPolar);
    }

    public void dividi(ComplejoPolar complejoPolar) {
        Complejo thisPolar = this.transformar();
        thisPolar.dividi(complejoPolar);
        cloneComplejo(thisPolar);
    }

    public void potencia(Double potencia) {
        ComplejoPolar thisPolar = (ComplejoPolar) this.transformar();
        thisPolar.potencia(potencia);
        cloneComplejo(thisPolar);
    }

    public void raizNesima(Double raiz) {
        parteReal = Math.pow(Math.E, Math.log(parteReal / raiz));
        parteImaginaria = parteImaginaria + (2*0*Math.PI)/raiz ;
        for(Double k=0.00; k<raiz; k++) {
            System.out.println("las Partes imaginarias son" + (parteImaginaria + (2*k*Math.PI)/raiz));
        }
    }

    private void cloneComplejo(Complejo complejoPolar) {
        ComplejoBinomico complejoBinomico = (ComplejoBinomico) complejoPolar.transformar();
        this.parteReal = complejoBinomico.parteReal;
        this.parteImaginaria = complejoBinomico.parteImaginaria;
    }
}
