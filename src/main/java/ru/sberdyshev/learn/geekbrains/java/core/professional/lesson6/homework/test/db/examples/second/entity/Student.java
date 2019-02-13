package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sberdyshev
 */
@Getter
public class Student {
    private final static Logger logger = LoggerFactory.getLogger(Student.class);
    private String name;
    private Integer id;
    private Integer score;

    public Student(Integer id, String name, Integer score) {
        logger.debug("Creating new student with id {}, name {}, score {}", id, name, score);
        if (id == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Student id con not be null");
            logger.warn(illegalArgumentException.getLocalizedMessage(), illegalArgumentException);
            throw illegalArgumentException;
        }
        if (name == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Student name con not be null");
            logger.warn(illegalArgumentException.getLocalizedMessage(), illegalArgumentException);
            throw illegalArgumentException;
        }
        if (score == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Student score con not be null");
            logger.warn(illegalArgumentException.getLocalizedMessage(), illegalArgumentException);
            throw illegalArgumentException;
        }
        this.name = name;
        this.id = id;
        this.score = score;
    }
}