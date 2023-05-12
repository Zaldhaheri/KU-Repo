class class1:
    def __init__ (self):
        self.feet = 0
        self.inch = 0
        self.yard = 0

    def set_inches(self, value):
        self.inch = value
    
    def set_feet(self,value):
        self.feet = value
    
    def set_yard(self,value):
        self.yard = value

    def get_inch(self):
        return self.inch
    
    def get_feet(self):
        return self.feet

    def get_yard(self):
        return self.yard
    
    def feet_to_inch(self):
        return self.feet * 12
    
    def yard_to_inch(self):
        return self.yard * 36
    
    def yard_to_feet(self):
        return self.yard * 3