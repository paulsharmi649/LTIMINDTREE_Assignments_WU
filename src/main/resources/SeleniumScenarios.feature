Feature: Operations on National Stock exchange of India Limited

  @WebTableReadSaveInHashmap
  Scenario: Read data from Web Table from URL https://www.nseindia.com/ and store SYMBOL and LTP value in hashmap
    Given user navigates to the website nseindia.com
    When user stores SYMBOL and LTP value in hashmap
    Then hashmap values are printed in console

    @RetrieveALLLinks
    Scenario: Retrieve all links avaialble on URL  https://www.nseindia.com/ using Functional Programming concept of Java
      Given user navigates to the website nseindia.com
      When user retrieves all links using  For each loop
      When user retrieves all links using  Stream
      When user retrieves all links using Parallel Stream
      When user retrieves all links using  Lambda expression




