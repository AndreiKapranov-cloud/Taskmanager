package by.taskanager.domain;

import by.taskmanager.domain.OneTimeTask;
import by.taskmanager.exception.SlayerException;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class OneTimeTaskTest {


    OneTimeTask oneTimeTask = new OneTimeTask();

    @Test
    public void testGetName() {

        oneTimeTask.setName("Hrodno");

        assertEquals(oneTimeTask.getName(), "Hrodno");

    }

    @Test(expected = SlayerException.class)
    public void testSetDeadlineException() throws SlayerException {
        oneTimeTask.setDeadline(LocalDateTime.parse("2002-12-12T12:12:12.676"));
    }


    @Test
    public void testGetDeadline() throws SlayerException {
        oneTimeTask.setDeadline(LocalDateTime.parse("2023-12-12T12:12:12.676"));
        assertEquals(oneTimeTask.getDeadline(), LocalDateTime.parse("2023-12-12T12:12:12.676"));
    }


    @DataPoint
    public static Object[] input = new Object[]{"1", 80};

    @Theory
    public void testHashCode(Object[] inputs) {

        oneTimeTask.setName((String) inputs[0]);

        Assume.assumeTrue(inputs.length == 2);
        Assert.assertEquals(inputs[1], oneTimeTask.hashCode());

    }


}
