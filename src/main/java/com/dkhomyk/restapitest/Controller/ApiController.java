package com.dkhomyk.restapitest.Controller;

import com.dkhomyk.restapitest.Model.Api;
import com.dkhomyk.restapitest.Model.Response;
import com.dkhomyk.restapitest.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {


    private ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/api")
    public Response createApi(@RequestBody Api api, final Response response) {
        return apiService.calculation(api, response);

    }
}
