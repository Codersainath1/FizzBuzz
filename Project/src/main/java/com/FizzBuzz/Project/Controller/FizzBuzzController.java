package com.FizzBuzz.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FizzBuzz.Project.Bean.RequestParamiter;
import com.FizzBuzz.Project.Services.FizzBuzzService;
import com.FizzBuzz.Project.Services.StatisticsService;

@RestController
public class FizzBuzzController {

	@Autowired
	FizzBuzzService fizzBuzzService;

	@Autowired
	StatisticsService statisticsService;

	@GetMapping("/v1/fizzbuzz")
	public ResponseEntity<List<String>> getFizzBuzz(@RequestParam int int1, @RequestParam int int2,
			@RequestParam int limit, @RequestParam String str1, @RequestParam String str2) {
		
		RequestParamiter reuest = new RequestParamiter(int1, int2, limit, str1, str2);

		List<String> result = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);

		return ResponseEntity.ok(result);

	}
	
	@GetMapping("/v1/fizzbuzz/statistics")
    public ResponseEntity<RequestParamiter> getStatistics() {
		RequestParamiter mostUsedRequest = statisticsService.getMostUsedRequest();
        return ResponseEntity.ok(mostUsedRequest);
    }
	
}
