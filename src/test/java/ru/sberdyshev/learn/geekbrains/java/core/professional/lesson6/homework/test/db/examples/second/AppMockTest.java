package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.DaoManager;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.StudentDao;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.dao.table.Table;
import ru.sberdyshev.learn.geekbrains.java.core.professional.lesson6.homework.test.db.examples.second.entity.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * @author sberdyshev
 */
@RunWith(MockitoJUnitRunner.class)
public class AppMockTest {
    @Mock
    private DataSource dataSource;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    private Student student;

    @Before
    public void setUp() throws Exception {
        assertThat(dataSource).isNotNull();
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(dataSource.getConnection()).thenReturn(connection);
        student = new Student(99, "Nick", 76);
        when(resultSet.first()).thenReturn(true);
        when(resultSet.getInt("ID")).thenReturn(student.getId());
        when(resultSet.getString("NAME")).thenReturn(student.getName());
        when(resultSet.getInt("SCORE")).thenReturn(student.getScore());
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void checkGetStudent() throws SQLException {
        DaoManager daoManager = DaoManager.getInstance(dataSource);
        StudentDao studentDao = (StudentDao) daoManager.getDao(Table.STUDENT);
        Student student = studentDao.getEntity(99);
        assertThat(student.getId()).isEqualTo(this.student.getId());
        assertThat(student.getName()).isEqualTo(this.student.getName());
        assertThat(student.getScore()).isEqualTo(this.student.getScore());
    }
}