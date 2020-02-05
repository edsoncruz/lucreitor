package br.com.lucreitor.math;

import br.com.lucreitor.vo.Investment;
import br.com.lucreitor.vo.InvestmentResult;

public class FinancialCalculator {

    private static double PROGRESSIVE_TAXES_UNDER_ONE_YEAR = 0.225;
    private static double PROGRESSIVE_TAXES_UNDER_TWO_YEAR = 0.175;
    private static double PROGRESSIVE_TAXES_ABOVE_TWO_YEAR = 0.15;
    private static double TREASURE_TAXES_BY_SEMESTER = (Math.pow(1 + 0.0025, 1/2d)-1);


    /**
     * Calculate future value
     *
     * @param investment
     * @return
     */
    public static InvestmentResult calculateFutureValue(Investment investment){

        double interestValue = investment.getInterestValueWithMultiplier();
        double totalResult = investment.getInitialValue();
        double capitalResult = investment.getInitialValue();
        double profitResult = 0;
        double taxesResult = 0;
        double otherCostsResult = 0;

        for (int i = 0; i < investment.getPeriodAmount(); i++){

            totalResult = ((interestValue + 1) * totalResult) + investment.getPaymentValue();
            capitalResult += investment.getPaymentValue();

            //Every semester Treasure charges a tax
            if(investment.isTreasure() && (i+1) % 6 == 0){

                double otherCosts = totalResult * TREASURE_TAXES_BY_SEMESTER;
                totalResult = totalResult - otherCosts;

                otherCostsResult += otherCosts;
            }
        }

        profitResult = totalResult - capitalResult;

        if(!investment.isTaxFree()){
            taxesResult += calculateTaxes(profitResult,investment.getPeriodAmount());
        }

        InvestmentResult result = new InvestmentResult();
        result.setCapital(capitalResult);
        result.setGrossProfit(profitResult);
        result.setTaxes(taxesResult);
        result.setOtherCosts(otherCostsResult);

        return result;
    }

    public static double calculateTaxes(double value, int month){
        if(month < 12){
            return value * PROGRESSIVE_TAXES_UNDER_ONE_YEAR;
        }else if(month < 24){
            return value * PROGRESSIVE_TAXES_UNDER_TWO_YEAR;
        }else{
            return value * PROGRESSIVE_TAXES_ABOVE_TWO_YEAR;
        }
    }

    public static double convertTaxFromYearToMonth(double tax){
        return Math.pow(1 + tax, 1/12d)-1;
    }

    public static double convertTaxFromMonthToYear(double tax){
        return Math.pow(1 + tax, 12d)-1;
    }
}
