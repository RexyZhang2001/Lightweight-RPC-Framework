package org.xhy.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.xhy.annotation.RpcService;
import org.xhy.common.Cache;
import org.xhy.common.URL;
import org.xhy.filter.FilterFactory;
import org.xhy.invoke.InvokerFactory;
import org.xhy.register.RegistryFactory;
import org.xhy.register.RegistryService;
import org.xhy.socket.serialization.SerializationFactory;
import org.xhy.socket.server.Server;
import org.xhy.utils.IpUtil;
import org.xhy.utils.ServiceNameBuilder;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 14:58
 */
public class ProviderPostProcessor implements InitializingBean, BeanPostProcessor {

    private RpcProperties rpcProperties;

    private final String ip = IpUtil.getIP();

    public ProviderPostProcessor(RpcProperties rpcProperties) {
        this.rpcProperties = rpcProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        RegistryFactory.init();
        FilterFactory.initServer();
        InvokerFactory.init();
        SerializationFactory.init();
        Thread t = new Thread(() -> {
            final Server server = new Server(rpcProperties.getPort());
            try {
                server.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.setDaemon(true);
        t.start();
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        // 找到bean上带有 RpcService 注解的类
        RpcService rpcService = beanClass.getAnnotation(RpcService.class);
        if (rpcService != null) {
            // 可能会有多个接口,默认选择第一个接口
            String serviceName = beanClass.getInterfaces()[0].getName();
            if (!rpcService.serviceInterface().equals(void.class)){
                serviceName = rpcService.serviceInterface().getName();
            }
            try {
                RegistryService registryService = RegistryFactory.get(rpcProperties.getRegistry().getName());
                final URL url = new URL();
                url.setPort(Properties.getPort());
                url.setIp(ip);
                url.setServiceName(serviceName);
                url.setVersion(rpcService.version());
                registryService.register(url);
                // 缓存
                final String key = ServiceNameBuilder.buildServiceKey(serviceName, rpcService.version());
                Cache.SERVICE_MAP.put(key,bean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}
