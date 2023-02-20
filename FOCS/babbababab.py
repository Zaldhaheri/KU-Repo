# -*- coding: utf-8 -*-
"""
Created on Mon Feb  6 14:25:07 2023

@author: zayed
"""

isPremiumCustomer = True
nbooksPurchased = 10

if isPremiumCustomer and 8<=nbooksPurchased:
	freeBooks = 2
elif isPremiumCustomer and 5<=nbooksPurchased:
	freeBooks = 1
elif not isPremiumCustomer and 12<=nbooksPurchased:
	freeBooks = 2
elif not isPremiumCustomer and 7<= nbooksPurchased:
	freeBooks = 1
else:
	freeBooks = 0
    
print(freeBooks)