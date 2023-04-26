package ru.galuk.sbertest.service;

import ru.galuk.sbertest.model.LogModel;

import java.util.List;

public interface LogService {

    void saveLog(LogModel logModel);

    List<LogModel> getAllLogs();
}