package br.com.lucreitor.vo;

public class InvestmentResult {


    private Double capital;
    private Double taxes;
    private Double grossProfit;
    private Double otherCosts;

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(Double grossProfit) {
        this.grossProfit = grossProfit;
    }

    public Double getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(Double otherCosts) {
        this.otherCosts = otherCosts;
    }

    public Double getTotal(){
        return capital + grossProfit;
    }

    public Double getTotalNet(){
        return capital + grossProfit - taxes - otherCosts;
    }

    public Double getNetProfit() {
        return grossProfit - taxes - otherCosts;
    }
}
