package superior.ncom;

public class ComplejoFactory {
    public static Complejo create(String complejo) {
        if (complejo.startsWith("(")) {
            return new ComplejoBinomico(complejo);
        } else {
            return new ComplejoPolar(complejo);
        }

    }
}
