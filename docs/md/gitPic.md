# <center>git作为图床的使用</center>

---
```
使用已经存在的git代码管理工具作为markdown文件的图床使用
gitee和github

```
- ### [gitee](https://gitee.com)
---
1)  验证

#### **problem**
-[ ] 使用空的工程初始化时 pull操作会报错【暂时在工程中加一份文件,临时解决报错问题】
-[ ] 如何由用户输入git的地址及用户名密码，目前写死，结合intellig官方文档看



- ### [github](https://github.com) 【时常抽风】

- Storage account ideas
---
由于通过git作为图床时[国内是gitee,国外github]，每次都需要设置账号，密码，地址，路径等，
对用户不友好，需要将这些信息持久化，参考官网[如何持久化](https://www.jetbrains.org/intellij/sdk/docs/basics/persisting_state_of_components.html)
,以及对密码等信息是[如何保存的](https://www.jetbrains.org/intellij/sdk/docs/basics/persisting_sensitive_data.html)

将这些个人信息转换成json字符串存储起来


