package org.xhy.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @gitee: https://gitee.com/XhyQAQ
 * @copyright: B站: https://space.bilibili.com/152686439
 * @Author: Xhy
 * @CreateTime: 2024-05-17 12:49
 */
public class FilterFactory {

    private static List<Filter> clientBeforeFilters = new ArrayList<>();
    private static List<Filter> clientAfterFilters = new ArrayList<>();
    private static List<Filter> serverBeforeFilters = new ArrayList<>();
    private static List<Filter> serverAfterFilters = new ArrayList<>();


    public static void registerClientBeforeFilter(Filter filter) {
        clientBeforeFilters.add(filter);
    }

    public static void registerClientAfterFilter(Filter filter) {
        clientBeforeFilters.add(filter);
    }

    public static void registerServerBeforeFilter(Filter filter) {
        serverBeforeFilters.add(filter);
    }

    public static void registerServerAfterFilter(Filter filter) {
        serverAfterFilters.add(filter);
    }

    public static List<Filter> getClientBeforeFilters() {
        return clientBeforeFilters;
    }

    public static List<Filter> getClientAfterFilters() {
        return clientAfterFilters;
    }

    public static List<Filter> getServerBeforeFilters() {
        return serverBeforeFilters;
    }

    public static List<Filter> getServerAfterFilters() {
        return serverAfterFilters;
    }
}
