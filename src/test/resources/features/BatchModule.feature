
@tag
Feature: Batch Module
  I want to use this template for my feature file
  
  
  Background:
  Given User sets Authoization to No  Auth.
   
    @tag1
  Scenario Outline: Check if user able to create a program with valid endpoint and request body (non existing values)
    Given User creates POST Request "<Sheetname>" and <rownumber> for the LMS batch api endpoints
    When User sends HTTPS Request and  request Body with mandatory , additional  fields.
    Then User receives 201 Created Status with response body.
    Examples:
   |Sheetname|rownumber|
   |program|0|
   
  

  @tag1
  Scenario Outline: Check if user able to create a Batch with valid endpoint and request body (non existing values)
  Given User creates POST Request "<Sheetname>" and <rownumber> for the LMS API batch endpoint with mandatory field.
  When User sends HTTPS Request and  request Body with mandatory , additional  fields
  Then User receives 201 Created Status with response body.
  
  Examples:
   |Sheetname|rownumber|
      |batch|0|
   |batch|1|
