import numpy as np

# Define XOR input data and target output
X = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
Y = np.array([[0], [1], [1], [0]])

# Define network architecture
input_size = 2
hidden_size = 2
output_size = 1
learning_rate = 0.1
epochs = 10000

# Initialize weights and biases
np.random.seed(0)
weights_input_hidden = np.random.uniform(size=(input_size, hidden_size))
biases_hidden = np.zeros((1, hidden_size))
weights_hidden_output = np.random.uniform(size=(hidden_size, output_size))
biases_output = np.zeros((1, output_size))

# Sigmoid activation function and its derivative
def sigmoid(x):
    return 1 / (1 + np.exp(-x))

def sigmoid_derivative(x):
    return x * (1 - x)

# Training loop
for epoch in range(epochs):
    # Forward propagation
    hidden_input = np.dot(X, weights_input_hidden) + biases_hidden
    hidden_output = sigmoid(hidden_input)
    output_input = np.dot(hidden_output, weights_hidden_output) + biases_output
    output = sigmoid(output_input)

    # Calculate loss
    loss = Y - output

    # Backward propagation
    d_output = loss * sigmoid_derivative(output)
    error_hidden = d_output.dot(weights_hidden_output.T)
    d_hidden = error_hidden * sigmoid_derivative(hidden_output)

    # Update weights and biases
    weights_hidden_output += hidden_output.T.dot(d_output) * learning_rate
    biases_output += np.sum(d_output, axis=0, keepdims=True) * learning_rate
    weights_input_hidden += X.T.dot(d_hidden) * learning_rate
    biases_hidden += np.sum(d_hidden, axis=0, keepdims=True) * learning_rate


# Testing the trained network
test_input = np.array([[0, 0], [0, 1], [1, 0], [1, 1]])
hidden_input = np.dot(test_input, weights_input_hidden) + biases_hidden
hidden_output = sigmoid(hidden_input)
output_input = np.dot(hidden_output, weights_hidden_output) + biases_output
predicted_output = sigmoid(output_input)

print("Predicted Output:")
print(predicted_output)