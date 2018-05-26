package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.entity.PageResult;
import com.pinyougou.pojo.entity.Result;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	/**
	 * 测试方法
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();		
	}

	/**
	 * 分页查询品牌
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int rows){
		return brandService.findPage(page,rows);
	}

	/**
	 * 品牌添加
	 * @param brand
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand){
		try {
			brandService.add(brand);
			return new Result(true,"增加成功");
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,"增加失败");
		}

	}

	/**
	 * 更新品牌
	 * @param brand
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand){
		try {
			brandService.update(brand);
			return new Result(true,"更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"更新失败");
		}
	}

	/**
	 * 根据ID
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectOneById")
	public TbBrand selectOneById(Long id){
		return brandService.selectOneById(id);
	}

	/**
	 * 批量删除 ctrl alt t
	 * @param ids
	 */
	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		try {
			brandService.delete(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}

	/**
	 * 条件查询
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult findPage(@RequestBody TbBrand brand,int page,int rows){
		PageResult resPage = brandService.findPage(brand, page, rows);
		return resPage;

	}
}
