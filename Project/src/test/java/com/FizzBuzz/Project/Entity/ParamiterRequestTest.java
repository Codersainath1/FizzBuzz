package com.FizzBuzz.Project.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.FizzBuzz.Project.Entitys.ParamiterRequest;

public class ParamiterRequestTest {

    @Test
    public void testParamiterRequest() {
        // Arrange
        long id = 1;
        long int1 = 3;
        long int2 = 5;
        long limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";
        long count = 5;

        // Act
        ParamiterRequest paramiterRequest = new ParamiterRequest(int1, int2, limit, str1, str2, count);
        paramiterRequest.setId(id);

        // Assert
        assertEquals(id, paramiterRequest.getId());
        assertEquals(int1, paramiterRequest.getInt1());
        assertEquals(int2, paramiterRequest.getInt2());
        assertEquals(limit, paramiterRequest.getLimit());
        assertEquals(str1, paramiterRequest.getStr1());
        assertEquals(str2, paramiterRequest.getStr2());
        assertEquals(count, paramiterRequest.getCount());
    }

}
