package org.example.client;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE,
        properties = "pactdemo-service.base-url:http://localhost:8080",
        classes = PactDemoClient.class)
public class PactDemoClientTest {

    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("pactdemo-service", null,
            8080, this);

    @Autowired
    private PactDemoClient pactDemoClient;

    @PactVerification(fragment = "pactWelcomeMessageExists")
    @Test
    public void welcomeMessageExists() {
        String dto = pactDemoClient.getWelcomeMsg("TheJungle");
        Assert.assertEquals(dto, "Welcome to TheJungle !");
    }

    //JSONObject obj = new JSONObject().put("message", "Welcome to TheJungle !");


    @Pact(consumer = "messaging-app")
    public RequestResponsePact pactWelcomeMessageExists(PactDslWithProvider builder) {
        return builder.given("Message exists")
                .uponReceiving("A request to /welcome/TheJungle")
                .path("/welcome/TheJungle")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(LambdaDsl.newJsonBody((o) -> o
                        .stringType("message", "Welcome to TheJungle !"))
                .build())
                .toPact();
    }




}
