package org.xhy.register;

import org.xhy.common.constants.Register;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 21:11
 */
public class RegistryFactory {

    private static Map<Register, RegistryService> registerServiceMap = new HashMap<Register, RegistryService>();

    static {
        registerServiceMap.put(Register.ZOOKEEPER,new CuratorZookeeperRegistry("127.0.0.1:2181"));
    }
    public static RegistryService get(Register register){
        return registerServiceMap.get(register);
    }
}
