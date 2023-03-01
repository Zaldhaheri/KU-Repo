my_List=[1,2,3,4,5,6,7,8]
new_List=[]

for i in my_List:
    if my_List[i-1]%2==0:
        new_List.append(my_List[i-1])

print(new_List)