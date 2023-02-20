# -*- coding: utf-8 -*-
"""
Created on Tue Jan 31 00:10:24 2023

@author: zayed
"""

num = int(input("Input seconds to convert to hours, minutes and seconds \n"))

while num>=3600:
    hours = int(num/3600)
    num = int(num-(hours*3600))

while num>=60:
    minutes = int(num/60)
    num = int(num-(minutes*60))  

seconds = num
print (hours , " hours, ", minutes, " minutes, ",seconds, " seconds ")
