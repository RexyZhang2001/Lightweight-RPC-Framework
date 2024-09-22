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
public class FilterLoader {

    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public void addFilter(List<Filter> filters){
        for (Object filter : filters) {
            addFilter((Filter) filter);
        }
    }
    public FilterResponse doFilter(FilterData data){
        for (Filter filter : filters) {
            final FilterResponse filterResponse = filter.doFilter(data);
            if (!filterResponse.getResult()) {
                return filterResponse;
            }
        }
        return new FilterResponse(true,null);
    }
}
