#include <stdlib.h>
#include <stdio.h>

int *ft_rrange(int start, int end)
{
    int *result;
    int i;

    i = 0;
    if (start == end)
    {
        result = (int *) malloc(sizeof(int));
        result[i] = end;
    }
    else if (start < end)
    {
        result = (int *) malloc(sizeof(int) * (end - start + 1));
        while (start <= end )
            result[i++] = end--;
    }
    else if (start > end)
    {
        result = (int *) malloc (sizeof(int) * (start - end + 1));
        while (start >= end)
            result[i++] = end++;
    }
    return (result);
}

int main()
{
    int start = -1;
    int end = 2;
    int i = 0;
    int *r = ft_rrange(start, end);
    while (i <= 10)
    {
        printf("%d ", r[i]);
        i++;
    }
}