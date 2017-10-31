package ru.atom.boot.mm;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class ConnectionControllerTest {

    @Test
    public void connect() throws Exception {
        ConnectionController connectionHandler = new ConnectionController();
        assertThat(connectionHandler.list()).isEmpty();

        connectionHandler.connect(1, "a");
        connectionHandler.connect(2, "b");
        connectionHandler.connect(3, "c");

        assertThat(connectionHandler.list()).isNotEmpty();
    }

    @Test
    public void list() throws Exception {

        ConnectionController connectionHandler = new ConnectionController();

        connectionHandler.connect(1, "a");
        connectionHandler.connect(2, "b");
        connectionHandler.connect(3, "c");

        assertTrue("a, b, c".equals(new ConnectionController().list()));
    }

}