package superior.ncom;

import java.util.Objects;

public abstract class Complejo implements Mostrable {
    abstract void suma(ComplejoBinomico complejo);
    abstract void suma(ComplejoPolar complejo);
    abstract void resta(ComplejoBinomico complejo);
    abstract void resta(ComplejoPolar complejo);
    abstract void multiplica(ComplejoBinomico complejo);
    abstract void multiplica(ComplejoPolar complejo);
    abstract void dividi(ComplejoBinomico complejo);
    abstract void dividi(ComplejoPolar complejo);
    abstract void potencia(Double numero);
    abstract void raizNesima(Double numero);

    public void suma(Complejo complejo2) {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.suma((ComplejoBinomico) complejo2);
        } else {
            this.suma((ComplejoPolar) complejo2);
        }
    }

    public void resta(Complejo complejo2) {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.resta((ComplejoBinomico) complejo2);
        } else {
            this.resta((ComplejoPolar) complejo2);
        }
    }

    public void multiplica(Complejo complejo2) {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.multiplica((ComplejoBinomico) complejo2);
        } else {
            this.multiplica((ComplejoPolar) complejo2);
        }
    }

    public void dividi(Complejo complejo2) {
        if (complejo2.getClass() == ComplejoBinomico.class) {
            this.dividi((ComplejoBinomico) complejo2);
        } else {
            this.dividi((ComplejoPolar) complejo2);
        }
    }

    public void operar(Complejo complejo, String operacion) {
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
    }

    public void operar(Double numero, String operacion) {
        if (Objects.equals(operacion, "potencia")) {
            this.potencia(numero);
        } else if (Objects.equals(operacion, "raiz")) {
            this.raizNesima(numero);
        }
    }

    public abstract Complejo transformar();
}
