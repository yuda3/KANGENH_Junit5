package com.group;

import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomsTest {

    @RepeatedTest(100)
    void testChoice() {
        List<String> options = new ArrayList<>();
        options.add("A");
        options.add("B");
        Randoms sut = new Randoms();
        final AtomicBoolean isCalled = new AtomicBoolean(false);

        sut.random = new RandomNumber() {
            @Override
            public int nextInt() {
                isCalled.set(true);
                return 0;
            }
        };
        assertEquals(sut.choice(options), "A");
        assertTrue(isCalled.get());
    }
}