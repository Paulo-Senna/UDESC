# Bisection Method

The bisection method is a root-finding algorithm that applies to any continuous function for which one knows two values with opposite signs.

### Algorithm Steps:
1. Choose an initial interval $[a, b]$, such that $f(a)f(b) < 0$.
2. Calculate the midpoint of the interval: $m = \frac{a + b}{2}$.
3. Determine if $f(m) > 0$ or $f(m) < 0$.
4. Choose the new interval to be $[a, m]$ if $f(a)f(m) < 0$. Otherwise, choose $[m, b]$.
5. Repeat the process until the gap size is smaller than a pre-set tolerance $\epsilon$ or a maximum number of iterations $N$ is reached.

---

<br>

### Analysis
* **Advantages:** Always convergent and can be used as a starter for more accurate methods. Since the intervals containing the root are halved at each iteration, the error in the solution is predictable.
* **Disadvantages:** Linear convergence (slow), as each step reduces the interval by half. Does not work for determining multiple roots where the function does not cross the x-axis.

---

<br>

## 🔍 Graph it!
> The first approach to finding the real roots of an algebraic equation is to graph it.

* **Matplotlib:** Used to graph representations (you dont need to have this library imported in your code, but need to install in your pc)
    ```windows
    python -m pip install matplot 
    ```
    
    <br>
    
    ```linux
    pip install matplot
    ```

    <br>
    
* **SymPy:** Used to simplify algebraic symbols.
  ```windows
  python -m pip install sympy
  ```

  <br>

  ```linux
  pip install sympy
  ```

<br>

### Graphical Analysis: $\cos(x) + x + 1 = 0$

Let us determine the approximate position of the real roots graphically:

```python
from sympy import *

x = symbols('x')
f = Lambda(x, cos(x) + x + 1)
plot(f(x), (x, -6, 6))
```
With this graph, we can see that the equation has only one real root.

---

<br>

### High Accuracy Determination: $x^4 - \sin(x) - 1 = 0$
Now, to determine the root with great accuracy and precision:

```Python
from matplotlib.pyplot import *
from sympy import *

x = symbols('x') #define x como uma variavel matematica e não de programação
f = Lambda(x, x**4 - sin(x) - 1) #Lambda é uma função que cria a função definindo a variavel isolada e sua formula

plot(f(x), (x, -1.5, 1.5)) #x define o eixo horizontal

```

<br>

### The Negative Root (Range $[-1, 0]$):

```Python
a = -1
b = 0
for n in range(1, 30):
    m1 = (a + b) / 2
    if f(m1) * f(a) < 0:
        b = m1
    else:
        a = m1
print(f"Negative root: {m1}")
```

<br>

### The Positive Root (Range $[1, 1.5]$):

```Python
a = 1
b = 1.5
for n in range(1, 30):
    m2 = (a + b) / 2
    if f(m2) * f(a) < 0:
        b = m2
    else:
        a = m2
print(f"Positive root: {m2}")
```

---

<br>

## 📦 Encapsulating
We can encapsulate the logic into a reusable function that takes the function $f$, the extremes $A$ and $B$ of the initial interval, and the number of iterations $N$.

```Python
def bisect1(f, a, b, n):
    if f(a) * f(b) >= 0:
        print('The method failed: f(a) and f(b) must have opposite signs.')
        return None
    for n in range(1, N + 1):
        m = (a + b) / 2
        if f(a) * f(m) < 0:
            b = m
        else:
            a = m
    return (a + b) / 2
```

<br>

### Advanced Procedure (with Tolerance $\epsilon$)
A procedure using the mximum number of iterations $Nmax$ and the tolerance $\epsilon$.

<br>

You can use this template to another exercises

* **$Nmax$:** Security block of iterations.
* **$\epsilon$:** Maximum margin of error.

```Python
def bisect2(f, A, B, Nmax, epsilon):
    a, b = A, B
    erro = 1
    n = 0
    while erro > epsilon and n < Nmax: ##identifica quando parar, diferente da bisect1
        if f(a) * f(b) >= 0:
            print('The method failed')
            return None
        m = (a + b) / 2
        if f(a) * f(m) < 0:
            b = m
        else:
            a = m
        erro = abs(a - b)
        n = n + 1
    return (a + b) / 2, n

# Usage example:
r1_res, n1 = bisect2(f, -1, 0, 40, 10**(-10))
```

<br>

## 📈 Accuracy vs. Number of Iterations
The number of iterations $n$ required to reach a specific tolerance can be calculated mathematically.

```Python
import numpy as np

def bisect3(f, A, B, epsilon):
    a, b = A, B
    n = int(np.ceil(np.log2(abs(b - a) / epsilon)))
    for i in range(1, n + 1):
        if f(a) * f(b) >= 0:
            print('The method failed')
            return None
        m = (a + b) / 2
        if f(a) * f(m) < 0:
            b = m
        else:
            a = m
    return (a + b) / 2, n
```

<br>

## 📝 Exercises

1. Graph each function to determine the real roots and solve using the bisection method (accuracy $10^{-11}$):
* (i) $e^x + x + 1 = 0$
* (ii) $e^{-x} + x = 0$
* (iii) $x^3 - 9x^2 - x - 4\sin(x) + 2 = 0$

2. Determine how many real solutions $\sin(x) - \cos(x^2) = 0$ has in $[0, 4]$ and $[4, 6]$. Find the largest roots with accuracy $10^{-7}$.
