from EspacoGeometrico import EspacoGeometrico
from Reta import Reta
from Ponto2D import Ponto2D
from ObjetoSobrepostoException import ObjetoSobrepostoException

espaco = EspacoGeometrico()

reta_vermelha = Reta(1, 0)
reta_verde = Reta(1, 2)
reta_azul = Reta(-1, 6)

A = Ponto2D(1, 1)
B = Ponto2D(2, 4)
C = Ponto2D(3, 3)
D = Ponto2D(3, 2)

try:

    espaco.adicionarReta(reta_vermelha)
    espaco.adicionarReta(reta_verde)
    espaco.adicionarReta(reta_azul)

except ObjetoSobrepostoException as e:
    print("Erro na reta", e)

for ponto, nome in zip([A, B, C, D], ['A', 'B', 'C', 'D']):
    try:
        espaco.adicionarPonto(ponto)
        print(f"Ponto {nome} adicionado")
    except ObjetoSobrepostoException as e:
        print(f"Erro ao adicionar o ponto {nome}: ", e) #acho que eu consegui resolver o problema que mencionei no outro codigo, mas nao sei o que ocasionou isso.