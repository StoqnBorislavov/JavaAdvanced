package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		List<Field> fields = Arrays.asList(RichSoilLand.class.getDeclaredFields());

		Map<Commands, List<Field>> modifiersMap = getMap(fields);

		fillMapWithFields(fields, modifiersMap);
		Consumer<Field> printer = field -> {
			StringBuilder builder = new StringBuilder();
			builder.append(Modifier.toString(field.getModifiers()));
				builder.append(" ").append(field.getType()
						.getSimpleName()).append(" ").append(field.getName());
			System.out.println(builder);
		};
		while (!input.equals("HARVEST")){

			switch (input){
				case "private":
					modifiersMap.get(Commands.PRIVATE).forEach(field -> printer.accept(field));
					break;
				case "protected":
					modifiersMap.get(Commands.PROTECTED).forEach(field -> printer.accept(field));
					break;
				case "public":
					modifiersMap.get(Commands.PUBLIC).forEach(field -> printer.accept(field));
					break;
				case "all":
					modifiersMap.get(Commands.ALL).forEach(field -> printer.accept(field));
					break;
			}
			input = sc.nextLine();
		}
	}

	private static void fillMapWithFields(List<Field> fields, Map<Commands, List<Field>> modifiersMap) {
		for (Field field : fields) {
			String modifier = Modifier.toString(field.getModifiers());
			switch (modifier){
				case "public":
					modifiersMap.get(Commands.PUBLIC).add(field);
					break;
				case "private":
					modifiersMap.get(Commands.PRIVATE).add(field);
					break;
				case "protected":
					modifiersMap.get(Commands.PROTECTED).add(field);
					break;
			}
		}
	}

	private static Map getMap(List<Field> fields) {
		Map<Commands, List<Field>> modifiersMap = new LinkedHashMap<>();
		modifiersMap.put(Commands.PUBLIC, new ArrayList<>());
		modifiersMap.put(Commands.PRIVATE, new ArrayList<>());
		modifiersMap.put(Commands.PROTECTED, new ArrayList<>());
		modifiersMap.put(Commands.ALL, fields);
		return modifiersMap;
	}
}
