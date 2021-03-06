# HW3-1

## Environment
* Ubuntu 18.04

## Compile
```
gcc main.cc -lm
./a.out
```

## References
* <https://www.gnu.org/software/libc/manual/html_node/Arithmetic.html>
* <https://www.gnu.org/software/libc/manual/html_node/Signal-Handling.html>
* <https://www.gnu.org/software/libc/manual/html_node/Status-bit-operations.html>
* <https://en.cppreference.com/w/c/numeric/fenv/feraiseexcept>
* <https://stackoverflow.com/questions/33191530/how-to-solve-undefined-reference-to-functions-in-fenv-h-when-using-uclibc>
    * `strings /lib/x86_64-linux-gnu/libm.so.6 | grep -E ^fe`: `fe*` lives in math library.
* <https://stackoverflow.com/questions/11893996/why-does-the-order-of-l-option-in-gcc-matter>
* <https://www.gnu.org/software/libc/manual/html_node/Floating-Point-Parameters.html>
* <https://www.gnu.org/software/libc/manual/html_node/FP-Exceptions.html>
    * Alternatively, you can enable traps for exceptions. In that case, when an exception is raised, your program will receive the SIGFPE signal. The default action for this signal is to terminate the program. See Signal Handling, for how you can change the effect of the signal. 
* <https://www.gnu.org/software/libc/manual/html_node/Control-Functions.html>
    * `feenableexcept`: This function enables traps for each of the exceptions as indicated by the parameter excepts. The individual exceptions are described in Status bit operations. Only the specified exceptions are enabled, the status of the other exceptions is not changed. 
* <https://en.cppreference.com/w/cpp/numeric/fenv>
* <https://www.gnu.org/software/libc/manual/html_node/Defining-Handlers.html>
* <https://stackoverflow.com/questions/39431879/c-handle-signal-sigfpe-and-continue-execution>
* <https://www.gnu.org/software/libc/manual/html_node/Handler-Returns.html>
* <https://wiki.sei.cmu.edu/confluence/display/c/SIG35-C.+Do+not+return+from+a+computational+exception+signal+handler>
* <https://stackoverflow.com/questions/14233464/can-a-c-program-continue-execution-after-a-signal-is-handled>
    * According to POSIX, the behavior of a process is undefined after it ignores a **SIGFPE**, SIGILL, or SIGSEGV signal that was not generated by kill(2) or raise(3). Integer division by zero has undefined result. On some architectures it will generate a SIGFPE signal. (Also dividing the most negative integer by -1 may generate SIGFPE.) **Ignoring this signal might lead to an endless loop**.
* <https://man7.org/linux/man-pages/man2/sigaction.2.html>
    * `void handler(int sig, siginfo_t *info, void *ucontext)`
    * `SA_SIGINFO (since Linux 2.2)`
    *  If SA_SIGINFO is specified in sa_flags, then sa_sigaction (instead of sa_handler) specifies the signal-handling function for signum. This function receives three arguments, as described below.
    * The following values can be placed in si_code for a SIGFPE signal: 
