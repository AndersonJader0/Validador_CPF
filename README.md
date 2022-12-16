# Validador_CPF
## Realiza operação matemática a base de aritmética básica para a validação do CPF.

### possui o seguinte algoritmo para a validação do cpf.
Algoritmo:
1 - Salvar os 11 números do CPF.
2 - Multiplicar o primeiro dígito da esquerda para a direita por 10, o segundo dígito
por 9, o terceiro dígito por 8… assim sucessivamente até multiplicar o último dígito
(não verificador) por 2.
3 - Somar todas as multiplicações realizadas.
4 - Dividir a soma por 11, o resto da divisão será o primeiro dígito verificador do CPF.
5 - Realizar o mesmo procedimento para achar o segundo dígito verificador do CPF.
Porém começando a multiplicar o primeiro número por 11 e terminando multiplicando
o primeiro dígito verificador por 2.
CPF: 123.456.789-11
meramente ilustrativo
Os números após o traço em negrito são os dígitos verificadores. Importantes
para a validação do CPF.
