package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: WangRunZhe
 * Create at:  2020年04月03日 23:14
 * Company:
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "brand")
/**
 *  跨域：A域名访问B域名的数据
 *  域名或请求端口或协议不一致时候，就跨域了
 */
@CrossOrigin
@Api(tags = "品牌相关操作")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "查询所有品牌", notes = "查询所有品牌")
    @GetMapping
    public Result findAll() {
        List<Brand> brandList = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK, "查询成功", brandList);
    }

    /***
     * 根据ID查询品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "通过id查找品牌", notes = "通过id查找品牌")
    @GetMapping("/{id}")
    public Result findById(@PathVariable(value = "id") Integer id) {
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true, StatusCode.OK, "查询成功", brand);
    }

    /***
     * 新增品牌数据
     * @param brand
     * @return
     */
    @ApiOperation(value = "新增品牌", notes = "新增品牌")
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /***
     * 修改品牌数据
     * @param brand
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    @ApiOperation(value = "修改品牌", notes = "修改品牌")
    public Result update(@RequestBody Brand brand, @PathVariable Integer id) {
        brand.setId(id);
        brandService.update(brand);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID删除品牌数据", notes = "根据ID删除品牌数据")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable Integer id) {
        brandService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 多条件搜索品牌数据
     * @param brand
     * @return
     */
    @ApiOperation(value = "多条件查询", notes = "多条件查询详细描述")
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand) {
        List<Brand> list = brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 分页搜索实现
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    @ApiOperation(value = "查询分页", notes = "查询分页详细描述")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page") Integer page,
                                            @PathVariable(value = "size") Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }


    /***
     * 分页搜索实现
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    @ApiOperation(value = "条件查询分页", notes = "条件查询分页详细")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,
                                            @PathVariable(value = "page") Integer page,
                                            @PathVariable(value = "size") Integer size) {
        int q = 10 / 0;
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

}
