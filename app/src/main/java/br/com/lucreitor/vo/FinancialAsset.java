package br.com.lucreitor.vo;


public class FinancialAsset {
    private String name;
    private Double anualInterest;
    private Boolean hasTaxes;

    public FinancialAsset(String name, double anualInterest) {
        this.name = name;
        this.anualInterest = anualInterest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnualInterest() {
        return anualInterest;
    }

    public void setAnualInterest(Double anualInterest) {
        this.anualInterest = anualInterest;
    }

    public Boolean getHasTaxes() {
        return hasTaxes;
    }

    public void setHasTaxes(Boolean hasTaxes) {
        this.hasTaxes = hasTaxes;
    }
}
