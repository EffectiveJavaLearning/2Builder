package nutrition;

/**
 * 看到了前面两种有失优雅的设计{@link BadNutritionFacts},{@link NutritionFacts}，
 * 这里我们展示兼顾可读性与线程安全的Builder模式
 *
 * Builder模式编写出来一个公共的静态内部类Builder，
 * 在静态内部类中提供链式调用的方法（return this和build()），Builder设构造方法以传入不可缺省的必要参数，
 * 私有化BestNutrition的构造方法，为使用者提供Builder的构造方法来构造对象
 *
 * 另外，builder可以在builder方法中对参数强加约束条件，并在对象域而不是builder域中对它们进行检验
 *      或者也可以直接在setter中进行检验，这样就不必等到builder才发现错误
 *
 * builder十分灵活，单个builder可以创建多个对象，其参数也可以在创建期间进行调整，也可以实现比如主键自增等操作
 * 另外，builder还可以通过参数生成抽象工厂，{@link builder.Builder}
 *
 * builder的主要缺陷是为了创建对象不得不先编写一个Builder对象，
 * 这或许会在对于性能要求十分严格的情况下造成一些问题。而且有些时候Builder方法也会非常冗长，
 * 因此只在参数很多或者感觉将来版本中参数会逐渐增多的时候使用Builder. 但是，从构造方法或者静态工厂改到Builder时，
 * 会出现很多过时的构造方法和静态工厂方法，增加更改代码逻辑的困难，因此最好一开始就使用最合适的那种方法创建对象。
 *
 *
 * @author LightDance
 */
public class BestNutritionFacts {
    //Required parameters
    private int servingSize;    //ml
    private int servings;       //per container

    //Optional parameters
    private int calories;       //
    private int fat;            //g
    private int sodium;         //mg
    private int carbohydrate;   //mg

    public void nutritionFactsInfo(){
        System.out.println("servingSize , servings , calories , fat , sodium , carbohydrate");
        System.out.println(servingSize + " , " + servings + " , " + calories + " , " +fat + " , " + sodium + " , " +carbohydrate);
    }

    private BestNutritionFacts(Builder builder){
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder{
        //Required parameters
        private int servingSize;    //ml
        private int servings;       //per container

        //Optional parameters
        private int calories = 0;       //
        private int fat = 0;            //g
        private int sodium = 0;         //mg
        private int carbohydrate = 0;   //mg

        public Builder(int servingSize , int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            this.calories = val;
            return this;
        }
        public Builder fat(int val) {
            this.fat = val;
            return this;
        }
        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Builder carbonhydrate(int val) {
            this.carbohydrate = val;
            return this;
        }

        public BestNutritionFacts build(){
            if (this.servings < 0 || this.servingSize < 0){
                System.out.println("illegal args!");
                throw new IllegalArgumentException();
            }
            return new BestNutritionFacts(this);
        }
    }
}
