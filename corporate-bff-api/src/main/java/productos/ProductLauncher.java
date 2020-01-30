package productos;

import io.vertx.core.Vertx;

public class ProductLauncher {
    public static void main(String... args) {
        Vertx vertx = Vertx.vertx();
        productos.ProductoService ps = new productos.ProductoService();
        vertx.deployVerticle(ps);
    }
}
