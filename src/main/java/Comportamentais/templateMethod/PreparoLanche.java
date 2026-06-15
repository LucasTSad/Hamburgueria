package Comportamentais.templateMethod;

public abstract class PreparoLanche {

    public final void preparar() {
        tostarPao();
        grelharCarne();
        adicionarIngredientes();
        finalizarMolho();
        embrulhar();
    }

    protected void tostarPao() {
        System.out.println("[PREPARO] Tostando pão...");
    }

    protected abstract void grelharCarne();
    protected abstract void adicionarIngredientes();

    protected void finalizarMolho() {
        System.out.println("[PREPARO] Adicionando molho da casa...");
    }

    protected void embrulhar() {
        System.out.println("[PREPARO] Embrulhando lanche.");
    }
}