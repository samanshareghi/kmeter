package com.omid.saman.kmeter;

public class PersonInfo {
	int phone, gate_num, total_purchase, tip, danger, nag, distance;
	String name, address, complex_name;

	public PersonInfo(int phone, int gate_num, int total_purchase, int tip,
			int danger, int nag, int distance, String name, String address,
			String complex_name) {
		
		this.phone = phone;
		this.gate_num = gate_num;
		this.total_purchase = total_purchase;
		this.tip = tip;
		this.danger = danger;
		this.nag = nag;
		this.distance = distance;
		this.name = name;
		this.address = address;
		this.complex_name = complex_name;
	}
}
