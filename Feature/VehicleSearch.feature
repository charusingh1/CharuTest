Feature: Vehicle Search Test

Scenario: Search vehicle information with valid registration number 
	Given User visits covercheck.vwfsinsuranceportal page 
	When the user enter valid vehicle registration number into the search bar "OV12UYY"
	And click on find vehicle button
	Then correct vehicle information is displayed on the page "OV12UYY"

Scenario: Search vehicle information with invalid registration number 
	Given User visits covercheck.vwfsinsuranceportal page 
	When the user enter invalid vehicle registration number into the search bar "123XYZ"
	And click on find vehicle button
	Then page displays message ‘Sorry record not found’

Scenario: Search vehicle information with blank registration number 
	Given User visits covercheck.vwfsinsuranceportal page
	When click on find vehicle button
	Then page displays ‘Please enter a valid car registration’

