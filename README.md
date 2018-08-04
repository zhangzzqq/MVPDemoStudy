


# MVPDemoStudy
一个练习MVP的demo，代码用到retrofit框架，学习这个demo两个重要的知识点都学习了。


retrofitHelper 是一个综合的封装

retrofitHelper2 是一个简单的封装

retrofitHelper3 是一个简单的封装,跟retrofitHelper2类似的


retrofitDemo2 非常的好的例子:

Api 是一个简单的封装，但是明显的封装的简洁，好用（比app module中的好）

ApiMethods 是一个综合的封装，跟retrofitHelper基本上一样，主要特点就是
多了一个头部拦截以及封装的更优美，没有下面这行代码
public <T> T create(Class<T> clazz){
        return retrofit.create(clazz);
    }




