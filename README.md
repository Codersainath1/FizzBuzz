# Fizzbuzz REST API

  This is the simple server which produces the FizzBuzz Sequence till the provided limit:

## Stack

- java 17
- spring boot 3.0.5 / maven
- junit
- Rest API
  
## API

 
This is Produces the Sequence
- /v1/fizzbuzz:

This is used to get most called request
- /v1/fizzbuzz/statistic:      

> The project embarks the `springdoc-openapi-ui` dependency, so a swagger page is reachable at this page `http://localhost:8080/swagger-ui.html`.

## Install & run

Import the maven project in any IDE you like and build the project and run it

## For Testing 
following are the curls

>'localhost:8080/v1/fizzbuzz?int1=2&int2=8&limit=16&str1=fizz&str2=buzz'
>
>
>'localhost:8080/v1/fizzbuzz/statistics'
