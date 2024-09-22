package org.xhy.socket.serialization;

import org.xhy.common.constants.RpcSerialization;
import org.xhy.spi.ExtensionLoader;

import java.io.IOException;
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


    public static org.xhy.socket.serialization.RpcSerialization get(RpcSerialization serialization){
        return ExtensionLoader.getInstance().get(serialization.name);
    }

    public static org.xhy.socket.serialization.RpcSerialization get(String name){
        return ExtensionLoader.getInstance().get(name);
    }

    public static void init() throws IOException, ClassNotFoundException {
        ExtensionLoader.getInstance().loadExtension(org.xhy.socket.serialization.RpcSerialization.class);
    }
}
