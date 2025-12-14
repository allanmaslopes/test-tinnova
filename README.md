# Teste Técnico - Tinnova


- Enpoint do swagger: http://localhost:8080/tinnova/swagger-ui/index.html#/
- Vou deixar alguns exemplos para agilizar os testes



# Cadastro de veiculo
```json
{
  "id": 0,
  "plate": "XPP-2937",
  "model": "Gol",
  "make": "volkswagen",
  "price": 15000,
  "modelYear": 2013,
  "color": "Green",
  "active": true
}
```


# Atualização parcial de veiculo
```json
{
  "id": 1,
  "price": 26000,
  "color": "Black"
}
```


# Atualização completa de veiculo
```json
{
  "id": 1,
  "plate": "XVV-2937",
  "model": "Palio",
  "make": "Fiat",
  "price": 15000,
  "modelYear": 2003,
  "color": "Red",
  "active": true
}
```

# Para realizar o softdelete decidi inserir apenas o id