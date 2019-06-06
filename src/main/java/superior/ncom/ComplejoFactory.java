package superior.ncom;

import java.util.Objects;

public class ComplejoFactory {
    public static Complejo create(String s, String s1, String tipo) {
        if (Objects.equals(tipo, "binomico")) {
            return new ComplejoBinomico(s, s1);
        } else {
            return new ComplejoPolar(s, s1);
        }

    }

    public static Complejo createFromString(String resultado) {
        if (resultado.startsWith("[")) {
            return new ComplejoPolar(resultado);
        } else {
            return new ComplejoBinomico(resultado);
        }
    }
}
