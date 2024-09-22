package org.xhy.socket.serialization;

import org.xhy.common.constants.RpcSerialization;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-08 11:57
 */
public class SerializationFactory {

    private static Map<RpcSerialization, org.xhy.socket.serialization.RpcSerialization> serializationMap
            = new HashMap<RpcSerialization, org.xhy.socket.serialization.RpcSerialization>();

    static {
        serializationMap.put(RpcSerialization.JSON,new JsonSerialization());
    }

    public static org.xhy.socket.serialization.RpcSerialization get(RpcSerialization serialization){
        return serializationMap.get(serialization);
    }
}
