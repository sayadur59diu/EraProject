package simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class TestCase1Simulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080");

    ScenarioBuilder scn = scenario("Basic GET Load Test")
            .exec(
                    http("Get Users")
                            .get("/users")
                            .check(status().is(200))
            );

    {
        setUp(
                scn.injectOpen(rampUsers(10).during(10))
        ).protocols(httpProtocol);
    }
}
