import random

senior_citizen = 0
non_senior = 0
n = 100
i = 0
age = [random.randint(1,100) for i in range (n)]

while i<100:
	if age[i]>=65:
		senior_citizen +=1
	elif age [i]<65:
		non_senior+=1
	i+=1
	
print("After going through 100 people, there are %i seniors and %i non seniors"%(senior_citizen,non_senior))