package superior.ncom;

public class ComplejoTransformer {
    private static Double calcularModulo(Double parteReal, Double parteImaginaria) {
        return Math.hypot(parteReal, parteImaginaria);
    }

    private static Double calcularArgumento(Double parteReal, Double parteImaginaria) {
        Double argumento = Math.atan2(parteImaginaria,parteReal);
        if (parteImaginaria < 0 && parteReal < 0) {
            argumento += Math.PI;
        } else if (parteImaginaria < 0 && parteReal >= 0) {
            argumento += 2*Math.PI;
        }
        return argumento;
    }

    public static ComplejoPolar convertirAPolar(Double parteReal, Double parteImaginaria) {
        return new ComplejoPolar(calcularModulo(parteReal, parteImaginaria), calcularArgumento(parteReal, parteImaginaria));
    }

    public static ComplejoBinomico convertirABinomico(Double modulo, Double argumento) {
        return new ComplejoBinomico(modulo * Math.cos(argumento), modulo * Math.sin(argumento));
    }

    public static Complejo convertirStringABinomico(String resultado) {
        try {
            Double parteReal = Double.parseDouble(resultado.substring(1, resultado.indexOf(",")));
            Double parteImaginaria = Double.parseDouble(resultado.substring(resultado.indexOf(",")+1, resultado.indexOf(")")));
            return new ComplejoBinomico(parteReal, parteImaginaria);
        } catch (Exception e) {
            return new NoComplejo();
        }
    }

    public static Complejo convertirStringAPolar(String resultado) {
        try {
            String modulo = resultado.substring(1, resultado.indexOf(";"));
            String argumento = resultado.substring(resultado.indexOf(";")+1, resultado.indexOf("]"));
            return new ComplejoPolar(Double.parseDouble(modulo), Double.parseDouble(argumento));
        } catch (Exception e) {
            return new NoComplejo();
        }
    }


}
