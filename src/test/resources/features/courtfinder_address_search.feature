@todo
Feature: As a citizen I need to find a court by name, address, county 
         so I can find useful information to help me
         

Scenario: No address entered and user requests search prompts error

              Given I am on the courtfinder address search page
              When I select continue
              Then I am prompted to enter a address       
        
Scenario Outline: Complete court name returns individual court entry in the results page

               Given I am on the courtfinder address search page
               When I enter a court name "<courtname>" and search
               Then I will be returned a single court result "<courtname>"
              
              Examples:
              
               
               |courtname|
               |Central Criminal Court|
               |accrington county court|
               |Bath county Court and Family court|
               |Bournemouth Crown court|
               
 Scenario Outline: Complete court name returns court details including dx and court number

               Given I am on the courtfinder address search page
               When I enter a court name "<court>" and search
               Then for the "<court>" the "<dx>" and "<courtnumber>" are displayed
              
              Examples:
              
               
               |court                 |dx              |courtnumber|
               |Central Criminal Court|46700 Old Bailey|413|                
                  
                            
                  
Scenario Outline: Partial court name returns result selection

               Given I am on the courtfinder address search page
               When I enter a partial court name "<partialcourtname>" and search
               Then in the result page I should find within the results the following "<courts>" listed
              
              Examples:
              

               |partialcourtname  |courts|
               |bournemouth       | Bournemouth and Poole County Court and Family Court,Bournemouth Crown Court,Bournemouth Magistrates' Court|
               |bradford court    | Bradford and Keighley Magistrates' Court and Family Court,Bradford Combined Court Centre|


Scenario Outline: Building name returns relevant court 

               Given I am on the courtfinder address search page
               When I enter a building name "<buildingname>" and search
               Then in the result page I should find within the results the following "<courts>" listed
              
              Examples:
              
              
               |buildingname|courts|
               |old bailey|Central Criminal Court|
               |Gee Street|Clerkenwell and Shoreditch County Court and Family Court| 
               |peak buildings|Buxton County Court,High Peak Magistrates' Court|
               |first avenue house|Central Family Court|
               
 
Scenario Outline: Partial address (street name) will return courts with matching address

               Given I am on the courtfinder address search page
               When I enter a street name "<streetname>" and search
               Then in the result page I should find within the results the following "<courts>" listed
              
              Examples:
              

              |streetname|courts|
              |Tenters Street|Bury County Court and Family Court| 
              |Little John Street|Chester Probate Sub-Registry|
              |London Road |Croydon Employment Tribunal|
              |Laneham Street|Scunthorpe County Court and Family Court|
              |Secretan Way|South Shields County Court and Family Court|
              
             
Scenario Outline: Partial address (town/city/county) will return courts with matching address

               Given I am on the courtfinder address search page
               When I enter a town, city or county "<town_city_county>" and search
               Then in the result page I should find within the results the following "<courts>" listed
              
              Examples:
              
              |town_city_county|courts|
              |burnley|Burnley Combined Court Centre,Burnley Magistrates' Court|
              |bury|Bury and Rochdale Magistrates' Court,Bury County Court and Family Court,Bury St Edmunds County Court and Family Court (#157),Bury St Edmunds Crown Court (#754),Bury St Edmunds Employment Tribunal,Bury St Edmunds Magistrates' Court and Family Court (#2867)|
              |London|City of London Magistrates' Court,Central Criminal Court,Mayor's and City of London Court|
              

             
Scenario Outline: address search that returns no results

               Given I am on the courtfinder address search page
               When I enter a invalid address "<invalidaddress>" and search
               Then I should be prompted that the address is invalid
               
              Examples:
              
              |invalidaddress|
              |zzzzzzzzzz    |              
               
# error message :
# Sorry, there are no results for xxxxx. Please check and try another name or addresss.              

                  