import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraTest {

    private Calculadora  calculadora;
    private ValidadorLimitesImpl validadorLimites;
    @Before
    public void setUp() throws Exception{
        calculadora = new Calculadora(-100, 100);
    }

    @Test
    public void add(){
        int result = calculadora.add(2,2);
        Assert.assertEquals(4, result);
    }

    @Test
    public void addWithDifferentArguments(){
        int result = calculadora.add(2,3);
        Assert.assertEquals(5, result);
    }

    @Test
    public void substract(){
        calculadora = new Calculadora(-100, 100);
        int result = calculadora.substract(5, 3);
        Assert.assertEquals(2, result);
    }

    @Test
    public void substractWithDifferentArguments(){
        int result = calculadora.substract(10, 6);
        Assert.assertEquals(4, result);
    }

    @Test
    public void substractReturningNegative(){
        int result = calculadora.substract(3, 5);
        Assert.assertEquals(-2, result);
    }

    @Test
    public void substractSettingLimitValues(){
        int result = calculadora.substract(5, 10);
        Assert.assertEquals(-5, result);
    }

    @Test
    public void substractExcedingLowerLimit(){
        try{
            int result = calculadora.substract(10, 150);
            Assert.fail("Excepción no se lanza cuando " + "excede  de los limites bajos");
        }catch (ArithmeticException e){

        }
    }

    @Test
    public void addExcedingUpperLimit(){

        try{
            int result = calculadora.add(10, 150);
            Assert.fail("Esto debe de ser un fallo: Nosotros hemos excedido el límite superior");
        }catch (ArithmeticException e){}

    }

    @Test
    public void setAndGetLimites(){
        Assert.assertEquals(100, calculadora.limiteMaximo());
        Assert.assertEquals(-100, calculadora.limiteMinimo());
    }

    @Test
    public void argumentsExceedLimitsAdd(){
        try{
            calculadora.add(calculadora.limiteMaximo() + 1, calculadora.limiteMinimo() - 1);
            Assert.fail("Esto debe fallar: Los argumentos exceden los límites");
        }catch (ArithmeticException e){}
    }

    @Test
    public void argumentsExceedLimitsInverseAdd(){
        try{
            calculadora.add(calculadora.limiteMinimo() - 1, calculadora.limiteMaximo() + 1);
            Assert.fail("Esto debe fallar: Los argumentos exceden los límites");
        }catch (ArithmeticException e){}
    }

    @Test
    public void argumentsExceedLimitsSubstract(){
        try{
            validadorLimites.validarArgumentos(calculadora.limiteMaximo() + 1, calculadora.limiteMinimo() - 1);
            Assert.fail("Esto debe fallar: Los argumentos exceden los límites");
        }catch (ArithmeticException e){}
    }

    @Test
    public void argumentsExceedLimitsInverseSubstract(){
        try{
            validadorLimites.validarArgumentos(calculadora.limiteMinimo() - 1, calculadora.limiteMaximo() + 1);
            Assert.fail("Esto debe fallar: Los argumentos exceden los límites");
        }catch (ArithmeticException e){}
    }

    @Test
    public void substractIsUsingValidator(){
        int arg1      = 10;
        int arg2      = -220;
        int limiteMax = 100;
        int limiteMin = 100;
        IValidadorLimites validarMock = mock(IValidadorLimites.class);
        when(validarMock.validarArgumentos(arg1,arg2)).thenReturn(false);

    }
}
