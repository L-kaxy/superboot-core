package com.wteam.superboot.core.exception;

import com.wteam.superboot.core.enums.Resultinfo;

public class SuperException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Resultinfo result;

	public SuperException(Resultinfo result) {
		super(result.getResultInfo());
		this.result = result;
	}

	public Resultinfo getResult() {
		return result;
	}

	public void setResult(Resultinfo result) {
		this.result = result;
	}

}
