package JavaAdvanced.Generics.Exercise.CustomList_07;

public class Sorter {

    public static void sort(CustomList<String> customList){
        for (int i = 0; i < customList.getElements().size(); i++) {
            String element = (String)customList.getElements().get(i);
            for (int j = i + 1; j < customList.getElements().size(); j++) {
                String nextElement = (String) customList.getElements().get(j);
                if(element.compareTo(nextElement) > 0){
                    customList.swap(i, j);
                }
            }
        }
    }

}
