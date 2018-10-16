package com.sca.core.self.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * 用于发送消息
 * Created by dell-liujf on 2018/10/12.
 */
public interface MyChannelSource extends Source {

    String defaultProcessorOutput = "defaultProcessorOutput";
    String myChannelProcessorOutput = "myChannelProcessorOutput";

    @Output("defaultProcessorOutput")
    MessageChannel defaultProcessorOutput();

    @Output("myChannelProcessorOutput")
    MessageChannel myChannelProcessorOutput();

}
