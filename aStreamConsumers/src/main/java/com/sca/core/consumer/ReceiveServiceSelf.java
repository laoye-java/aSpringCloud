package com.sca.core.consumer;

import com.sca.core.self.sink.MySink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * Created by dell-liujf on 2018/10/11.
 */
//消息接受端，stream给我们提供了Sink,Sink源码里面是绑定input的，要跟我们配置文件的input关联的。
@EnableBinding({MySink.class})
public class ReceiveServiceSelf {

    @StreamListener(MySink.INPUT)
    public void receive(Object payload){
        System.out.println("==1==" + MySink.INPUT + "接收源消息：==" + payload) ;
    }

    @StreamListener(MySink.defaultProcessorInput)
    public void receive_defaultProcessorInput(Object payload){
        System.out.println("==2==" + MySink.defaultProcessorInput + "接收中转消息：==" + payload) ;
    }

    @StreamListener(MySink.myChannelInput)
    public void receive_myChannelInput(Object payload){
        System.out.println("==3==" + MySink.myChannelInput + "接收源消息：==" + payload) ;
    }

    @StreamListener(MySink.myChannelProcessorInput)
    public void receive_myChannelProcessorInput(Object payload){
        System.out.println("==4==" + MySink.myChannelProcessorInput + "接收中转消息：==" + payload) ;
    }

}
