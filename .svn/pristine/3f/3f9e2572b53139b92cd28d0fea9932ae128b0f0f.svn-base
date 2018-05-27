package cn.mldn.action;

import cn.mldn.service.IEmpEducationService;
import cn.mldn.util.web.action.AbstractAction;
import cn.mldn.util.web.annotation.Autowired;
import cn.mldn.util.web.annotation.Controller;
import cn.mldn.util.web.annotation.RequestMapping;
import cn.mldn.util.web.servlet.ModelAndView;
import cn.mldn.vo.EmpEducation;

@Controller
@RequestMapping("/pages/back/admin/emp_education/*")
public class EmpEducationAction extends AbstractAction {
	@Autowired
	private IEmpEducationService empEducationService;
	@RequestMapping("emp_education_add")
	public ModelAndView add(EmpEducation vo) {
		ModelAndView mv=new ModelAndView("pages/back/admin/emp_education/emp_education_list.action");
		try {
			this.empEducationService.add(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
}
