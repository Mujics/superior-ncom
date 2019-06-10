package superior.ncom;

import org.junit.Assert;
import org.junit.Test;

public class ComplejoTests {

    @Test
    public void mostrar_numero_complejo_en_forma_binomica() {
        Mostrable complejoEnFormaBinomica = new ComplejoBinomico(4.0,4.0);
        Assert.assertEquals(complejoEnFormaBinomica.mostrar(), "4 + 4j");
    }

    @Test
    public void transformar_binomico_a_polar_y_mostrar() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(4.0,4.0);
        ComplejoPolar complejoPolar = (ComplejoPolar) complejoBinomico.transformar();
        Assert.assertEquals("[ 5.66 ; 0.79 ]", complejoPolar.mostrar());
    }

    @Test
    public void transformar_polar_a_binomico_y_mostrar() {
        ComplejoPolar complejoPolar = new ComplejoPolar(Math.sqrt(2), Math.PI / 4);
        Mostrable complejoBinomico = complejoPolar.transformar();
        Assert.assertEquals("1 + 1j", complejoBinomico.mostrar());
    }

    @Test
    public void transformar_a_conjugado_y_mostrar() {
        ComplejoBinomico complejoBinomico = new ComplejoBinomico(4.0,4.0);
        complejoBinomico.transformarAConjugado();
        Assert.assertEquals("4 - 4j", complejoBinomico.mostrar());
    }

    @Test
    public void sumaDeComplejosCaso1() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoBinomico segundo = new ComplejoBinomico(3D,2D);
        primero.suma(segundo);
        Assert.assertEquals(primero.mostrar(), "5 + 5j");
    }

    @Test
    public void sumaDeComplejosCaso2() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoBinomico primeroCopia = new ComplejoBinomico(2D,3D);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        primero.suma(segundo);
        segundo.suma(primeroCopia);
        Assert.assertEquals(primero.mostrar(), "6.05 + 5.94j");
        Assert.assertEquals(segundo.mostrar(), "[ 8.47 ; 0.78 ]");
        Assert.assertEquals(segundo.transformar().mostrar(), "6.05 + 5.94j");
    }

    @Test
    public void sumaDeComplejosCaso3() {
        ComplejoPolar primero = new ComplejoPolar(8D,Math.PI / 5);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        primero.suma(segundo);
        Assert.assertEquals(primero.mostrar(), "[ 13 ; 0.63 ]");
    }

    @Test
    public void restaDeComplejosCaso1() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoBinomico segundo = new ComplejoBinomico(3D,2D);
        primero.resta(segundo);
        Assert.assertEquals(primero.mostrar(), "-1 + 1j");
    }

    @Test
    public void restaDeComplejosCaso2() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        primero.resta(segundo);
        Assert.assertEquals(primero.mostrar(), "-2.05 + 0.06j");
    }

    @Test
    public void restaDeComplejosCaso3() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        segundo.resta(primero);
        Assert.assertEquals(segundo.mostrar(), "[ 2.05 ; -0.03 ]");
    }

    @Test
    public void restaDeComplejosCaso4() {
        ComplejoPolar primero = new ComplejoPolar(5D,Math.PI / 5);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        segundo.resta(primero);
        Assert.assertEquals(segundo.mostrar(), "[ 0 ; 0 ]");
    }

    @Test
    public void multiplicacionDeComplejosCaso1() {
        ComplejoBinomico primero = new ComplejoBinomico(3D,5D);
        ComplejoBinomico segundo = new ComplejoBinomico(2D,-3D);
        primero.multiplica(segundo);
        Assert.assertEquals(primero.mostrar(), "21 + 1j");
    }

    @Test
    public void multiplicacionDeComplejosCaso2() {
        ComplejoPolar primero = new ComplejoPolar(2D,Math.PI / 3);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        primero.multiplica(segundo);
        Assert.assertEquals(primero.mostrar(), "[ 10 ; 1.68 ]");
    }

    @Test
    public void multiplicacionDeComplejosCaso3() {
        ComplejoBinomico primero = new ComplejoBinomico(5D,8D);
        ComplejoBinomico segundo = new ComplejoBinomico(6D,-9D);
        primero.multiplica(segundo);
        Assert.assertEquals(primero.mostrar(), "102 + 3j");
    }

    @Test
    public void multiplicacionDeComplejosCaso4() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        primero.multiplica(segundo);
        Assert.assertEquals(primero.mostrar(), "-0.73 + 18.01j");
    }

    @Test
    public void multiplicacionDeComplejosCaso5() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        segundo.multiplica(primero);
        Assert.assertEquals(segundo.mostrar(), "[ 18.03 ; 1.61 ]");
        Assert.assertEquals(segundo.transformar().mostrar(), "-0.73 + 18.01j");
    }

    @Test
    public void divisionDeComplejosCaso1() {
        ComplejoBinomico primero = new ComplejoBinomico(3D,2D);
        ComplejoBinomico segundo = new ComplejoBinomico(5D,-3D);
        primero.dividi(segundo);
        Assert.assertEquals(primero.mostrar(), "0.26 + 0.56j");
    }

    @Test
    public void divisionDeComplejosCaso2() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        primero.dividi(segundo);
        Assert.assertEquals(primero.mostrar(), "0.68 + 0.25j");
    }

    @Test
    public void divisionDeComplejosCaso3() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,3D);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        segundo.dividi(primero);
        Assert.assertEquals(segundo.mostrar(), "[ 1.39 ; -0.35 ]");
    }

    /*@Test
    public void potenciaDeComplejos1() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,2D);
        primero.potencia(2);
        Assert.assertEquals(primero.mostrar(), "8j");
    }

    @Test
    public void potenciaDeComplejos2() {
        ComplejoBinomico primero = new ComplejoBinomico(2D,2D);
        primero.potencia(4);
        Assert.assertEquals(primero.mostrar(), "-64");
    }*/

    @Test
    public void raizDeComplejos() {
        ComplejoBinomico primero = new ComplejoBinomico(4D,1D);
        primero.raizNesima(2D);
        Assert.assertEquals(primero.mostrar(), "2 + 1j");
    }

    @Test
    public void raizDeComplejosCaso2() {
        ComplejoPolar primero = new ComplejoPolar(5D,Math.PI / 5);
        primero.raizNesima(2D);
        Assert.assertEquals(primero.mostrar(), "[ 3.57 ; 0.97 ]");
    }

    @Test
    public void sumaDeFasoresCaso1() {
        FuncionTrigonometrica funcion1 = new FuncionTrigonometrica(10D, 3D, -Math.PI/3);
        FuncionTrigonometrica funcion2 = new FuncionTrigonometrica(5D, 3D, 5*Math.PI/12);
        funcion1.sumar(funcion2);
        Assert.assertEquals(funcion1.mostrar(), "7.368 . cos(3t - 0.547)");
    }

    @Test
    public void sumaDeFasoresCaso2() {
        FuncionTrigonometrica funcion1 = new FuncionTrigonometrica(2D, 5D, -Math.PI/4);
        FuncionTrigonometrica funcion2 = new FuncionTrigonometrica(7D, 5D, Math.PI/3);
        funcion1.sumar(funcion2);
        Assert.assertEquals(funcion1.mostrar(), "6.764 . cos(5t + 0.758)");
    }

    @Test
    public void sumaDeFasoresCaso3() {
        FuncionTrigonometrica funcion1 = new FuncionTrigonometrica(2D, 5D, -Math.PI/4, "Seno");
        FuncionTrigonometrica funcion2 = new FuncionTrigonometrica(7D, 5D, Math.PI/3);
        funcion1.sumar(funcion2);
        Assert.assertEquals(funcion1.mostrar(), "8.947 . cos(5t + 0.989)");
    }

   /* @Test
    public void crear2ComplejosConStringYSumar() {
        Complejo complejo1 = ComplejoFactory.create("12", "12", "binomico");
        Complejo complejo2 = ComplejoFactory.create("12", "12", "binomico");
        complejo1.suma(complejo2);
        Assert.assertEquals("[ 5.66 ; 0.79π ]", complejo1.mostrar());
    }

    @Test
    public void a() {
        ComplejoPolar primero = new ComplejoPolar(2D,Math.PI / 3);
        ComplejoPolar segundo = new ComplejoPolar(5D,Math.PI / 5);
        Complejo complejo = ComplejoFactory.createFromString("102 + 3j");
        Assert.assertEquals(primero.mostrar(), complejo.mostrar());
    }*/

}
