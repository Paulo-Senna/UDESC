class Reta:
    def __init__(self, a : int, b: int):
        self.a = a 
        self.b = b
        def intercepta(self, outra: 'Reta') -> bool:
            return self.a != outra.a
        
        def estaNaReta(self, ponto: 'Ponto2D') -> bool:
            return ponto.y == self.a * ponto.x + self.b