Feature: As a researcher I need to gather all the property chamber - land registration decisions
         so I can store them for future retrieval

        
Scenario: verify and collect decisions

         Given I am on  247 property chamber land registration record
         When I verify the following property chamber land registration values:
         |field                           |value                |
         |case reference                  |REF/2010/1066        | 
         |date of decision                |08/03/2011|
         |adjudicator                     |Mr Michael Mark|        
         |appellant                       |(1) Ian Michael Osborne (2) Barbara Linda Osborne|
         |respondent                      |(1) Mary Lawton (2) Robert Noyes (3) Richard Sandford-Fawcett|
         |main category                   |Adverse possession|
         |main subcategory                |Applications under Schedule 6 to the Land Registration Act 2002|
         |secondary category              |Adverse possession|
         |secondary subcategory           |Applications under Schedule 6 to the Land Registration Act 2002| 
#        |note                            ||                   
         |decision(s)                     |http://www.ahmlr.gov.uk/Judgments/j247/2010.1066%20Osborne%20-v-%20Lawton.doc|
         Then I need to retrieve 500 property chamber land registration records to file "property_chamber_land_registration.csv" 