package com.FizzBuzz.Project.Services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FizzBuzz.Project.Entitys.ParamiterRequest;
import com.FizzBuzz.Project.Exception.BadRequestException;
import com.FizzBuzz.Project.Repository.ParamiterRequestRepository;

@Service
public class FizzBuzzService {

	Logger logger = LoggerFactory.getLogger(FizzBuzzService.class);

	@Autowired
	ParamiterRequestRepository repository;

	public List<String> generateFizzBuzz(int int1, int int2, int limit, String str1, String str2) {

		if (int1 == 0 || int2 == 0||str1==null||str2==null) {
			logger.error("invalid paramiter is Entered");
		throw new BadRequestException("Entered number is not a valid i.e int 1 or int 2 is null");

		}
		ParamiterRequest request = repository.findByInt1AndInt2(int1, int2);
		if (request == null) {
			request = new ParamiterRequest(int1, int2, limit, str1, str2, 1);
			repository.save(request);
		} else {
			request.setCount(request.getCount() + 1);
			repository.save(request);

		}
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= limit; i++) {
			if (i % (int1 * int2) == 0) {
				result.add(str1 + str2);
			} else if (i % int1 == 0) {
				result.add(str1);
			} else if (i % int2 == 0) {
				result.add(str2);
			} else {
				result.add(toString().valueOf(i));
			}
		}
		return result;

	}

}
