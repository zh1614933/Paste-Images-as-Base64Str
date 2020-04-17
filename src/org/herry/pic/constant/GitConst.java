package org.herry.pic.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangheng
 * @description
 * @date 2020/4/13
 */
public class GitConst {
    public static final Map<String, String> GIT_MAP;
    static
    {
        GIT_MAP = new HashMap<String, String>();
        GIT_MAP.put("GITHUB", "github.com");
        GIT_MAP.put("GITEE", "gitee.com");
    }
}
