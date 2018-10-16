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

//    @RequestMapping("/{msg}")
//    public String send(@PathVariable("msg") String msg){
//        sendService.sendMsg(msg);
//        return "success msg" ;
//    }

    @RequestMapping("/defaultMsg")
    public String send(){
        String msg = "hello" ;
        sendService.sendMsg(msg);
        return "success hello" ;
    }
}
