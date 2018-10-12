package com.yangwei.www;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <showVersionInfo href="http://d.android.com/tools/testing">Testing documentation</showVersionInfo>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        int a = 6;
//        assertEquals(4, 2 + 2);
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 6:
                    return;
            }
            System.out.print(i + "\n");
        }
    }
}