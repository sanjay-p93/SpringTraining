Sample spring Application with SOAP web services for retrieving student details

http://localhost:8080/ws/students.wsdl
Can be used  to retrieve the WSDL for the application


Sample request - pricing the name will give response with student details

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:soap="http://spring.com/soap-service">
   <soapenv:Header/>
   <soapenv:Body>
      <soap:getStudentRequest>
         <soap:name>Lisa</soap:name>
      </soap:getStudentRequest>
   </soapenv:Body>
</soapenv:Envelope>