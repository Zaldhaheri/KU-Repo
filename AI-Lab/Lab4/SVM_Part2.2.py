import numpy as np
import matplotlib.pyplot as plt
from sklearn import svm

def robust_load(filename):
    with open(filename, 'r') as f:
        lines = f.readlines()
    cleaned_lines = filter(lambda x: x.strip() != '', lines)  # Filter out empty lines
    data = np.array([list(map(float, line.split())) for line in cleaned_lines])
    return data

F_b = robust_load('bass_v2.dat')
F_s = robust_load('salamon_v2.dat')

plt.figure()
plt.scatter(F_b[:, 0], F_b[:, 1], marker='*', color='b', label='Class 1 (Bass)')
plt.scatter(F_s[:, 0], F_s[:, 1], marker='+', color='r', label='Class 2 (Salamon)')
plt.xlim(1, 20)
plt.ylim(1, 20)
plt.xlabel('x1')
plt.ylabel('x2')
plt.legend()
plt.grid(True)
plt.show()

nbr_samples_Fb = F_b.shape[0]
nbr_samples_Fs = F_s.shape[0]

vec_1 = np.ones(nbr_samples_Fb)   # label of class seabass set to 1
vec_2 = -np.ones(nbr_samples_Fs)  # label of class salamon set to -1

train_data = np.vstack((F_b, F_s))
label_train_data = np.hstack((vec_1, vec_2))

# Train the SVM classifier
clf = svm.SVC(kernel='rbf', C=1, class_weight={-1: 1, 1: 1})
clf.fit(train_data, label_train_data)

d = 0.2
x1Grid, x2Grid = np.meshgrid(np.arange(train_data[:, 0].min(), train_data[:, 0].max(), d),
                             np.arange(train_data[:, 1].min(), train_data[:, 1].max(), d))
xGrid = np.c_[x1Grid.ravel(), x2Grid.ravel()]  # The test data

# Classify the test data
labels = clf.predict(xGrid)

# Get decision scores
scores = clf.decision_function(xGrid)
print(labels)
print(scores)


plt.figure(figsize=(10,8))

colors = ['r' if y == -1 else 'b' for y in label_train_data]
class_1 = plt.scatter(train_data[label_train_data == -1][:, 0], train_data[label_train_data == -1][:, 1], c='r', marker='.')
class_2 = plt.scatter(train_data[label_train_data == 1][:, 0], train_data[label_train_data == 1][:, 1], c='b', marker='.')

support_vectors = plt.scatter(clf.support_vectors_[:, 0], clf.support_vectors_[:, 1], facecolors='none', edgecolors='k', s=100)

contour = plt.contour(x1Grid, x2Grid, scores.reshape(x1Grid.shape), levels=[0], colors='k')
plt.clabel(contour, inline=1, fontsize=10)

plt.title('SVM Classifier with RBF Kernel')
plt.xlabel('x1')
plt.ylabel('x2')
plt.legend([class_1, class_2, support_vectors], ['-1', '+1', 'Support Vectors'])
plt.grid(True)
plt.axis('equal')
plt.show()

filtered_data = []

with open('FishData.dat', 'r') as f:
    for line in f:
        values = line.strip().split()
        if all(value.replace('.', '', 1).isdigit() for value in values):
            filtered_data.append([float(value) for value in values])

F = np.array(filtered_data)
labels = clf.predict(F)
Classified_fish = np.column_stack((F, labels))
np.savetxt('FishData_classified.dat', Classified_fish, delimiter=' ', fmt='%f')