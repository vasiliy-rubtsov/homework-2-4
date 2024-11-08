package ru.rubtsov.vasiliy.calculator;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private ICalculator service;
    public CalculatorController(ICalculator service) {
        this.service = service;
    }

    @GetMapping
    public String hello() {
        return "<h2>Добро пожаловать в Калькулятор!</h2>" +
                "<h3>Выполняемые функции:</h3>" +
                "<dl>" +
                "<dt>/calculator/plus?num1=&lt;num1&gt;&num2=&lt;num2&gt;</dt><dd>Сложение num1 и num2</dd></dl>" +
                "<dl><dt>/calculator/minus?num1=&lt;num1&gt;&num2=&lt;num2&gt;</dt><dd>Вычитание num2 из num1</dd></dl>" +
                "<dl><dt>/calculator/multiply?num1=&lt;num1&gt;&num2=&lt;num2&gt;</dt><dd>Умножение num1 на num2</dd></dl>" +
                "<dl><dt>/calculator/divide?num1=&lt;num1&gt;&num2=&lt;num2&gt;</dt><dd>Деление num1 на num2</dd>" +
                "</dl>";
    }

    @GetMapping(path="plus")
    public String plus(
            @RequestParam("num1")
            String num1,
            @RequestParam("num2")
            String num2
    ) {
        return String.format("%s", this.service.plus(Double.parseDouble(num1), Double.parseDouble(num2)));
    }

    @GetMapping(path="minus")
    public String minus(
            @RequestParam("num1")
            String num1,
            @RequestParam("num2")
            String num2
    ) {
        return String.format("%s", this.service.minus(Double.parseDouble(num1), Double.parseDouble(num2)));
    }

    @GetMapping(path="multiply")
    public String multiply(
            @RequestParam("num1")
            String num1,
            @RequestParam("num2")
            String num2
    ) {
        return String.format("%s", this.service.multiply(Double.parseDouble(num1), Double.parseDouble(num2)));
    }

    @GetMapping(path="divide")
    public String divide(
            @RequestParam("num1")
            String num1,
            @RequestParam("num2")
            String num2
    ) {
        return String.format("%s", this.service.divide(Double.parseDouble(num1), Double.parseDouble(num2)));
    }
}
