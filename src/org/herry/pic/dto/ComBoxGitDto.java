package org.herry.pic.dto;/**
 * @author zhangheng
 * @date 2020/4/13 1:16
 */

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.herry.pic.constant.GitConst;

/**
 * @author zhangheng
 * @description
 * @date 2020/4/13
 */
public class ComBoxGitDto extends GitDto {
    @Override
    public String toString() {
        return this.simpleRepoUri(this.getRemoteRepoUri()) + "|" + this.getUserName() ;
    }

    /**
     * @author zhang.heng
     * @date 2020-04-18 00:28
     * @Param: [uri]
     * @return java.lang.String
     * 将uri以较短的词代替
     * @throws
     * @taskId
    */
    private String simpleRepoUri(String uri) {
        String simpleString = "";
        Set<Map.Entry<String, String>> entries = GitConst.GIT_MAP.entrySet();
        Iterator<Map.Entry<String, String>> iteratorMap = entries.iterator();
        while (iteratorMap.hasNext()) {
            Map.Entry<String, String> item = iteratorMap.next();
            if (uri.contains(item.getValue())) {
                simpleString = item.getKey();
            }
        }
        return simpleString;
    }

}
