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