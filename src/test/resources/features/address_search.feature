Feature: As a citizen I need to find a court by name, address, county 
         so I can find useful information to help me
         
Scenario Outline: Complete court name returns individual court entry

               Given I am on the address search page
               When I enter a court name "<courtname>" and search
               Then I will be returned a single court result
               
               |courtname|
               |Central Criminal Court|
               |accrington county court|
               |Bath county Court and Family court|
               |Bournemouth Crown court|
               
                  
                  
Scenario Outline: Partial court name returns result selection

               |courtname  |results|
               |bournemouth| Bournemouth and Poole County Court and Family Court (#139) Bournemouth Crown Court (#406) Bournemouth Magistrates' Court (|
               |bradford court| Bradford and Keighley Magistrates' Court and Family Court (#2354) , Bradford Combined Court Centre (#402, CCI 141)|

Scenario Outline: Building name returns relevant court 
              
               |buildingname|court|
               |old bailey|Central Criminal Court|
               |Gee Street House|Clerkenwell and Shoreditch County Court and Family Court| 
               |peak buildings|Buxton County Court|
               |first avenue house|Central Family Court|
               

Scenario Outline: Partial address (street name) will return courts with matching address

              |StreetName||
              |Tenters Street|Bury County Court and Family Court| 
              |Little John Street|Chester Probate Sub-Registry|
              |London Road |Croydon Employment Tribunal|
              |Laneham Street|Scunthorpe County Court and Family Court|
              |Secretan Way|South Shields County Court and Family Court|
              
              
Scenario Outline: Partial address (town/city/county) will return courts with matching address

              |area||
              |burnley|Burnley Combined Court Centre,Burnley Magistrates' Court|
              |bury|Bury and Rochdale Magistrates' Court,Bury County Court and Family Court,Bury St Edmunds County Court and Family Court (#157) 
Bury St Edmunds Crown Court (#754) 
Bury St Edmunds Employment Tribunal 
Bury St Edmunds Magistrates' Court and Family Court (#2867)|
              |London|City of London Magistrates' Court,Central Criminal Court,Mayor's and City of London Court|
              
              
Scenario Outline: address search that returns no results


# Sorry, there are no results for xxxxx. Please check and try another name or addresss.              

                  