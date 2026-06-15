package Comportamentais.templateMethod;

public class PreparoVegano extends PreparoLanche {

    @Override
    protected void grelharCarne() {
        System.out.println("[PREPARO] Grelhando hambúrguer de grão-de-bico.");
    }

    @Override
    protected void adicionarIngredientes() {
        System.out.println("[PREPARO] Adicionando rúcula, tomate seco e maionese vegana.");
    }

    @Override
    protected void finalizarMolho() {
        System.out.println("[PREPARO] Adicionando molho de tahine.");
    }
}