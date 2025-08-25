package simulations;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import java.util.*;
import java.util.stream.IntStream;
import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

public class TestCase2Simulation extends Simulation {

    // HTTP configuration
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080");

    // Feeder for random user names
    FeederBuilder<Object> feeder = arrayFeeder(
            IntStream.range(0, 1000)
                    .mapToObj(i -> Map.<String, Object>of("user", "User" + i))
                    .toArray(Map[]::new)
    ).random();

    // Scenario: POST users
    ScenarioBuilder scn = scenario("POST Load Test")
            .feed(feeder)
            .exec(
                    http("Add User")
                            .post("/users")
                            .body(StringBody("#{user}"))
                            .header("Content-Type", "text/plain") // Fallback for HttpHeaderNames
                            .check(status().is(200))
            );

    // Setup: 20 users per second for 30 seconds
    {
        setUp(
                scn.injectOpen(constantUsersPerSec(20).during(30))
        ).protocols(httpProtocol);
    }
}