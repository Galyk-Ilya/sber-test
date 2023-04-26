package ru.galuk.sbertest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.galuk.sbertest.model.LogModel;
import ru.galuk.sbertest.service.LogService;

import java.util.List;

@RestController
@RequestMapping(path = "/core-api/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping
    public void saveLog(LogModel logModel) {
        logService.saveLog(logModel);
    }

    @GetMapping
    public List<LogModel> getAllLogs() {
        return logService.getAllLogs();
    }
}
