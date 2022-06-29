package net.yorksolutions.jsontestremake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controller {

	final CacheRepository repository;

	@Autowired
	Controller(CacheRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/md5")
	@CrossOrigin
	HashMap<String, String> md5(@RequestParam(name = "text") String text) {

		Optional<Cache> result = repository.findByMd5Input(text);
		HashMap<String, String> md5Output = new HashMap<>();

		if (result.isPresent()) {
			md5Output.put("md5", result.get().md5Output);
		}

		MD5 output = new MD5(text);
		md5Output.put("md5", output.md5);
		Cache cache = new Cache();
		cache.md5Input = text;
		cache.md5Output = output.md5;
		repository.save(cache);

		return md5Output;
	}

	@GetMapping("/datetime")
	@CrossOrigin
	DateTime dateTime() {
		Date current_date = new Date();
		return new DateTime(current_date);
	}

	@GetMapping("/ip")
	@CrossOrigin
	IP ip(HttpServletRequest request) {
		return new IP(request.getRemoteAddr());
	}

	@GetMapping("/headers")
	@CrossOrigin
	Map<String, String> headers(@RequestHeader Map<String, String> headers) {
		return headers;
	}

}
