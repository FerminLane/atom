package ru.atom.server;


import okhttp3.Response;
import org.junit.Assert;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;


public class ServerClient {
    private static String login = "atom";
    private static String password = "mail";

    private static final Logger log = LogManager.getLogger(ServerClient.class);


    @Test
    public void registration() throws IOException {
        Response response = ServerClientAPI.registration(login, password);
        String body = response.body().string();
        log.info(body);

    }

  }