Feature: As a researcher I need to gather all the Health, Education and Social Care - care standards decisions
         so I can store them for future retrieval

        
Scenario: verify and collect decisions

         Given I am on 1279 HESCC care standards record
         When I verify the following HESCC care standards values:
         |field                           |value                            |
         |case reference                  |2014/2239/EY-SUS                 | 
         |decision name                   |Mrs Gillian McDuff  v Ofsted     |
         |date of decision                |13/08/2014           |                 
         |schedule                        |Schedule 7: Suspension of child minders/day care registration|
         |main category                   |Suspension of registration|
         |main subcategory                |No Sub Category|
         |note                            |[2014] UKFTT 0780 (HESC)|                   
         |decision(s)                     |http://www.carestandardstribunal.gov.uk/Judgments/j1279/_NCN_%20Final%20Decision%20-%202239.EY-SUS%20%20Gillian%20McDuff%20v%20Ofsted.pdf|
         Then I need to retrieve 2000 HESCC care standards records to file "HESCC_Care_Standards.csv"