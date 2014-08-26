Feature:  As a user that has started the court finder journey
          I need to select what type of search 
          So that I can find my court using the criterion I know
 
          
Scenario: Select a postcode search

           Given I am on the court finder search selection page
           When I select the postcode search and click continue
           Then I am redirected to the postcode search page


Scenario: select an name and address search

           Given I am on the court finder search selection page
           When I select the name and address search and click continue
           Then I am redirected to the name and address search page
           
          
Scenario: select a list view of the courts

           Given I am on the court finder search selection page
           When I select the list view  search and click continue
           Then I am redirected to the list view page
