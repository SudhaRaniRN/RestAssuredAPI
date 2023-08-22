
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
   |program|1|
   |program|2|
   
   @tag2
   Scenario: Check if user able to create a program with valid endpoint and request body (existing values in Program Name)
   Given User creates POST Request for the LMS API with "<programName>"
   When User sends HTTPS Request and  request Body with mandatory , additional  fields.
   Then User receives 400 Bad Request Status with message and boolean success details
   
   @tag3
   Scenario: Check if user able to create a program missing mandatory fields in request body
   Given User creates POST Request for the LMS API endpoint
   When User sends HTTPS Request and  request Body with mandatory , additional  fields.
   Then User receives 400 Bad Request Status with message and boolean success details
