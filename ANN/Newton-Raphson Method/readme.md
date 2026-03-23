# Newton-Raphson Method
...

---

<br>

## Implementation

Necessary libraries: 

```
from matplotlib.pyplot import *
from sympy import *
init_printing()
```

<br>

We want the real roots of the equation **x^2 - sin(x) - 1/2 = 0**

```
x=symbols('x')

f= Lambda(x, x**2-sin(x)-1/2)
f(x)

plot(f(x), (x, -1,2))
```

<br>

Calcular a derivada

```
df=diff(f(x), x)
df
```

<br>

Definir a funcao derivada com o comando Lambda:

```
Df = Lambda(x, df)
Df(x)
```

## Function

```
def newton_raphson1(f, x0, N):
  for i in range(1, N):
    x1 = x0 - f(x0)/Df(x0)
    x0 = x1
return x0

r1=newton_raphson(f, -1.,6)
```

<br>

```
def newton_raphson2(f,a,N):
  x0 = float(a)
  for i in range(1,N):
    x1 = x0 - f(x0) / Df(x0)
    x0 = x1
return x0
```

<br>

```
def newton_raphson3(f, a, Nmax, epsilon):
  erro = 1
  n = 0
  x0 = float(a)
  df = diff(f(x), x)
  Df= Lambda(x, df)
  while errp>epsilon and n<Nmax:
    x1 = x0 - f(x0) / Df(x0)
    erro = abs(x1 - x0)
    n = n + 1
    x0 = x1
return x1,n
```

<br>

## Exercises 



1. Use o método de Newton-Raphson para determinar a raiz real de f(x)=x−sin(x)+2, com tolerância de intervalo ϵ=10−8. Quantas iterações seriam necessárias para obter a mesma raiz usando o método da bissecção (determine esse número sem aplicar o método).

2. Seja a função f(x)=x2+xsin(x3)+3x−10.
(i) Faça um gráfico desta função.
(ii) Determine todas as raízes reais positivas, usando o método de Newton-Raphson, com uma tolerância de intervalo ϵ=10−10.
(iii) Use o método de Newton-Raphson com tolerância de intervalo ϵ=10−10 para determinar os extremos relativos (especificando x e f(x) de f(x) no intervalo [1.5,2.2].


