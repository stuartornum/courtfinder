   
Feature: As a user I need to be able to make a postcode and area of law search 
         so that it will give a list of the closest court/tribunals 
         regardless of jurisdiction

        
Scenario Outline: Entering a valid postcode and area of law returns expected courts

          Given I am on the courtfinder search page
          When I enter a postcode "<postcode>" and area of law "<law>"
          Then I am returned the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                                     |
          |SW1H9AJ |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |SW1H9AJ |Children         |Central Family Court                                       |
          |SW1H9AJ |Civil partnership|Central Family Court,Brighton Family Court                 |
          |CA488RT |Bankruptcy       |Aberystwyth Justice Centre                                 |

        
Scenario Outline: Entering an Northern Ireland postcode and area of law will return an error 

          Given I am on the courtfinder search page
          When I enter a Northern Ireland postcode "<postcode>" and area of law "<law>"
          Then I am returned an error message that Northern Ireland is not supported
          
         Examples:
         |postcode|law               | 
         |BT1     |Adoption          |
         |BT60    |Children          |
         |BT18    |Civil partnership |
         |BT74    |Divorce           |
         |BT45    |Bankruptcy        |
         |BT68    |Housing possession|
         |BT55    |Money claims      |
         |BT21    |Probate           |
         |BT9     |Crime             |
         |BT21    |Domestic violence |
         |BT56    |Forced marriage   |
         |BT6     |Employment        |
         |BT33    |Social security   |
         |BT44    |High court        |
         |BT      |All law           |


Scenario Outline: Entering a valid Northern Ireland postcode and Immigration
                  returns expected courts

          Given I am on the courtfinder search page
          When I enter a postcode "<postcode>" and area of law "<law>"
          Then I am returned the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                           |
          |BT21|Immigration          |Glasgow Tribunal Hearing Centre (Eagle Building) |

         
Scenario: The search button is disabled until a postcode is entered

          Given I am on the courtfinder search page
          And the search button is disabled
          When I enter a postcode
          Then  the search button is enabled


Scenario: Entering a postcode only and searching will prompt an error to enter an area of law

          Given I am on the courtfinder search page
          And the search button is disabled
          When I enter a postcode
          And then select search
          Then I am prompted that an area of law must be entered 

        
Scenario Outline: postcode search is not case sensitive 

          Given I am on the courtfinder search page
          When I enter a postcode "<postcode>" and area of law "<law>"
          Then I am returned the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                                     |
          |SW1H9AJ  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |sw1h9aj  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |Sw1H9Aj  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |SW1H 9AJ |Adoption         |Inner London Family Proceedings Court,Central Family Court |


Scenario Outline: Each search result should have a link to view details    

          Given I am on the courtfinder search page
          When I enter a postcode "<postcode>" and area of law "<law>"
          And select view details for "<court>"
          Then I am redirected to the "<court>" details page
          
          Examples:
          |postcode|law              |court                                            |
          |SW1H9AJ  |Adoption        |Inner London Family Proceedings Court            |
          |BT21|Immigration          |Glasgow Tribunal Hearing Centre (Eagle Building) |

          
Scenario Outline: The number of results found for a postcode search should be displayed   

          Given I am on the courtfinder search page
          When I enter a postcode "<postcode>" and area of law "<law>"
          Then the total number of results <result> should be displayed
          
          Examples:
          |postcode |law              |result|
          |SW1H9AJ  |Adoption         |2     |
          |BT21     |Immigration      |4     |

         
Scenario Outline: The number of results found for a postcode search should be displayed   

          Given I am on the courtfinder search page
          When I enter an invalid postcode "<postcode>" with an area of law "<law>"
          Then I am prompted that the postcode could not be found
          
          Examples:
          |postcode            |law              |
          |CD2                 |Crime            |
          |CX3                 |All law          |
          
@needsclarifying         
Scenario Outline: Enter the exact postcode for the court or tribunal and its detail page is displayed  

          Given I am on the courtfinder search page
          When I enter an exact postcode "<postcode>" and area of law "<law>"
          Then I am redirected to the "<CourtOrTribunal>" details page
          
          Examples:
          |postcode |law              |CourtOrTribunal                                   |
          |SE1 6AZ  |Crime            |Inner London Crown Court                          |
                  
                              