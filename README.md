This project impplements the token generation code. 

1) The JwtAuthenticationController.java has the /authenticate endpoint that generates the JWT token and returns to be used in the subsequent calls.

2) The JwtRequestFilter intercepts the requests and validates the token. If the token is valid then the token is set in the securityContextHolder so that the subsequent calls skip the token validation. 
