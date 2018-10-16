package com.sca.core.self.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * 用于监听发送端发送的消息
 * Created by dell-liujf on 2018/10/12.
 */
public interface MySink extends Sink {

    String myChannelInput = "myChannelInput";

    @Input("myChannelInput")
    SubscribableChannel myChannelInput();
}
