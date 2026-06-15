package Comportamentais.templateMethod;

public class PreparoClassico extends PreparoLanche {

    @Override
    protected void grelharCarne() {
        System.out.println("[PREPARO] Grelhando blend 180g ao ponto.");
    }

    @Override
    protected void adicionarIngredientes() {
        System.out.println("[PREPARO] Adicionando queijo, alface e tomate.");
    }
}