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

    public void transformarAConjugado() {
        parteImaginaria = -parteImaginaria;
    }

    @Override public String mostrar() {
        DecimalFormat df = new DecimalFormat("###.##");
        return "(" + df.format(parteReal) + "," + df.format(Math.abs(parteImaginaria)) + ")";
    }

    public ComplejoPolar transformar() {
        return ComplejoTransformer.convertirAPolar(parteReal, parteImaginaria);
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

    public void multiplica(ComplejoBinomico complejoBinomico) throws Exception {
        Complejo thisPolar = this.transformar();
        Complejo otherPolar = complejoBinomico.transformar();
        try {
            thisPolar.multiplica(otherPolar);
        } catch (Exception e) {
            throw new Exception();
        }
        cloneComplejo(thisPolar);
    }

    public void multiplica(ComplejoPolar complejoPolar) {
        Complejo thisPolar = this.transformar();
        thisPolar.multiplica(complejoPolar);
        cloneComplejo(thisPolar);
    }

    public void dividi(ComplejoBinomico complejoBinomico) throws Exception {
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
