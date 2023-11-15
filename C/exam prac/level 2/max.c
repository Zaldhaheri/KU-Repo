#include <stdlib.h>
#include <stdio.h>

int max(int *tab, unsigned int len)
{
    int i;
    int max;

    i = 0;
    if (len == 0)
        return (0);
    max = tab[i];
    while (i < len)
    {
        if (max < tab[i])
            max = tab[i];
        i++;
    }
    return (max);
}

int main()
{
    int *tab;

    tab = malloc(sizeof(int) * 3);
    tab[0] = -10;
    tab[1] = 10;
    tab[2] = 0;
    printf("%d\n", max(tab, 3));
}