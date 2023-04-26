package ru.galuk.sbertest.dao;

import ru.galuk.sbertest.model.LogModel;

import java.util.List;

public interface LogDao {

    void saveLog(LogModel logModel);

    List<LogModel> getAllLogs();
}