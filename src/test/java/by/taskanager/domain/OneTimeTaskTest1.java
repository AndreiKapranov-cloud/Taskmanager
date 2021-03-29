package by.taskanager.domain;

import by.taskmanager.domain.OneTimeTask;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class OneTimeTaskTest1 {


    public static final int a = 17;
    public static final int b = 21;
    OneTimeTask oneTimeTask1 = new OneTimeTask();

    @Theory
    public void testHashCode(Object[] input) {
        // GIVEN
        int a = (int) input[0];
        String b = (String) input[1];

        // WHEN

        oneTimeTask1.setName(b);

        System.out.println("If name = "+ b +",then HashCode = " + oneTimeTask1.hashCode());

        // THEN
        Assert.assertEquals(a, oneTimeTask1.hashCode());

    }

    @DataPoints
    public static Object[][] dataForHash() {
        return new Object[][]{
                {80, "1"},
                {81, "2"},
                {82, "3"}
        };
    }
}

