package nutrition;

/**
 * 一般当我们需要多个可选参数时，会这样做，但这样的话随着参数增加，容易失控，可读性也奇差，
 * 而且就算我们不小心颠倒了其中两个参数的顺序，也不会报错。这时推荐使用JavaBeans模式
 * @see NutritionFacts //顺便一提，@see标签不顶头写就会失效，而加了大括号{}的@link标签则不会
 *
 * @author LightDance
 */
public class BadNutritionFacts {
    private int servingSize;    //ml
    private int servings;       //per container
    private int calories;       //
    private int fat;            //g
    private int sodium;         //mg
    private int carbohydrate;   //mg


    public BadNutritionFacts(int servingSize, int servings) {
        this(servingSize , servings  ,0);
    }

    public BadNutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize , servings , calories ,0);
    }

    public BadNutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize , servings , calories , fat , 0);
    }

    public BadNutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize , servings , calories , fat , sodium , 0);
    }

    public BadNutritionFacts(int servingSize, int servings, int calories,
                             int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
