import com.wu.mapper.BlogMapper;
import com.wu.pojo.Blog;
import com.wu.utils.IDUtil;
import com.wu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/25
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MySqlTest {
    static Logger logger = Logger.getLogger(MySqlTest.class);

    @Test
    public void inserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.addBlog(new Blog(IDUtil.getId(), "Mybatis如此简单", "狂神说", new Date(), 999));
        mapper.addBlog(new Blog(IDUtil.getId(), "Java如此简单", "狂神说", new Date(), 999));
        mapper.addBlog(new Blog(IDUtil.getId(), "Spring如此简单", "狂神说", new Date(), 100));
        mapper.addBlog(new Blog(IDUtil.getId(), "微服务如此简单", "狂神说", new Date(), 999));
        sqlSession.close();
    }

    //where if
    @Test
    public void ifTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("title", "Mybatis如此简单");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            logger.info(blog);
        }
        sqlSession.close();
    }

    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","动态SQL");
        map.put("author","秦疆");
        map.put("id","443217cf28494f3fbf3d8b317fec178d");
        mapper.updateBlog(map);
    }

}
