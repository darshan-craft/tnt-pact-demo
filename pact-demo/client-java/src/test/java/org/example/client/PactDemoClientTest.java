package org.example.client;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import org.example.entity.Message;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = "demo-provider" +
        ".base-url:http://localhost:8080/", classes = PactDemoClient.class)
public class PactDemoClientTest {
    
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("demo-provider", null, 8080, this);
    
    @Autowired
    private PactDemoClient pactDemoClient;
    
    @Test
    @PactVerification(fragment = "pactWelcomeMessageExists")
    public void welcomeMessageExists() {
        
        Message dto = pactDemoClient.getWelcomeMsg("TheJungle");
        Assert.assertEquals(dto.getMessage(), "Welcome to TheJungle !");
    }
    
    @Pact(consumer = "demo-client-java")
    public RequestResponsePact pactWelcomeMessageExists(PactDslWithProvider builder) {
        
        return builder.given("Message exists").uponReceiving("A request to /welcome/TheJungle").path(
                "/welcome/TheJungle").method("GET").willRespondWith().status(200).body(
                LambdaDsl.newJsonBody(o -> o.stringValue("message", "Welcome to TheJungle !")).build()).toPact();
    }
}
