package org.example.java78;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class ReadPositiveIntParamTest {

    @Test
    public void readDurationImperative() {
        Properties props = new Properties();
        props.setProperty("a", "5");
//        props.setProperty("b", "true");
//        props.setProperty("c", "-3");

//        assertEquals(5, ReadPositiveIntParam.readDurationImperative(props, "a"));
//        assertEquals(0, ReadPositiveIntParam.readDurationImperative(props, "b"));
//        assertEquals(0, ReadPositiveIntParam.readDurationImperative(props, "c"));
//        assertEquals(0, ReadPositiveIntParam.readDurationImperative(props, "d"));

        assertEquals(5, ReadPositiveIntParam.readDurationWithOptional(props, "a"));
//        assertEquals(0, ReadPositiveIntParam.readDurationWithOptional(props, "b"));
//        assertEquals(0, ReadPositiveIntParam.readDurationWithOptional(props, "c"));
//        assertEquals(0, ReadPositiveIntParam.readDurationWithOptional(props, "d"));
    }

}