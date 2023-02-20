# -*- coding: utf-8 -*-
"""
Created on Mon Feb 13 14:43:26 2023

@author: zayed
"""

d1,d2={2:3,8:19,6:4,5:12},{2:5,4:3,3:9}
d3 = dict()
for a,b in d1.items():
    if not a in d2.keys():
        d3[a]=b
        
for a,b in d2.items():
    if not a in d1.keys():
        d3[a]=b
            

            
    
