package ru.galuk.sbertest.dao;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import ru.galuk.sbertest.CommonTest;
import ru.galuk.sbertest.model.LogModel;

import java.time.LocalDateTime;
import java.util.List;

@Sql(scripts = {"/sql/clear-table.sql", "/sql/insert-data.sql"}, config = @SqlConfig(dataSource = "dataSourceTest"))
public class LogDaoTest extends CommonTest {
    private static final String LOG_TABLE = "LOG";

    @Autowired
    private LogDao logDao;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplateTest;

    @Test
    public void saveLogTest() {
        Assert.assertEquals(3, countRowsInTableWhere("MESSAGE IN ('Message1', 'Message2', 'Message3', 'Message4')"));
        LogModel log = new LogModel()
            .setLevel("debug")
            .setMessage("Message4")
            .setTime(LocalDateTime.now());
        logDao.saveLog(log);
        Assert.assertEquals(4, countRowsInTableWhere("MESSAGE IN ('Message1', 'Message2', 'Message3', 'Message4')"));
    }

    @Test
    public void getAllLogsTest() {
        List<LogModel> logs = logDao.getAllLogs();
        Assert.assertNotNull(logs);
        Assert.assertEquals(3, logs.size());
        Assert.assertEquals("debug", logs.get(0).getLevel());
        Assert.assertEquals("error", logs.get(1).getLevel());
        Assert.assertEquals("warn", logs.get(2).getLevel());
    }

    private int countRowsInTableWhere(String whereClause) {
        return JdbcTestUtils.countRowsInTableWhere(jdbcTemplateTest.getJdbcTemplate(), LOG_TABLE, whereClause);
    }
}
