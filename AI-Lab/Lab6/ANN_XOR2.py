from sklearn.neural_network import MLPClassifier
import numpy as np
import matplotlib.pyplot as plt

# Define XOR input data and target output
X = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
Y = np.array([0, 1, 1, 0])

# Create an MLPClassifier with a larger hidden layer and different parameters
mlp = MLPClassifier(hidden_layer_sizes=(4,), activation='relu', solver='lbfgs', max_iter=10000, random_state=0)

# Fit the model to the data
mlp.fit(X, Y)


# Testing the trained model
predictions = mlp.predict(X)
print("Test results:", predictions)

# Visualization
labels = ['[0,0]', '[0,1]', '[1,0]', '[1,1]']
x = np.arange(len(labels))
width = 0.35
fig, ax = plt.subplots()
rects1 = ax.bar(x - width/2, Y, width, label='Actual')
rects2 = ax.bar(x + width/2, predictions, width, label='Predicted')
ax.set_ylabel('Values')
ax.set_title('Actual vs Predicted XOR outputs')
ax.set_xticks(x)
ax.set_xticklabels(labels)
ax.legend()
ax.bar_label(rects1, padding=3)
ax.bar_label(rects2, padding=3)
fig.tight_layout()
plt.show()