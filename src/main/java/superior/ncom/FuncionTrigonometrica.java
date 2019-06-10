package superior.ncom;

import java.text.DecimalFormat;

public class FuncionTrigonometrica implements Mostrable{
    private Double amplitud;
    private Double frecuencia;
    private Double fase;

    public FuncionTrigonometrica(Double amplitud, Double frecuencia, Double fase) {
        this.amplitud = amplitud;
        this.frecuencia = frecuencia;
        this.fase = fase;
    }

    public FuncionTrigonometrica(String amplitud, String frecuencia, String fase) {
        this.amplitud = Double.parseDouble(amplitud);
        this.frecuencia = Double.parseDouble(frecuencia);
        this.fase = Double.parseDouble(fase);
    }

    public FuncionTrigonometrica(Double amplitud, Double frecuencia, Double fase, String seno) {
        this.amplitud = amplitud;
        this.frecuencia = frecuencia;
        this.fase = fase + Math.PI/2;
    }

    public void sumar(FuncionTrigonometrica funcion2) {
        ComplejoPolar thisPolar = this.obtenerComplejoPolar();
        ComplejoPolar otherPolar = funcion2.obtenerComplejoPolar();
        thisPolar.suma(otherPolar);
        FuncionTrigonometrica funcionTrigonometrica = thisPolar.convertirEnFuncion(frecuencia);
        setearValores(funcionTrigonometrica);
    }

    private ComplejoPolar obtenerComplejoPolar() {
        return new ComplejoPolar(amplitud, fase);
    }

    @Override public String mostrar() {
        return getAmplitudMostrable() + " . cos(" + getFrecuenciaMostrable() + "t " + getFaseMostrable() + ")";
    }

    private String getAmplitudMostrable() {
        DecimalFormat df = new DecimalFormat("###.###");
        return df.format(amplitud);
    }

    private String getFrecuenciaMostrable() {
        DecimalFormat df = new DecimalFormat("###.###");
        return df.format(frecuencia);
    }

    private String getFaseMostrable() {
        DecimalFormat df = new DecimalFormat("###.###");

        if (fase > 0) {
            return "+ " + df.format(fase);
        }
        return "- " + df.format(Math.abs(fase));
    }

    private void setearValores(FuncionTrigonometrica funcionTrigonometrica) {
        this.amplitud = funcionTrigonometrica.amplitud;
        this.frecuencia = funcionTrigonometrica.frecuencia;
        this.fase = funcionTrigonometrica.fase;
    }
}
