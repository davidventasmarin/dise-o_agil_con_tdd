public class Calculadora {

    private int _limiteMin;
    private int _limiteMax;

    ValidadorLimitesImpl validadorLimites = new ValidadorLimitesImpl(_limiteMax, _limiteMin);


    public int limiteMaximo(){
        get_limiteMax();
        set_limiteMax(_limiteMax);

        return _limiteMax;
    }

    public int limiteMinimo(){
        get_limiteMin();
        set_limiteMin(_limiteMin);
        return _limiteMin;
    }

    Calculadora(int minValor, int maxValor){
        set_limiteMax(maxValor);
        set_limiteMin(minValor);
    }
    Calculadora(){
        set_limiteMin(-100);
        set_limiteMax(100);
    }

    public int add(int arg1, int arg2){
        int result = arg1 + arg2;
        validadorLimites.validarArgumentos(arg1, arg2);
        if(result > _limiteMax){
            throw new ArithmeticException("Límite máximo excedido");
        }
        return result;
    }

    public int substract(int arg1, int arg2) {
        int result = arg1 - arg2;
        validadorLimites.validarArgumentos(arg1, arg2);
        if(result < _limiteMin){
            throw new ArithmeticException("Límite máximo excedido");
        }
        return result;
    }

    public int get_limiteMin() {
        return _limiteMin;
    }

    public void set_limiteMin(int _limiteMin) {
        this._limiteMin = _limiteMin;
    }

    public int get_limiteMax() {
        return _limiteMax;
    }

    public void set_limiteMax(int _limiteMax) {
        this._limiteMax = _limiteMax;
    }
}
