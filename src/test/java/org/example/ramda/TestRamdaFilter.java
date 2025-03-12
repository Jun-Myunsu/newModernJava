package org.example.ramda;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class TestRamdaFilter {
//    private static MockedStatic<RamdaFilter> mFilter;
//
//    @BeforeClass
//    public static void beforeClass() {
//        mFilter = mockStatic(RamdaFilter.class);
//    }

//    @AfterClass
//    public static void afterClass() {
//        mFilter.close();
//    }

    @Test
    public void testFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = RamdaFilter.filter(numbers, i -> i % 2 == 0);
        List<Integer> smallerThanThree = RamdaFilter.filter(numbers, i -> i < 3);

        assertEquals(Arrays.asList(2, 4), even);
    }
}