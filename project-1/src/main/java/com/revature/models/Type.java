package com.revature.models;

import java.io.Serializable;

public class Type implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int typeId;
	private String type;
	
	
	public Type() {
		super();
	}


	public Type(int typeId, String type) {
		super();
		this.typeId = typeId;
		this.type = type;
	}


	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + typeId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", type=" + type + "]";
	}
	
	
	

}
