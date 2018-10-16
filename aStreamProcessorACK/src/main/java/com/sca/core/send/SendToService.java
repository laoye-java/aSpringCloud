package com.sca.core.send;

import com.sca.core.ack.SendToBinder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * 出现多个相同的input接收监听时，轮询处理 , 默认只会处理一个，
 * 经测试 （1 和 3 轮流出现，2 和 4 轮流出现）,处理机制是轮询接收
 * Created by dell-liujf on 2018/10/12.
 */
@EnableBinding(value = {SendToBinder.class})
public class SendToService {
    @StreamListener(SendToBinder.INPUT)//监听通道
//    @SendTo(SendToBinder.output)//返回处理结果到output通道
    @SendTo(value = {SendToBinder.defaultProcessorOutput})//返回处理结果到output通道
    public Object receiveFromInput(Object payload){
        System.out.println("==消息中转站，接收消息" + SendToBinder.INPUT + "=="+payload);
        return "==中转消息=="+payload ;
    }

}
