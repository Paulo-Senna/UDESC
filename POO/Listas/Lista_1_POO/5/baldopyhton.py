class Fornecedor:
    def __init__(self, nome, cnpj, produto_fornecido):
        self.nome = nome
        self.cnpj = cnpj
        self.produto_fornecido = produto_fornecido

    def __str__(self):
        return f"Fornecedor: {self.nome}, CNPJ: {self.cnpj}, Produto: {self.produto_fornecido}"

class CarrinhoDeCompras:
    def __init__(self, id_carrinho, cliente, total_itens):
        self.id_carrinho = id_carrinho
        self.cliente = cliente
        self.total_itens = total_itens

    def __str__(self):
        return f"Carrinho ID: {self.id_carrinho}, Cliente: {self.cliente}, Total de Itens: {self.total_itens}"

fornecedor1 = Fornecedor("Distribuidora Alimentos LTDA", "12.345.678/0001-99", "Arroz")
fornecedor2 = Fornecedor("Frutas do Vale", "98.765.432/0001-00", "Banana")

carrinho1 = CarrinhoDeCompras(101, "Maria", 12)
carrinho2 = CarrinhoDeCompras(102, "João", 5)

print(fornecedor1)
print(fornecedor2)
print(carrinho1)
print(carrinho2)
