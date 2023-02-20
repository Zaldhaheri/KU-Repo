# -*- coding: utf-8 -*-
"""
Created on Wed Jan 25 13:39:46 2023

@author: zayed
"""

import matplotlib.pyplot as plt
import numpy as np

fig, ax = plt.subplots()

n = np.linspace (-3,3)
ax.plot(n, n**2+3*n+2, label= '$n^2+3n+2$')
ax.plot(n, n**2 , label= '$n^2$')

ax.legend()
