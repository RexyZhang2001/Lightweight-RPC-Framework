package org.xhy.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 17:01
 */
public class MethodInvocation {

    private Object o;

    private Method method;
    public MethodInvocation(Object o, Method method){
        this.o = o;
        this.method = method;
    }
    public Object invoke(Object parameter) throws InvocationTargetException, IllegalAccessException {

        return method.invoke(o,parameter);
    }
}
