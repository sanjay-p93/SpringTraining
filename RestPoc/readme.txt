Sample Application with REST endpoints for arithmetic operations

POST methods - takes two parameters {"a":x,"b":y} and returns the result of operation
"http://localhost:8080/math/add"
"http://localhost:8080/math/sub"
"http://localhost:8080/math/mul"
"http://localhost:8080/math/div"

GET method - retune the square root of number provided as the request parameter
http://localhost:8080/math/sqrt/{number}

Application also demonstrate RestTemplate used consume RESTful Web Services, The RestTemplate is used to retrieve result from the URI provided.
Sample : "http://localhost:8080/restTemplate/add"
