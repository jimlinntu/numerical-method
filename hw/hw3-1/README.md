# HW3-1

## Environment
* Ubuntu 18.04

## Compile
```
gcc main.cc -lm
```

## References
* <https://www.gnu.org/software/libc/manual/html_node/Arithmetic.html>
* <https://www.gnu.org/software/libc/manual/html_node/Signal-Handling.html>
* <https://www.gnu.org/software/libc/manual/html_node/Status-bit-operations.html>
* <https://en.cppreference.com/w/c/numeric/fenv/feraiseexcept>
* <https://stackoverflow.com/questions/33191530/how-to-solve-undefined-reference-to-functions-in-fenv-h-when-using-uclibc>
    * `strings /lib/x86_64-linux-gnu/libm.so.6 | grep -E ^fe`: `fe*` lives in math library.
* <https://stackoverflow.com/questions/11893996/why-does-the-order-of-l-option-in-gcc-matter>
