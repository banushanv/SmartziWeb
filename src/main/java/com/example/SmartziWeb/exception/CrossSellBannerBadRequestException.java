/**
 * 
 */
package com.example.SmartziWeb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author asel.meemeduma
 *
 */

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class CrossSellBannerBadRequestException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CrossSellBannerBadRequestException(String message) {
		super(message);
	}
	
	
	public CrossSellBannerBadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
