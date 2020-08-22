package fr.modcraftmc.updater.server;

import com.sun.net.httpserver.HttpServer;
import fr.modcraftmc.updater.common.Constants;
import fr.modcraftmc.updater.server.handlers.rootHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModcraftUpdaterServer {

    private static Logger logger = LoggerFactory.getLogger("Modcraft updater server");


    public static void main(String[] args) {
        new ModcraftUpdaterServer().startServer();
    }

    public void startServer() {

        try {

            HttpServer server = HttpServer.create(new InetSocketAddress(Constants.PORT), 0);

            server.setExecutor(Executors.newFixedThreadPool(2));

            server.createContext("/", new rootHandler());

            server.start();
            logger.info("starting modcraft updater server");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
