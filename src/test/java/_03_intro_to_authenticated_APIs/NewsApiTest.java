package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;

import _01_intro_to_APIs.data_transfer_objects.Result;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {
	
	@Mock
	WebClient webClientMock;
	
	@Mock
	RequestHeadersUriSpec requestHeadersUriSpecMock;

    NewsApi newsApi;

    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	
    	NewsApi na = new NewsApi();
    	na.setWebClient(webClientMock);
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
    	String topic = "food";
    	Result result = new Result();
        Result[] expectedResults = {result};
    	//when
    	
        when(webClientMock.get())
        	.thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function <UriBuilder,URI>) any()));
        
        //then
    }

    @Test
    void itShouldFindStory(){
        //given

        //when

        //then
    }


}