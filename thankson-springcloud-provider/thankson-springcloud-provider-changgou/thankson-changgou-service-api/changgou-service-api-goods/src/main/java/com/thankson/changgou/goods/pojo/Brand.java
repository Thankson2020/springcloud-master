package com.thankson.changgou.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * brand实体类
 *
 * @author Thankson
 * @date 2020年03月16日 00:13:15
 */
@Table(name = "tb_brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand implements Serializable{

	/**
	 * 品牌id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;

	/**
	 * 品牌名称
	 */
    @Column(name = "name")
	private String name;

	/**
	 * 品牌图片地址
	 */
    @Column(name = "image")
	private String image;

	/**
	 * 品牌的首字母
	 */
    @Column(name = "letter")
	private String letter;

	/**
	 * 排序
	 */
    @Column(name = "seq")
	private Integer seq;

}
