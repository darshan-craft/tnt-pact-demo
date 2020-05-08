package com.elsevier.submissions.cdd.petstore.server;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.spring.junit5.MockMvcTestTarget;
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(properties = {
		"pact.verifier.publishResults=true"
})
@Provider("pet-server")
@PactBroker(host = "demo-broker", port = "9292", tags = {"latest"})
class PetServerApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@TestTemplate
	@ExtendWith(PactVerificationSpringProvider.class)
	void pactVerificationTestTemplate(PactVerificationContext context) {
		context.verifyInteraction();
	}
	
	@BeforeEach
	void before(PactVerificationContext context) {
		context.setTarget(new MockMvcTestTarget(mockMvc));
	}
	
	@State("Pet Api Success Response")
	public void testStatePetApiSuccessResponse() {}
}
