public class ValidadorLimitesImpl{

    Calculadora calculadora;
    private int _limite_maximo;
    private int _limite_minimo;

    ValidadorLimitesImpl(int _limite_maximo, int _limite_minimo){
        this._limite_maximo = _limite_maximo;
        this._limite_minimo = _limite_minimo;
    }

    public int limiteMaximo() {
        int _limiteMax = calculadora.get_limiteMax();
        return _limiteMax;
    }

    public int limiteMinimo() {
        int _limiteMin = calculadora.get_limiteMin();
        System.out.println("Esto se ejecuta ");
        return _limiteMin;
    }

    public boolean validarArgumentos(int arg1, int arg2) {
        calculadora = new Calculadora();
        System.out.println("Vamos a ver que " + _limite_maximo);
        if(arg1 > _limite_maximo){
            throw new ArithmeticException("Primer argumento excedido límite máximo");
        }

        if(arg1 < _limite_minimo){
            throw new ArithmeticException("Primer argumento excedido límite mínimo");
        }

        if(arg2 < _limite_minimo){
            throw new ArithmeticException("Segundo argumento excedido límite mínimo");
        }

        if(arg2 > _limite_maximo){
            throw new ArithmeticException("Segundo argumento excedido límite máximo");
        }


        return true;
    }
}
