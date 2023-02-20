# -*- coding: utf-8 -*-
"""
Created on Mon Feb 13 15:18:06 2023

@author: zayed
"""


has_dups=False
list1 = (1,2,3,2)
set1 = set(list1)

print (len(list1))
print (len(set1))
if len(list1)!=len(set1):
    has_dups=True