package br.com.erudio;

import br.com.erudio.numerics.NumericUtils;
import br.com.erudio.numerics.math.MathUtils;
import br.com.erudio.numerics.math.NumericsAccounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private NumericUtils numericUtils;

    @Autowired
    private MathUtils mathUtils;

    @Autowired
    private NumericsAccounts numericsAccounts;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double greeting(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        mathUtils.validateNumericInput(numberOne, numberTwo);

        return numericsAccounts.sum(numericUtils.covertToDouble(numberOne), numericUtils.covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double subtract(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        mathUtils.validateNumericInput(numberOne, numberTwo);

        return numericsAccounts.subtract(numericUtils.covertToDouble(numberOne), numericUtils.covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        mathUtils.validateNumericInput(numberOne, numberTwo);
        mathUtils.validateNumericZero(numberOne, numberTwo);

        return numericsAccounts.division(numericUtils.covertToDouble(numberOne), numericUtils.covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) {
        mathUtils.validateNumericInput(numberOne, numberTwo);

        return numericsAccounts.multiplication(numericUtils.covertToDouble(numberOne), numericUtils.covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double mean(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        mathUtils.validateNumericInput(numberOne, numberTwo);

        return numericsAccounts.mean(numericUtils.covertToDouble(numberOne), numericUtils.covertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{number}",
            method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number) {
        mathUtils.validateNumericInput(number);
        return numericsAccounts.squareRoot(numericUtils.covertToDouble(number));
    }
}