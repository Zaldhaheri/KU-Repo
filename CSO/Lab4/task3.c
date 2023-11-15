#include <stdio.h>
#include <math.h>

double distance(double x1, double y1, double x2, double y2)
{
    return sqrt(pow(x2-x1, 2) + pow(y2-y1, 2));
}


int main()
{
    double x[3];
    double y[3];
    int i = 0;
    while (i < 3)
    {
        printf("Enter x for point %d: ", i + 1);
        scanf(" %lf", &x[i]);
        printf("Enter y for point %d: ", i + 1);
        scanf(" %lf", &y[i]);
        i++;
    }

    double ab = distance(x[0],y[0],x[1],y[1]);
    double bc = distance(x[1],y[1],x[2],y[2]);
    double ca = distance(x[2],y[2],x[0],y[0]);

    printf("distance of point 1 to point 2 is: %.4lf\n", ab);
    printf("distance of point 2 to point 3 is: %.4lf\n", bc);
    printf("distance of point 3 to point 1 is: %.4lf\n", ca);

    int degree90 = -1;

    if (ab * ab + bc * bc == ca * ca)
        degree90 = 2;
    else if (ca * ca + ab * ab == bc * bc)
        degree90 = 1;
    else if (bc * bc + ca * ca == ab * ab)
        degree90 = 3;

    if (degree90 != -1)
    {
        printf("The point %d has a 90 degrees on x: %.4lf, y: %.4lf\n", degree90, x[degree90-1], y[degree90-1]);
    }
    
}