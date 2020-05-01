package com.thankson.changgou.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Spu和Sku 组合对象
 *
 * @author Thankson
 * @date 2020年03月16日 00:13:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods implements Serializable {
    private Spu spu;
    private List<Sku> skuList;
}
