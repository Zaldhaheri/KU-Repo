#include <stdio.h>

void reorder(long x)
{
    int i = sizeof(x) - 1;
    int j = 0;
    unsigned char byte;
    while(i >= 0)
    {
        byte = (x >> (i * 8)) & 0xFF;
        printf("0xC%03X  0x%02X\n", j++, byte);
        i--;
    }
}

int main()
{
    long x = 0xAABBCCDDEEFF0011;
    reorder(x);
    return (0);
}