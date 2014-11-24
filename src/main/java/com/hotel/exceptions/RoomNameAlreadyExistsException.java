package com.hotel.exceptions;

public class RoomNameAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RoomNameAlreadyExistsException(String message) {
		super(message);
	}

}
