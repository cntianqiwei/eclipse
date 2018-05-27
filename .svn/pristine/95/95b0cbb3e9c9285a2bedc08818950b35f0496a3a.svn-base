package cn.mldn.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.vo.Resource;

public interface IResourceService {
	/**
	 * 申请表中详细清单的数据集合
	 * @param spid 申请表的ID 
	 * @return 返回结果如下
	 * 1、key=allResource,value=所有清单
	 * @throws Exception 程序异常
	 */
	public Map<String,Object> listBySup(Long spid)throws Exception;
	/**
	 * 实现待购物清单的增加
	 * @param vo 要添加的物品清单表
	 * @return
	 * @throws Exception
	 */
	public boolean addResource(Resource vo)throws Exception;
	/**
	 * 实现清单页面的回显示
	 * @param resid 清单ID
	 * @return 返回vo
	 * @throws Exception
	 */
	public Resource resourceFindByResid(Long resid)throws Exception;
	/**
	 * 实现清单内容的修改
	 * @param vo 修改的vo
	 * @return 修改成功返回true
	 * @throws Exception 程序异常
	 */
	public boolean editResource(Resource vo) throws Exception;
	/**
	 * 实现清单内容的修改
	 * @param vo 修改的vo
	 * @param resid 清单编号
	 * @return 修改成功返回true
	 * @throws Exception 程序异常
	 */
	public boolean editResource(Resource vo,Long resid) throws Exception;
	/**
	 * 实现申请表里清单列表的删除
	 * @param resid 清单表ID
	 * @return 删除成功返回true
	 * @throws Exception 程序异常
	 */
	public boolean deleteResource(Set<Long> resids)throws Exception;
	/**
	 * 实现分页模糊查询显示后勤库存的办公用品显示
	 * @param currentPage 当前页
	 * @param lineSize 每页行
	 * @param column 列
	 * @param keyWord 关键字
	 * @return 返回结果如下
	 * 1、key=allRecorders,value=所有的数据行数
	 * 2、key=allResource,value=库存办公用品表的数据
	 * @throws Exception 程序异常
	 */
	public Map<String, Object> listByStatus3(long currentPage,int lineSize,String column,String keyWord)throws Exception;
	/**
	 * 增加库存数量
	 * @param resid 库存清单ID
	 * @param amount 库存数量
	 * @return 增加成功返回true
	 * @throws Exception 程序异常
	 */
	public boolean addAmount(long resid,int amount)throws Exception;

}
