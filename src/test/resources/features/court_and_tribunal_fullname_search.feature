 @todo
Feature: As a user I need to search for a court by name
         So I can view the full details of the services and amenities it offers
 
 @needtoclarify    
 Scenario Outline: Entering a valid court/tribunal name and area of law returns the court/tribunal details page

          Given I am on the courtfinder search page
          When I enter a fullname for a court or tribunal "<CourtOrTribunal>" and area of law "<law>"
          Then I am redirected to the "<CourtOrTribunal>" details page
          
          
          Examples:
          |CourtOrTribunal      |law              | 
          |Central Family Court |Adoption         |
 
 

  Scenario Outline: When I start to type the name of a court  
                    a list of possible courts and tribunals 
                    matching the entry appears from which I can choose
  
          Given I am on the courtfinder search page
          When I enter a partial name "<PartialName>" for a court or tribunal
          And I select the court or tribunal "<CourtOrTribunal>" displayed in the matches list
          Then I am redirected to the "<CourtOrTribunal>" details page
          
          Examples:
          |PartialName  |CourtOrTribunal                           | 
          |aber         |Aberdeen Tribunal Hearing Centre          |         
          |Car          |Cardiff Probate Registry of Wales         |
          |tam          |Tameside County Court and Family Court    |