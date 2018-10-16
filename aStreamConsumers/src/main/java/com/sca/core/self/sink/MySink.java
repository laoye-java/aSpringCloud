package com.sca.core.self.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by dell-liujf on 2018/10/12.
 */
public interface MySink extends Sink {

    String myChannelInput = "myChannelInput";
    String defaultProcessorInput = "defaultProcessorInput";
    String myChannelProcessorInput = "myChannelProcessorInput";

    @Input("myChannelInput")
    SubscribableChannel myChannelInput();

    @Input("defaultProcessorInput")
    SubscribableChannel defaultProcessorInput();

    @Input("myChannelProcessorInput")
    SubscribableChannel myChannelProcessorInput();
}
