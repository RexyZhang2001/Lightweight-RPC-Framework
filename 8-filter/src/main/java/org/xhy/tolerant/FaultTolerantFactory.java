package org.xhy.tolerant;

import org.xhy.common.constants.FaultTolerant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-16 23:22
 */
public class FaultTolerantFactory {

    private static Map<FaultTolerant,FaultTolerantStrategy> faultTolerantStrategyMap = new HashMap<>();

    static {
        faultTolerantStrategyMap.put(FaultTolerant.Failover,new FailoverFaultTolerantStrategy());
    }

    public static FaultTolerantStrategy get(FaultTolerant faultTolerant){
        return faultTolerantStrategyMap.get(faultTolerant);
    }

}
