package com.group;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack<String> strings = null;

    @BeforeEach
    void setUp() {
        strings = new Stack<>();
    }

    @Test
    void isEmptyTest(){
        assertTrue(strings.isEmpty());
    }

    @Test
    void isEmptyStackException(){
        assertThrows(EmptyStackException.class,() -> strings.pop());
    }

    @Test
    void isNotEmpty(){
        strings.push("kim");
        assertFalse(strings.isEmpty());
    }

    @Test
    void isNotEmptyAndEqual(){
        strings.push("kim");
        assertEquals("kim", strings.pop());
    }

}
