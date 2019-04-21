package superior.ncom;

import org.junit.Assert;
import org.junit.Test;

public class ComplejoTests {
    @Test
    public void calcular_modulo_de_un_complejo_en_forma_binomica() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(4.0,4.0);
        Assert.assertEquals(5.65, complejoBinomico.calcularModulo(), 0.1);
    }

    @Test
    public void mostrar_numero_complejo_en_forma_binomica() {
        Mostrable complejoEnFormaBinomica = new ComplejoBinomico(4.0,4.0);
        Assert.assertEquals(complejoEnFormaBinomica.mostrar(), "4 + 4j");
    }

    @Test
    public void calcular_argumento_de_un_complejo_en_forma_binomica() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(4.0,4.0);
        Assert.assertEquals(0.78, complejoBinomico.calcularArgumento(), 0.1);
    }

    @Test
    public void transformar_binomico_a_polar_y_mostrar() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(4.0,4.0);
        Mostrable complejoPolar = complejoBinomico.transformarAPolar();
        Assert.assertEquals("[ 5.65 ; 0.78π ]", complejoPolar.mostrar());
    }

    @Test
    public void transformar_polar_a_binomico_y_mostrar() {
        ComplejoPolar complejoPolar = new ComplejoPolar(4.0,4.0);
        Mostrable complejoBinomico = complejoPolar.transformarABinomico();
        Assert.assertEquals("4 + 4j", complejoBinomico.mostrar());
    }

    @Test
    public void transformar_a_conjugado_y_mostrar() {
        ComplejoPolar complejoPolar = new ComplejoPolar(4.0,4.0);
        Mostrable complejo = (Mostrable) complejoPolar.transformarAConjugado();
        Assert.assertEquals("4 - 4j", complejo.mostrar());
    }
}
