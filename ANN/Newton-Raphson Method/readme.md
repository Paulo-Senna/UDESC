# Newton-Raphson Method
The Newton-Raphson method is a root-finding algorithm de uma funcao continua e suave f(x)

---

<br>

## Algorithm steps:

1. Comeca com um papilte inicial x0, idealmente proximo da raiz verdadeira
2. Metodo melhora o palpite com **Aproximacao linear de f(x)** proximo de x0
> Geometricamente, traca uma reta tangente ao grafico da funcao no ponto x0 e verifica onde essa reta cruza o eixo x, (esse ponto de cruzamento se torna a nova aproximacao x1)

---

<br>

## Formulas:

### Equacao fundamental do metodo:

x_1 = x_0 - \frac{f(x_0)}{f'(x_0)}

<br>

### Processo de Newton-Raphson (generalizada)

x_{i+1} = x_i - \frac{f(x_i)}{f'(x_i)}

<br>

### Criterio de parada

|x_{i+1} - x_i| < \epsilon

---

<br>

## Codigo

### Graph it!

```Python
from matplotlib.pyplot import *
from sympy import *

x = symbols('x')

f = Lambda(x, x**2-sin(x)-1/2)

plot(f(x), (x, -1, 2))
```

### Derivada em python

```Python
df = diff (f(x), x)
df

Df = Lambda(x, df)
```

### Iteracao tendo a funcao e sua derivada

```Python
x0 = 0.5
#x1 = x0 - f(x0)/Df(x0)
#repetindo o processo 4x

for i in range(1, 4):
  x1 = x0 - f(x0)/Df(x0)
  x0 = x1
printf(x0);

```

### Funcao final
Entrada: funcao, um ponto inicial e o numero de iteracoes

```Python
def newton_raphson3(f, a, Nmax, epsilon):
    erro = 1
    n = 0
    x0 = float(a)
    
    # Calculando a derivada automaticamente
    df = diff(f(x), x)
    Df = Lambda(x, df)
    
    # Loop de iteração
    while erro > epsilon and n < Nmax:
        x1 = x0 - f(x0)/Df(x0)
        erro = abs(x1 - x0)
        n += 1
        x0 = x1
        
    return x1, n
```

---

<br>

## Exercises

1. Use o método de Newton-Raphson para determinar a raiz real de f(x)=x−sin(x)+2, com tolerância de intervalo ϵ=10−8. Quantas iterações seriam necessárias para obter a mesma raiz usando o método da bissecção (determine esse número sem aplicar o método).

<br>

2. Seja a função f(x)=x2+xsin(x3)+3x−10.
(i) Faça um gráfico desta função.
(ii) Determine todas as raízes reais positivas, usando o método de Newton-Raphson, com uma tolerância de intervalo ϵ=10−10.
(iii) Use o método de Newton-Raphson com tolerância de intervalo ϵ=10−10 para determinar os extremos relativos (especificando x e f(x) de f(x) no intervalo [1.5,2.2].



