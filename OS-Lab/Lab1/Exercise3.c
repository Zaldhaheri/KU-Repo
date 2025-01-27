#include <stdio.h>
#include <stdlib.h>

int find_max(int a, int b, int c)
{
    if (a > b && a > c)
        return a;
    else if (b > c && b > a)
        return b;
    else
        return c;
}

int main(int argc, char **argv)
{
    if (argc == 3)
    {
        int n;
        printf("Enter a 3rd number: ");
        scanf(" %d", &n);
        printf("Max: %d\n", find_max(atoi(argv[1]), atoi(argv[2]), n));
    }
    else
        printf("enter two numbers\n");
}

// int main()
// {
//     int n;
//     int i = 2;
//     printf("Enter a number from 1 to n: ");
//     scanf(" %d", &n);
//     while(i <= n)
//     {
//         if (i % 2 == 0)
//             printf("%d ", i);
//         i++;
//     }
// }