# -*- coding: utf-8 -*-
"""
Created on Wed Jan 25 13:39:01 2023

@author: zayed
"""

import matplotlib.pyplot as plt
import numpy as np

fig, ax = plt.subplots()

n = np.linspace (0,10)
ax.plot(n, 2*n**3-10, label= '$2n^3-10$')
ax.plot(n, 50*n**2+10, label= '$50n^2+10$')

ax.legend()
