package com.sca.core.rest;

import com.sca.core.producer.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell-liujf on 2018/10/11.
 */
@RestController
@RequestMapping("/send")
public class ProducerRest {

    @Autowired
    private SendService sendService;

    @RequestMapping("/sendMsgByMyChannel")
    public String sendMsgByMyChannel(){
        String myChannelMsg = "hello myChannelMsg" ;
        sendService.sendMyChannelMsg(myChannelMsg);
        return "success: " + myChannelMsg ;
    }
}
