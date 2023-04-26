package ru.galuk.sbertest.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.galuk.sbertest.model.LogModel;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LogRowMapper implements RowMapper<LogModel> {

    @Override
    public LogModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new LogModel()
            .setMessage(rs.getString("MESSAGE"))
            .setType(rs.getString("TYPE"))
            .setLevel(rs.getString("LEVEL"))
            .setTime(rs.getTimestamp("TIME").toLocalDateTime());
    }
}