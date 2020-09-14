package com.sapient;
//Jai Mahajan
public class transact {
private String tran_id=null;
private String clientid=null;
private String securityid=null;
private String type=null;
private String date=null;
private Double value=0.0;
private String flag=null;
private Double fees=0.0;
private String intraday=null;
	
	public transact(String tran_id,String clientid,String securityid,String type,String date,Double value,String flag) {
		// TODO Auto-generated constructor stub
		this.clientid=clientid;
		this.securityid=securityid;
		this.type=type;
		this.date=date;
		this.value=value;
		this.flag=flag;

	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getSecurityid() {
		return securityid;
	}

	public void setSecurityid(String securityid) {
		this.securityid = securityid;
	}

	public String getType() {
		return type;
	}
	public String getIntraday() {
		return intraday;
	}

	public void setIntraday(String intraday) {
		this.intraday = intraday;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
