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
    public void calcular_modulo_de_un_complejo_en_forma_binomica_caso_2() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(3.0,5.0);
        Assert.assertEquals(Math.sqrt(34), complejoBinomico.calcularModulo(), 0.1);
    }

    @Test
    public void calcular_modulo_de_un_complejo_en_forma_binomica_caso_3() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(1.0/3.0,-1.0/3.0);
        Assert.assertEquals(Math.sqrt(2)/3.0, complejoBinomico.calcularModulo(), 0.1);
    }

    @Test
    public void calcular_modulo_de_un_complejo_en_forma_binomica_caso_4() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(-Math.sqrt(2),Math.sqrt(2));
        Assert.assertEquals(2, complejoBinomico.calcularModulo(), 0.1);
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
    public void calcular_argumento_de_un_complejo_en_forma_binomica_caso_2() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(3.0,5.0);
        Assert.assertEquals(1.03, complejoBinomico.calcularArgumento(), 0.0001);
    }

    @Test
    public void calcular_argumento_de_un_complejo_en_forma_binomica_caso_3() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(1.0/3.0,-1.0/3.0);
        Assert.assertEquals(-0.78539816+Math.PI, complejoBinomico.calcularArgumento(), 0.1);
    }

    @Test
    public void calcular_argumento_de_un_complejo_en_forma_binomica_caso_4() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(-Math.sqrt(2),Math.sqrt(2));
        Assert.assertEquals(-0.78539816+Math.PI, complejoBinomico.calcularArgumento(), 0.1);
    }

    @Test
    public void calcular_argumento_de_un_complejo_en_forma_binomica_caso_5() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(-Math.sqrt(2),-Math.sqrt(2));
        Assert.assertEquals(0.78539816, complejoBinomico.calcularArgumento(), 0.1);
    }

    @Test
    public void transformar_binomico_a_polar_y_mostrar() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(4.0,4.0);
        Mostrable complejoPolar = complejoBinomico.transformarAPolar();
        Assert.assertEquals("[ 5.65 ; 0.78π ]", complejoPolar.mostrar());
    }

    @Test
    public void transformar_polar_a_binomico_y_mostrar() {
        ComplejoPolar complejoPolar = new ComplejoPolar(Math.sqrt(2),Math.PI / 4);
        Mostrable complejoBinomico = complejoPolar.transformarABinomico();
        Assert.assertEquals("1 + 1j", complejoBinomico.mostrar());
    }

    @Test
    public void transformar_a_conjugado_y_mostrar() {
        ComplejoPolar complejoPolar = new ComplejoPolar(4.0,4.0);
        Mostrable complejo = (Mostrable) complejoPolar.transformarAConjugado();
        Assert.assertEquals("4 - 4j", complejo.mostrar());
    }
}
