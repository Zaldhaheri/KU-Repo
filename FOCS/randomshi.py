# -*- coding: utf-8 -*-
"""
Created on Thu Jan 26 12:23:14 2023

@author: zayed
"""

num1 = int(input("enter num1: "))
num2 = int(input("enter num2: "))
num3 = int(input("enter num3: "))
print("Least number: ")
if num3>num1 and num2>num1:
    print(num1)
if num3>num2 and num1>num2:
    print(num2)
if num1>num3 and num2>num3:
    print(num3)