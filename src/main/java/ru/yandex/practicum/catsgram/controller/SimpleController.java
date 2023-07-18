package ru.yandex.practicum.catsgram.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.catsgram.service.HackCatService;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class SimpleController {
    private final HackCatService hackCatService;
    public SimpleController(HackCatService hackCatService){
        this.hackCatService = hackCatService;
    }

    @GetMapping("/do-hack")
    public void doHackNow(){
        hackCatService.doHackNow();
    }
    @GetMapping("/home")
    public String homePage(HttpServletRequest request) {
        log.info("Получен запрос к эндпоинту: '{} {}', Строка параметров запроса: '{}'",
                request.getMethod(), request.getRequestURI(), request.getQueryString());
        return "Котограм";
    }
}
