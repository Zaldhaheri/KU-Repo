# -*- coding: utf-8 -*-
"""
Created on Tue Jan 31 01:10:04 2023

@author: zayed
"""

ScoreA = int(input("Input the first test score\n"))
ScoreB = int(input("Input the second test score\n"))
ScoreC = int(input("Input the third test score\n"))
Avr = (ScoreA + ScoreB + ScoreC)/3

if Avr >= 90:
    Grade = "A"
    
elif Avr >= 80:
    Grade = "B"
    
elif Avr >= 70:
    Grade = "C"
    
elif Avr >= 60:
    Grade = "D"
    
else:
    Grade = "F"
    
print("The average test scores is %f and your letter grade is %s" %(Avr, Grade))
