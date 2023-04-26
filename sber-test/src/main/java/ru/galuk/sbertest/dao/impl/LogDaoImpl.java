package ru.galuk.sbertest.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.galuk.sbertest.dao.LogDao;
import ru.galuk.sbertest.mapper.LogRowMapper;
import ru.galuk.sbertest.model.LogModel;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogDaoImpl implements LogDao {
    private static final String INSERT_LOG = "INSERT INTO LOG (MESSAGE, TYPE, LEVEL, TIME) " +
        "VALUES (:message, :type, :level, :time)";

    private static final String SELECT_LOGS = "SELECT * FROM LOG";

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final LogRowMapper logRowMapper;

    @Override
    public void saveLog(LogModel logModel) {
        jdbcTemplate.update(INSERT_LOG, new BeanPropertySqlParameterSource(logModel));
    }

    @Override
    public List<LogModel> getAllLogs() {
        return jdbcTemplate.query(SELECT_LOGS, EmptySqlParameterSource.INSTANCE, logRowMapper);
    }
}