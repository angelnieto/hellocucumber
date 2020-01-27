package src.main.java.hellocucumber;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;

public class MyVerticle extends AbstractVerticle {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyVerticle.class);

	@Override
	public void start(final Future<Void> future) {
		HttpServer server = vertx.createHttpServer();
		Router router = Router.router(vertx);
		router.route().handler(routingContext -> {
			HttpServerResponse response = routingContext.response();
			response.putHeader("content-type", "text/html");
			String msg = "Hello, ";
			String agt = "Vert-x";
			msg = msg + agt + " World!";
			response.end("<html>" + msg + "</html>");

			LOGGER.debug("Pasando por el método start() - DEBUG");
			LOGGER.trace("Pasando por el método start() - TRACE");
			LOGGER.info("Pasando por el método start() - INFO");
			LOGGER.warn("Pasando por el método start() - WARN");
			LOGGER.error("Pasando por el método start() - ERROR");
		});
		server.requestHandler(router::accept).listen(8080);
	}

}
