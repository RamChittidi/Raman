Feature: cucumber with pom feature
Scenario: cucumber with pom
Given navigate to url
When user enter username And password
When LoginSucess
When user click on branches
When user click on newBranchCreation
When user given branchname And address1 And area And zipcode
When user click on selectCountry And selectState And selectCity
When user click on Submitbtn
Then newBranchCreation Sucessfull 
Then user click on logout