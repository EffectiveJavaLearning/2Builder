package builder;

/**
 * builder的抽象工厂，通过泛型控制返回类型，
 * 而在实现该接口的类中加以限制如Tree buildTree(Builder<? extends Node> nodeBuilder);进行约束。
 *
 * 传统的抽象工厂是用Class对象的newInstance充当build的一部分，但newInstance总是调用其无参构造方法，
 * 而不管这种构造方法存不存在，于是客户端就需要处理InstantiationException或者IllegalAccessException；
 * 加上newInstance会传递无参构造方法所抛出的异常，即使newInstance缺乏相应的throws子句。
 * 也就是说，newInstance破坏了Java的异常检查，
 * 而使用Builder的异常检测机制则可以解决这个问题{@link nutrition.BestNutritionFacts}
 *
 * @author LightDance
 */
public interface Builder<T> {

    public T build();
    //然后创建Builder类时implements一下就可以了
}
