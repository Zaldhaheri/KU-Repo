# -*- coding: utf-8 -*-
"""
Created on Wed Jan 25 13:39:49 2023

@author: zayed
"""

import matplotlib.pyplot as plt
import numpy as np

fig, ax = plt.subplots()

n = np.linspace (-3,3)
ax.plot(n, 2**n, label= '$2^n$')
ax.plot(n, n**n, label= '$n^n$')

ax.legend()
