#include <stdio.h>

int main()
{
    float f;
    float sum = 0;
    int count = 0;
    int i = 1;
    printf("Enter 5 numbers of 6 decimal values\n");

    while(i <= 5)
    {
        printf("number %d: ", i);
        scanf(" %f", &f);
        int ft = (int) f;
        if ((ft - f) == 0)
        {
            sum += f;
            count++;
        }
        i++;
    }

    if (count > 0)
        printf("The estimated number is %.2f\n", sum/count);
    else
        printf("No valid numbers\n");
}