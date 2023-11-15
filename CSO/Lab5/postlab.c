#include <stdio.h>

int main() {
    unsigned int num = 0xCDE8;
    unsigned int new_num = (num & 0xFF) | 0xAB00;
    printf("New number: 0x%X\n", new_num);
    unsigned int cd_num = (num >> 8) & 0xFF;
    printf("CD number: 0x%X\n", cd_num);
    return 0;
}