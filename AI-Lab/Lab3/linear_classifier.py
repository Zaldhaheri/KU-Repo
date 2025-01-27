import matplotlib.pyplot as plt
import numpy as np

def load_data(file_path):
    data = []
    with open(file_path, 'r') as file:
        for line in file:
            line = line.strip()
            if line:  # Skip empty lines
                length, lightness = map(float, line.split())
                data.append((length, lightness))
    return data

def compute_mean(data):
    length_sum = 0
    lightness_sum = 0
    num_samples = len(data)

    for length, lightness in data:
        length_sum += length
        lightness_sum += lightness

    mean_length = length_sum / num_samples
    mean_lightness = lightness_sum / num_samples

    return mean_length, mean_lightness
def classify_fish(fish_features, w1, w2, b):
        result = w1 * fish_features[0] + w2 * fish_features[1] + b
        if result > 0:
            return "Class 1 (Salmon)"
        else:
            return "Class 2 (Sea bass)"

def plot_perpendicular_bisector(salamon_mean, bass_mean):
    midpoint = ((salamon_mean[0] + bass_mean[0]) / 2, (salamon_mean[1] + bass_mean[1]) / 2)
    slope = (bass_mean[1] - salamon_mean[1]) / (bass_mean[0] - salamon_mean[0])
    perpendicular_slope = -1 / slope

    x_vals = np.linspace(min(salamon_mean[0], bass_mean[0]), max(salamon_mean[0], bass_mean[0]), 100)
    y_vals = midpoint[1] + perpendicular_slope * (x_vals - midpoint[0])

    plt.plot(x_vals, y_vals, 'k--', label='Perpendicular Bisector')



salamon_data = load_data("salamon.dat")
bass_data = load_data("bass.dat")

# Compute the means of class 1 (salamon) and class 2 (bass)
salamon_mean_length, salamon_mean_lightness = compute_mean(salamon_data)
bass_mean_length, bass_mean_lightness = compute_mean(bass_data)

# Compute the linear classifier parameters (w1, w2, and b)
w1 = bass_mean_lightness - salamon_mean_lightness
w2 = salamon_mean_length - bass_mean_length
b = (bass_mean_length * salamon_mean_lightness) - (salamon_mean_length * bass_mean_lightness)


# Plot the feature vector samples
plt.scatter(*zip(*salamon_data), c='r', label='Class 1 (Salamon)')
plt.scatter(*zip(*bass_data), c='b', label='Class 2 (Bass)')

# Plot the means
plt.scatter(salamon_mean_length, salamon_mean_lightness, c='r', marker='X', s=200, label='Class 1 Mean')
plt.scatter(bass_mean_length, bass_mean_lightness, c='b', marker='X', s=200, label='Class 2 Mean')
# Plot the line joining the means
plt.plot([salamon_mean_length, bass_mean_length], [salamon_mean_lightness, bass_mean_lightness], 'g--', label='Best Separating Line')

# Draw the perpendicular bisector
plot_perpendicular_bisector((salamon_mean_length, salamon_mean_lightness), (bass_mean_length, bass_mean_lightness))

plt.xlabel('Length')
plt.ylabel('Lightness')
plt.title('Feature Vector Samples and Perpendicular Bisector')
plt.legend()
plt.grid(True)
plt.show()


# Load data for the new fish instance
new_fish_data = load_data("FishData.dat")

# Classify the new fish instance
for fish_features in new_fish_data:
    classification = classify_fish(fish_features, w1, w2, b)
    print("Fish Feature Vector:", fish_features)
    print("New Fish Classification:", classification)
    print("---------------")