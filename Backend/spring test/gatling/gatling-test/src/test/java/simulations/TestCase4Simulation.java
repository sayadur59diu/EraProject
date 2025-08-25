package simulations;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class TestCase4Simulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080");

    ScenarioBuilder scn = scenario("High Load Stress Test")
            .exec(http("Get Users").get("/users"));

    {
        setUp(
                scn.injectOpen(rampUsers(100).during(60))
        ).protocols(httpProtocol);
    }
}
