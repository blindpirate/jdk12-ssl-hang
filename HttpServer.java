import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.security.SslSocketConnector;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpServer {
    private Connector connector;
    private SslSocketConnector sslConnector;
    private final Server server = new Server();
    private File trustStore = new File("test-key-store/serverStore");
    private String trustStorePassword = "asdfgh";

    public void start() throws Exception {
        server.start();
        createConnector();
        enableSsl();
        System.setProperty("javax.net.ssl.trustStore", trustStore.getPath());
        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
    }

    public URL getUrl() throws MalformedURLException {
        return new URL("https://localhost:" + sslConnector.getLocalPort());
    }

    private void createConnector() throws Exception {
        connector = new SocketConnector();
        connector.setPort(8080);
        server.addConnector(connector);
        connector.start();
    }

    void enableSsl() throws Exception {
        sslConnector = new SslSocketConnector();
        sslConnector.setKeystore(trustStore.getPath());
        sslConnector.setKeyPassword(trustStorePassword);
        server.addConnector(sslConnector);
        sslConnector.start();
    }

    void stop() throws Exception {
        sslConnector.stop();
        sslConnector.close();

        server.removeConnector(sslConnector);

        connector.stop();
        connector.close();

        server.removeConnector(connector);

        server.stop();
    }
}
