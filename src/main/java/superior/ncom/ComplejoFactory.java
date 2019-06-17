package superior.ncom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static List<Complejo> createArray(String resultadoEspecial) {
        List<String> resultados = Arrays.asList(resultadoEspecial.split(":"));
        List<Complejo> complejos = new ArrayList<>();
        for (String res : resultados) {
            complejos.add(create(res));
        }
        return complejos;
    }
}
