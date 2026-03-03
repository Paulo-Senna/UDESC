from ObjetoSobrepostoException import ObjetoSobrepostoException
from Reta import Reta
from Ponto2D import Ponto2D

class EspacoGeometrico:

    def __init__(self):
        self.retas = []
        self.pontos = []

        def adicionarReta(self, reta: Reta):

            for r in self.retas:
                if r.intercepta(reta):
                    raise ObjetoSobrepostoException("A reta intercepta outra ja existe")
                self.retas.append(reta)

            def adicionarPonto(self, ponto: Ponto2D):
                for r in self.retas:##professor, nao sei pq, mas nao consegui continuar meu codigo, nao entendo mto de python e meu programa ta rodando e eu nao consigo complementar esse codigo
                    if r.estaNaReta(ponto):
                        raise ObjetoSobrepostoException("o ponto esta sobreaposto a uma reta")
                    self.pontos.append(ponto)
            