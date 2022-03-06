package com.example.demo;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Orders {

	@Id
	private int orderId;
	private int userId;
	private String orderDate;
	private String orderCode;
	private String userName;
	private int prodId;
	private String prodName;
}
