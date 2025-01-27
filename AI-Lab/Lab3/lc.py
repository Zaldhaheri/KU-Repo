import numpy as np
import matplotlib.pyplot as plt

# Load the dataset
fb = np.loadtxt('bass.dat')
fs = np.loadtxt('salamon.dat')

# Plot two classes
plt.figure()
plt.plot(fb[:, 0], fb[:, 1], 'b*')
plt.xlim(1, 20)
plt.ylim(1, 20)
plt.xlabel('x1')
plt.ylabel('x2')
#plt.hold(True)
plt.plot(fs[:, 0], fs[:, 1], 'r+')

# Compute the mean of bass class and plot it
m1 = np.mean(fb, axis=0)
plt.plot(m1[0], m1[1], 'og', markersize=8, markerfacecolor='g')

# Compute the mean of salamon class and plot it
m2 = np.mean(fs, axis=0)
plt.plot(m2[0], m2[1], 'og', markersize=8, markerfacecolor='g')

# Compute the median of m1 & m2 and plot it
med = (m1 + m2) / 2
plt.plot(med[0], med[1], 'sg', markersize=8, markerfacecolor='g')

# Draw the line between m1 & m2
x = [m1[0], m2[0]]
y = [m1[1], m2[1]]
plt.plot(x, y, linewidth=3, color='y')

# Compute & display the best line separating two classes
# Unit vector defining the line m1m2
u = (m1 - m2) / np.linalg.norm(m1 - m2)
w1 = u[0]
w2 = u[1]
w = np.array([w1, w2])

b = np.dot(w, med)
print("Bias term (b):", b)

plt.show()
