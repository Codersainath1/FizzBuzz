package com.FizzBuzz.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FizzBuzz.Project.Entitys.ParamiterRequest;

@Repository
public interface ParamiterRequestRepository extends JpaRepository<ParamiterRequest, Long> {

	public ParamiterRequest findByInt1AndInt2(int int1, int int2);
	
	@Query(nativeQuery = true, value = "select * from paramiter_request  where count=(Select max(count) from paramiter_request)")
	public ParamiterRequest findMostCalled();
}
