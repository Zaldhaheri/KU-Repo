/* 
* man.c
* My first C program
* By <Zayed>
* created 27/02/2023
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *longestCommonPrefix(char ** strs, int strsSize){


    int prefixlen = strlen(strs[0]);
    for (int i = 0; i < strsSize; i++)
    {
        for (int j = 0; j < prefixlen; j++)
        {
            if (strs[0][j] != strs[i][j])
            {
                prefixlen = j;
            }
        }
    }

    char *result = (char*)malloc(prefixlen + 1);
    for (int i = 0; i < prefixlen; i++){
        result[i] = strs[0][i];
    }
    result[prefixlen] = '\0';


    return result;
}


int main()
{
    char *strs[] = {"flow","flowers","floght"};
    int strsSize = 3;
    char *r = longestCommonPrefix(strs,strsSize);
    printf("%s\n",r);
    free(r);

}


