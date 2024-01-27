package com.todo.api.util;

import com.todo.api.response.GoogleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Service
public class GoogleOAuthUtil {

    @Autowired
    RestTemplate restTemplate;

    public GoogleResponse googleResponse(String token) {
        String url = "https://www.googleapis.com/oauth2/v3/userinfo?access_token="+token;
        System.out.println("URL ====> "+url);
        GoogleResponse response = restTemplate
                .getForObject(url,
                        GoogleResponse.class
                        );
        return  response;
    }

}
