## 查询  

#### 思路
![](img/Pasted%20image%2020230318001937.png)
查询全体学生的姓名及其出生年份。  
```sql  
select sname, year(getdate())-age as birthday from S  
##year()获取时间参数中的年份  
##getdate()获取当前时间  
```  
  
![](img/Pasted%20image%2020221226175525.png)  
![](img/Pasted%20image%2020221226182019.png)  
#### distinct去重  
加载查询属性前面  
```sql  
select distinct sno from SC where grade < 60  
```  
  
#### in集合包含  
```sql  
##查询计算机科学系(CS),数学系(MA)和信息系(IS)学生的姓名和性别。  
select sname,ssex from student   
where sdept in('CS','MA','IS');  
##当in中需要多个值就用圆括号括起来  
```  
  
#### like字符匹配模糊查询  
##### 三种通配符  
%:0-多个字符,比如:例a%b->acb,ab,acccccb都符合  
\_:只能一个字符,比如:例a_b->acb,aeb,aab符合    
\[\]:方框表示在范围内的任意一个数
```sql
[a-d]表示a到d中其中一个字母
[0-9]表示从0到9的任意一个数都可以
[012]表示0,1,2这三个数中任意一个都可以
```
当要查的就是上面两个符号时用escape转义'\\'->DB%=>like 'DB\\%' escape'\\'   
![](img/Pasted%20image%2020230316233540.png)
```sql  
##查询所有姓“刘”的学生的姓名、学号和性别  
select sno,sname,ssex from student where  
sname like '刘%';   
##查询姓“李”且全名最多为3个汉字的学生的姓名  
where sname like '李__' or sname like '李_' ##后面的sanme不能省  
```  
  
escape转义可以用其他符号,比如0  
![](img/Pasted%20image%2020221228205924.png)  
  
  
#### orderby  
从 SC表中输出学习“C1”号课程的成绩在前3名的学生的学号和成绩  
```sql  
select top 3 sno,grade from SC where cno = 'C1'  
order by grade desc  
##查询最高的几个就是倒序,用DESC  
```  
##### 百分比  
top的使用  
top n前几个  
top n percent前百分比  
top加在属性前面  
  
#### 聚合函数  
![](img/Pasted%20image%2020221228212006.png)  
只有count(\*)不忽略空值 <font color=#66CC99 style=" font-weight:bold;">count(属性列)会忽略空值!!!</font>  
其他聚合函数都忽略空值  
![](img/Pasted%20image%2020230316232018.png)
```sql  
select count(*) as '学生人数' from student   
```  
2、查询S表中所有学生的平均年龄，最大年龄，最小年龄以及年龄的和  
```sql  
select avg(age),max(age),min(age),sum(age)  
from S  
```  
  
#### groupby  
对数据分组,然后聚合函数会对每个分组有效  
查询结果<font color=#66CC99 style=" font-weight:bold;">涉及到聚合函数才用groupby</font>  
即<font color=#66CC99 style=" font-weight:bold;">当聚合函数需要得到多个结果时,就用groupby</font>  
因为聚合函数本身只能得到一个结果  
  
查询每个院系的学生人数  
```sql  
select sdept,count(*) from student  
group by sdept;  
##这个count(*)聚合函数是对分组后的数据进行作用的  
```  
  
#### having  
<font color=#F09B59 style=" font-weight:bold;">只有在使用groupby时才会用having</font>  
where是在groupby<font color=#66CC99 style=" font-weight:bold;">之前执行</font>的  
<font color=#66CC99 style=" font-weight:bold;">having是对分组聚合后的数据进行处理</font>  
  
查询每个院系女生人数。只显示女生人数超过100人的院系名和女生人数  
```sql  
select sdept,count(sno) as '女生人数' from student  
where sex = '女'  
group by sdept  
having count(sno) > 100  
```  
查询选修了4门以上课程的学生的学号。  
```sql  
select sno from sc  
group by sno  
having count(*) > 4 ##where在groupby之前执行  
##因此此处不能用where,必须用having  
```  

##### having和where的区别
求选修C4号课程的学生平均年龄  
```sql
##where在聚合查询之前过滤内容
##having对聚合查询的结构进行过滤  
select avg(age) '平均年龄' from s,sc
where s.sno = sc.sno and sc.cno = 'c4';
```

#### 联合查询  
没考过  
  
  
#### 多表查询  
1、查询计算机系女生的考试成绩，要求显示学号，姓名，课程号和考试成绩  
```sql  
select sname,s.sno .....  
join sc on s.sno = sc.sno  
where sex = '女' and sdept = '计算机系'  
```  
  
2、查询计算机系男生的选学课程名，要求显示学号，姓名，选学课程名  
```sql  
select s.sno,sname,c.cname from s  
join sc on s.sno = sc.sno  
join c on c.cno = sc.cno  
where sdept = '计算机系' and sex = '男'  
```  
多表连接还可以用where条件代替join  
from S,SC where sc.sno = s.sno and 条件  

#### 子查询
![](img/Pasted%20image%2020230316231107.png)

## 存储过程
一般考选择题,游标考纲有单从来没有考过  
### Tsql
全局变量 两个@@开头  
不能自己定义   

局部变量 一个@开头  
##### 变量申明和赋值
```sql
declare @x1 int,@x2 char(10)

//局部变量修改方式,前面加select或set
select @x1 = 100;
set @x2 = '200';
//输出
print '我的银行卡密码是'+@x1  //我的银行卡密码是100
```



### 存储过程
系统存储过程以sp_开头  
扩展存储过程以xp_开头  
用户自定义存储过程

```sql
create procedure pro1
@stuNumber char(7)
as
select * from student where sno = @stuNumber;
```
怎么调用执行这段代码?  
execute+传参数  
```sql
execute pro1 '1234567'//execute可以简写为exec
```

创建存储过程pro3.向课程表中插入一条记录
```sql
create procedure pro3
@sno char(7),@sname char(7),@credit int
as
insert into c(sno,sname,grade)
values(@sno,@sname,@credit)

exec pro3 '1111','lyh',120
```
创建带有输入参数的存储过程proc_del，用于删除S表中指定学号的学生信息
```sql
create procedure proc_del 
@sno char(7)
as
delete from s where s.sno = @sno;
```

##### 变参输出
什么时候加output?  
执行时加output接收值,创建过程声明变量时标记要return的变量也要加  

创建存储过程查对应学生生日并输出    
```sql
create procedure pro
@sno char(7),@birth datetime output   
as
select @birth =year(getdate()) - age from s
where sno = @sno;

//声明一个变量来接收输出的生日
delcare @birth datetime
exec pro '00111' @birth output
//输出
print'生日是'+str(@birth)
```
在教学管理数据库中，创建一个PV_GRADE的存储过程,输入一个学生的姓名，输出其总成绩和平均成绩  
```sql
create procedure PV_GRADE
@sname char(7),@sum int output,@avg real output  //real浮点类型
as
select sum(grade),avg(grade) from s join sc
on sc.sno = s.sno
where sname = @sname

delcare @sum int,@avg real
exec PV_GRADE '0011' @sum output,@avg output
print'总成绩:'+str(@sum)+'平均成绩'+str(@avg)
```



##### 修改和删除存储过程
修改alter后面和create一样  
删除存储过程就一个drop procedure 名就可以了  

##### 总结
T-SQL中的变量分为:    
全局变量，也叫系统变量，名字以@@开头，且不能自定义，具有的含义是由系统定义好的，直接使用。    
自定义变量，也就局部变量，名字以@开头，由用户根据需要定义。    
2、T-SQL中声明变量的语句??  
declare局部变量名变量类型  
3、T-SQL中给变量赋值的语句??  
select局部变量名=值  
或  
set局部变量名=值  
4、T-SQL中输出变量的语句??    
print局部变量名|全局变量名|表达式  
注: print后输出的值必须是字符串类型  


## 触发器
<font color=#66CC99 style=" font-weight:bold;">ddl的触发器一般不考</font>
触发器是一种特殊类型的存储过程.通过事件进行触发被自动调用

1、DML触发器  
当数据库服务器中发生数据操作语言(DML-insert, update, delete)事件时执行的存储过程，  
2、DDL触发器  
当数据库服务器中发生数据定义语言(DDL-create, alter, drop)事件时执行的存储过程。只有后触发。

#### 前后触发器
后触发 for after  
前出发 instead of  

1、在教学管理数据库中，为学生表S创建一个简单的DML触发器S_I_U，在插入和修改数据时自动显示提示信息。
```sql
create trigger S_I_U
on S
for
insert,update
as
print'对S表进行了插入或修改'
```

2、修改上例子中触发器S_I_U，使得对学生表S进行添加或修改之前自动给出错误提示信息。
```sql
create trigger S_I_U
on S
instead of
insert,update
as
print'错误信息'
```

##### 触发器临时表
原表完全没有动   
deleted表,存<font color=#F09B59 style=" font-weight:bold;">假设</font>被更改前的值(备份)  
inserted表,存<font color=#F09B59 style=" font-weight:bold;">假设</font>被更改后的值(现在的值)  

#### 具体语句触发
##### 后置具体
student中删除一条学生记录时，若该学生已选课
则提示“该生已选课，禁止删除”，并回滚事件
```sql
create trigger tr01
on sc
for delete
as  ##as后面跟tsql语句
begin  ##begin相当于括号
    if exist(select * from sc,deleted where sc.sno = deleted.sno)
    begin
        printf'该生已选课,禁止删除'
        rollback
    end
end                
```

##### 前置具体
2、创建一个名为tr_02的前触发器，当在学生表student中删除一条学生记录时，若该学生已选课则提示“该生已选课，禁止删除"
```sql
create trigger tr_02
on student
instead of delete
as
begin
    if exist(select * from sc,deleted where sc.sno = deleted.sno)
    begin
        print'该生已选课，禁止删除'
    end
    begin
        ##前置触发器你需要帮他写执行语句
        delete from student where sno 
        in(select sno from deleted)
    end
end    
```

##### update触发器
3、创建一个名为tr_03的后触发器，当学生表student中更新学生学号时，若该生已经选课，则提示“该生已经选课，禁止更新”并回 滚该事务
```sql
create trigger tr_03
on student
for update
as
begin
    if update(sno)   ##update要判断
    begin
        if exist(select * from sc,deleted where sc.sno = deleted.sno)
        begin
            print'该生已选课，禁止更改'
            rollback
        end
    end
end    
```

4、创建一个名为tr_04的前触发器，当学生表student中更新学生学号时，若该生已经选课，则提示“该生已经选课，禁止更新”
```sql
create trigger tr_04
on student
instead of update
as
begin
    if update(sno)   ##update要判断
    begin
        if exist(select * from sc,deleted where sc.sno = deleted.sno)
        begin
            print'该生已选课，禁止更改'
        end
        begin
            ##这个不能用多表联查去做
            update student set sno = (select sno from inserted)
            where sno in (select sno from deleted)
        end
    end
end    
```
