@todo
Feature: As a user I need to be able to make a postcode and area of law search 
         so that it will give a list of the closest court/tribunals 


Scenario: No postcode entered and user requests search prompts error


          Given I am on the courtfinder postcode search page
          When I select continue
          Then I am prompted to enter a postcode
          
        
Scenario Outline: Entering a valid postcode and area of law returns expected courts

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                                     |
          |SW1H9AJ |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |SW1H9AJ |Children         |Central Family Court                                       |
          |SW1H9AJ |Civil partnership|Central Family Court,Brighton Family Court                 |
#          |CA488RT |Bankruptcy       |Aberystwyth Justice Centre                                 |
                   

      
Scenario Outline: Entering an Northern Ireland postcode and area of law will return an error 

          Given I am on the courtfinder postcode search page
          When I enter a Northern Ireland postcode "<postcode>" and area of law "<law>" and select continue
#          Then I am returned an error message that Northern Ireland is not supported except for immigration
          
 #          "Aside from immigration tribunals, 
 #           this tool does not return results for Northern Ireland. 
 #           Other courts and tribunals in Northern Ireland are handled 
 #           by the Northern Ireland Courts and Tribunals Service."
          
          
         Examples:
         |postcode|law                     |   
         |BT1     |Adoption                |
         |BT60    |Children                |
         |BT18    |Civil partnership       |
         |BT74    |Divorce                 |
         |BT45    |Bankruptcy              |
         |BT68    |Housing possession      |
         |BT55    |Money claims            |
         |BT21    |Probate                 |
         |BT9     |Crime                   |
         |BT21    |Domestic violence       |
         |BT56    |Forced marriage         |
         |BT6     |Employment              |
         |BT33    |Social security         |
 #        |BT44    |High court              |
         |BT      |All courts and tribunals|

 
Scenario Outline: Entering a valid Northern Ireland postcode and Immigration
                  returns expected courts

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                         |
          |BT21|Immigration          |Glasgow Tribunal Hearing Centre|

                
Scenario Outline: postcode search is not case sensitive 

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am redirected to the postcode results displaying the closest "<courts>"
          
          Examples:
          |postcode|law              |courts                                                     |
          |SW1H9AJ  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |sw1h9aj  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |Sw1H9Aj  |Adoption         |Inner London Family Proceedings Court,Central Family Court |
          |SW1H 9AJ |Adoption         |Inner London Family Proceedings Court,Central Family Court |



Scenario Outline: Each court name should be a link to the respective court detail page  

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          And select the "<court>" link in the postcode search results
          Then I am redirected to the selected "<court>" details page
          
          Examples:
          |postcode|law              |court                                            |
          |SW1H9AJ  |Adoption        |Inner London Family Proceedings Court            |
          |BT21     |Immigration     |Glasgow Tribunal Hearing Centre                  |


Scenario Outline: Each court result should show the dx and court number  

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then for the "<court>" the "<dx>" and "<courtnumber>" are displayed
          
          Examples:
          |postcode|law                              |court                                            |dx|courtnumber|
          |BB2 1AA  |All courts and tribunals        |Accrington Magistrates' Court                    |742020 Blackburn 10|1725|
 


Scenario Outline: Each court result should show the postal address 

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then for the "<court>" the "<postaladdress>" is displayed
          
          Examples:
          |postcode|law              |court                                            |dx|courtnumber|
          |SW1H9AJ  |Adoption        |Inner London Family Proceedings Court            |||
          |BT21     |Immigration     |Glasgow Tribunal Hearing Centre                  |||
           
Scenario Outline: The number of results found for a postcode search should be displayed   

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then the total number of search results <result> should be displayed
          
          Examples:
          |postcode |law              |result|
          |SW1H9AJ  |Adoption         |10    |
          |BT21     |Immigration      |1     |
          |SE1 6AZ  |Crime            |10    |

       
Scenario Outline: Error for postcode returning no results  

          Given I am on the courtfinder postcode search page
          When I enter a postcode "<postcode>" and area of law "<law>" and select continue
          Then I am prompted that the searched postcode could not be found
          
 #        xxxxx is not a valid postcode, please check and try another postcode.          
          
          Examples:
          |postcode            |law                               |
          |CD2                 |Crime                             |
          |CX3                 |All courts and tribunals          |
          
                
                              