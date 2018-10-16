package com.sca.core.producer;

import com.sca.core.self.source.MyChannelSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by dell-liujf on 2018/10/11.
 */
//这个注解给我们绑定消息通道的，Source是Stream给我们提供的，
//可以点进去看源码，可以看到output和input,这和配置文件中的output，input对应的。
@EnableBinding({MyChannelSource.class})
public class SendService {

    @Autowired
    private MyChannelSource myChannelSource;

    /**
     * stream默认提供的消息发送方式
     * @param msg
     */
    public void sendMyChannelMsg(String msg){
        myChannelSource.myChannelOutput().send(MessageBuilder.withPayload(msg).build());
    }

}
