#include <stdio.h> 

int main() 
{ 
int i; 
char *test_string; 
scanf("%d", &i); 
if (i == 1) 
{ 
test_string = "Введено значение 1"; 
} 
printf("i=%d\n", i); 
printf("test_string=%s", test_string); 
return 0; 
}
