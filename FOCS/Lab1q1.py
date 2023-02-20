# -*- coding: utf-8 -*-
"""
Created on Wed Jan 25 13:37:33 2023

@author: zayed
"""

import matplotlib.pyplot as plt
import numpy as np

fig, ax = plt.subplots()

n = np.linspace (-5,5)
ax.plot(n, 10*n**2, label= '$10n^2$')
ax.plot(n, 2*n**4-4*n**2, label= '$2n^4-4n^2$')

ax.legend()
