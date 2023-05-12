# Name: ......
# Id: ........
# sec: .......
# ===================================
# class definition
class Complex:
    def __init__ (self, real, complex):
        self.real = real
        self.complex = complex

    def __add__(self, a):
        reals = self.real + a.real
        complexs = self.complex + a.complex
        return Complex(reals,complexs)
    
    def __mul__(self,a):
        realp = (self.real*a.real) - (self.complex*a.complex)
        complexp = (self.real*a.complex) + (self.complex*a.real)
        return Complex(realp,complexp)
    
    def conjugate(self):
        return Complex(self.real,-1*self.complex)

    def magnitude(self):
        return ((self.real**2) + (self.complex**2))**0.5

    def __eq__(self,a):
        return self.real == a.real and self.complex == a.complex

    def __repr__(self):
        if self.complex>0:
            return f"{self.real} + {self.complex}i "
        return f"{self.real} - {-1*self.complex}i "

c1 = Complex(2, 3)
c2 = Complex(4,-7)

print("The first complex numbers: ", c1)
print("The second complex numbers: ", c2)
print("The conjugate of the second complex number: ", c2.conjugate())
print("Addition of the two complex numbers:", c1 + c2)
print("Multiplication of the two complex numbers:", c1 * c2)
print("The magnitude of |2 + 3i|: %.2f" % (c1.magnitude()))
if c1 == c2:
    print("The two numbers are equal")
else:
    print("The two numbers arent equal")
