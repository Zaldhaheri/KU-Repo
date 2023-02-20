# -*- coding: utf-8 -*-
"""
Created on Tue Jan 31 00:55:35 2023

@author: zayed
"""

weight = int(input("Input weight in pounds\n"))
height = int(input("input height in inches\n"))

bmi = (weight*703)/(height**2)

if bmi >= 18.5 and bmi <=25:
    print("normal bmi")
    
elif bmi < 18.5:
    print("underwight bmi")
    
else:
    print("overweight bmi")