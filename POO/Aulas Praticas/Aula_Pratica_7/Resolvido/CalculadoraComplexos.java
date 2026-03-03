package Resolvido;

public class CalculadoraComplexos implements IOperacoesBasicas<Complexo> {
    public Complexo soma(Complexo operador1, Complexo operador2) {
        return new Complexo(operador1.getReal() + operador2.getReal(),
                operador1.getImaginaria() + operador2.getImaginaria());
    }

    public Complexo subtracao(Complexo operador1, Complexo operador2) {
        return new Complexo(operador1.getReal() - operador2.getReal(),
                operador1.getImaginaria() - operador2.getImaginaria());
    }
}
