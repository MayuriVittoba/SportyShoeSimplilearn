package com.example.demo;

import javax.persistence.Id;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class OrderDetails {
	
	@Id
	private int orderId;
	private int prodId;

}
