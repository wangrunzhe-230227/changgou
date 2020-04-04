package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: WangRunZhe
 * Create at:  2020年04月03日 23:13
 * Company:
 * @version: 1.0
 */
public interface BrandService {

    /***
     * 查询所有品牌
     * @return
     */
    public List<Brand> findAll();

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public Brand findById(Integer id);

    /***
     * 新增品牌
     * @param brand
     */
    public void add(Brand brand);

    /***
     * 修改品牌数据
     * @param brand
     */
    public void update(Brand brand);


    /***
     * 删除品牌
     * @param id
     */
    public void delete(Integer id);

    /***
     * 多条件搜索品牌方法
     * @param brand
     * @return
     */
    public List<Brand> findList(Brand brand);

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public PageInfo<Brand> findPage(Integer page, Integer size);

    /***
     * 多条件分页查询
     * @param brand 搜索条件
     * @param page
     * @param size
     * @return
     */
    PageInfo<Brand> findPage(Brand brand, Integer page, Integer size);

}
