package Estrutura.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaIngrediente {

    private static final Map<String, DadosIngrediente> cache = new HashMap<>();

    public static DadosIngrediente obter(String nome, int calorias, String alergenos) {
        if (!cache.containsKey(nome)) {
            cache.put(nome, new DadosIngrediente(nome, calorias, alergenos));
            System.out.println("[FLYWEIGHT] Criando novo ingrediente: " + nome);
        }
        return cache.get(nome);
    }

    public static int totalCriados() {
        return cache.size();
    }

    static void limparCache() {
        cache.clear();
    }
}
