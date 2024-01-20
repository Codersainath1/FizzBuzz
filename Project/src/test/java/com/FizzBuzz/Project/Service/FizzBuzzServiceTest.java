package com.FizzBuzz.Project.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import com.FizzBuzz.Project.Entitys.ParamiterRequest;
import com.FizzBuzz.Project.Exception.BadRequestException;
import com.FizzBuzz.Project.Repository.ParamiterRequestRepository;
import com.FizzBuzz.Project.Services.FizzBuzzService;

public class FizzBuzzServiceTest {

    @Mock
    private Logger logger;

    @Mock
    private ParamiterRequestRepository repository;

    @InjectMocks
    private FizzBuzzService fizzBuzzService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateFizzBuzz() {
        // Arrange
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        ParamiterRequest mockRequest = new ParamiterRequest(int1, int2, limit, str1, str2, 1);

        when(repository.findByInt1AndInt2(int1, int2)).thenReturn(mockRequest);

        // Act
        List<String> result = fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);

        // Assert
        assertEquals(15, result.size());
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("Fizz", result.get(2));
        assertEquals("4", result.get(3));
        assertEquals("Buzz", result.get(4));
        assertEquals("Fizz", result.get(5));
        assertEquals("7", result.get(6));
        assertEquals("8", result.get(7));
        assertEquals("Fizz", result.get(8));
        assertEquals("Buzz", result.get(9));
        assertEquals("11", result.get(10));
        assertEquals("Fizz", result.get(11));
        assertEquals("13", result.get(12));
        assertEquals("14", result.get(13));
        assertEquals("FizzBuzz", result.get(14));

        verify(repository, times(1)).findByInt1AndInt2(int1, int2);
        verify(repository, times(1)).save(any(ParamiterRequest.class));
    }

    @Test
    public void testGenerateFizzBuzzWithInvalidNumbers() {
        // Arrange
        int int1 = 0;
        int int2 = 5;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2));
        assertEquals("Entered number is not a valid i.e int 1 or int 2 is null", exception.getMessage());

        verify(logger, times(1)).error("invalid paramiter is Entered");
        verify(repository, never()).findByInt1AndInt2(anyInt(), anyInt());
        verify(repository, never()).save(any(ParamiterRequest.class));
    }
 
    @Test
    public void testGenerateFizzBuzzWithInvalidNumbers2() {
        // Arrange
        int int1 = 5;
        int int2 = 0;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2));
        assertEquals("Entered number is not a valid i.e int 1 or int 2 is null", exception.getMessage());

        verify(logger, times(1)).error("invalid paramiter is Entered");
        verify(repository, never()).findByInt1AndInt2(anyInt(), anyInt());
        verify(repository, never()).save(any(ParamiterRequest.class));
    }
 
    @Test
    public void testGenerateFizzBuzzWithNullStrings() {
        // Arrange
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = null;
        String str2 = "Buzz";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2));
        assertEquals("Entered number is not a valid i.e int 1 or int 2 is null", exception.getMessage());

        verify(logger, times(1)).error("invalid paramiter is Entered");
        verify(repository, never()).findByInt1AndInt2(anyInt(), anyInt());
        verify(repository, never()).save(any(ParamiterRequest.class));
    }
    @Test
    public void testGenerateFizzBuzzWithNullStrings2() {
        // Arrange
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = null;
        String str2 = "Buzz";

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2));
        assertEquals("Entered number is not a valid i.e int 1 or int 2 is null", exception.getMessage());

        verify(logger, times(1)).error("invalid paramiter is Entered");
        verify(repository, never()).findByInt1AndInt2(anyInt(), anyInt());
        verify(repository, never()).save(any(ParamiterRequest.class));
    }
    
    @Test
    public void testGenerateFizzBuzz2() {
        // Arrange
        int int1 = 3;
        int int2 = 5;
        int limit = 15;
        String str1 = "Fizz";
        String str2 = "Buzz";

        // Simulate repository not finding ParamiterRequest
        when(repository.findByInt1AndInt2(int1, int2)).thenReturn(null);

        // Act
        fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);

        // Assert
        verify(repository, times(1)).findByInt1AndInt2(int1, int2);
        verify(repository, times(1)).save(any(ParamiterRequest.class));
    }

   

}
