#include <stdio.h>

int main()
{
    int N;
    int num;
    int arr;
    int count;
    int isOdd;

    isOdd = 0;
    printf("Please enter N the number of integers in the list: ");
    scanf(" %d", &N);
    if (N < 3 || N > 20)
    {
        printf("N must be between 3 and 20");
        return (0);
    }
    printf("Enter the %d numbers: \n", N);
    for (int i = 0; i < N; i++)
    {
        scanf(" %d", &num);
        if (num % 2 != 0)
            count++;
        else
            count = 0;

        if (count == 3)
            isOdd = 1;
    }
    printf("Three consecutive odd integers? ");
    if (isOdd)
        printf("YES");
    else
        printf("NO");
    return (0);
}