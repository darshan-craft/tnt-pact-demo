package com.elsevier.submissions.provider;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactSource;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRestPactRunner.class)
@Provider("demo-provider")
@PactBroker(protocol = "http", host = "demo-broker", port = "9292", tags = {"latest"})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PactproviderdemoApplicationTests {
    
    @TestTarget
    public final Target target = new SpringBootHttpTarget();
    
    @State("Message exists")
    public void toGetState() { }
}
