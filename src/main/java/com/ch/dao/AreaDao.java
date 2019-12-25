package com.ch.dao;

import com.ch.domain.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AreaDao {

    /**
     * 根据id查询一个
     * @return
     */
    public Area findById(int id);

    /**
     * 查询所有
     * @return
     */
    public List<Area> findAll();

    /**
     * 保存一个
     * @param area
     */

    public void save(Area area);

    /**
     * 修改
     * @param area
     */
    public void update(Area area);


    /**
     * 删除
     * @param id
     */
    public void delete(int id);

    /**
     * 查询总条数
     */
    public int countAll();

    public Area findByMoHu(String name);

    /**
     * 分页查询
     * @return
     * @param map
     */
    public List<Area> findByPage(Map map);

    /**
     *
     * 动态查询
     * @param area
     * @return
     */
    public List<Area> findByDt(Area area);
}
