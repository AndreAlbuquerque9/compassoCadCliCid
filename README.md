# compassoCadCliCid

End points e exemplos
-
* Cadastrar cidade
  * POST - /cidades
    ```
      {
        "nomeEstado": "ESTADO",
        "nomeCidade": "CIDADE"
      }
    ```
  
* Cadastrar cliente
  * POST - /clientes
      ```
      {
        "nome": "NOME",
        "idade": IDADE,
        "dataNascimento": "YYYY-MM-DD",
        "sexo": "M",
        "nomeCidade": "CIDADE"
      }
      ```
  
* Consultar cidade pelo nome
  * GET - /cidades?cidade=nome_da_cidade
  
* Consultar cidade pelo estado
  * GET - /estados?estado=nome_do_estado
* Consultar cliente pelo nome
  * GET - /clientes?=cliente=nome_do_cliente
* Consultar cliente pelo Id
  * GET - /clientes/{id}
* Remover cliente
  * DELETE - /clientes/{id}
* Alterar o nome do cliente
  * PUT - /clientes/{id}
  ```
    {
    	"nome": "NOME"
    }
  ```
