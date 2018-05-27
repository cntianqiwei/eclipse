package cn.mldn.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.vo.Plan;

public interface IPlanService {
	
	/**
	 * 编辑landetails中的雇员信息，并进行人数的增加或者删除
	 * 增加参与人员需要满足条件:
	 * 	1，不能重复增加参与人员
	 *  2，改参与人员再任务所在时段不能有其他任务
	 *  3，
	 * 删除参与人员需要满足条件:
	 *  1，
	 * @param eid 增加或者删除的雇员信息
	 * @param count 可传递的参数为（1,-1）
	 * @return 
	 * 1,key="flag" ,value=成功返回true，失败返回false
	 * 2,key="msg" ,value=成功或者失败的提示信息
	 * @throws Exception
	 */
	public Map<String,Object> editAmount(long pid,String eid,int count) throws Exception ;
	/**
	 * 根据任务id查询任务内容及人员
	 * @param pid 任务id
	 * @return 
	 * 1、key="plan" value=任务对象
	 * 2、key="allEmps" value=所有参与此任务的雇员List集合
	 * 3、key="allLevels" value=map(lid,title)
	 * 3、key="allDepts" value=map(did,dname)
	 * @throws Exception
	 */
	public Map<String,Object> findById(long pid) throws Exception ;
	/**
	 * 新增一个工作安排
	 * @param plan 
	 * @return 新增成功返回true，失败返回false
	 * @throws Exception 程序异常
	 */
	public boolean add(Plan plan) throws Exception ; 
	/**
	 * 模糊查询
	 * @param currentPage
	 * @param lineSize
	 * @param column
	 * @param keyWord
	 * @return 1、key="allPlans" value=List集合
	 * 	2、key="allRecorders" value=查询的数量
	 * @throws Exception
	 */
	public Map<String,Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws Exception ;
	
	/**
	 * 删除草稿（状态码为0）中的工作任务
	 * @param ids pid主键列
	 * @return 删除成功返回true,否则返回false
	 * @throws Exception 程序异常
	 */
	public boolean delete(Set<Long> ids) throws Exception ;
	/**
	 * 根据任务的id修改任务状态status(0:草稿,1:发布)
	 * @param pid
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public boolean editStatusById(long pid,int status) throws Exception ;
	/**
	 * 任务调度增加员工
	 * @param eid 当前账户id
	 * @param did 部门
	 * @return 
	 * 1、key="allEmps" value=当前部门下能调度的人员List<Emp>
	 * 2、key="allLevels" value=map(lid,Lid类)
	 * 
	 * @throws Exception
	 */
	public Map<String,Object> addEmpPre(String eid,long did) throws Exception ;
	
}
