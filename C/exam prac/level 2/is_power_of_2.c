#include <stdio.h>

int is_power_of_2(unsigned int n)
{
    int i;

    i = 0;
    while (i * i <= n)
    {
        if (i * i == n)
            return (1);
        i++;
    }
    return (0);
}

int main()
{
    printf("%d", is_power_of_2(100));
}