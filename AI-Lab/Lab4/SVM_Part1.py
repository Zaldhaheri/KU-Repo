import numpy as np
import matplotlib.pyplot as plt
from sklearn import svm

np.random.seed(1)
r = np.sqrt(np.random.rand(100))
t = 2 * np.pi * np.random.rand(100)
data1 = np.column_stack((r * np.cos(t), r * np.sin(t)))
r2 = np.sqrt(3 * np.random.rand(100) + 1)   # Radius
t2 = 2 * np.pi * np.random.rand(100)        # Angle
data2 = np.column_stack((r2 * np.cos(t2), r2 * np.sin(t2)))  # Points
fig, ax = plt.subplots()
ax.plot(data1[:, 0], data1[:, 1], 'r.', markersize=15)
ax.plot(data2[:, 0], data2[:, 1], 'b.', markersize=15)
circle1 = plt.Circle((0, 0), 1, color='black', fill=False)
circle2 = plt.Circle((0, 0), 2, color='black', fill=False)
ax.add_artist(circle1)
ax.add_artist(circle2)
ax.set_aspect('equal', 'box')
ax.set_xlim([-2.5, 2.5])
ax.set_ylim([-2.5, 2.5])
plt.show()

data3 = np.vstack((data1, data2))
theclass = np.ones(200)
theclass[:100] = -1

clf = svm.SVC(kernel='rbf', C=1e10)
clf.fit(data3, theclass)
d = 0.02
x1Grid, x2Grid = np.meshgrid(np.arange(data3[:, 0].min(), data3[:, 0].max(), d),
                             np.arange(data3[:, 1].min(), data3[:, 1].max(), d))
xGrid = np.c_[x1Grid.ravel(), x2Grid.ravel()]
labels = clf.predict(xGrid)
scores = clf.decision_function(xGrid)
plt.figure(figsize=(10, 6))
scatter1 = plt.scatter(data3[theclass == -1][:, 0], data3[theclass == -1][:, 1], c='r', label='-1')
scatter2 = plt.scatter(data3[theclass == 1][:, 0], data3[theclass == 1][:, 1], c='b', label='+1')
contour = plt.contourf(x1Grid, x2Grid, scores.reshape(x1Grid.shape), levels=[-1, 0, 1], alpha=0.3, colors=['r', 'b', 'g'])
scatter3 = plt.scatter(clf.support_vectors_[:, 0], clf.support_vectors_[:, 1], facecolors='none', edgecolors='k', s=100, label='Support Vectors')
plt.title('SVM Classifier with RBF Kernel')
plt.xlabel('X1')
plt.ylabel('X2')
plt.legend(handles=[scatter1, scatter2, scatter3])
plt.grid(True)
plt.show()