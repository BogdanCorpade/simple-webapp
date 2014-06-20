package com.sdl.web.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bcorpade on 6/20/2014.
 */
@Service
public class GenericRequest {
    public <R> R callMateApi(String callUri,Object dataToSend, Class<R> responseType) {

        RestTemplate restTemplate = new RestTemplate();
        R response = null;
        String apiUri = "http://localhost:9091" + callUri;

        HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity requestEntity = new HttpEntity(dataToSend, requestHeaders);

        try {
            System.out.println("Calling " + apiUri + " dataToSend=" + dataToSend);
            response = restTemplate.postForObject(apiUri, requestEntity, responseType);
            System.out.println("Return: " + response);

        } catch (RestClientException e) {
            System.out.println("Error occurred : " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
                System.out.println("Error when trying to communicate to  API " + apiUri);
            e.printStackTrace();
        }
        return response;
    }
}
