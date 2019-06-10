package superior.ncom;

public class ComplejoFactory {
    public static Complejo create(String complejo) {
        if (complejo.startsWith("(")) {
            return ComplejoTransformer.convertirStringABinomico(complejo);
        } else if (complejo.startsWith("[")) {
            return ComplejoTransformer.convertirStringAPolar(complejo);
        } else {
            return new NoComplejo();
        }

    }
}
