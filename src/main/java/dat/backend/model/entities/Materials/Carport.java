package dat.backend.model.entities.Materials;

import dat.backend.model.entities.Essentials.BillOfMaterials;

public class Carport {
    BillOfMaterials billOfMaterials;
    private int nyPris;

    public Carport(BillOfMaterials billOfMaterials, int nyPris) {
        this.billOfMaterials = billOfMaterials;
        this.nyPris = nyPris;
    }

    public BillOfMaterials getBillOfMaterials() {
        return billOfMaterials;
    }

    public void setBillOfMaterials(BillOfMaterials billOfMaterials) {
        this.billOfMaterials = billOfMaterials;
    }

    public int getNyPris() {
        return nyPris;
    }

    public void setNyPris(int nyPris) {
        this.nyPris = nyPris;
    }
}
