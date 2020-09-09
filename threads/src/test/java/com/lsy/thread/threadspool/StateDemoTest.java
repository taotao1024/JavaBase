package com.lsy.thread.threadspool;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

public class StateDemoTest {

    @Test
    public void testPath01() {
        String path = StateDemoTest.class.getClassLoader().getResource("a.text").getPath();
        System.out.println(path);
    }

    @Test
    public void testPath02() {
        String path = StateDemoTest.class.getResource("/").getFile();
        System.out.println(path);
    }

    @Test
    public void testPath03() {
        String path = StateDemoTest.class.getClassLoader().getResource("").getPath();
        System.out.println(path);
    }

    @Test
    public void testPath04() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(path);
    }

    @Test
    public void testPath05() {
        URL base = this.getClass().getResource("");
        System.out.println(base);
    }

    @Test
    public void testPath06() throws IOException {
        URL base = this.getClass().getResource("");
        System.out.println(base);
        String path = new File(base.getFile(), "../../").getCanonicalPath();
        System.out.println(path);
    }
}