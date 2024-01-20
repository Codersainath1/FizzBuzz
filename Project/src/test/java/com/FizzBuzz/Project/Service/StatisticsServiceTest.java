package com.FizzBuzz.Project.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.FizzBuzz.Project.Bean.RequestParamiter;
import com.FizzBuzz.Project.Entitys.ParamiterRequest;
import com.FizzBuzz.Project.Repository.ParamiterRequestRepository;
import com.FizzBuzz.Project.Services.StatisticsService;

public class StatisticsServiceTest {

    @Mock
    private ParamiterRequestRepository repository;

    @InjectMocks
    private StatisticsService statisticsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMostUsedRequest() {
        // Arrange
        ParamiterRequest mockParamiterRequest = new ParamiterRequest(3, 5, 15, "Fizz", "Buzz", 5);

        when(repository.findMostCalled()).thenReturn(mockParamiterRequest);

        // Act
        RequestParamiter result = statisticsService.getMostUsedRequest();

        // Assert
        assertNotNull(result);
        assertEquals(3, result.getInt1());
        assertEquals(5, result.getInt2());
        assertEquals(15, result.getLimit());
        assertEquals("Fizz", result.getStr1());
        assertEquals("Buzz", result.getStr2());
        assertEquals(5, result.getCount());

        verify(repository, times(1)).findMostCalled();
    }

   
}
