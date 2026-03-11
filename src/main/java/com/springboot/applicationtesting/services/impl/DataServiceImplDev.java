package com.springboot.applicationtesting.services.impl;

import com.springboot.applicationtesting.services.DataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("dev")
public class DataServiceImplDev implements DataService {
    @Override
    public String getData() {
        return "This is development data.";
    }

}
