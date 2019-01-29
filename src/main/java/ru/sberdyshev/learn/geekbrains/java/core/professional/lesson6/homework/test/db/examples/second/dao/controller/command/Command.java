package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.controller.command;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author sberdyshev
 */
@Getter
@Setter
public class Command {
    private CommandType commandType;
    private List<String> arguments;
}
