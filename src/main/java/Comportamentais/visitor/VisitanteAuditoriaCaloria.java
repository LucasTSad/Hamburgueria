package Comportamentais.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitanteAuditoriaCaloria implements IVisitanteCardapio {

    private int              limiteKcal;
    private List<String>     itensAltosCalorias = new ArrayList<>();

    public VisitanteAuditoriaCaloria(int limiteKcal) { this.limiteKcal = limiteKcal; }

    @Override
    public void visitar(ItemVisitavel item) {
        if (item.getCalorias() > limiteKcal) itensAltosCalorias.add(item.getNome());
    }

    @Override
    public void visitar(ComboVisitavel combo) {
        if (combo.getCalorias() > limiteKcal) itensAltosCalorias.add(combo.getNome());
    }

    public List<String> getItensAltosCalorias() { return itensAltosCalorias; }
    public int          totalAltosCalorias()    { return itensAltosCalorias.size(); }
}