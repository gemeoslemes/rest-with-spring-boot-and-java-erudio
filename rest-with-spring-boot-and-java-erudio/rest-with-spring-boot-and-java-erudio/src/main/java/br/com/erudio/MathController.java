package br.com.erudio;

import br.com.erudio.execeptions.ExceptionDivisionZero;
import br.com.erudio.execeptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double greeting(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtract(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return covertToDouble(numberOne) - covertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        if (!isNumericZero(numberOne) || !isNumericZero(numberTwo)) {
            throw new ExceptionDivisionZero("Please set a number greater than 0!");
        }
        return covertToDouble(numberOne) / covertToDouble(numberTwo);
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return covertToDouble(numberOne) * covertToDouble(numberTwo);
    }
    @RequestMapping("/med/{numberOne}/{numberTwo}")
    public Double average(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        Double sum = covertToDouble(numberOne) + covertToDouble(numberTwo);
        return sum / 2;
    }
    @RequestMapping("/squareRoot/{numberOne}")
    public Double squareRoot(@PathVariable(value = "numberOne") String numberOne) {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        double root = Math.sqrt(covertToDouble(numberOne));

        DecimalFormat formatNumber = new DecimalFormat("#.##");

        return covertToDouble(formatNumber.format(root));
    }

    private boolean isNumericZero(String number) {
        Double numericNumber = covertToDouble(number);
        if (numericNumber == 0) {
            return false;
        }
        return true;
    }

    private Double covertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
