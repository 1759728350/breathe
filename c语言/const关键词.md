#### const的意义
防止修饰的值被修改
像全局变量会被多个文件修改
因此在全局变量上加const可以阻止其他引用该变量的函数修改这个全局变量


修饰变量
不能再被赋值修改

修饰函数参数

修饰函数返回值

[指针相关没看懂](https://blog.csdn.net/little_rookie__/article/details/111873494?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167781273916800222850109%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167781273916800222850109&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-2-111873494-null-null.142^v73^pc_search_v2,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=const%E5%85%B3%E9%94%AE%E5%AD%97&spm=1018.2226.3001.4187)

##### const前后位置区别
```c
const char *p//指向内容不变
char* const p//指向位置不变,硬件资源常用,用得比较多
//像芯片位置都规定死了

    char s[10] = {'1','2','4'};
    char *p2 = s;
    p2[1] = '4';//可以修改

    //编译器提示无法修改
    const char *p1 = s;
    p1[1] = '3';//Read-only variable is not assignable



const char* const p//表示位置不变且该位置里的内容也不能变的
//多用于ROM空间
```

##### 字符串常量
字符串常量需要用const接收
[字符数组](./数组#####字符数组的定义方式)