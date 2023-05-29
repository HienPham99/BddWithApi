#Author: your.email@your.domain.com

 @GetCanadianUser
Feature: Getting Canadian User Validation

  @HappyCase
  Scenario: Send a request with valid endpoint URL and method
    Given User has valid URL and Method
    When User sends a request
    Then Response is returned correctly
    