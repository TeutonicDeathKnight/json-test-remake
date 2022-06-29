package net.yorksolutions.jsontestremake;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.Map;

public class Headers {

	Map<String, String> headers(@RequestHeader Map<String, String> headers) {
		// RestTemplate will assume that the response is JSON formatted, and will try to parse
		//     the json string into the java object that we specify
		 return headers;
	}

}
