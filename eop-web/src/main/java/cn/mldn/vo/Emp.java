package cn.mldn.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Emp implements Serializable {
	private String eid; // 雇员ID
	private Integer lid; // 雇员职位ID（关联level表）
	private Long did; // 雇员的部门ID（关联dept表）
	private String ename; // 雇员姓名
	private Double salary; // 雇员工资
	private String phone; // 雇员手机号码
	private String password; // 雇员登录密码
	private String photo; // 雇员照片
	private String note; // 雇员备注
	private Date hiredate; // 雇员入职日期
	private String ineid; // 修改 该雇员信息的 人事ID
	private Integer status; // 雇员状态（ 0-正常； 1-已被锁定； 2-信息已被逻辑删除； 3-是离职雇员 ）

	public Emp() {
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getIneid() {
		return ineid;
	}

	public void setIneid(String ineid) {
		this.ineid = ineid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Emp [eid=" + eid + ", lid=" + lid + ", did=" + did + ", ename=" + ename + ", salary=" + salary
				+ ", phone=" + phone + ", password=" + password + ", photo=" + photo + ", note=" + note + ", hiredate="
				+ hiredate + ", ineid=" + ineid + ", status=" + status + "]";
	}

}
