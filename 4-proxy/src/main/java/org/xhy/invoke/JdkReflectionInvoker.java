package org.xhy.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-10 16:54
 */
public class JdkReflectionInvoker implements Invoker{

    private Map<Integer,MethodInvocation> methodCache = new HashMap<>();

    @Override
    public Object invoke(Invocation invocation) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException {
        final Integer methodCode = invocation.getMethodCode();
        if (!methodCache.containsKey(methodCode)) {
            final Class<?> aClass = Class.forName(invocation.getClassName());
            final Method method = aClass.getMethod(invocation.getMethodName(), invocation.getParameterTypes());
            methodCache.put(methodCode,new MethodInvocation(aClass.newInstance(),method));
        }
        final MethodInvocation methodInvocation = methodCache.get(methodCode);
        return methodInvocation.invoke(invocation.getParameter());
    }
}
