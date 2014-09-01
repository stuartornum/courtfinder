Feature: scrape details of courts from the production website


Scenario: collect the court/tribunal names, links

          Given I am on the alphabetical list of courts-tribunals
          Then I collect all the details for each court listed for <letter>:
          |letter|
          |A     |
          |B     |  
          |C     |
          |D     |
          |E     |
          |F     |
          |G     |
          |H     |                    
          |I     |
          |J     |
          |K     |
          |L     |
          |M     |
          |N     |
          |O     |
          |P     |              
          |Q     |
          |R     |
          |S     |
          |T     |
          |U     |
          |V     |
          |W     |  
          |X     |
          |Y     |
          |Z     |                  
          And I save all the court details
          

                     