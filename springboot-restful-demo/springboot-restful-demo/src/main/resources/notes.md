#what is dispatcher servlet?
-it is responsible for routing the requests based on the url provided.
#who is configuring dispatcher servlet?
-Spring boot auto configuration
#what does dispatcher servlet do?
-dispatcher servlet find the right method and send the response body back(@RestController uses both controller and response body) and the response sent back is converted to json using jackson.
#How does beans/objects get converted to json?
-Spring boot auto configuration, coz of message converters and jackson beans are intiliazed
#who is configuring the error mapping?
-Spring boot auto configuration, it creates a default error page for us.


Servlet dispatcherServlet mapped to [/]
Mapped "{[/helloworld],methods=[GET]}" onto public java.lang.String com.webservices.restful.springbootrestfuldemo.HelloWorldController.helloWorld()
Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.error(javax.servlet.http.HttpServletRequest)

When using a Post method, best practice is to send a 201 created response instead of 200. For this we can return ResponseEntity.created and the uri can be sent as response by building uri from ServletUriComponentsBuilder.