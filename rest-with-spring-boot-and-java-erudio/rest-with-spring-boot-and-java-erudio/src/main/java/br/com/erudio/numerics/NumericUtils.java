package br.com.erudio.numerics;

import org.springframework.stereotype.Component;

@Component
public class NumericUtils {
    public boolean isNumericZero(String number) {
        Double numericNumber = covertToDouble(number);
        if (numericNumber == 0) {
            return false;
        }
        return true;
    }

    public Double covertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
