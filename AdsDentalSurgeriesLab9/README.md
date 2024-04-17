# Documentation page for security API
http://localhost:8080/swagger-ui.html

# Documentation page for ADS Dental Surgeries API
http://localhost:8081/swagger-ui.html

# I implemented temporary an in-memory process with the following dummy data - update underway
username    | password | role
admin       | 1234     | ADMIN
patient     | 1234     | PATIENT
dentist     | 1234     | DENTIST

# At the moment, only the following endpoint is secured 
# http://localhost:8080/adsweb/api/v1/patient/list
# Only the admin can display the list of patient

#### PROCESS TO ACCESS AN ENDPOINT (check the docs folder to get Postman's usage)
Generate the jwt token from http://localhist:8081/token
    parameters: 
        - username (string)
        - password (string)
        - withRefreshToken (boolean)    # allows to generate besides the jwt token, a refresh token
        - grantType (string)            # password/refreshToken

-	Only  users with “ADMIN” role can display a list of patients  http://localhost:8080/adsweb/api/v1/patient/list
-	Only users with role “ADMIN” and/or  “DENTIST” can display a patient details http://localhost:8080/adsweb/api/v1/patient/get/{patientId}
-	Only users with “USER” role can access http://localhost:8080/adsweb/api/v1/patient/register
-	Only users with “USER” and/or “ADMIN” can update patient’s details http://localhost:8080/adsweb/api/v1/patient/update/{patientId}
-	Only users with “ADMIN” role can delete a patient http://localhost:8080/adsweb/api/v1/delete/{patientId} 
