package org.xhy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 15:26
 */
@Component
public class ConsumerConfig {

    @Bean
    public RpcProperties rpcProperties(){
        return new RpcProperties();
    }

    @Bean
    public ConsumerPostProcessor consumerPostProcessor(RpcProperties rpcProperties){
        Properties.setPort(rpcProperties.getPort());
        Properties.setRegister(rpcProperties.getRegistry());
        Properties.setSerialization(rpcProperties.getSerialization());
        Properties.setProxy(rpcProperties.getProxy());

        return new ConsumerPostProcessor(rpcProperties);
    }
}
