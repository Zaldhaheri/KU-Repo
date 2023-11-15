#include <stdio.h>
#include <unistd.h>

void printBits(unsigned int x) {
    int numBits = 8;
    int i = numBits - 1;

    while(i >= 0)
    {
        if (x & 1 << i)
            write(1, "1", 2);
        else
            write(1, "0", 2);
        i--; 
    }
    printf("\n");
}

void shift(int x, int n)
{
    printBits(x >> n);
}

int main()
{
    int x;
    int n;
    printf("x = ");
    scanf(" %d", &x);
    printf("n = ");
    scanf(" %d", &n);
    shift(x, n);
    return (0);
}