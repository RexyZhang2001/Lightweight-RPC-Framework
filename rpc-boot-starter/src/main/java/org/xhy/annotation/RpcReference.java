package org.xhy.annotation;

import org.xhy.common.constants.FaultTolerant;
import org.xhy.common.constants.LoadBalance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 00:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface RpcReference {

    String version() default "1.0";

    FaultTolerant faultTolerant() default FaultTolerant.Failover;

    LoadBalance loadBalance() default LoadBalance.Round;

    long time() default 3000;

    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
