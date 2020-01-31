package productos;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.HashMap;
import java.util.Map;

public class ProductoService extends AbstractVerticle {

    private Map<String, JsonObject> products = new HashMap<>();

    @Override
    public void start() {

        setUpInitialData();

        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        //router.route().handler(this::handleHello);
        router.get("/").handler(this::handleHello);
        router.get("/products/:productID").handler(this::handleGetProduct);
        router.put("/products/:productID").handler(this::handleAddProduct);
        router.get("/products").handler(this::handleListProducts);
        router.post("/products/:productID").handler(this::handleAddProductPost);
        router.delete("/products/:productID").handler(this::handleAddProductDelete);

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }

    private void handleGetProduct(RoutingContext routingContext) {
        String productID = routingContext.request().getParam("productID");
        HttpServerResponse response = routingContext.response();
        if (productID == null) {
            sendError(400, response);
        } else {
            JsonObject product = products.get(productID);
            if (product == null) {
                sendError(404, response);
            } else {
                response.putHeader("content-type", "application/json").end(product.encodePrettily());
            }
        }
    }

    private void handleAddProduct(RoutingContext routingContext) {
        String productID = routingContext.request().getParam("productID");
        String productBodyID = routingContext.getBodyAsJson().getString("id");
        HttpServerResponse response = routingContext.response();
        if (productID == null) {
            sendError(400, response);
        } else {
            JsonObject product = routingContext.getBodyAsJson();
            if (product == null) {
                sendError(400, response);
            } else if(productID.equals(productBodyID)){
                products.put(productID, product);
                response.end();
            } else{
                sendError(417, response);
            }
        }
    }

    private void handleAddProductPost(RoutingContext routingContext) {
        String productID = routingContext.request().getParam("productID");
        String productBodyID = routingContext.getBodyAsJson().getString("id");
        HttpServerResponse response = routingContext.response();
        if (productID == null) {
            sendError(400, response);
        } else {
            JsonObject product = routingContext.getBodyAsJson();
            if (product == null) {
                sendError(400, response);
            }  else if(productID.equals(productBodyID)){
                products.put(productID, product);
                response.end();
            } else{
                sendError(417, response);
            }
        }
    }

    private void handleAddProductDelete(RoutingContext routingContext) {
        String productID = routingContext.request().getParam("productID");
        HttpServerResponse response = routingContext.response();
        if (productID == null) {
            sendError(400, response);
        } else {
            products.remove(productID);
            response.end();
        }
    }

    private void handleListProducts(RoutingContext routingContext) {
        JsonArray arr = new JsonArray();
        products.forEach((k, v) -> arr.add(v));
        routingContext.response().putHeader("content-type", "application/json").end(arr.encodePrettily());
    }

    private void sendError(int statusCode, HttpServerResponse response) {
        response.setStatusCode(statusCode).end();
    }

    private void setUpInitialData() {
        addProduct(new JsonObject().put("id", "prod3568").put("name", "Egg Whisk").put("price", 3.99).put("weight", 150));
        addProduct(new JsonObject().put("id", "prod7340").put("name", "Tea Cosy").put("price", 5.99).put("weight", 100));
        addProduct(new JsonObject().put("id", "prod8643").put("name", "Spatula").put("price", 1.00).put("weight", 80));
    }

    private void addProduct(JsonObject product) {
        products.put(product.getString("id"), product);
    }

    private void handleHello(RoutingContext routingContext) {
        routingContext.response().putHeader("content-type","text/html");
        String msg = "Hello ";
        String agt = "Vert-x";
        msg = msg + agt + " World!";
        routingContext.response().end("<html>" + msg + "</html>");
    }

}
