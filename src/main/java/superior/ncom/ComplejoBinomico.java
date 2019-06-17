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

    public String mostrar() {
        DecimalFormat df = new DecimalFormat("###.##");
        return "(" + df.format(parteReal) + "," + df.format(parteImaginaria) + ")";
    }

    public String mostrarCompleto() {
       return  "(" + parteReal.toString() + "," + parteImaginaria.toString() + ")";
    }

    public ComplejoPolar transformar() {
        return ComplejoTransformer.convertirAPolar(parteReal, parteImaginaria);
    }

    @Override public String mostrarCon2KPI(Integer iteraciones) {
        ComplejoPolar complejoPolar = transformar();
        return complejoPolar.mostrarCon2KPI(iteraciones);
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
        ComplejoPolar thisPolar = this.transformar();
        thisPolar.potencia(potencia);
        cloneComplejo(thisPolar);
    }

    public void raizNesima(Double raiz) {
        ComplejoPolar thisPolar = this.transformar();
        thisPolar.raizNesima(raiz);
        cloneComplejo(thisPolar);
    }

    private void cloneComplejo(Complejo complejoPolar) {
        ComplejoBinomico complejoBinomico = (ComplejoBinomico) complejoPolar.transformar();
        this.parteReal = complejoBinomico.parteReal;
        this.parteImaginaria = complejoBinomico.parteImaginaria;
    }
}
