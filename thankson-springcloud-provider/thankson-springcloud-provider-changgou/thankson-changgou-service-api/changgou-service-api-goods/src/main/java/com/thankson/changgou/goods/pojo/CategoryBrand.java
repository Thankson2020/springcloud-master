package com.thankson.changgou.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * categoryBrand实体类
 *
 * @author Thankson
 * @date 2020年03月16日 00:13:15
 */
@Table(name = "tb_category_brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryBrand implements Serializable{

	/**
	 * 分类ID
	 */
	@Id
    @Column(name = "category_id")
	private Integer categoryId;

	/**
	 * 品牌ID
	 */
    @Column(name = "brand_id")
	private Integer brandId;

}
