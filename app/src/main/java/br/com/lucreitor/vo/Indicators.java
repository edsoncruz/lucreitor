package br.com.lucreitor.vo;

import br.com.lucreitor.math.FinancialCalculator;

public class Indicators {
    private static double poupancaInterestByMonth;
    private static double selicOverInterestByMonth;
    private static double cdiInterestByMonth;

    public static void setSelicOverInterestByMonth(double selicOverInterestByMonth) {
        Indicators.selicOverInterestByMonth = selicOverInterestByMonth;
    }

    /**
     * CDI is amost always iguals to Selic Over, that's why I'm setting the same here
     * @param selicOverInterestByMonth
     */
    public static void setCdiInterestByMonth(double selicOverInterestByMonth) {
        cdiInterestByMonth = selicOverInterestByMonth;
    }

    /**
     * Poupança is 70% of Selic when Selic is 8,5% and below.
     * @param selicRealInterestByMonth
     */
    public static void setPoupancaInterestByMonth(double selicRealInterestByMonth) {
        poupancaInterestByMonth = selicRealInterestByMonth * 0.70;
    }

    public static double getCdiInterestByMonth() {
        return cdiInterestByMonth;
    }

    public static double getPoupancaInterestByMonth() {
        return poupancaInterestByMonth;
    }

    public static double getSelicOverInterestByMonth() {
        return selicOverInterestByMonth;
    }

    public static double getSelicOverInterestByYear() {
        return FinancialCalculator.convertTaxFromMonthToYear(selicOverInterestByMonth);
    }

    public static double getCdiInterestByYear() {
        return FinancialCalculator.convertTaxFromMonthToYear(cdiInterestByMonth);
    }

    public static double getPoupancaInterestByYear() {
        return FinancialCalculator.convertTaxFromMonthToYear(poupancaInterestByMonth);
    }
}
