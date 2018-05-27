package cn.mldn.service;

import java.util.List;
import java.util.Map;

import cn.mldn.vo.Emp;

public interface IEmpService {
	/**
	 * 当原部门有领导，而现在添加部门领导时，原部门领导若降一级等级仍高于或等于后加（或后变动）的领导，则部门领导不变，否则部门领导变为后加（或后变动）人员，原部门领导级别降1
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean add(Emp vo) throws Exception;
	public List<Emp> list() throws Exception;
	public Map<String,Object> list(Long currentPage, Integer lineSize) throws Exception;
	public Map<String,Object> list(Long currentPage, Integer lineSize, String column, String keyWord,String mid) throws Exception;
	public Map<String,Object> listPre() throws Exception;
	public boolean deleteByIds(List<String> ids) throws Exception;
	public Emp get(String id) throws Exception; 
	/**
	 * 修改前的准备工作，需查出雇员信息进行表单回填，所有的部门信息以及所有的级别信息
	 * @param id 要修改的雇员信息
	 * @return key=emp value=Emp;key=allDepts value=List<Dept> ;key=allLevels value=List<Level>
	 * @throws Exception 程序执行错误
	 */
	public Map<String,Object> editPre(String id) throws Exception;
	public boolean edit(Emp vo) throws Exception;
	public Map<String,Object> getCompeleteDetails(String eid,String mid) throws Exception;
	public Map<String,Object> getSimpleDetails(String eid) throws Exception;
	public boolean getCheck(String eid) throws Exception;
}
