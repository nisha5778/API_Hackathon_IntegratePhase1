@tag
Feature: Assignment Module Scenarios
 
 
 #@15Delassignsub
 #	Scenario Outline: delete request for deleting the id 
 #	Given : "del" Request to "delete" the data 
 #	When :  delete the  submission by using submission <id> request
 #	Then : user recieves the list of data which can be validated.
 #	
 #	Examples:
 #	|id|
 #	|1158|
 	
@16DeleteDataByAssignmentIdP
	 Scenario: User is trying to delete an assignment
	 	Given User creates DELETE Request for the LMS API endpoint 
    When User calls the payload API with delete request by assignmentId
    Then Assignment gets deleted  
    
 