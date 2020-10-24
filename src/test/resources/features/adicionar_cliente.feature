Feature: Add clients

	As user I want to add new clients
	
Background:
	Given that I am on the main page

Scenario: Should add new client successfully
	When I select the option "Bank Manager Login"
	And I select the option "Add Customer"
	And I type first name as "Jose"
	And I type second name as "Silva" 
	And seleciono a opcao Add Customer
	Then é exibido uma mensagem informando que a conta foi inserida com sucesso