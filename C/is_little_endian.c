#include <stdio.h>
#include <limits.h>

void printBits(unsigned int x) {
    int i;
    int numBits = 4; // Calculate the number of bits in an int

    for (i = numBits - 1; i >= 0; i--) {
        unsigned int mask = 1 << i;
        putchar((x & mask) ? '1' : '0');
    }
    putchar('\n');
}

int is_little_endian()
{
    unsigned int x = 0x12345678;
    char *c = (char*) &x;
    return (*c == 0x78);
}

unsigned replace_byte(unsigned x, int i, unsigned char b)
{
    int i8 = i * 8;
    unsigned byte = 0xFF << i8;
    return (x & ~byte) | (b << i8);
}

int bit_a(int x)
{
    return !!x;
}

int bit_b(int x)
{
    return !x;
}

int bit_c(int x)
{
    return !!(x & 0xFF);
}

int bit_d(int x)
{
    return !!(~x & 0xFF);
}

int int_shifts_are_arithmetic()
{
    int x = ~0;
    return (x >> 1) == x;
}

unsigned srl (unsigned x, int k)
{
    unsigned xsra = (int) x >> k;
    unsigned byte = (unsigned) ~0 >> k;
    return xsra & byte;
}

int sra (int x, int k)
{
    unsigned w = sizeof(int) << 3;
    int xsrl = (unsigned) x >> k;
    int sign = x & 1 << (w - 1);
    int byte = ((1 << k) - 1) << (w - k);
    (sign) && (xsrl |= byte);
    return xsrl;
}

int any_odd_one(unsigned x)
{
    return !!(x & 0b10101010);
}

int odd_ones(unsigned x)
{
    x ^= x >> 16;
    x ^= x >> 8;
    x ^= x >> 4;
    x ^= x >> 2;
    x ^= x >> 1;
    return x & 1;
}

int leftmost_one(unsigned x)
{
    x |= x >> 16;
    x |= x >> 8;
    x |= x >> 4;
    x |= x >> 2;
    x |= x >> 1;
    return x ^ (x >> 1);
}

int int_size_is_32()
{
    int set_msb = INT_MIN;
    int beyond_msb = 1 << 15;
    beyond_msb <<= 15;
    beyond_msb <<= 2;
    return set_msb && !beyond_msb;
}

int lower_one_mask(int x, int n)
{
    int mask = (2 << (n - 1)) - 1;
    return mask & x;
}

unsigned rotate_left(unsigned x, int n)
{
    int w = sizeof(x) << 3;
    int left = (x << (w - n - 1)) << 1;
    int right = x >> n;
    return left + right;
}

int fits_bits(int x, int n)
{
    int mask = ~((1 << (n - 1)) -1 );
    x &= mask;
    return !x || x == mask;
}

void show_long(long x, int size)
{
    while(size >= 0 && x != 0)
    {
        printf("%02lX\n", 0xFF & x);
        x >>= 8;
        size -= 2;
    }
}

void show_int(short *x)
{
    unsigned int i = 0;
    while(i < 2)
    {
        printf("%.4X", *x >> 16);
        *x = *x >> 16;
        i++;
    }
}

int main()
{
    unsigned short X = 53191;
    unsigned short Y = 40516;
    unsigned int Z1 = X * Y;
    printf("%d", Z1);

}