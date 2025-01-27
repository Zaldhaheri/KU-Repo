import math

def main():
  diameter = float ( input (" Please enter the diameter of the circle : \n") )
  radius = diameter /2
  area = math . pi * radius **2
  perimeter =2* math . pi * radius
  print("Results :")
  print(f" Radius : { radius :.2f}")
  print(f" Area : { area :.2f}")
  print(f" Perimeter : { perimeter :.2f}")
if __name__ == "__main__":
  main()
