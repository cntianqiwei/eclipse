package cn.mldn.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import com.alibaba.fastjson.JSON;

import cn.mldn.service.IResourceService;
import cn.mldn.service.ISupplypurchaseService;
import cn.mldn.util.web.SplitPageUtil;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.util.web.servlet.ServletObjectUtil;
import cn.mldn.vo.Resource;
import cn.mldn.vo.Supplypurchase;

@Controller
@RequestMapping("/pages/back/admin/supply/*")
public class SupplypurchaseAction extends AbstractAction {
	@Autowired
	private ISupplypurchaseService supplypurchaseService;
	@Autowired
	private IResourceService resourceService;
	@RequestMapping("supply_resource_editAmout")
	public ModelAndView addAmount(Long resid,Integer amount)throws Exception{
		ModelAndView mav = new ModelAndView(super.getPage("resource.page"));
		boolean flag= false;
		flag = this.resourceService.addAmount(resid, amount);
		mav.add("flag", flag);
		return mav;
	}
	@RequestMapping("supply_resource_list")
	public ModelAndView resourceList() throws Exception{
		System.out.println("执行");
		ModelAndView mav = new ModelAndView(super.getPage("resource.page"));
		String columnData = "办公用品名称:title" ;
		SplitPageUtil spu = new SplitPageUtil(columnData,super.getPageKey("resource.action"));
		Map<String, Object> map = this.resourceService.listByStatus3(spu.getCurrentPage(), spu.getLineSize(), spu.getColumn(), spu.getKeyword());
		mav.addMap(map);
		return mav;
	}
	@RequestMapping("supply_apply_edit")
	public void editSupByResource(Long spid,String ids)throws Exception{
		Set<Long> resids = super.handleIdToLong(ids);
		boolean flag= false;
		flag=this.supplypurchaseService.editSupByResource(spid, resids);
		super.print(flag);
//		if(this.supplypurchaseService.editSupByResource(spid, resids)) {
//			ServletObjectUtil.getRequest().setAttribute("msg", "申请提交成功,请等待财务审核");
//			ServletObjectUtil.getRequest().setAttribute("url", "supply_apply_list.action");
//			ServletObjectUtil.getRequest().setAttribute("urlClick", "/eop/pages/back/admin/supply/supply_apply_list.action");
//			return "/pages/plugins/forward.jsp" ; 
//		}else {
//			ServletObjectUtil.getRequest().setAttribute("msg", "内容修改失败！");
//			ServletObjectUtil.getRequest().setAttribute("url", "supply_apply_list.action");
//			ServletObjectUtil.getRequest().setAttribute("urlClick", "/eop/pages/back/admin/supply/supply_apply_list.action");
//			return "/pages/plugins/forward.jsp" ; 
//		}
	}
	@RequestMapping("supply_goods_remove")
	public void Remove(String ids)throws Exception{
		Set<Long> resids = super.handleIdToLong(ids);
		System.out.println(resids);
		Map<String, Object> result =new HashMap<>();
		result.put("flag", this.resourceService.deleteResource(resids));
		super.print(JSON.toJSON(result));
	}
	
	@RequestMapping("supply_goods_edit")
	public String editResource(Resource vo,Long resid,Long spid)throws Exception{
		String photo=null;
		if(ServletObjectUtil.getParameter().isUpload()) {
			photo=(String)new ArrayList(ServletObjectUtil.getParameter().createUUIDFileName("photo")).get(0);
			@SuppressWarnings("deprecation")
			String realPath=ServletObjectUtil.getRequest().getRealPath("/");
			ServletObjectUtil.getParameter().saveUpload("photo", realPath+"upload/resource/"+photo);
		}else {
			photo="nophoto.png";
		}
		vo.setPhoto(photo);
//		System.out.println(resid); 
//		System.out.println(spid); 
		if(this.resourceService.editResource(vo, resid)) {
			ServletObjectUtil.getRequest().setAttribute("msg", "内容修改成功！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"supply_details_list.action?spid="+spid+"\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "/eop/pages/back/admin/supply/supply_details_list.action?spid="+spid+"");
			return "/pages/plugins/forward.jsp" ; 
		}else {
			ServletObjectUtil.getRequest().setAttribute("msg", "内容修改失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"supply_goods_edit.jsp\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/supply/supply_goods_edit.jsp\"");
			return "/pages/plugins/forward.jsp" ; 
		}
		
	}
	
	@RequestMapping("supply_goods_edit_pre")
	public ModelAndView editPreResource(Long resid)throws Exception{
		ModelAndView mav =new ModelAndView("/pages/back/admin/supply/supply_goods_edit.jsp");
		mav.add("Resource", this.resourceService.resourceFindByResid(resid));
		return mav;
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("supply_goods_add")
	public  String addResource(Resource vo,Long spid) throws Exception{
		String photo=null;
		if(ServletObjectUtil.getParameter().isUpload()) {
			photo=(String)new ArrayList(ServletObjectUtil.getParameter().createUUIDFileName("photo")).get(0);
			@SuppressWarnings("deprecation")
			String realPath=ServletObjectUtil.getRequest().getRealPath("/");
			ServletObjectUtil.getParameter().saveUpload("photo", realPath+"upload/resource/"+photo);
		}else {
			photo="nophoto.png";
		}
		vo.setPhoto(photo);
		if(this.resourceService.addResource(vo)) {
			ServletObjectUtil.getRequest().setAttribute("msg", "申请单添加成功！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"supply_details_list.action?spid="+spid+"\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "/eop/pages/back/admin/supply/supply_details_list.action?spid="+spid+"");
			return "/pages/plugins/forward.jsp" ; 
		}else {
			ServletObjectUtil.getRequest().setAttribute("msg", "申请单添加失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"supply_goods_add.jsp\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/supply/supply_goods_add.jsp\"");
			return "/pages/plugins/forward.jsp" ; 
		}
		
	}
	@RequestMapping("supply_details_list")
	public ModelAndView ResourceList(Long spid)throws Exception{
		ModelAndView mav = new ModelAndView("/pages/back/admin/supply/supply_details_list.jsp");
		Map<String, Object> map = this.resourceService.listBySup(spid);
		mav.addMap(map);
		return mav;
	}
	@RequestMapping("supply_apply_list")
	public ModelAndView supList() throws Exception{
//		ModelAndView mav = new ModelAndView("/pages/back/admin/supply/supply_apply_list.jsp");
		ModelAndView mav = new ModelAndView(super.getPage("list.page"));
		String columnData = "标题:title" ;
		SplitPageUtil spu = new SplitPageUtil(columnData,super.getPageKey("list.action"));
		Map<String, Object> map = this.supplypurchaseService.listSupByFindSplit(spu.getColumn(), spu.getKeyword(), spu.getCurrentPage(), spu.getLineSize());
//		System.out.println(map);
		mav.addMap(map);
		return mav;
		
	}
	@RequestMapping("supply_apply_add")
	public String add(Supplypurchase vo) throws Exception {
//		vo.setEid(super.getMid());
//		boolean flag=false;
//		flag=this.supplypurchaseService.addSup(vo);
//		System.out.println(flag);
//		super.print(flag);
		
		vo.setEid(super.getMid());
		if(this.supplypurchaseService.addSup(vo)) {
			ServletObjectUtil.getRequest().setAttribute("msg", "申请成功！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"supply_apply_list.action\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/supply/supply_apply_list.action");
			return "/pages/plugins/forward.jsp" ; 
		}else {
			ServletObjectUtil.getRequest().setAttribute("msg", "申请失败！");
			ServletObjectUtil.getRequest().setAttribute("url", "\"supply_apply_add.jsp\"");
			ServletObjectUtil.getRequest().setAttribute("urlClick", "\"/eop/pages/back/admin/supply/supply_apply_add.jsp\"");
			return "/pages/plugins/forward.jsp" ; 
		}
	}
}
