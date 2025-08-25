package simulations;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class TestCase3Simulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080");

    ScenarioBuilder scn = scenario("Chain: GET then POST")
            .exec(http("Get Users").get("/users"))
            .pause(1)
            .exec(http("Add User")
                    .post("/users")
                    .body(StringBody("ChainedUser"))
                    .header("Content-Type", "text/plain")); // Fix for asText()

    {
        setUp(
                scn.injectOpen(atOnceUsers(50))
        ).protocols(httpProtocol);
    }
}
