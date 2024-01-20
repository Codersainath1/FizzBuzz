package com.FizzBuzz.Project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FizzBuzz.Project.Bean.RequestParamiter;
import com.FizzBuzz.Project.Entitys.ParamiterRequest;
import com.FizzBuzz.Project.Repository.ParamiterRequestRepository;


@Service
public class StatisticsService {

	@Autowired 
	ParamiterRequestRepository repository;
	
	
	public RequestParamiter getMostUsedRequest() {
		RequestParamiter paramiter = null;
ParamiterRequest paramiterRequest = repository.findMostCalled();
		
		if (!paramiterRequest.equals(null)) {
			paramiter = new RequestParamiter();
			paramiter.setInt1(paramiterRequest.getInt1());
			paramiter.setInt2(paramiterRequest.getInt2());
			paramiter.setLimit(paramiterRequest.getLimit());
			paramiter.setStr1(paramiterRequest.getStr1());
			paramiter.setStr2(paramiterRequest.getStr2());
			paramiter.setCount(paramiterRequest.getCount());
		}
		return paramiter;
	}
}
