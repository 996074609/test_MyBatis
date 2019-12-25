package com.ch;


import com.ch.dao.AreaDao;
import com.ch.domain.Area;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.RequestWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test03 {
    AreaDao areaDao = null;
    SqlSession sqlSession = null;
    InputStream in = null;

    @Test
    public void save() {
        Area area=new Area();
        area.setName("赶场镇");
        area.setCode("110110");
        area.setCitycode("119119");
        areaDao.save(area);
        System.out.println(area.getId());
    }

    @Test
    public  void findAll(){
        List<Area> all = areaDao.findAll();
        System.out.println(all);
    }

    @Test
    public void findById(){
        Area byId = areaDao.findById(3151);
        System.out.println(byId);
    }

    /**
     * 修改
     * @throws IOException
     */
    @Test
    public void update(){
        Area area = areaDao.findById(3151);
        if(area!=null){
            area.setName("赶场");
            areaDao.update(area);
        }else {
            System.out.println("异常");
        }
    }

    /**
     * 删除
     * @throws IOException
     */
    @Test
    public void delete(){
        areaDao.delete(3150);
    }
    @Test
    public void countAll(){
        int a=areaDao.countAll();
        System.out.println(a);
    }

    /**
     * 模糊查询
     */
    @Test
    public void findByMoHu(){
        Area area = areaDao.findByMoHu("%赶场%");
        System.out.println(area);
    }


    /**
     *
     * @throws IOException
     */
    @Test
    public  void findByPage(){
        Map map=new HashMap();
        map.put("currentIndex",0);
        map.put("pageSize",5);
        List<Area> areas = areaDao.findByPage(map);
        System.out.println(areas);

    }


    /**
     *
     * 动态查询
     * @throws IOException
     */
    @Test
    public void dt(){
        Area area=new Area();
       // area.setName("%赶场%");
        List<Area> areas = areaDao.findByDt(area);
        System.out.println(areas);
    }
    @Before
    public void before() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        areaDao = sqlSession.getMapper(AreaDao.class);

    }


    @After
    public void after() throws IOException {

        sqlSession.close();
        in.close();
    }
}
