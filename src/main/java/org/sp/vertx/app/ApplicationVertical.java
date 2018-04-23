package org.sp.vertx.app;

import org.sp.vertx.app.domain.User;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class ApplicationVertical extends AbstractVerticle {

	private final int PORT = 8081;
	private final Logger LOGGER = LoggerFactory.getLogger(ApplicationVertical.class);

	@Override
	public void start(Future<Void> startFuture) throws Exception {
		
		LOGGER.info("Start app");
	
		Router router = Router.router(vertx);
		router.get("/api/users/:id").handler(this::getUserById);
		vertx.createHttpServer().requestHandler(router::accept).listen(config().getInteger("http.port", PORT),
				result -> {
					if (result.succeeded()) {
						startFuture.complete();
					} else {
						startFuture.fail(result.cause());
					}
				});
	}

	public void getUserById(RoutingContext context) {
		String userId = context.request().getParam("id");
		User user = new User(userId, "phea soy", false, "1234");
		context.response().putHeader("content-type", "application/json").setStatusCode(200)
				.end(Json.encodePrettily(user));
	}

}
