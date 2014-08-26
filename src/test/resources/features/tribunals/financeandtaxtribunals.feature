Feature: As a researcher I need to gather all the finance and tax tribunal decisions
         so I can store them for future retrieval

       
Scenario: verify and collect decisions

         Given I am on  7915 finance and tax tribunal record
         When I verify the following tribunal values:
         |field                           |value                |
         |decision number                 |TC 03923             |         
         |appellant                       |Duncan McKee         |
         |respondent                      |The Commissioners for Her Majesty's Revenue & Customs|
         |chairmen - special commissioners|Mr Kenneth Mure QC|
         |date of decision                |18/08/2014|
         |main category                   |INCOME TAX/CORPORATION TAX|
         |main subcategory                |Appeals|
#         |note                            ||
#         |decision(s)                     ||  
         Then I need to retrieve 8000 records to file "financeandtaxtribunals.csv"    