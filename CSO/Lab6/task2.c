#include <stdio.h>
#include <stdlib.h>

int sumArray(int* arr, int n) {
    int total = 0;
    for (int iter = 0; iter < n; iter++) {
        total += arr[iter];
    }
    return total;
}

int main()
{
    int *arr;
    int n;
    printf("arr size = ");
    scanf(" %d", &n);
    arr = malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++)
    {
        printf("arr[%d] = ", i);
        scanf(" %d", &arr[i]);
    }
    printf("sum = %d\n", sumArray(arr, n));
}