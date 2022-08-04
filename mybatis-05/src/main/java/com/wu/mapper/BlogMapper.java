package com.wu.mapper;

import com.wu.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    /**
     * 新增博客
     *
     * @param model
     * @return
     */
    int addBlog(@Param("model") Blog model);

    /**
     * 用动态sql获取信息
     *
     * @param map
     * @return
     */
    List<Blog> queryBlogIf(@Param("map") Map map);

    int updateBlog(@Param("map") Map map);
}
