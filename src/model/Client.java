package model;

import java.io.Serializable;

public class Client implements Serializable{
	private int id;
	private String name;
	private String code;
	private int depositamount;
	
	public Client() {
		super();
	}
	
	public Client(int id,String name, String code, int depositamount) {
		super();
                this.id=id;
		this.name = name;
		this.code = code;
		this.depositamount = depositamount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDepositamount() {
		return depositamount;
	}

	public void setDepositamount(int depositamount) {
		this.depositamount = depositamount;
	}
	
	
}
