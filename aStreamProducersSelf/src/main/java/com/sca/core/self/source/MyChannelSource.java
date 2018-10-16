package com.sca.core.self.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 自定义消息通道
 * Created by dell-liujf on 2018/10/12.
 */
public interface MyChannelSource {

    String myChannelOutput = "myChannelOutput";

    @Output("myChannelOutput")
    MessageChannel myChannelOutput();

}
