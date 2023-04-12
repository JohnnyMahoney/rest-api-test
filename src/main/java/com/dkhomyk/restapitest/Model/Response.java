package com.dkhomyk.restapitest.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@AllArgsConstructor
@ResponseBody
public class Response {
    private String uuid;
    private Double distance;
    private Integer duration;
    private Double speed;
}
