# language: pt
Funcionalidade: Compra completa My Store

	Usuario podera adicionar compras ao carrinho e criar um usuario e fazer fluxo completo
	para prosseguir com a compra de seus produtos.
	
	
	pré-requesitos: Usuario precisa ter acesso a internet, um email valido ainda nao cadastro
	no sitemas.

@compraCompleta   
Cenario: Realizar uma compra completa 
	Dado que estou na pagina http://automationpractice.com/index.php
	E seleciono o primeiro produto na lista	
	Entao devera ser apresentado a tela produto adicionado no carrinho "Product successfully added to your shopping cart"
	E clicar no botao Proceed to checkout
	Entao devera ser apresentado produto adicionado ao carrinho
	E clicar no botao verde Proceed to checkout
	E Preencher "mike@teste.com" valido	
	E clicar no botao Create an Account
	E preencher todos os campos obrigatorios
	E clicar no botao Register
	Entao devera refletir endereço corretamente
	E clicar no botao Proceed 
	E clicar no Terms of service	
	E clicar no botao Proceed too checkout
	Entao o valor da compra devera ser o mesmo selecionado
	E clicar em Pay by bank wire
	E clicar no botao I confirm my order
	Entao devera aparecer "Your order on My Store is complete."
	
	
	