package cn.mldn.service;

import java.util.Map;

import cn.mldn.vo.EmpResource;

public interface IEmpResourceService {
	/**
	 * 模糊分页显示雇员申请办公用品申请单
	 * @param currentPage 当前页
	 * @param lineSize 每页行
	 * @param column 列
	 * @param keyWord 关键字
	 * @return 返回如下
	 * 1、key=allRecorders,value=所有数据的行数
	 * 2、key=allEmpResource,value=所有数据申请表的信息
	 * @throws Exception 程序异常
	 */
	public Map<String, Object> listByEmpResource(Long currentPage, Integer lineSize, String column, String keyWord) throws Exception;
	/**
	 * 进行雇员申请单的内部显示
	 * @param eresid 申请单ID
	 * @return 返回结果如下
	 * 1、key=EmpResource,value=申请单内容
	 * 2、key=allDetails,value=所有的清单内容
	 * 3、key=allResources,value=所有用品的内容
	 * @throws Exception 程序异常
	 */
	public Map<String,Object> handelByEresid(Long eresid)throws Exception;
	/**
	 * 进行对EmpResource申请表的审核
	 * @param eresid 申请表id
	 * @param vo 申请表内容
	 * @return 变更内容成功返回true
	 * @throws Exception 程序异常
	 */
	public boolean editEmpResource(Long eresid,EmpResource vo) throws Exception;
	
 
}
