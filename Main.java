public class Main {
    static HttpServer server = new HttpServer();

    public static void main(String[] args) throws Exception {
        server.start();
        Thread.sleep(1000);

        server.getUrl().openConnection().connect();

        Thread.sleep(1000);

        server.stop();
    }
}
