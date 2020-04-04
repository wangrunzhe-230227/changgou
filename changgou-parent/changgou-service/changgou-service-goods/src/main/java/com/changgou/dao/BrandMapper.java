package com.changgou.dao;

import com.changgou.goods.pojo.Brand;
import tk.mybatis.mapper.common.Mapper;

/**
 * Description: 使用通用Mapper 需要继承 tk.mybatis.mapper.common.Mapper接口
 * 增加数据，调用Mapper.insert()
 * 增加数据，调用Mapper.insertSelective()
 *
 * 修改数据，调用Mapper.update(T)
 * 修改数据，调用Mapper.updateByPrimaryKey(T)
 *
 * 查询数据，根据ID查询Mapper.selectByPrimaryKey(ID)
 * 查询数据，条件查询Mapper.select(T)
 *
 * <p>
 * ModelName:【】模块
 *
 * @author: WangRunZhe
 * Create at:  2020年04月03日 23:12
 * Company:
 * @version: 1.0
 */
public interface BrandMapper extends Mapper<Brand> {
}
