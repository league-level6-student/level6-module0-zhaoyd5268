package _02_cat_facts_API;

import _02_cat_facts_API.data_transfer_objects.CatFacts;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/*

Use the meow facts API to show the user a random cat fact.
Make an initial request, saving the response as a String to facilitate making your Plain Old Java Objects to represent the request.
Then, write a method that will save the response as an instance of your object, returning the fact from that object.

A swagger page for this very simple API can be found here: https://app.swaggerhub.com/apis-docs/whiterabbit8/meowfacts/1.0.0

 */
public class CatFactsApi {

    private static final String baseUrl = "https://meowfacts.herokuapp.com/";

    private WebClient webClient;

    public CatFactsApi() {
        this.webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void testRequest(){
        /*
        Use the WebClient to make the request, converting the response to String.class.
        This request doesn't require url parameters, so you can omit the .uri() method call entirely
        */

    	Mono <String> mono = webClient
    			.get()
    			.retrieve()
    			.bodyToMono(String.class);
    			
        //Collect the response from the Mono object
    
    	String collection = mono.block();
        /*
        Print out the actual JSON response -
        this is what you will input into jsonschema2pojo.com
         */

    	System.out.println(collection);

        /*
        Use http://www.jsonschema2pojo.org/ to generate your POJO
        and place it in the cat_facts_API.data_transfer_objects package.
        Select:
        Class name: CatWrapper
        Target Language = java
        Source Type = JSON
        Annotation Style = Gson
        */
    }

    public String getCatFact() {

        //Make the request, saving the response in an object of the type that you just created in your
        //data_transfer_objects package (CatWrapper)

    	Mono<CatFacts> m = webClient
    					  .get()
    					  .retrieve()
    					  .bodyToMono(CatFacts.class);
    	
        //Use block() to collect the response into a java object using the class you just created

    	String cf = m.block().toString();
    	
        //return the Object
        return cf;


    }

    public String findCatFact(){
        //use the getCatFact method to retrieve a cat fact

    	String cf = getCatFact();
    	
        //return the first (and only) String in the Arraylist of data in the response
        return cf;
    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }
}
