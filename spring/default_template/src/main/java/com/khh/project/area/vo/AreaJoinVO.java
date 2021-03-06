package com.khh.project.area.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;
import com.khh.DefaultVO;

@Entity
@Table(name="TB_AREA")
public class AreaJoinVO extends DefaultVO {
	private static final long serialVersionUID = 7772635232307168982L;

	@NotNull
	@Expose @Id @Column(name="AREA_ID")	Integer area_id	;//지역ID	NUMBER 
	@Expose @Column(name="AREA1")	String area1	;//시도	VARCHAR2
	@Expose @Column(name="AREA2")	String area2	;//시구군	VARCHAR2
	@Expose @Column(name="AREA3")	String area3	;//동	VARCHAR2
	@Expose @Column(name="ORDER_ID1")	Integer order_id1	;// VARCHAR2
	@Expose @Column(name="ORDER_ID2")	Integer order_id2	;// VARCHAR2
 
	@Expose
	@OneToMany(fetch=FetchType.LAZY) //즉시로딩
	@JoinColumn(name="AREA_ID", nullable=false, insertable=false, updatable=false)
	List<AreaVVO> map = new ArrayList<AreaVVO>();

	@Expose
	@OneToMany(fetch=FetchType.LAZY) //즉시로딩
	@JoinColumn(name="AREA_ID", nullable=false, insertable=false, updatable=false)
	List<AreaBaseVO> base = new ArrayList<AreaBaseVO>();
	
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public String getArea1() {
		return area1;
	}
	public void setArea1(String area1) {
		this.area1 = area1;
	}
	public String getArea2() {
		return area2;
	}
	public void setArea2(String area2) {
		this.area2 = area2;
	}
	public String getArea3() {
		return area3;
	}
	public void setArea3(String area3) {
		this.area3 = area3;
	}
	public Integer getOrder_id1() {
		return order_id1;
	}
	public void setOrder_id1(Integer order_id1) {
		this.order_id1 = order_id1;
	}
	public Integer getOrder_id2() {
		return order_id2;
	}
	public void setOrder_id2(Integer order_id2) {
		this.order_id2 = order_id2;
	}
	
	
}
