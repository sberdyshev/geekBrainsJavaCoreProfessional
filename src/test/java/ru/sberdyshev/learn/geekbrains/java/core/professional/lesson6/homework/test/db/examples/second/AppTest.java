package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.DaoManager;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.StudentDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity.Student;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sberdyshev
 */
public class AppTest {

    private DaoManager daoManager;
    private StudentDao studentDao;
    private Student student101;
    private Student student102;
    private Student student103;
    private Student student99;
    private Integer amountOflinesBeforeTest;

    @Before
    public void setUp() throws Exception {
        daoManager = DaoManager.getInstance();
        studentDao = (StudentDao) daoManager.getDao(Table.STUDENT);
        studentDao.turnTransactionsHandlingOn();
        student101 = new Student(101, "Amily", 101);
        student102 = new Student(102, "Andrey", 102);
        student103 = new Student(103, "Jet Li", 103);
        student99 = new Student(99, "Nick", 76);
        studentDao.addEntity(student101);
        studentDao.addEntity(student102);
        studentDao.addEntity(student103);
        studentDao.addEntity(student99);
        amountOflinesBeforeTest = studentDao.count();
    }

    @After
    public void clean() throws Exception {
        studentDao.rollback();
    }

    @Test
    public void checkGetStudent() throws SQLException {
        Student actualStudent = studentDao.getEntity(student101.getId());
        assertThat(actualStudent.getId()).isEqualTo(student101.getId());
        assertThat(actualStudent.getName()).isEqualTo(student101.getName());
        assertThat(actualStudent.getScore()).isEqualTo(student101.getScore());
    }

    @Test
    public void checkGetStudents() throws SQLException {
        List<Student> students = studentDao.getEntities();
        boolean resultStudentListContainsStudent99 = studentListContainsStudent(students, student99);
        boolean resultStudentListContainsStudent101 = studentListContainsStudent(students, student101);
        boolean resultStudentListContainsStudent102 = studentListContainsStudent(students, student102);
        boolean resultStudentListContainsStudent103 = studentListContainsStudent(students, student103);
        boolean resultStudentListContainsAllStudents = resultStudentListContainsStudent99 && resultStudentListContainsStudent101 && resultStudentListContainsStudent102 && resultStudentListContainsStudent103;
        assertThat(resultStudentListContainsStudent99).isEqualTo(true);
        assertThat(resultStudentListContainsStudent101).isEqualTo(true);
        assertThat(resultStudentListContainsStudent102).isEqualTo(true);
        assertThat(resultStudentListContainsStudent103).isEqualTo(true);
        assertThat(resultStudentListContainsAllStudents).isEqualTo(true);
        assertThat(students.size()).isEqualTo(amountOflinesBeforeTest);
    }

    @Test
    public void checkAddStudent() throws SQLException {
        Student newStudent = new Student(999, "CheckName", 1000);
        boolean result = studentDao.addEntity(newStudent);
        assertThat(result).isEqualTo(true);
        int newAmountOfLines = studentDao.count();
        Student expectedStudent = studentDao.getEntity(999);
        assertThat(newAmountOfLines).isEqualTo(amountOflinesBeforeTest + 1);
        assertThat(expectedStudent.getId()).isEqualTo(newStudent.getId());
        assertThat(expectedStudent.getScore()).isEqualTo(newStudent.getScore());
        assertThat(expectedStudent.getName()).isEqualTo(newStudent.getName());
    }

    @Test
    public void checkUpdateStudent() throws SQLException {
        Student newStudent = new Student(student102.getId(), "new name", 9999);
        Student beforeTestStudent = studentDao.getEntity(student102.getId());
        assertThat(beforeTestStudent.getId()).isEqualTo(student102.getId());
        assertThat(beforeTestStudent.getName()).isEqualTo(student102.getName());
        assertThat(beforeTestStudent.getScore()).isEqualTo(student102.getScore());
        boolean result = studentDao.updateEntity(newStudent);
        assertThat(result).isEqualTo(true);
        Student afterTestStudent = studentDao.getEntity(newStudent.getId());
        assertThat(afterTestStudent.getId()).isEqualTo(newStudent.getId());
        assertThat(afterTestStudent.getName()).isEqualTo(newStudent.getName());
        assertThat(afterTestStudent.getScore()).isEqualTo(newStudent.getScore());
    }

    private boolean studentListContainsStudent(List<Student> students, Student checkedStudent) {
        boolean result = students.stream().anyMatch(currentStudent -> currentStudent.getId().equals(checkedStudent.getId()) && currentStudent.getName().equals(checkedStudent.getName()) && currentStudent.getScore().equals(checkedStudent.getScore()));
        return result;
    }
}