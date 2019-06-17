package superior.ncom;

import java.util.Objects;

public abstract class Complejo {
    abstract void suma(ComplejoBinomico complejo);
    abstract void suma(ComplejoPolar complejo);
    abstract void resta(ComplejoBinomico complejo);
    abstract void resta(ComplejoPolar complejo);
    abstract void multiplica(ComplejoBinomico complejo) throws Exception;
    abstract void multiplica(ComplejoPolar complejo);
    abstract void dividi(ComplejoBinomico complejo) throws Exception;
    abstract void dividi(ComplejoPolar complejo);
    abstract void potencia(Double numero);
    abstract void raizNesima(Double numero);
    public abstract String mostrar();
    public abstract String mostrarCompleto();

    public void suma(Complejo complejo2) throws Exception {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.suma((ComplejoBinomico) complejo2);
        } else if (complejo2.getClass() == ComplejoPolar.class){
            this.suma((ComplejoPolar) complejo2);
        }else {
            throw new Exception();
        }

    }

    public void resta(Complejo complejo2) throws Exception {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.resta((ComplejoBinomico) complejo2);
        } else if (complejo2.getClass() == ComplejoPolar.class){
            this.resta((ComplejoPolar) complejo2);
        }
        else {
            throw new Exception();
        }
    }

    public void multiplica(Complejo complejo2) throws Exception {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.multiplica((ComplejoBinomico) complejo2);
        } else if (complejo2.getClass() == ComplejoPolar.class){
            this.multiplica((ComplejoPolar) complejo2);
        }
        else {
            throw new Exception();
        }
    }

    public void dividi(Complejo complejo2) throws Exception {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.dividi((ComplejoBinomico) complejo2);
        } else if (complejo2.getClass() == ComplejoPolar.class){
            this.dividi((ComplejoPolar) complejo2);
        }
        else {
            throw new Exception();
        }
    }

    public void operar(Complejo complejo, String operacion) throws Exception {
        try {
            if (Objects.equals(operacion, "+")) {
                this.suma(complejo);
            } else if (Objects.equals(operacion, "-")){
                this.resta(complejo);
            } else if (Objects.equals(operacion, "*")){
                this.multiplica(complejo);
            }
            else if (Objects.equals(operacion, "/")){
                this.dividi(complejo);
            }
        } catch (Exception e) {
            throw new Exception();
        }

    }

    public void operar(Double numero, String operacion) {
        if (Objects.equals(operacion, "potencia")) {
            this.potencia(numero);
        } else if (Objects.equals(operacion, "raiz")) {
            this.raizNesima(numero);
        }
    }

    public abstract Complejo transformar();

    public abstract String mostrarCon2KPI(Integer iteraciones);
}
