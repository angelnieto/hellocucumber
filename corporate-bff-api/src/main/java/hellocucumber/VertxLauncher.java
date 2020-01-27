package src.main.java.hellocucumber;

import io.vertx.core.Vertx;

public class VertxLauncher {
	public static void main(String... args) {
		Vertx vertx = Vertx.vertx();
		MyVerticle myVerticle = new MyVerticle();
		vertx.deployVerticle(myVerticle);
	}
}