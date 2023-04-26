package ru.galuk.sbertest.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import ru.galuk.sbertest.dao.LogDao;
import ru.galuk.sbertest.model.LogModel;
import ru.galuk.sbertest.service.LogService;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogDao logDao;

    @Override
    public void saveLog(LogModel logModel) {
        try {
            log.info(logModel);
            logDao.saveLog(logModel);
        } catch (Exception e) {
            log.error("Ошибка при сохранении лога в БД", e);
            throw HttpServerErrorException.create(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка", HttpHeaders.EMPTY, null, null);
        }
    }

    @Override
    public List<LogModel> getAllLogs() {
        try {
            return logDao.getAllLogs();
        } catch (Exception e) {
            log.error("Ошибка при получении списка логов", e);
            throw HttpServerErrorException.create(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "Ошибка", HttpHeaders.EMPTY, null, null);
        }
    }
}