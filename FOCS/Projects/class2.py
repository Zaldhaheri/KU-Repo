class class2:
    def __init__ (self):
        self.feet = 0
        self.inch = 0
        self.yard = 0
        self.furlong = 0

    def set_inches(self, value):
        self.inch = value
    
    def set_feet(self,value):
        self.feet = value
    
    def set_yard(self,value):
        self.yard = value

    def set_furlong(self,value):
        self.furlong = value

    def get_inch(self):
        return self.inch
    
    def get_feet(self):
        return self.feet

    def get_yard(self):
        return self.yard
    
    def get_furlong(self):
        return self.furlong
    
    def furlong_to_inch(self):
        return self.furlong * 220 * 36
    
    def furlong_to_feet(self):
        return self.furlong * 220 * 3
    
    def furlong_to_yard(self):
        return self.furlong * 220
    