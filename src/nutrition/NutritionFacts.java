package nutrition;

/**
 * 为了解决{@link BadNutritionFacts}中的问题，调用一个无参构造器创建对象，
 * 然后用setter方法设置各个必要参数、可选参数。
 *
 * 但是这种方法仍然存在问题：调用setter方法过程中存在状态不一致问题，需要额外的线程安全控制，
 * 而且这种情况调试起来非常困难。
 *
 * 于是，我们现在祭出更加优秀的一种设计方法{@link BestNutritionFacts}
 *
 * @author LightDance
 */
public class NutritionFacts {
    private int servingSize = -1;   //ml
    private int servings = -1;      //per container
    private int calories = 0;       //
    private int fat = 0;            //g
    private int sodium = 0;         //mg
    private int carbohydrate = 0;   //mg

    public NutritionFacts() {
        super();
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setServings(10);
        nutritionFacts.setServingSize(20);
        nutritionFacts.setCalories(50);
        nutritionFacts.setSodium(90);
        //use nutritionFacts do sth
    }
}
