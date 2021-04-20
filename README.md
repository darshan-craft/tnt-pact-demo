# tnt-pact-demo
A short repo to demo the pact based contract testing using a pact broker, and a couple clients

## Steps to run the demo
### Run the pact broker docker image
- navigate to docker-compose.yaml directory
- Run docker-compose up
### Generate the Pact interactions
- Run PactDemoClientTest
### Publish the Pacts to Pact Broker
- Run mvn verify , Since the pact publish task is joined with verify lifecycle task, running it would push the pact json to the broker.
### Test the provider against the published pacts
- Run ProviderApplicationTest

The reports can be seen on the pact broker UI on localhost:9292

The whole process shows how the consumer (client-java) can dictate the contract interactions to its service provider(provider), and the provider can always verify its implementations against it.
That's basically the crux of CDD, which makes it possible for complex consumer-provider architecture to remain sane in the world of CI & CD. 
