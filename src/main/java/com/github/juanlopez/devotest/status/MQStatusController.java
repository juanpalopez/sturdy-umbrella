package com.github.juanlopez.devotest.status;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MQStatusController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStatus(){
        return  "redirect:actuator/health/rabbit";
    }
}
