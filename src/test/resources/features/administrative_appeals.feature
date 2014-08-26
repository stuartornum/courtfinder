Feature: As a researcher I need to gather all the Health, administrative appeals decisions
         so I can store them for future retrieval

@todo        
Scenario: verify and collect decisions

         Given I am on 4272 administrative appeals record
         When I verify the following administrative appeals values:
         |field                           |value                            |
         |neutral citation number         |2014 UKUT 359 AAC|
         |reported number                 | |
         |file number                     |CCS 2116 2013        | 
         |appellant                       |CA|
         |respondent                      |(1) Secretary of State for Work and Pensions and (2) EG (CSM) |
         |judge/commisioner               |Judge C. Turnbull|          
         |date of decision                |05/08/2014|  
         |date added                      |21/08/2014|              
         |main category                   |Child support|
         |main subcategory                |variation/departure directions: other|
         |secondary category              ||
         |secondary subcategory           || 
         |note                            |Whether discretionary beneficiary has a beneficial interest in the trust assets within Variations Regulation 18 (1) (a) |                   
         |decision(s)                     |http://www.osscsc.gov.uk/judgmentfiles/j4272/CCS%202116%202013-00.doc|
         Then I need to retrieve 4500 administrative appeals records to file "Administrative_Appeals_22-08-2014.csv"