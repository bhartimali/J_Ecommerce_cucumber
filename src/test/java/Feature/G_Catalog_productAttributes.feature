Feature: Product Attributes feature

Background:
Given User is already on the login page
When User Enters the emailid as "admin@yourstore.com" and password as "admin"
And User click on the login button
Then Page title should be "Dashboard / nopCommerce administration"
When User click on the Catalog Menu
And User click on the Attribute menu Item
And User click on the Product Attribute sub menu
Then User should be on the Product attribute Page

@AddAttributes
Scenario: Add new product attribute
Given User click on the attribute add new button
Then User should be on add new product attribute page
When User Enter the attribute name
And User click on the attribute SAVE button
Then Added attribute conformation Message should be "The new attribute has been added successfully."

@UpdateAttributeInfo
Scenario: Update product attribute info
Given User click on the attribute add new button
Then User should be on add new product attribute page
When User Enter the attribute name
And User click on the attribute SAVE button
When User click on the added attribute Edit button
Then It should be open Edit product attribute details page
When User updates the attribute description
And User click on the attribute SAVE button
Then Attribute updated Message should be "The attribute has been updated successfully."

@DeleteAttrbute
Scenario: Delete product Attribute
Given User click on the attribute add new button
Then User should be on add new product attribute page
When User Enter the attribute name
And User click on the attribute SAVE button
And User click on the added attribute checkbox
When User click on the attribute delete button
And User click on the conform attribute delete button
Then Attribute should be deleted from attribute list table