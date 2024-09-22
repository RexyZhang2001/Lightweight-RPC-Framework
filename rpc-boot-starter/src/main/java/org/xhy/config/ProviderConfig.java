package org.xhy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 15:16
 */
@Component
public class ProviderConfig {

    @Bean
    public RpcProperties rpcProperties(){
        return new RpcProperties();
    }

    @Bean
    public ProviderPostProcessor providerPostProcessor(RpcProperties rpcProperties){
        Properties.setPort(rpcProperties.getPort());
        Properties.setRegister(rpcProperties.getRegistry());
        Properties.setInvoke(rpcProperties.getInvoke());
        Properties.setSerialization(rpcProperties.getSerialization());
        Properties.setCorePollSize(rpcProperties.getCorePollSize());
        Properties.setMaximumPoolSize(rpcProperties.getMaximumPoolSize());
        return new ProviderPostProcessor(rpcProperties);
    }
}
