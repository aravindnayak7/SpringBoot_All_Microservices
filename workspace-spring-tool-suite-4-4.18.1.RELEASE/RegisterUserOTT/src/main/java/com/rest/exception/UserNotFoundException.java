package com.rest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="User not found exception")
public class UserNotFoundException extends Exception{

}
