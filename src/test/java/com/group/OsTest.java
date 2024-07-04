package com.group;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class OsTest {


    @Test
    public void winTest() {
        System.out.println(System.getProperty("os.name").contains("Windows"));
        assumeTrue("Windows".equals(System.getProperty("os.name")),
                () -> "Aborting test: not on developer workstation");
    }

    @Test
    public void macTest() {
        System.out.println("このテストはWindows環境で実行されます");
    }

    @Test
    public void linuxTest() {
        System.out.println("このテストはWindows環境で実行されます");
    }

}
