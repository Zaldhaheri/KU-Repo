#include <stdio.h>
#include <stdbool.h>

typedef struct 
{
    int width;
    int length;
    int height;
} Cuboid;

void ScaleCuboid(int a, Cuboid *cuboid) 
{
    cuboid->width *= a;
    cuboid->length *= a;
    cuboid->height *= a;
}

int ComputeArea(Cuboid cuboid) 
{
    return 2 * (cuboid.height * cuboid.width + cuboid.height * cuboid.length + cuboid.width * cuboid.length);
}

int ComputeVolume(Cuboid cuboid) 
{
    return cuboid.height * cuboid.width * cuboid.length;
}

bool isCube(Cuboid cuboid) 
{
    return cuboid.height == cuboid.width && cuboid.height == cuboid.length;
}

int main() 
{
    Cuboid myCuboid = {3, 3, 3};
    printf("Initial dimensions: Width = %d, Length = %d, Height = %d\n", myCuboid.width, myCuboid.length, myCuboid.height);
    ScaleCuboid(2, &myCuboid);
    printf("Scaled dimensions: Width = %d, Length = %d, Height = %d\n", myCuboid.width, myCuboid.length, myCuboid.height);
    printf("Surface Area: %d\n", ComputeArea(myCuboid));
    printf("Volume: %d\n", ComputeVolume(myCuboid));
    if (isCube(myCuboid)) 
        printf("The cuboid is a cube.\n");
    else 
        printf("The cuboid is not a cube.\n");
    return 0;
}
