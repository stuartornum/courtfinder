Feature: As a user of courtfinder 
         I need to be introduced to what this service can provide 
         so that I don't waste my time

        
Scenario: Selecting to start redirects to the search selection page  
          
           Given I am on the courtfinder start page
           When I click the start button
           Then I am redirected to the courtfinder search selection page
           
                    