public class ValidadorLimitesImpl{

    Calculadora calculadora;

    ValidadorLimitesImpl(Calculadora calculadora){
        this.calculadora = calculadora;
    }

    public static boolean validarArgumentos(Calculadora calculadora, int arg1, int arg2) {
        if(arg1 > calculadora.get_limiteMax()){
            throw new ArithmeticException("Primer argumento excedido límite máximo");
        }

        if(arg1 < calculadora.get_limiteMin()){
            throw new ArithmeticException("Primer argumento excedido límite mínimo");
        }

        if(arg2 < calculadora.get_limiteMin()){
            throw new ArithmeticException("Segundo argumento excedido límite mínimo");
        }

        if(arg2 > calculadora.get_limiteMax()){
            throw new ArithmeticException("Segundo argumento excedido límite máximo");
        }


        return true;
    }
}
