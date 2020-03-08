package com.batches.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompositeId implements Serializable{
	private Integer TAG_ID;
	private Integer TRG_ID;
}
