# Bisection Method
The bisection method consists in:

1. Chose an initial interval *[a, b]*, such that f(a)f(b)<0.
2. The midpoint of the interval m = (a + b)/2.
3. Determine if f(m) > 0 or f(m) < 0.
4. Choose the new interval to be [a, m] if f(a)f(m) < 0. Otherwise choose [m, b].
5. Repeat the process until the gap size is smaller than a pre-se tolerance ϵ or a maximum number of iterations N.

<br>

* **Advantages:** Always convergent and can be used as a starter for more accurate methods. Since the intervals containing the roo are halved at each iteration, we can predict the error in the solution.
* **Disadvantages:** Linear convergence (slow), each step reduced by half. Does not work for determining multiple roots

---

<br>

## Finding the roots
> The first approach to finding the real roots of an algebraic equation is to graph it.

<br>

* **matplot:** used to graph representations
* **sympy:** used to simplify algebric symbols



---

<br>

Let us determine the approximate position of the real roots of cos(x) + x + 1 = 0 (if any) graphically:

```
from matplotlib.pyplot import *
from sympy import *
init_printing()

x = symbols('x')
f = Lambda(x, cos(x) + x + 1)
f(x)

plot(f(x), (x, -6, 6))
```

<br>

With this graph we can see that the equation has only one real root.

---

<br>

Now, to determinate the root with great accuracy and precision of: **x^4 - sin(x) - 1 = 0**

```
from matplotlib.pyplot import *
from sympy import*
init_printing()

x = symbols('x')

f = Lambda(x, x**4-sin(x)-1)
f(x)

plot(f(x), (x, -1.5, 1.5))
```

<br>

The negative root(range [-1, 0]):
```
a = -1
b = 0
for n in range(1, 30)
  m1(a+b)/2
  if f(m1)*f(a)<0:
    b=m1
  else
    a=m1
print(m1)
```

<br>

The positive root(range [1, 1.5]):
```
a = 1
b = 1.5

for n in range (1, 30):
  m2 = (a + b)/2
  if f(m2)*f(a)<0:
    b = m2
  else: 
    a = m2
print(m2)
```

---

<br>

## Encapsulating
We can encapsulate the above commands in a function that has as inputs 
the function *f* whose zeros we want to find, the extremes A and B of the initial 
interval and the number of interations N, where the root is the output.

```
def bisect1(f, A,B,N):
  a = A
  b = B
  if f(a) *f(b)>= 0:
    print(f'The method failed')
    return None
  for n in range (1, N + 1):
    m = (a + b)/2
    if f(a)*f(m)<0;
      b = m
    else:
      a = m
  return (a + b) / 2

  r1 = bissect1(f, -1,0,20)
  r2=bisect1(f,0,2,20)
```

---

<br>

A procedure that has as inputs function *f* whose zeros we want to find, the extremes *A* and *B* of
the initial interval, the maximum number of interations *N* and the tolerance ϵ of the interval that contains 
the root. As output we have the root and the number of iterations performed.

```
def bisect2(f, A, B, Nmax, epsilon):
  a = A
  b = B
  erro = 1
  n = 0
  while erro>epsilon and n<Nmax:
    if f(a)*f(b)>=0:
      print('The method failed')
        return None
    m = (a + b) / 2
    if f(a)*f(m)<0:
      b = m
    else: 
      a = m
    erro = abs (a - b)
    n = n + 1
  return (a + b) / 2, n

  r1 = bisect2(f, -1,0,40,10**(-10))
  R1=r1[0]

  r2 = bisect2(f,0,2,40,10**(-10))
  R2=r2[0]
```

---

<br>

## Relationship between accuracy and number of iterations

```
def bisect3(f,A,B,epsilon):
    a=A
    b=B
    n = int(np.ceil(np.log2(abs(b-a)/epsilon)))
    for i in range(1, n+1):
        if f(a)*f(b)>=0:
            print('The method failed')
            return None
        m=(a+b)/2
        if f(a)*f(m)<0:
            b=m
        else:
            a=m
    return (a+b)/2,n
```

## Exercises



1. In the items below, graph each function to determine the real roots (if any) and their number. Then determine each one of them through the bisection method, with an interval accuracy of 10−11, determining the necessary number of iterations.

(i) ex+x+1=0,

(ii) e−x+x=0,

(iii) x3−9x2−x−4sinx+2=0.

2. Determine how many real solutions the equation sinx−cos(x2)=0 has in the interval [0,4] and how many in the interval [4,6]. Numerically determine the largest roots in each interval, with an interval accuracy of 10−7.
