class class3:
    def __init__ (self):
        self.feet = 0
        self.inch = 0
        self.yard = 0
        self.furlong = 0
        self.mile = 0

    def set_inches(self, value):
        self.inch = value
    
    def set_feet(self,value):
        self.feet = value
    
    def set_yard(self,value):
        self.yard = value

    def set_furlong(self,value):
        self.furlong = value

    def set_mile(self,value):
        self.mile = value

    def get_inch(self):
        return self.inch
    
    def get_feet(self):
        return self.feet

    def get_yard(self):
        return self.yard
    
    def get_furlong(self):
        return self.furlong
    
    def get_mile(self):
        return self.mile
    
    def mile_to_inch(self):
        return self.mile * 8 * 220 * 3 * 12
    
    def mile_to_feet(self):
        return self.mile * 8 * 220 * 3
    
    def mile_to_yard(self):
        return self.mile * 8 * 220
    
    def mile_to_furlong(self):
        return self.mile * 8
    