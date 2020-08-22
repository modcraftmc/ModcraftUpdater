package fr.modcraftmc.updater.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;

public class rootHandler implements HttpHandler {

    private static Logger logger = LoggerFactory.getLogger("Modcraft request handler");


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        logger.info("new connexion form {}", httpExchange.getRemoteAddress().getHostName());
        OutputStream outputStream = httpExchange.getResponseBody();


        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("ModcraftUpdater server");

        httpExchange.sendResponseHeaders(200, htmlBuilder.length());
        outputStream.write(htmlBuilder.toString().getBytes());
        outputStream.flush();
        outputStream.close();

    }
}
