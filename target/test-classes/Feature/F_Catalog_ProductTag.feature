Feature: Product Tag feature

Background:
Given User is already on the login page
When User Enters the emailid as "admin@yourstore.com" and password as "admin"
And User click on the login button
Then Page title should be "Dashboard / nopCommerce administration"
When User click on the Catalog Menu
And User click on the product Tags menu Item 
Then User should be on the product tags Page

@SearchTagName
Scenario: Search product tag by tag name
Given User enter the product tag name in the searchbox
When User click on the search tag button
Then User should found the tag name in the tag table

@UpdateTagName
Scenario: Update product tag name
Given User click on the tag edit button
Then It should be open tag edit page
When User update the tag name 
And User Click on the tag SAVE button
Then  Updated Conformation message should be "The product tag has been updated successfully."

@DeleteSelectedTag
Scenario: Delete the selected product tag name
Given User check the checkbox of tag name in the table
When User click on the tag delete(Selected) button
And User click on the conform YES delete button
Then Tag name should be deleted from the table
