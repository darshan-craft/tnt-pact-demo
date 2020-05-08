package com.elsevier.submissions.cdd.petstore.client;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.PactTestExecutionContext;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.ConsumerPactTest;
import au.com.dius.pact.core.model.RequestResponsePact;
import com.elsevier.submissions.cdd.petstore.client.model.Pet;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class PactClientTest extends ConsumerPactTest {
    
    private static final String MOCK_PET_NAME = "Mock Pet";
    private static final long MOCK_PET_ID = 10L;
    private static final String PACT_PROVIDER = "pet-server";
    private static final String PACT_CONSUMER = "pet-consumer";
    
    @Override
    protected RequestResponsePact createPact(PactDslWithProvider builder) {
    
        return builder.given("Pet Api Success Response")
                .uponReceiving("A request to /pet/10")
                .path("/pet/10")
                .method("GET")
                .willRespondWith()
                .status(200)
                .matchHeader("Content-Type", "application/json")
                .body(LambdaDsl.newJsonBody(o -> {
                    o.stringValue("name", MOCK_PET_NAME);
                    o.numberValue("id", MOCK_PET_ID);
                }).build())
                .toPact();
    }
    
    @Override
    protected void runTest(MockServer mockServer, PactTestExecutionContext context) {
    
        ResponseEntity<Pet> postResponse = new RestTemplate()
                .getForEntity(mockServer.getUrl() + "/pet/" + MOCK_PET_ID, Pet.class);
    
        assertThat(postResponse.getStatusCode().value()).isEqualTo(200);
        assertThat(postResponse.getBody()).isNotNull()
                .hasFieldOrPropertyWithValue("name", MOCK_PET_NAME)
                .hasFieldOrPropertyWithValue("id", MOCK_PET_ID);
    }
    
    @Override
    protected String providerName() {
        
        return PACT_PROVIDER;
    }
    
    @Override
    protected String consumerName() {
        
        return PACT_CONSUMER;
    }
}
