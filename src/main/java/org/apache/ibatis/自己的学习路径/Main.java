package org.apache.ibatis.自己的学习路径;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yangzhe14
 * @date 2023/7/8
 */
public class Main {
    /**
     * 顺着这个思路开始往后看
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        // 拿字节流这个没啥看的
        InputStream inputstream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /**
         *mybatis配置mapper,解析，有4种方式：package,class,resource,url
         */
        sqlSessionFactory.getConfiguration().addMapper(DemoMapper.class);
        DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
        System.out.println(mapper.count());
    }
}