#include <signal.h>
#include <stdlib.h>
#include <stdio.h>
#include <fenv.h>
#include <float.h>
#include <setjmp.h>

jmp_buf fpe;

void handler(int signum, siginfo_t *info, void *ucontext){
    if(fetestexcept(FE_OVERFLOW) == 0){
        fprintf(stderr, "fp exception %x at address %p\n", info->si_code, info->si_addr);
    }
    longjmp(fpe, 1);
}

int main(){
    if (feenableexcept(FE_OVERFLOW) == -1){
        fprintf(stderr, "[!] Enabling FE_OVERFLOW failed!\n");
        exit(1);
    }
    struct sigaction new_action, old_action;
    new_action.sa_flags = SA_SIGINFO;
    new_action.sa_sigaction = handler;
    sigemptyset(&new_action.sa_mask);

    if (sigaction(SIGFPE, &new_action, &old_action) != 0){
        fprintf(stderr, "[!] Setting SIGFPE handler failed!\n");
        exit(1);
    }

    double x = DBL_MIN;
    printf("min_normal = %g\n", x);
    x = x / 13.0;
    printf("min_normal / 13.0 = %g\n", x);
    x = DBL_MAX;
    printf("max_normal = %g\n", x);
    if(setjmp(fpe) == 0){
        x = x * x;
    }
    printf("max_normal = %g\n", x);

    return 0;
}

