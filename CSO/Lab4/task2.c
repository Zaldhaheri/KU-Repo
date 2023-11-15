#include <stdio.h>

int main()
{
    double arr[5];
    double input;
    double pi = 3.14;
    int i = 0;
    double temp;
    printf("Enter 5 values of diameter\n");
    while(i < 5)
    {
        printf("diameter %d: ", i+1);
        scanf(" %lf", &input);
        arr[i] = input;
        i++;
    }

for (i = 0; i < 4; i++) {
    for (int j = 0; j < 4 - i; j++) {
        if (arr[j] < arr[j + 1]) {
            temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
    printf("\n");
    i = 0;
    while (i < 5)
    {
        if (arr[i] > 0)
            printf("%d) Diameter: %.3lf, Perimeter: %.3lf, Area: %.3lf\n", i, arr[i], pi*arr[i], 0.25*pi*arr[i]*arr[i]);
        else
            printf("%d) Diameter: %.3lf cant be negative\n", i, arr[i]);
        i++;
    }
}