package br.com.lucreitor.vo;

public class Investment {
    private String description;
    private Double initialValue;
    private Double paymentValue;
    private Double interestValue;
    private Double multiplier;
    private Integer periodAmount;
    private Boolean taxFree;
    private Boolean treasure;
    private InvestmentResult result;

    public Investment(String description, Double initialValue, Double paymentValue, Double interestValue, Double multiplier, Integer periodAmount, Boolean taxFree, Boolean treasure){
        this.description = description;
        this.setInitialValue(initialValue);
        this.setPaymentValue(paymentValue);
        this.setInterestValue(interestValue);
        this.setMultiplier(multiplier);
        this.setPeriodAmount(periodAmount);
        this.setTaxFree(taxFree);
        this.setTreasure(treasure);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Double initialValue) {
        this.initialValue = initialValue;
    }

    public Double getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public Double getInterestValue() {
        return interestValue;
    }

    public void setInterestValue(Double interestValue) {
        this.interestValue = interestValue;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public Integer getPeriodAmount() {
        return periodAmount;
    }

    public void setPeriodAmount(Integer periodAmount) {
        this.periodAmount = periodAmount;
    }

    public Boolean isTaxFree() {
        return taxFree;
    }

    public void setTaxFree(Boolean taxFree) {
        this.taxFree = taxFree;
    }

    public Boolean isTreasure() {
        return treasure;
    }

    public void setTreasure(Boolean treasure) {
        this.treasure = treasure;
    }

    public Double getInterestValueWithMultiplier(){
       return getInterestValue() * getMultiplier();
    }

    public InvestmentResult getResult() {
        return result;
    }

    public void setResult(InvestmentResult result) {
        this.result = result;
    }
}
