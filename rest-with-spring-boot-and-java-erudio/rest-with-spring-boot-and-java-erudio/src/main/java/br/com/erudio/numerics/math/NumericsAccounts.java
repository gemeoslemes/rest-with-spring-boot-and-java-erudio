package br.com.erudio.numerics.math;;

import br.com.erudio.numerics.NumericUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class NumericsAccounts {

    @Autowired
    private NumericUtils numericUtils;

    public Double sum(Double numberOne, Double numberTwo) throws Exception {
        return numberOne + numberTwo;
    }

    public Double subtract(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne *numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {
        Double sum = numberOne + numberTwo;
        return sum / 2;
    }


    public Double squareRoot(Double numberOne) {
        double root = Math.sqrt(numberOne);

        DecimalFormat formatNumber = new DecimalFormat("#.##");

        return numericUtils.covertToDouble(formatNumber.format(root));
    }
}
