package com.dkhomyk.restapitest.Model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class Api {

    private final String uuid;
    private final List<Positions> positions;

}
