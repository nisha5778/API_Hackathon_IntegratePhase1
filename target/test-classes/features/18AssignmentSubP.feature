Feature: Assignment submission Module 
@6assign
Scenario Outline:
	Given : "post" Request to "create" the data 
	When : User sends request Body from excel "<SheetName>" and <RowNumber>
	Then : user recieves the list of data which can be validated.
 	
	Examples:
	
	|SheetName|RowNumber|
	|postassign	|				0	|


@7get
Scenario: get all data
 	Given : "get" Request to "retrieve" the data  
 	When : User sends get request 
 	Then : user recieves the list of data which can be validated.
 @8assignmentid	
 	Scenario Outline: get by id
 	Given : "get" Request to "retrieve" the data 
 	When : data is retrieved using <id> by get request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
	|4001|
	
	@9studentid
	Scenario Outline: get grades
	Given : "get" Request to "retrieve" the data 
 	When : grade is retrieved using "<id>" by get request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|U7877|
 	
 	@10batchid
 	Scenario Outline: get grades by batch id
 	Given : "get" Request to "retrieve" the data 
 	When : grade is retrieved using batch <id> by get request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|6409|
 	
 	@11submissionbyuserid
 		Scenario Outline: get submission by userid
 	Given : "get" Request to "retrieve" the data 
 	When :  get submission by using user "<id>" request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|U7877|
 	
 	@12SubBatchId
 	Scenario Outline:get submission by batch id
 	Given : "get" Request to "retrieve" the data 
 	When :  get submission by using batch <id> request
 	Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|id|
 	|6409|
 	
 	@13Putresubmitassign
 	Scenario Outline: resubmit assignment with update request
 	Given : "put" Request to "update" the data
 When : User sends request Body from excel "<SheetName>" and <RowNumber>
 Then : user recieves the list of data which can be validated.
 	    
	
 	
 	Examples:
 	|SheetName|RowNumber|
 	|put			|				 0|
 	
 	@14Putgradeassignment
 	Scenario Outline: update assginment 
 	Given : "put" Request to "update" the data
 	When : User sends request Body from excel "<SheetName>" and <RowNumber>
 Then : user recieves the list of data which can be validated.
 	
 	Examples:
 	|SheetName|RowNumber|
 	|putgrade	|				 0|
 	
 	
 	
 	