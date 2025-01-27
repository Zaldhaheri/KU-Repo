import numpy as np
import matplotlib.pyplot as plt

epochs = 1000
alpha = 0.05
hidden_units = 70

def train_network(epochs):
    W1 = np.random.rand(hidden_units, 2)
    W2 = np.random.rand(1, hidden_units)

    for step in range(epochs):
        x = np.array([2 * np.random.rand() - 1, 1])
        y = 2 * x[0]**2 - 2

        # Feedforward
        a1 = np.tanh(np.dot(W1, x))
        h = np.dot(W2, a1)

        # Backpropagation
        error = y - h
        W2 += alpha * error * a1
        derivative = (1 - a1) * (1 + a1)
        W1 += alpha * error * np.outer(derivative * W2, x)

    return W1, W2

# Testing function
def test_network(W1, W2, X_test):
    predictions = []
    for x in X_test:
        a1 = np.tanh(np.dot(W1, x))
        h = np.dot(W2, a1)
        predictions.append(h)
    return predictions

X_test = np.array([[x, 1] for x in np.linspace(-1, 1, 100)])
y_test = [2 * x[0]**2 - 2 for x in X_test]

# Training and Testing
W1, W2 = train_network(epochs)
predictions = test_network(W1, W2, X_test)

# Visualization
plt.figure()
plt.plot(X_test[:, 0], y_test, label='Target Output')
plt.plot(X_test[:, 0], predictions, label='Predicted Output', linestyle='dashed')
plt.title(f"Epochs: {epochs}")
plt.legend()
plt.show()

# Accuracy calculation (Mean Squared Error in this case)
mse = np.mean((np.array(predictions) - y_test) ** 2)
print(f"Mean Squared Error for {epochs} epochs: {mse}")