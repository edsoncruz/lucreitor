package br.com.lucreitor;

import java.util.ArrayList;
import java.util.List;

import br.com.lucreitor.math.FinancialCalculator;
import br.com.lucreitor.vo.Indicators;
import br.com.lucreitor.vo.Investment;

public class InvestmentData {

    public static List<Investment> generateInvestmentData(Double initialValue, Double paymentValue, Integer periodAmount) {

        Investment fgts = new Investment("FGTS", initialValue, paymentValue, FinancialCalculator.convertTaxFromYearToMonth(0.03), 1.0, periodAmount, true,false);
        Investment poupanca = new Investment("Poupança",initialValue, paymentValue, Indicators.getPoupancaInterestByMonth(), 1.0, periodAmount, true, false);
        Investment selic = new Investment("Selic",initialValue, paymentValue, Indicators.getSelicOverInterestByMonth(), 1.0, periodAmount, false, true);
        Investment cdb100 = new Investment("CDB de 100% do CDI",initialValue, paymentValue, Indicators.getCdiInterestByMonth(), 1.0, periodAmount, false,false);
        Investment lci100 = new Investment("LCI de 100% do CDI", initialValue, paymentValue, Indicators.getCdiInterestByMonth(), 1.0, periodAmount, true, false);
        Investment cdb120 = new Investment("CDB de 120% do CDI", initialValue, paymentValue, Indicators.getCdiInterestByMonth(), 1.2, periodAmount, false,false);
        Investment cdbPre10 = new Investment("CDB pré 10% a.a",initialValue, paymentValue, FinancialCalculator.convertTaxFromYearToMonth(0.1), 1.0, periodAmount, false,false);
        Investment cdbPre1268 = new Investment("CDB pré 12,68%",initialValue, paymentValue, FinancialCalculator.convertTaxFromYearToMonth(0.1268), 1.0, periodAmount, false,false);
        Investment cdbPre15 = new Investment("CDB pré 15% a.a",initialValue, paymentValue, FinancialCalculator.convertTaxFromYearToMonth(0.15), 1.0, periodAmount, false,false);

        fgts.setResult(FinancialCalculator.calculateFutureValue(fgts));
        poupanca.setResult(FinancialCalculator.calculateFutureValue(poupanca));
        selic.setResult(FinancialCalculator.calculateFutureValue(selic));
        cdb100.setResult(FinancialCalculator.calculateFutureValue(cdb100));
        lci100.setResult(FinancialCalculator.calculateFutureValue(lci100));
        cdb120.setResult(FinancialCalculator.calculateFutureValue(cdb120));
        cdbPre10.setResult(FinancialCalculator.calculateFutureValue(cdbPre10));
        cdbPre1268.setResult(FinancialCalculator.calculateFutureValue(cdbPre1268));
        cdbPre15.setResult(FinancialCalculator.calculateFutureValue(cdbPre15));

        List<Investment> investments = new ArrayList<>();
        investments.add(fgts);
        investments.add(poupanca);
        investments.add(selic);
        investments.add(cdb100);
        investments.add(lci100);
        investments.add(cdb120);
        investments.add(cdbPre10);
        investments.add(cdbPre1268);
        investments.add(cdbPre15);

        return investments;
    }
}
