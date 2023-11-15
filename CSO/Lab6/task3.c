#include <stdio.h>

long switch_eg (long x, long y, long z)
{ 
    long w = 1;
    switch(x) {
        case 1: w = y*z;
            break;
        case 2: //fall-through case
            w = y/z;
        case 3:
            w += z;
            break;
        case 5: //fall-through case

        case 6:
            w -= z;
            break;

        default:
            w = 2;
    }
    return w;
}
