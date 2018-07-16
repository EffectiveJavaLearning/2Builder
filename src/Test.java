import nutrition.BestNutritionFacts;

public class Test {

    public static void main(String[] args) {
        BestNutritionFacts.Builder builder =
                new BestNutritionFacts.Builder(3 , 60);
        BestNutritionFacts nutritionFacts = builder
                .calories(10)
                .carbonhydrate(30)
                .sodium(48)
                .build();
        nutritionFacts.nutritionFactsInfo();

    }
}
