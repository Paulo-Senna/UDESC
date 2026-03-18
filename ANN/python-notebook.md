
## Metodo da bissecao

* 1. O fluxo de água em um canal pode ser modelado por uma equação polinomial. 
Precisamos encontrar a altura da água x para a qual a função f(x)=x^3−9x+3 seja zero, 
sabendo que essa altura está entre 0 e 1 metro.

<br>

```
import numpy as np
from scipy import optimize

# Definindo a função do problema
def f(x):
    return x**3 - 9*x + 3

# Aplicando a bisseção no intervalo [0, 1]
resultado_bisect = optimize.root_scalar(f, bracket=[0, 1], method='bisect')

print("--- Método da Bisseção ---")
print(f"Raiz encontrada: {resultado_bisect.root}")
print(f"Convergiu com sucesso? {resultado_bisect.converged}")
print(f"Número de iterações: {resultado_bisect.iterations}")
```

## Metodo de Newton-Raphton

* 2. Muitos algoritmos de renderização de gráficos precisam calcular raízes 
quadradas rapidamente. O cálculo da raiz quadrada de 5 pode ser formulado como a 
busca da raiz de f(x)=x^2−5. Encontre essa raiz começando com um palpite inicial x0​=2. 
A derivada dessa função é f′(x)=2x.

<br>

```
from scipy import optimize

# Função principal
def f(x):
    return x**2 - 5

# Derivada da função principal
def df(x):
    return 2*x

# Aplicando Newton-Raphson com x0=2 e passando a derivada
resultado_newton = optimize.root_scalar(f, x0=2.0, fprime=df, method='newton')

print("\n--- Método de Newton-Raphson ---")
print(f"Raiz encontrada (sqrt de 5): {resultado_newton.root}")
print(f"Convergiu com sucesso? {resultado_newton.converged}")
print(f"Número de iterações: {resultado_newton.iterations}")
```

## Metodo da Secante

3. Considere o problema da interseção de curvas em cinemática, onde precisamos saber 
quando a trajetória de um robô cruza a origem. A equação transcendental do movimento 
é dada por f(x)=cos(x)−x. Como misturamos trigonometria e polinômios, usaremos o 
método da secante com palpites iniciais em x0​=0.5 e x1​=1.0.

```
import numpy as np
from scipy import optimize

# Função transcendental
def f(x):
    return np.cos(x) - x

# Aplicando o método da secante sem precisar da derivada
# Passamos dois chutes iniciais: x0 e x1
resultado_secant = optimize.root_scalar(f, x0=0.5, x1=1.0, method='secant')

print("\n--- Método da Secante ---")
print(f"Raiz encontrada: {resultado_secant.root}")
print(f"Convergiu com sucesso? {resultado_secant.converged}")
print(f"Número de iterações: {resultado_secant.iterations}")
```





