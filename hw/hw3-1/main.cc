#include <signal.h>
#include <stdio.h>
#include <fenv.h>

int main(){
    feraiseexcept(FE_OVERFLOW);
    return 0;
}

