package ru.rubtsov.vasiliy.calculator;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private Calculator service;
    public CalculatorController() {
        this.service = new CalculatorService();
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
            @RequestParam(name = "num1", required = false)
            @NotEmpty(message="Параметр num1 обязателен")
            String num1,
            @RequestParam(name = "num2", required = false)
            @NotEmpty(message="Параметр num2 обязателен")
            String num2
    ) {
        return String.format("%s", this.service.plus(Double.parseDouble(num1), Double.parseDouble(num2)));
    }

    @GetMapping(path="minus")
    public String minus(
            @RequestParam(name = "num1", required = false)
            @NotEmpty(message="Параметр num1 обязателен")
            String num1,
            @RequestParam(name = "num2", required = false)
            @NotEmpty(message="Параметр num2 обязателен")
            String num2
    ) {
        return String.format("%s", this.service.minus(Double.parseDouble(num1), Double.parseDouble(num2)));
    }

    @GetMapping(path="multiply")
    public String multiply(
            @RequestParam(name = "num1", required = false)
            @NotEmpty(message="Параметр num1 обязателен")
            String num1,
            @RequestParam(name = "num2", required = false)
            @NotEmpty(message="Параметр num2 обязателен")
            String num2
    ) {
        return String.format("%s", this.service.multiply(Double.parseDouble(num1), Double.parseDouble(num2)));
    }

    @GetMapping(path="divide")
    public String divide(
            @RequestParam(name = "num1", required = false)
            @NotEmpty(message="Параметр num1 обязателен")
            String num1,
            @RequestParam(name = "num2", required = false)
            @NotEmpty(message="Параметр num2 обязателен")
            String num2
    ) {
        if (Double.parseDouble(num1) == 0) {
            return "Недопустимая операция: Деление на ноль";
        }
        return String.format("%s", this.service.divide(Double.parseDouble(num1), Double.parseDouble(num2)));
    }
}
