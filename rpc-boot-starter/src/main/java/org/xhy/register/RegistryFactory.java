package org.xhy.register;

import org.xhy.common.constants.Register;
import org.xhy.spi.ExtensionLoader;

import java.io.IOException;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 21:11
 */
public class RegistryFactory {


    public static RegistryService get(Register register){
        return ExtensionLoader.getInstance().get(register.name);
    }


    public static RegistryService get(String name){
        return ExtensionLoader.getInstance().get(name);
    }

    public static void init() throws IOException, ClassNotFoundException {
        ExtensionLoader.getInstance().loadExtension(RegistryService.class);
    }
}
