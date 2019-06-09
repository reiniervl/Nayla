package com.rvlstudio.nayla.service.transferrable;

import java.util.Optional;

/**
 * ResultTO
 */
public abstract class ResultTO<T> {
	private Result result;
	private T payload;

	private ResultTO(Result result, T payload) {
		this.result = result;
		this.payload = payload;
	}

	public ResultTO(T payload) {
		this(Result.Success, payload);
	}

	public ResultTO(Result result) {
		this(result, null);
	}

	public ResultTO(ResultTO<T> resultTO) {
		assert !resultTO.isSuccessFul(): "Resultaat kan niet successvol zijn";
		this.result = resultTO.result;
		this.payload = resultTO.payload;
	}
	
	public boolean isSuccessFul() {
		return result == Result.Success;
	}

	public Result getResult() {
		return this.result;
	}

	public Optional<T> getPayload() {
		return Optional.ofNullable(payload);
	}
}