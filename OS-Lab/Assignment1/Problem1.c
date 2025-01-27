#include <stdio.h>
#include <stdlib.h>

int oddnum(int *arr)
{
    int count;
    int i;

    i = 0;
    count = 0;
    while(i < 4)
    {
        if (arr[i] % 2 != 0)
            count++;
        i++;
    }
    return (count);
}

int modulo5(int *arr)
{
    int count;
    int i;

    i = 0;
    count = 0;
    while (i < 4)
    {
        if (arr[i] % 5 == 0)
            count++;
        i++;
    }
    return (count);
}

float avgodd(int *arr)
{
    int count;
    int sum;
    int i;

    i = 0;
    count = 0;
    sum = 0;
    while(i < 4)
    {
        if (arr[i] % 2 != 0)
        {
            count++;
            sum += arr[i];
        }
        i++;
    }
    return ((float) sum / count);
}

float avg4(int *arr)
{
    int sum;

    sum = 0;
    for (int i = 0; i < 4; i++)
        sum += arr[i];
    return ((float) sum / 4.0);
}

int main(int argc, char **argv)
{
    int *arr;
    if (argc != 5)
    {
        printf("ERROR!");
        return (0);
    }
    arr = (int *) malloc(4 * sizeof(int));
    if (!arr)
        return (0);
    for (int i = 1; i <= 4; i++)
        arr[i - 1] = atoi(argv[i]);
    printf("The number of odd integers is: %d\n", oddnum(arr));
    printf("The number of integers mutiple of 5 is: %d\n", modulo5(arr));
    printf("The average of the odd integers is: %.2f\n", avgodd(arr));
    printf("The average of all the integers is: %.2f\n", avg4(arr));
    free(arr);
    return (0);
}