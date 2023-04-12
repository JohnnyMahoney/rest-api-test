package com.dkhomyk.restapitest.Model;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
public class Positions {

    private final Double lat;
    private final Double lng;
    private final Date time;

}
