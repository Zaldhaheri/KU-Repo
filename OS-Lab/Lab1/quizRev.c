#include <stdio.h>
#include <stdlib.h>

int multi(int x, int y, int j)
{
    return (x * y * j);
}

int main(int argc, char **argv)
{
    int i;
    int j;
    if (argc == 4)
    {
        int x = atoi(argv[1]);
        int y = atoi(argv[2]);
        int z = atoi(argv[3]);
        printf("Enter i: ");
        scanf("%d", &i);
        printf("Enter j: ");
        scanf("%d", &j);
        printf("x = %d\ny = %d\nz = %d\ni = %d\nj = %d\n", x, y, z, i, j);
        printf("multi(x, y, j): %d", multi(x, y, j));
    }
    else
    {
        if (argc < 4)
            printf("Error input amount is less than 4");
        else
            printf("Error input amount is more than 4");
    }
}