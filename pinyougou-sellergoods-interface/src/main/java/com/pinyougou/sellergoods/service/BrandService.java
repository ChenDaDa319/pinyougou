package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.entity.PageResult;

import java.util.List;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	/**
	 * 测试方法
	 * @return
	 */
	List<TbBrand> findAll();

	/**
	 * 分页查询品牌
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageResult findPage(int pageNum,int pageSize);

	/**
	 * 增加品牌
	 * @param brand
	 */
	void add(TbBrand brand);

	/**
	 * 修改
	 * @param brand
	 */
	void update(TbBrand brand);

	/**
	 * 根据ID查找品牌
	 * @param id
	 * @return
	 */
	TbBrand selectOneById(Long id);

	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(Long[] ids);

	/**
	 * 条件查询
	 * @param brand
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageResult findPage(TbBrand brand,int pageNum,int pageSize);
}
