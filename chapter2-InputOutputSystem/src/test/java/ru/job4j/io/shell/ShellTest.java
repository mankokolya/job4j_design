package ru.job4j.io.shell;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ShellTest {
    @Test
    public void whenCdBack() {
        Shell shell = new Shell();
        shell.cd(File.separator + "user" + File.separator + "..");
        assertThat(
                shell.pwd(), is(File.separator)
        );
    }

    @Test
    public void whenCdRoot() {
        Shell shell = new Shell();
        shell.cd(File.separator);
        assertThat(
                shell.pwd(), is(File.separator)
        );
    }

    @Test
    public void whenCdUserLocal() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("local");
        assertThat(
                shell.pwd(), is(File.separator + "user" + File.separator + "local")
        );
    }

    @Test
    public void whenCdUserBack() {
        Shell shell = new Shell();
        shell.cd("user");
        shell.cd("..");
        assertThat(
                shell.pwd(), is(File.separator)
        );
    }

}