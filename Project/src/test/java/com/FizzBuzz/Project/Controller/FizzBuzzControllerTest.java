package com.FizzBuzz.Project.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.FizzBuzz.Project.Bean.RequestParamiter;
import com.FizzBuzz.Project.Services.FizzBuzzService;
import com.FizzBuzz.Project.Services.StatisticsService;

public class FizzBuzzControllerTest {

    @Mock
    private FizzBuzzService fizzBuzzService;

    @Mock
    private StatisticsService statisticsService;

    @InjectMocks
    private FizzBuzzController fizzBuzzController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFizzBuzz() {
        // Arrange
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        List<String> expectedResult = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "13", "14", "FizzBuzz");

        when(fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2)).thenReturn(expectedResult);

        // Act
        ResponseEntity<List<String>> responseEntity = fizzBuzzController.getFizzBuzz(int1, int2, limit, str1, str2);

        // Assert
        assertEquals(expectedResult, responseEntity.getBody());
        assertEquals(200, responseEntity.getStatusCodeValue());

        verify(fizzBuzzService, times(1)).generateFizzBuzz(int1, int2, limit, str1, str2);
    }

    @Test
    public void testGetStatistics() {
        // Arrange
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        RequestParamiter expectedRequestParamiter = new RequestParamiter(int1, int2, limit, str1, str2);

        when(statisticsService.getMostUsedRequest()).thenReturn(expectedRequestParamiter);

        // Act
        ResponseEntity<RequestParamiter> responseEntity = fizzBuzzController.getStatistics();

        // Assert
        assertEquals(expectedRequestParamiter, responseEntity.getBody());
        assertEquals(200, responseEntity.getStatusCodeValue());

        verify(statisticsService, times(1)).getMostUsedRequest();
    }
}
