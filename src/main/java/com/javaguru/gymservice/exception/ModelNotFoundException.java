package com.javaguru.gymservice.exception;

import lombok.Data;

/**
 * @author: adewaleijalana
 * @email: adewaleijalana@gmail.com
 * @date: 11/25/23
 **/


@Data
public class ModelNotFoundException extends RuntimeException {

	private String className;
	private String argumentSupplied;
	private String errorCode;

	public ModelNotFoundException(String className, String argumentSupplied, String errorCode) {
		super(argumentSupplied);
		this.className = className;
		this.argumentSupplied = argumentSupplied;
		this.errorCode= errorCode;
	}


	public ModelNotFoundException(String className, String argumentSupplied) {
		super(argumentSupplied);
		this.className = className;
		this.argumentSupplied = argumentSupplied;
	}


	public ModelNotFoundException(String argumentSupplied) {
		super(argumentSupplied);
		this.argumentSupplied = argumentSupplied;
	}

}


