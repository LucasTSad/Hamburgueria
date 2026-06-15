package Comportamentais.templateMethod;

public class PreparoFrango extends PreparoLanche {

    @Override
    protected void grelharCarne() {
        System.out.println("[PREPARO] Grelhando filé de frango temperado.");
    }

    @Override
    protected void adicionarIngredientes() {
        System.out.println("[PREPARO] Adicionando queijo, alface, tomate e milho.");
    }

    @Override
    protected void embrulhar() {
        System.out.println("[PREPARO] Embrulhando em papel kraft personalizado.");
    }
}