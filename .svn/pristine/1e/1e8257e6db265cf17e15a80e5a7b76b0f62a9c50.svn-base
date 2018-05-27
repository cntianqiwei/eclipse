package cn.mldn.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.vo.Resource;
import cn.mldn.vo.Supplypurchase;

public interface ISupplypurchaseService {
	/**
	 * 创建一个采购申请
	 * @param vo 添加的申请表
	 * @return 申请成功返回true，否则返回false
	 * @throws Exception 程序异常
	 */
	public boolean addSup(Supplypurchase vo)throws Exception;
	/**
	 * 在不分页的情况下得到申请表supplypurchase的所有信息
	 * @return 返回如下
	 * 1、key=allSup,value=所有Supplypurchase表的list集合
	 * @throws Exception 程序异常
	 */
	public Map<String, Object> listSupByFindAll()throws Exception;
	/**
	 * 实现后勤业务申请表的展示
	 * @param column 列
	 * @param keyWord 关键字
	 * @param currentPage 当前页
	 * @param lineSize 每页行
	 * @return 返回结果如下
	 * 1、key=allRecorders,value=所有的数据行数
	 * 2、key=allSup,value=申请表的数据
	 * @throws Exception 程序异常
	 */
	public Map<String, Object> listSupByFindSplit(String column,String keyWord,long currentPage,int lineSize)throws Exception;
	/**
	 * 实现清单提交后申请表单的变更
	 * @param spid 申请表ID
	 * @param resids 清单ID
	 * @return 修改成功返回true,否则返回false
	 * @throws Exception 程序异常
	 */
	public boolean editSupByResource(Long spid,Set<Long> resids)throws Exception;
	 

}
