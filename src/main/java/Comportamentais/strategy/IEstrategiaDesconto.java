package Comportamentais.strategy;

public interface IEstrategiaDesconto {
    double calcularDesconto(double valorOriginal);
    String getDescricao();
}