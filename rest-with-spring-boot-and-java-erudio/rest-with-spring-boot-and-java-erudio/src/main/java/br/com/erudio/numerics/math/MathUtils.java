package br.com.erudio.numerics.math;

import br.com.erudio.execeptions.ExceptionDivisionZero;
import br.com.erudio.execeptions.UnsupportedMathOperationException;
import br.com.erudio.numerics.NumericUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MathUtils {
    @Autowired
    private NumericUtils numericUtils;

    public void validateNumericInput(String numberOne, String numberTwo) {
        if (!numericUtils.isNumeric(numberOne) || !numericUtils.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
    }

    public void validateNumericZero (String numberOne, String numberTwo) {
        if (!numericUtils.isNumericZero(numberOne) || !numericUtils.isNumericZero(numberTwo)) {
            throw new ExceptionDivisionZero("Please set a number greater than 0!");
        }
    }

    public void validateNumericInput(String numberOne) {
        if (!numericUtils.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
    }
}
