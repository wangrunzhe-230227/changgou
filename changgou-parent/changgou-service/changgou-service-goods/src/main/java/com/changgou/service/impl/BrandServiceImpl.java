package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

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
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     * findAll:(查询所有品牌)
     *
     * @param
     * @return java.util.List<com.changgou.goods.pojo.Brand>
     * Create at: 2020年04月04日
     * @throws
     * @author WangRunZhe
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        // 根据ID查询->通用Mapper.selectByPrimaryKey(Object)根据主键查询
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 增加
     *
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        // 使用Mapper.insertSelective(T)实现增加
        //方法中但凡带有Selective，会忽略空值
        brandMapper.insertSelective(brand);
    }

    /**
     * 修改
     *
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 条件查询
     *
     * @param brand
     * @return
     */
    @Override
    public List<Brand> findList(Brand brand) {
        // 调用方法构建条件
        Example example = createExample(brand);
        return brandMapper.selectByExample(example);
    }

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        // 分页实现，后面的查询紧跟集合查询
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();
        // 封装PageInfo
        return new PageInfo<>(brands);
    }

    /***
     * 多条件分页查询
     * @param brand 搜索条件
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        Example example = createExample(brand);
        List<Brand> brands = brandMapper.selectByExample(example);
        return new PageInfo<Brand>(brands);
    }

    /**
     * 条件构建
     */
    public Example createExample(Brand brand) {
        // 自定义条件搜索对象
        Example example = new Example(Brand.class);
        // 条件构造器
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            // 品牌名称
            if (!StringUtils.isEmpty(brand.getName())) {
                // 根据名字模糊查询
                /**
                 * 1：Brand的属性名
                 * 2：占位符参数，搜索的条件
                 */
                criteria.andLike("name", "%" + brand.getName() + "%");
            }
            // 品牌的首字母
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }

}
