package cn.mldn.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Reimbursement_details implements Serializable{
	private Long rbdid;
	private Long rbsid;
	private Double money;
	private String note;
	public Long getRbdid() {
		return rbdid;
	}
	public void setRbdid(Long rbdid) {
		this.rbdid = rbdid;
	}
	public Long getRbsid() {
		return rbsid;
	}
	public void setRbsid(Long rbsid) {
		this.rbsid = rbsid;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
