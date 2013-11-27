package com.codeholic.pojos.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 数据字典 实体
 * @author ltc
 *
 */
@Entity
@Table(name="DICTIONARY")
@NamedQueries({
	
	@NamedQuery(name = "dict.readLabelsByFieldCode", query = "select d from Dict d where d.field_code=:field_code order by d.order_no"),
	@NamedQuery(name = "dict.readLabel", query = "select d.label from Dict d where d.field_code = :field_code and d.decode = :decode"),
	@NamedQuery(name = "dict.readAllField", query = "select distinct d.field_code, d.field_name from Dict d"),
	@NamedQuery(name = "dict.readLabelsByFieldName", query = "select d from Dict d where d.field_name=:field_name order by d.order_no")
})
public class Dict extends EntityObject implements Serializable{

	private static final long serialVersionUID = -4032781125051522098L;
	
	@Id
	@Column(name="DICT_ID")
	private String dictId;
	
	@Column(name="FIELD_CODE")
	private String field_code;
	
	@Column(name="FIELD_NAME")
	private String field_name;
	
	@Column(name="LABEL")
	private String label;
	
	@Column(name="CODE")
	private int decode;
	
	@Column(name="ORDER_NO")
	private int order_no;
	
	public String getDictId() {
		return dictId;
	}
	
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	
	public String getField_code() {
		return field_code;
	}
	
	public void setField_code(String field_code) {
		this.field_code = field_code;
	}
	
	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getDecode() {
		return decode;
	}

	public void setDecode(int decode) {
		this.decode = decode;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	
}
