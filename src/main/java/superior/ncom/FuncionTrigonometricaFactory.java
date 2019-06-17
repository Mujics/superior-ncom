package superior.ncom;

import java.util.Objects;

public class FuncionTrigonometricaFactory {
    public static FuncionTrigonometrica create(String amplitud, String frecuencia, String fase, String tipoDeFuncion) {
        try {
            Double amplitud1 = Double.parseDouble(amplitud);
            Double frecuencia1 = Double.parseDouble(frecuencia);
            Double fase1;
            if (Objects.equals(tipoDeFuncion, "seno")) {
                fase1 = Double.parseDouble(fase) + Math.PI/2;
            } else {
                fase1 = Double.parseDouble(fase);
            }
            return new FuncionTrigonometrica(amplitud1, frecuencia1, fase1);
        } catch (Exception e) {
            return new NoFuncionTrigonometrica();
        }

    }
}
