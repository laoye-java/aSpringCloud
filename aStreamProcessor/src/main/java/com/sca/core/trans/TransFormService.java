package com.sca.core.trans;

import com.sca.core.self.processor.MyProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * 出现多个相同的input接收监听时，轮询处理 , 默认只会处理一个，
 * 经测试 （1 和 3 轮流出现，2 和 4 轮流出现）,处理机制是轮询接收
 * Created by dell-liujf on 2018/10/12.
 */
@EnableBinding(MyProcessor.class)
public class TransFormService {

    /**
     * 接收 MyProcessor.INPUT
     * 转发 MyProcessor.defaultProcessorOutput
     * @param payload
     * @return
     */
    @ServiceActivator(inputChannel = MyProcessor.INPUT, outputChannel = MyProcessor.defaultProcessorOutput)
    public Object transformDefaultToDefaultProcessor(Object payload){
        System.out.println("==1=="+"消息中转站,接收"+MyProcessor.INPUT+"："+payload);
        return "消息中转站,转发"+MyProcessor.defaultProcessorOutput+"：" + payload;
    }

    /**
     * 接收 MyProcessor.INPUT
     * 转发 MyProcessor.myChannelProcessorOutput
     * @param payload
     * @return
     */
    @StreamListener(MyProcessor.INPUT)//监听通道
    @SendTo(MyProcessor.myChannelProcessorOutput)//返回处理结果到output通道
//    @ServiceActivator(inputChannel = MyProcessor.INPUT, outputChannel = MyProcessor.myChannelProcessorOutput)
    public Object transformDefaultToDefault(Object payload){
        System.out.println("==3=SendTo=="+"消息中转站,接收"+MyProcessor.INPUT+"："+payload);
//        System.out.println("==3=Processor=="+"消息中转站,接收"+MyProcessor.INPUT+"："+payload);
        return "消息中转站,转发"+MyProcessor.myChannelProcessorOutput+"：" + payload;
    }

    //========================================

    /**
     * 接收 MyProcessor.myChannelInput
     * 转发 MyProcessor.myChannelProcessorOutput
     * @param payload
     * @return
     */
    @ServiceActivator(inputChannel = MyProcessor.myChannelInput, outputChannel = MyProcessor.myChannelProcessorOutput)
    public Object transformMyChannelToMyChannelProcessor(Object payload){
        System.out.println("==2=="+"消息中转站,接收"+MyProcessor.myChannelInput+"："+payload);
        return "消息中转站,转发"+MyProcessor.myChannelProcessorOutput+"：" + payload;
    }

    /**
     * 接收 MyProcessor.myChannelInput
     * 转发 MyProcessor.defaultProcessorOutput
     * @param payload
     * @return
     */
    @ServiceActivator(inputChannel = MyProcessor.myChannelInput, outputChannel = MyProcessor.defaultProcessorOutput)
    public Object transformMyChannelToDefaultProcessor(Object payload){
        System.out.println("==4=="+"消息中转站,接收"+MyProcessor.myChannelInput+"："+payload);
        return "消息中转站,转发"+MyProcessor.defaultProcessorOutput+"：" + payload;
    }

}
