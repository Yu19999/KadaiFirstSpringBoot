package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

@RestController
public class KadaiFirstController {

    // 指定日の曜日を算定するメソッド
    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString();
    }

    // 足し算を行なうメソッド
    @GetMapping("/plus/{num1}/{num2}")
    public String calcPlus(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 + num2);
    }

    // 引き算を行なうメソッド
    @GetMapping("/minus/{num1}/{num2}")
    public String calcMinus(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 - num2);
    }

    // 掛け算を行なうメソッド
    @GetMapping("/times/{num1}/{num2}")
    public String calcTimes(@PathVariable int num1, @PathVariable int num2) {
        return String.valueOf(num1 * num2);
    }

    // 割り算を行なうメソッド
    @GetMapping("/divide/{num1}/{num2}")
    public String calcDivide(@PathVariable int num1, @PathVariable int num2) {
        if (num2 == 0) {
            return "Cannot divide by zero";
        }
        return String.valueOf(num1 / num2);
    }

}
