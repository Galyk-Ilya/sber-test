package ru.galuk.sbertest.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class Error {
    private Integer code;
    private String message;
}