package com.omid.saman.kmeter;

public class PersonInfo {
	int danger, nag;
	float total_purchase, tip, distance;
	String phone, zone, name, address, complex_name, gate_num;

	public PersonInfo(String phone, String zone, String gate_num, float total_purchase, float tip,
			int danger, int nag, float distance, String name, String address,
			String complex_name) {
		
		this.phone = phone;
		this.zone = zone;
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
