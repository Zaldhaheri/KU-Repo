# -*- coding: utf-8 -*-
"""
Created on Mon Feb 13 12:23:19 2023

@author: zayed
"""

polygon_sides = {"square": '4', "triangle": '3', "octagon": '8'}
n_polygon = dict()

for k,v in polygon_sides.items():
    n_polygon[v]=k