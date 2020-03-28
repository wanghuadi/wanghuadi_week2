package com.wanghuadi.beans;

import java.math.BigInteger;
import java.util.Date;

public class Inspection {
	private BigInteger  id;// int primary key auto_increment,
	private String keyword;// VARCHAR(50),
	private String mes;// VARCHAR(200),
	private String name;// VARCHAR(50),
	private String product;// VARCHAR(255),
	private String address;// VARCHAR(255),
	private Double capital;//	double,
	private Date idate;// date,
	private Date inspection_time;// date,
	private Status status;// VARCHAR(50),
	private String remark;// VARCHAR(255)
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getCapital() {
		return capital;
	}
	public void setCapital(Double capital) {
		this.capital = capital;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public Date getInspection_time() {
		return inspection_time;
	}
	public void setInspection_time(Date inspection_time) {
		this.inspection_time = inspection_time;
	}
	public Status getStatus() {
		return status;
	}
	/*public void setStatus(Status status) {
		this.status = status;
	}*/
	public void setStatus(String status) {
		this.status = status.equals("待审核")?Status.WAIT:status.equals("通过")?Status.SUCCESS:Status.NOTSUCCESS;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Inspection(BigInteger id, String keyword, String mes, String name, String product, String address,
			Double capital, Date idate, Date inspection_time, Status status, String remark) {
		super();
		this.id = id;
		this.keyword = keyword;
		this.mes = mes;
		this.name = name;
		this.product = product;
		this.address = address;
		this.capital = capital;
		this.idate = idate;
		this.inspection_time = inspection_time;
		this.status = status;
		this.remark = remark;
	}
	public Inspection() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Inspection [id=" + id + ", keyword=" + keyword + ", mes=" + mes + ", name=" + name + ", product="
				+ product + ", address=" + address + ", capital=" + capital + ", idate=" + idate + ", inspection_time="
				+ inspection_time + ", status=" + status + ", remark=" + remark + "]";
	}
	
	
}
