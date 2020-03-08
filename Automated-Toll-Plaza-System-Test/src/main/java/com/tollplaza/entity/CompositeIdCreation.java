package com.tollplaza.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class CompositeIdCreation implements Serializable{
	private Integer TAG_MASTER_ID;
	private Integer TAG_ID;
}
