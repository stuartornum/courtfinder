Feature: scrape details of courts from the production website


Scenario Outline: collect the court/tribunal names, links

          Given I am on the alphabetical list of courts-tribunals
          When I select all the "<letter>"
          Then I collect all the details for each court listed for "<letter>"
          
          Examples:
          |letter|
          |A     |
#          |B     |
#          |C     |
#          |D     |
#          |E     |
#          |F     |
#          |G     |
#          |H     |                    
#          |I     |
#          |J     |
#          |K     |
#          |L     |
#          |M     |
#          |N     |
#          |O     |
#          |P     |              
#          |Q     |
#          |R     |
#          |S     |
#          |T     |
#          |U     |
#          |V     |
#          |W     |  
#          |X     |
#          |Y     |
#          |Z     |
                     