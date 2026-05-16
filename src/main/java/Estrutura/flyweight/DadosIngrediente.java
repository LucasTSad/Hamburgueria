package Estrutura.flyweight;

public class DadosIngrediente {

    private final String nome;
    private final int calorias;
    private final String alergenos;

    public DadosIngrediente(String nome, int calorias, String alergenos) {
        this.nome = nome;
        this.calorias = calorias;
        this.alergenos = alergenos;
    }

    public String getNome() {
        return nome;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getAlergenos() {
        return alergenos;
    }

    @Override
    public String toString() {
        return String.format("%s (%d kcal, alérgenos: %s)", nome, calorias, alergenos);
    }
}
