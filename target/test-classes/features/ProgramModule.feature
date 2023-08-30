
@tag
Feature: Post request
  I want to use this template for my feature file
  
  Background: 
  Given User sets Authoization to No  Auth.
  

  @tag1
  Scenario Outline: Check if user able to create a program with valid endpoint and request body (non existing values)
    Given User creates POST Request "<Sheetname>" and <rownumber> for the LMS API endpoint
    When User sends HTTPS Request and  request Body with mandatory , additional  fields.
    Then User receives 201 Created Status with response body.
    Examples:
   |Sheetname|rownumber|
   |program|0|
   |program|1|
   
   @tag2
   Scenario: Check if user able to create a program with valid endpoint and request body (existing values in Program Name)
   Given User creates POST Request for the LMS API with "<programName>"
   When User sends HTTPS Request and  request Body with mandatory , additional  fields with existing values.
   Then User receives 400 Bad Request Status with message and boolean success details
   
   @tag3
   Scenario Outline: Check if user able to create a program missing mandatory fields in request body
   Given User creates POST Request "<Sheetname>" and <rownumber> for the LMS API endpoint with missing field.
   When User sends HTTPS Request and  request Body with mandatory , additional  fields with missing data.
   Then User receives 500 Bad Request2 Status with message and boolean success details
   
    Examples:
   |Sheetname|rownumber|
   |program|0| 
   
   
   @tag4
   Scenario: Check if user able to retrieve all programs with valid LMS API
   Given User creates GET Request for the LMS API endpoint
   When User sends HTTPS Request 
   Then User receives 200 OK Status with response body.
   
   @tag5
   Scenario: Check if user able to retrieve a program with valid program ID and LMS API
   Given User creates GET Request with valid <programId> for the LMS API endpoint
   When User sends HTTPS Request 
   Then User receives 200 OK Status with response body.
   
   @tag6
   Scenario: Check if user able to retrieve a program with invalid valid program ID and LMS API
   Given User creates GET Request with invalid <programId> for the LMS API endpoint
   When User sends HTTPS Request 
   Then User receives 404 Not Found Status with message and boolean success details
   
   @tag7
   Scenario: Check if user able to update a program with valid programID and mandatory request body
   Given User creates PUT Request for the LMS API endpoint  and Valid programID
   When User sends HTTPS Request 
   Then  User receives 200 OK Status with response body.
   
   @tag8
   Scenario: Check if user able to update a program with invalid programID and mandatory request body
   Given User creates PUT Request for the LMS API endpoint  and inValid programID
   When User sends HTTPS Request 
   Then  User receives 404 Not Found Status with message and boolean success details
   
   @tag9
   Scenario: Check if user able to update a program  missing mandatory fields in request body
   Given User creates PUT Request for the LMS API endpoint  and Valid programID with mising fields
   When User sends HTTPS Request 
   Then  User receives 500 Bad Request2 Status with message and boolean success details
   
   @tag10
   Scenario: Check if user able to update a program with  Valid program Name and request body
   Given User creates PUT Request for the LMS API endpoint  and Valid program Name
   When User sends HTTPS Request 
   Then User receives 200 OK Status with response body.
   
   @tag11
   Scenario: Check if user able to update a program with  invalid program Name and request body
   Given User creates PUT Request for the LMS API endpoint  and inValid program Name
   When User sends HTTPS Request 
   Then User receives 404 Not Found Status with message and boolean success details
   
   @tag12
   Scenario: Check if user able to update a program using valid program name - missing mandatory fields in request body 
   Given User creates PUT Request for the LMS API endpoint  and  Valid program Name  and missing field
   When User sends HTTPS Request 
   Then User receives 500 Bad Request2 Status with message and boolean success details
   
   @tag13
   Scenario: Check if user able to delete a program with valid programName
   Given User creates DELETE Request for the LMS API endpoint  and  valid programName
   When User sends HTTPS Request
   Then User receives 200 Ok status with message
   
   @tag14
   Scenario: Check if user able to delete a program with valid LMS API,invalid programName
   Given User creates DELETE Request for the LMS API endpoint  and  invalid programName
   When User sends HTTPS Request
   Then User receives 404 Not Found Status with message and boolean success details
   
   @tag15
   Scenario: Check if user able to delete a program with valid program ID
   Given User creates DELETE Request for the LMS API endpoint  and  valid program ID
   When User sends HTTPS Request
   Then User receives 200 Ok status with message
   
   @tag16
   Scenario: Check if user able to delete a program with valid LMS API,invalid program ID
   Given User creates DELETE Request for the LMS API endpoint  and  invalid program ID
    When User sends HTTPS Request
   Then User receives 404 Not Found Status with message and boolean success details
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   