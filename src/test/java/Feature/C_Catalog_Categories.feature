Feature: Categories Feature in the application

Background:
Given User is already on the login page
When User Enters the emailid as "admin@yourstore.com" and password as "admin"
And User click on the login button
Then Page title should be "Dashboard / nopCommerce administration"
When User click on the Catalog Menu
And User click on the Categories menu Item 
Then User should be on the Categories Page

@AddCategories
Scenario: Add Product Categories 
Given User click on the Add new Category button
Then It should be open Add new Category Page
When User Enter the categoryName and Description
And User Click on the category SAVE button 
Then Conformation message should be "The new category has been added successfully."

@SearchCategory
Scenario: Search category from categories Table
Given User click on the Add new Category button
When User Enter the categoryName and Description
And User Click on the category SAVE button 
When User enter the category name in the search input box
And User click on the category search button
Then User should found the categoryName from the category Table

@UpdateCategory
Scenario: Update the added category
Given User click on the Add new Category button
When User Enter the categoryName and Description
And User Click on the category SAVE button 
When User enter the category name in the search input box
And User click on the category search button
When User click on the searched category edit button
Then It should be open Edit category page
When User update the Category descripton
And User Click on the category SAVE button 
Then It should be displya the conformation msg "The category has been updated successfully."

@DeleteCategory
Scenario: Delete added category
Given User click on the Add new Category button
When User Enter the categoryName and Description
And User Click on the category SAVE button 
When User enter the category name in the search input box
And User click on the category search button
When User check the searched category checkbox
And User click on the delete(Selected) button
When User click on the conform YES popup button
Then Display the msg in the Category table should be "No data available in table"

@ExportCategory
Scenario: Export Category List in Excel file
Given User click on the Export droupdown
When User select the Export to excel option
Then Excel file should be downloaded

@ImportCategory
Scenario: Import Category from Excel File
Given User click on the import button
When User upload the category excel file
And User click on the import to excel button
Then Message should be Display as "Categories have been imported successfully."