package ru.galuk.sbertest.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@ToString
@Accessors(chain = true)
public class LogModel {
    private String message;
    private String type;
    private String level;
    private LocalDateTime time;
}