package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {

	private static final Field[] RICH_SOIL_LAND = RichSoilLand.class.getDeclaredFields();//TODO this is reflection getting all fields.
	private static final Scanner SCAN = new Scanner(System.in);
	private static final String END_COMMAND = "HARVEST";
	private static final String PRIVATE = "private";
	private static final String PUBLIC = "public";
	private static final String PROTECTED = "protected";
	private static final String PRINT_FORMAT = "%s %s %s";

	private static final Function<Field, String> FIELD_STRING_FUNCTION = (field -> String.format(PRINT_FORMAT,Modifier.toString(field.getModifiers()),field.getType().getSimpleName(),field.getName()));
	private static void printFilteredFields(String modifier){
		Arrays.stream(RICH_SOIL_LAND)
				.filter(field-> Modifier.toString(field.getModifiers()).equals(modifier))
				.map(FIELD_STRING_FUNCTION)
				.forEach(System.out::println);
	}
	private static void printFields(){
		Arrays.stream(RICH_SOIL_LAND)
				.map(FIELD_STRING_FUNCTION)
				.forEach(System.out::println);
	}

	public static void main(String[] args) {

		String input;

		while (!END_COMMAND.equals(input=SCAN.nextLine())){
			switch (input){
				case "private":
					printFilteredFields(PRIVATE);
					break;
				case "public":
					printFilteredFields(PUBLIC);
					break;
				case "protected":
					printFilteredFields(PROTECTED);
					break;
				default:
					printFields();
					break;
			}
		}
		SCAN.close();
	}

}
