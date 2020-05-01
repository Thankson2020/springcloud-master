package com.thankson.changgou.goods.dao;

import com.thankson.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * brand数据层
 *
 * @author Thankson
 * @date 2020年03月16日 00:13:15
 */
public interface BrandMapper extends Mapper<Brand> {

    /**
     * 查询分类对应的品牌集合
     *
     * @param categoryId 分类id
     * @return List<Brand>
     * @author Thankson
     * @date 2020年03月16日 00:13:15
     */
    @Select("SELECT brand.* FROM tb_category_brand category_brand,tb_brand brand WHERE category_brand.category_id=#{categoryId} AND brand.id=category_brand.brand_id")
    List<Brand> findByCategory(Integer categoryId);

}
