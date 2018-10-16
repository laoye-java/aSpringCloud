package com.sca.core.self.processor;

import com.sca.core.self.sink.MySink;
import com.sca.core.self.source.MyChannelSource;
import org.springframework.cloud.stream.messaging.Processor;

/**
 * Created by dell-liujf on 2018/10/12.
 */
public interface MyProcessor extends Processor, MyChannelSource, MySink {
}
