package br.com.lucreitor.vo;

import br.com.lucreitor.math.FinancialCalculator;

public class Indicators {
    public static double POUPANCA_INTEREST_BY_MONTH = 0.0037;
    public static double SELIC_REAL_INTEREST_BY_MONTH = FinancialCalculator.convertTaxFromYearToMonth(0.0640);
    public static double CDI_INTEREST_BY_MONTH = FinancialCalculator.convertTaxFromYearToMonth(0.0640);


}
