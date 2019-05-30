package superior.ncom;

public class ComplejoTransformer {
    private static Double calcularModulo(Double parteReal, Double parteImaginaria) {
        return Math.hypot(parteReal, parteImaginaria);
    }

    private static Double calcularArgumento(Double parteReal, Double parteImaginaria) {
        Double argumento = Math.atan2(parteImaginaria,parteReal);
        /*if (parteImaginaria < 0 && parteReal < 0) {
            argumento += Math.PI;
        } else if (parteImaginaria < 0 && parteReal > 0) {
            argumento += 2*Math.PI;
        }*/
        return argumento;
    }

    public static ComplejoPolar convertirAPolar(Double parteReal, Double parteImaginaria) {
        return new ComplejoPolar(calcularModulo(parteReal, parteImaginaria), calcularArgumento(parteReal, parteImaginaria));
    }

    public static ComplejoBinomico convertirABinomico(Double modulo, Double argumento) {
        return new ComplejoBinomico(modulo * Math.cos(argumento), modulo * Math.sin(argumento));
    }
}
