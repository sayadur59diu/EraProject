package simulations;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class TestCase5Simulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080");

    ScenarioBuilder scn = scenario("POST with Assertions")
            .exec(http("Add User")
                    .post("/users")
                    .body(StringBody("AssertedUser"))
                    .header("Content-Type", "text/plain")); // Fix for asText()

    {
        setUp(
                scn.injectOpen(constantUsersPerSec(30).during(20))
        ).protocols(httpProtocol)
                .assertions(
                        global().responseTime().max().lt(200),
                        global().successfulRequests().percent().gt(99.0)
                );
    }
}
