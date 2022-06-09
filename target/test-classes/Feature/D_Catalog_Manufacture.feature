Feature: Manufacture feature

Background:
Given User is already on the login page
When User Enters the emailid as "admin@yourstore.com" and password as "admin"
And User click on the login button
Then Page title should be "Dashboard / nopCommerce administration"
When User click on the Catalog Menu
And User click on the Menufactures menu Item 
Then User should be on the Menufactures Page

@AddNewMenufacture
Scenario: Add new manufacture name
Given User click on add new button
Then It should be open add new manufacture page
When User enter manufacture name
And User click on manufacture save button
Then Message should be display as "The new manufacturer has been added successfully."

@SearchManufactureName
Scenario: Search manufacture name from manufacture table
Given User click on add new button
When User enter manufacture name
And User click on manufacture save button
When User Enter the manufature name in the search box
And User click on the search Manufacture button
Then User should be found the manufacture name from the manufacture Table

@UpdateManufacture
Scenario: Update the Manufacture name
Given User click on add new button
When User enter manufacture name
And User click on manufacture save button
When User Enter the manufature name in the search box
And User click on the search Manufacture button
And User click on the edit button in the manufactures table
Then It should be open Edit manufacture page
When User update the manufacture name
And User click on manufacture save button
Then Conformation msg should be "The manufacturer has been updated successfully."

@DeleteManufacture
Scenario: Delete added Manufacture
Given User click on add new button
When User enter manufacture name
And User click on manufacture save button
When User Enter the manufature name in the search box
And User click on the search Manufacture button
When User check the searched manufacture checkbox
And User click on the manufacture delete button
When User click on the manufacture conform YES popup button
Then Display the Message in the manufacture table should be "No data available in table"

@ExportManufactureList
Scenario: Export Manufacture List in Excel file
Given User click on the Export droupdown Manufacture page 
When User select the Export to excel option under droupdown
Then Manufacture List should be downloaded in a excel file

@ImportManufactureList
Scenario: Import Manufacture List from Excel File
Given User click on the manufacture IMPORT button
When User upload the Manufacture excel file
And User click on the import to excel button for upload the file
Then Import file Message should be "Manufacturers have been imported successfully."